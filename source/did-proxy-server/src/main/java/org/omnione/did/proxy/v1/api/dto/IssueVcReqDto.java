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

package org.omnione.did.proxy.v1.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.omnione.did.proxy.v1.dto.RequestIssueVcReqDto;

@Getter
@Setter
@ToString
@Builder
public class IssueVcReqDto {
    private String id;
    private String txId;
    private RequestIssueVcReqDto.AccE2e accE2e;
    private String encReqVc;
    private RequestIssueVcReqDto.DidAuth didAuth;
}
