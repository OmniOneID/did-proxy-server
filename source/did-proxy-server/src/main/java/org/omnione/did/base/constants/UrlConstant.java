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

package org.omnione.did.base.constants;

public class UrlConstant {

    public static class Proxy {
        public static final String V1 = "/proxy/api/v1";
        public static final String PROPOSE_ISSUE_VC = "/propose-issue-vc";
        public static final String REQUEST_ISSUE_PROFILE = "/request-issue-profile";
        public static final String REQUEST_ISSUE_VC = "/request-issue-vc";
        public static final String CONFIRM_ISSUE_VC = "/confirm-issue-vc";
        public static final String PROPOSE_REVOKE_VC = "/propose-revoke-vc";
        public static final String REQUEST_REVOKE_VC = "/request-revoke-vc";
        public static final String CONFIRM_REVOKE_VC = "/confirm-revoke-vc";
    }

    public static class Issuer {
        public static final String V1 = "/issuer/api/v1";
        public static final String INSPECT_PROPOSE_ISSUE = "/inspect-propose-issue";
        public static final String GENERATE_ISSUE_PROFILE = "/generate-issue-profile/proxy";
        public static final String ISSUE_VC = "/issue-vc/proxy";
        public static final String COMPLETE_VC = "/complete-vc";
        public static final String INSPECT_PROPOSE_REVOKE = "/inspect-propose-revoke";
        public static final String REVOKE_VC = "/revoke-vc";
        public static final String COMPLETE_REVOKE = "/complete-revoke";
    }
}