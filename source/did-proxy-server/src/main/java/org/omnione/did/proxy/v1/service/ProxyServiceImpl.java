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

package org.omnione.did.proxy.v1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.omnione.did.proxy.v1.api.IssuerFeign;
import org.omnione.did.proxy.v1.api.dto.*;
import org.omnione.did.proxy.v1.dto.*;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProxyServiceImpl implements ProxyService {

    private final IssuerFeign issuerFeign;

    @Override
    public ProposeIssueVcResDto proposeIssueVc(ProposeIssueVcReqDto reqDto) {
        log.info("proposeIssueVc called with: {}", reqDto);

        InspectProposeIssueReqDto issuerReq = InspectProposeIssueReqDto.builder()
                .id(reqDto.getId())
                .vcPlanId(reqDto.getVcPlanId())
                .issuer(reqDto.getIssuer())
                .offerId(reqDto.getOfferId())
                .build();

        InspectProposeIssueResDto issuerRes = issuerFeign.inspectProposeIssue(issuerReq);

        return ProposeIssueVcResDto.builder()
                .txId(issuerRes.getTxId())
                .refId(issuerRes.getRefId())
                .build();
    }

    @Override
    public RequestIssueProfileResDto requestIssueProfile(RequestIssueProfileReqDto reqDto) {
        log.info("requestIssueProfile called with: {}", reqDto);
        GenerateIssueProfileReqDto issuerReq = GenerateIssueProfileReqDto.builder()
                .id(reqDto.getId())
                .txId(reqDto.getTxId())
                .userId(reqDto.getUserId())
                .build();
        GenerateIssueProfileResDto issuerRes = issuerFeign.generateIssueProfile(issuerReq);
        return RequestIssueProfileResDto.builder()
                .txId(issuerRes.getTxId())
                .authNonce(issuerRes.getAuthNonce())
                .profile(issuerRes.getProfile())
                .build();
    }

    @Override
    public RequestIssueVcResDto requestIssueVc(RequestIssueVcReqDto reqDto) {
        log.info("requestIssueVc called with: {}", reqDto);

        IssueVcReqDto issuerReq = IssueVcReqDto.builder()
                .id(reqDto.getId())
                .txId(reqDto.getTxId())
                .accE2e(reqDto.getAccE2e())
                .encReqVc(reqDto.getEncReqVc())
                .didAuth(reqDto.getDidAuth())
                .build();

        IssueVcResDto issuerRes = issuerFeign.issueVc(issuerReq);

        return RequestIssueVcResDto.builder()
                .txId(issuerRes.getTxId())
                .e2e(issuerRes.getE2e())
                .build();
    }

    @Override
    public ConfirmIssueVcResDto confirmIssueVc(ConfirmIssueVcReqDto reqDto) {
        log.info("confirmIssueVc called with: {}", reqDto);

        CompleteVcReqDto issuerReq = CompleteVcReqDto.builder()
                .id(reqDto.getId())
                .txId(reqDto.getTxId())
                .vcId(reqDto.getVcId())
                .build();

        CompleteVcResDto issuerRes = issuerFeign.completeVc(issuerReq);

        return ConfirmIssueVcResDto.builder()
                .txId(issuerRes.getTxId())
                .build();
    }

    @Override
    public ProposeRevokeVcResDto proposeRevokeVc(ProposeRevokeVcReqDto reqDto) {
        log.info("proposeRevokeVc called with: {}", reqDto);

        InspectProposeRevokeReqDto issuerReq = InspectProposeRevokeReqDto.builder()
                .id(reqDto.getId())
                .vcId(reqDto.getVcId())
                .build();

        InspectProposeRevokeResDto issuerRes = issuerFeign.inspectProposeRevoke(issuerReq);

        return ProposeRevokeVcResDto.builder()
                .txId(issuerRes.getTxId())
                .issuerNonce(issuerRes.getIssuerNonce())
                .authType(issuerRes.getAuthType())
                .build();
    }

    @Override
    public RequestRevokeVcResDto requestRevokeVc(RequestRevokeVcReqDto reqDto) {
        log.info("requestRevokeVc called with: {}", reqDto);

        RevokeVcReqDto issuerReq = RevokeVcReqDto.builder()
                .id(reqDto.getId())
                .txId(reqDto.getTxId())
                .request(RevokeVcReqDto.Request.builder()
                        .vcId(reqDto.getRequest().getVcId())
                        .issuerNonce(reqDto.getRequest().getIssuerNonce())
                        .proof(RevokeVcReqDto.Proof.builder()
                                .type(reqDto.getRequest().getProof().getType())
                                .created(reqDto.getRequest().getProof().getCreated())
                                .verificationMethod(reqDto.getRequest().getProof().getVerificationMethod())
                                .proofPurpose(reqDto.getRequest().getProof().getProofPurpose())
                                .proofValue(reqDto.getRequest().getProof().getProofValue())
                                .build())
                        .build())
                .build();

        RevokeVcResDto issuerRes = issuerFeign.revokeVc(issuerReq);

        return RequestRevokeVcResDto.builder()
                .txId(issuerRes.getTxId())
                .build();
    }

    @Override
    public ConfirmRevokeVcResDto confirmRevokeVc(ConfirmRevokeVcReqDto reqDto) {
        log.info("confirmRevokeVc called with: {}", reqDto);

        CompleteRevokeReqDto issuerReq = CompleteRevokeReqDto.builder()
                .id(reqDto.getId())
                .txId(reqDto.getTxId())
                .build();

        CompleteRevokeResDto issuerRes = issuerFeign.completeRevoke(issuerReq);

        return ConfirmRevokeVcResDto.builder()
                .txId(issuerRes.getTxId())
                .build();
    }
}
