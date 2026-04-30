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

package org.omnione.did.proxy.v1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.omnione.did.base.constants.UrlConstant;
import org.omnione.did.proxy.v1.dto.*;
import org.omnione.did.proxy.v1.service.ProxyService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = UrlConstant.Proxy.V1)
public class ProxyController {

    private final ProxyService proxyService;

    @PostMapping(value = UrlConstant.Proxy.PROPOSE_ISSUE_VC)
    public ProposeIssueVcResDto proposeIssueVc(@RequestBody ProposeIssueVcReqDto reqDto) {
        return proxyService.proposeIssueVc(reqDto);
    }

    @PostMapping(value = UrlConstant.Proxy.REQUEST_ISSUE_PROFILE)
    public RequestIssueProfileResDto requestIssueProfile(@RequestBody RequestIssueProfileReqDto reqDto) {
        return proxyService.requestIssueProfile(reqDto);
    }

    @PostMapping(value = UrlConstant.Proxy.REQUEST_ISSUE_VC)
    public RequestIssueVcResDto requestIssueVc(@RequestBody RequestIssueVcReqDto reqDto) {
        return proxyService.requestIssueVc(reqDto);
    }

    @PostMapping(value = UrlConstant.Proxy.CONFIRM_ISSUE_VC)
    public ConfirmIssueVcResDto confirmIssueVc(@RequestBody ConfirmIssueVcReqDto reqDto) {
        return proxyService.confirmIssueVc(reqDto);
    }

    @PostMapping(value = UrlConstant.Proxy.PROPOSE_REVOKE_VC)
    public ProposeRevokeVcResDto proposeRevokeVc(@RequestBody ProposeRevokeVcReqDto reqDto) {
        return proxyService.proposeRevokeVc(reqDto);
    }

    @PostMapping(value = UrlConstant.Proxy.REQUEST_REVOKE_VC)
    public RequestRevokeVcResDto requestRevokeVc(@RequestBody RequestRevokeVcReqDto reqDto) {
        return proxyService.requestRevokeVc(reqDto);
    }

    @PostMapping(value = UrlConstant.Proxy.CONFIRM_REVOKE_VC)
    public ConfirmRevokeVcResDto confirmRevokeVc(@RequestBody ConfirmRevokeVcReqDto reqDto) {
        return proxyService.confirmRevokeVc(reqDto);
    }
}
