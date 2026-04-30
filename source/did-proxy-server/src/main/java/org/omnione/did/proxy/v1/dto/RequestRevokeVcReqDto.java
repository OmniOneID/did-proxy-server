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

package org.omnione.did.proxy.v1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestRevokeVcReqDto {
    private String id;
    private String txId;
    private Request request;

    @Getter
    @Setter
    @ToString
    public static class Request {
        private String vcId;
        private String issuerNonce;
        private Proof proof;
    }

    @Getter
    @Setter
    @ToString
    public static class Proof {
        private String type;
        private String created;
        private String verificationMethod;
        private String proofPurpose;
        private String proofValue;
    }
}
