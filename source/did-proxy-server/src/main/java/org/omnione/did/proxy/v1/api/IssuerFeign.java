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

package org.omnione.did.proxy.v1.api;

import org.omnione.did.base.constants.UrlConstant;
import org.omnione.did.proxy.v1.api.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "Issuer", url = "${issuer.url}" + UrlConstant.Issuer.V1)
public interface IssuerFeign {

    @PostMapping(UrlConstant.Issuer.INSPECT_PROPOSE_ISSUE)
    InspectProposeIssueResDto inspectProposeIssue(@RequestBody InspectProposeIssueReqDto reqDto);

    @PostMapping(UrlConstant.Issuer.GENERATE_ISSUE_PROFILE)
    GenerateIssueProfileResDto generateIssueProfile(@RequestBody GenerateIssueProfileReqDto reqDto);

    @PostMapping(UrlConstant.Issuer.ISSUE_VC)
    IssueVcResDto issueVc(@RequestBody IssueVcReqDto reqDto);

    @PostMapping(UrlConstant.Issuer.COMPLETE_VC)
    CompleteVcResDto completeVc(@RequestBody CompleteVcReqDto reqDto);

    @PostMapping(UrlConstant.Issuer.INSPECT_PROPOSE_REVOKE)
    InspectProposeRevokeResDto inspectProposeRevoke(@RequestBody InspectProposeRevokeReqDto reqDto);

    @PostMapping(UrlConstant.Issuer.REVOKE_VC)
    RevokeVcResDto revokeVc(@RequestBody RevokeVcReqDto reqDto);

    @PostMapping(UrlConstant.Issuer.COMPLETE_REVOKE)
    CompleteRevokeResDto completeRevoke(@RequestBody CompleteRevokeReqDto reqDto);
}
