/*
 * Copyright 2026 OmniOne.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omnione.did.base.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@Component
public class ApiLoggingFilter extends OncePerRequestFilter {

    private static final List<String> VISIBLE_CONTENT_TYPES = List.of(
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_PLAIN_VALUE,
            MediaType.TEXT_XML_VALUE,
            MediaType.TEXT_HTML_VALUE,
            MediaType.APPLICATION_FORM_URLENCODED_VALUE
    );

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.builder()
            .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
            .build()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .registerModule(new JavaTimeModule())
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"))
            .setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return uri.startsWith("/actuator")
                || uri.startsWith("/swagger-ui")
                || uri.startsWith("/v3/api-docs");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        long startTime = System.currentTimeMillis();

        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info(
                    "HTTP {} {} | status={} | duration={}ms | request={} | response={}",
                    requestWrapper.getMethod(),
                    requestWrapper.getRequestURI(),
                    responseWrapper.getStatus(),
                    elapsedTime,
                    getRequestBody(requestWrapper),
                    getResponseBody(responseWrapper)
            );
            responseWrapper.copyBodyToResponse();
        }
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        return getPayload(request.getContentAsByteArray(), request.getContentType(), request.getCharacterEncoding());
    }

    private String getResponseBody(ContentCachingResponseWrapper response) {
        return getPayload(response.getContentAsByteArray(), response.getContentType(), response.getCharacterEncoding());
    }

    private String getPayload(byte[] content, String contentType, String encoding) {
        if (content.length == 0) {
            return "";
        }

        if (!isVisibleContentType(contentType)) {
            return "[binary content omitted]";
        }

        Charset charset = StringUtils.hasText(encoding) ? Charset.forName(encoding) : StandardCharsets.UTF_8;
        String payload = new String(content, charset).trim();

        if (!StringUtils.hasText(payload)) {
            return "";
        }

        try {
            Object json = OBJECT_MAPPER.readValue(payload, Object.class);
            return OBJECT_MAPPER.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            return payload;
        }
    }

    private boolean isVisibleContentType(String contentType) {
        if (!StringUtils.hasText(contentType)) {
            return false;
        }

        return VISIBLE_CONTENT_TYPES.stream().anyMatch(contentType::startsWith);
    }
}
