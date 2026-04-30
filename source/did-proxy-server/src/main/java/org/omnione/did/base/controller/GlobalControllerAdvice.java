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

package org.omnione.did.base.controller;

import org.omnione.did.base.exception.ErrorCode;
import org.omnione.did.base.exception.OpenDidException;
import org.omnione.did.base.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import feign.FeignException;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestControllerAdvice(basePackages = {"org.omnione.did"})
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        int httpStatus = 400;

        String errorMessages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ErrorResponse errorResponse = new ErrorResponse("9999", errorMessages);
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(httpStatus));
    }

    @ExceptionHandler(OpenDidException.class)
    public ResponseEntity<ErrorResponse> handleAPIException(OpenDidException ex) {
        int httpStatus = ex.getErrorCode().getHttpStatus();
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getCode(), ex.getErrorCode().getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(httpStatus));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> handleFeignException(FeignException ex) {
        int httpStatus = ex.status() != -1 ? ex.status() : HttpStatus.INTERNAL_SERVER_ERROR.value();
        String body = ex.contentUTF8();

        if (body == null || body.trim().isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorCode.ISSUER_RESPONSE_ERROR.getCode(), "Issuer Error: " + ex.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(httpStatus));
        }

        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }
}
