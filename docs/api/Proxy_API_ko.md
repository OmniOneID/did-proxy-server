---
puppeteer:
    pdf:
        format: A4
        displayHeaderFooter: true
        landscape: false
        scale: 0.8
        margin:
            top: 1.2cm
            right: 1cm
            bottom: 1cm
            left: 1cm
    image:
        quality: 100
        fullPage: false
---

Proxy API
==

- 일자: 2026-02-26
- 버전: v3.0.0
  
목차
---
<!-- TOC tocDepth:2..3 chapterDepth:2..6 -->

- [1. 개요](#1-개요)
- [2. API 목록](#2-api-목록)
    - [2.1. 발급 API](#21-발급-api)
    - [2.2. 폐기 API](#22-폐기-api)
- [3. 발급 API](#3-발급-api)
    - [3.1. Propose Issue VC](#31-propose-issue-vc)
    - [3.2. Request Issue Profile](#32-request-issue-profile)
    - [3.3. Request Issue VC](#33-request-issue-vc)
    - [3.4. Confirm Issue VC](#34-confirm-issue-vc)
- [4. 폐기 API](#4-폐기-api)
    - [4.1. Propose Revoke VC](#41-propose-revoke-vc)
    - [4.2. Request Revoke VC](#42-request-revoke-vc)
    - [4.3. Confirm Revoke VC](#43-confirm-revoke-vc)

<!-- /TOC -->


## 1. 개요

본 문서는 Proxy Service가 제공하는 API를 정의한다.

<div style="page-break-after: always; margin-top: 50px;"></div>


## 2. API 목록

### 2.1. 발급 API

| API                     | URL                                      | Description                  | Protocol |
| ----------------------- | ---------------------------------------- | ---------------------------- | -------- |
| `propose-issue-vc`      | /proxy/api/v1/propose-issue-vc           | VC 발급 제안                 | VC 발급  |
| `request-issue-profile` | /proxy/api/v1/request-issue-profile      | VC 발급 프로파일 요청        | VC 발급  |
| `request-issue-vc`      | /proxy/api/v1/request-issue-vc           | VC 발급 요청                 | VC 발급  |
| `confirm-issue-vc`      | /proxy/api/v1/confirm-issue-vc           | VC 발급 완료 확인            | VC 발급  |

### 2.2. 폐기 API

| API                     | URL                                      | Description                  | Protocol |
| ----------------------- | ---------------------------------------- | ---------------------------- | -------- |
| `propose-revoke-vc`     | /proxy/api/v1/propose-revoke-vc          | VC 폐기 제안                 | VC 폐기  |
| `request-revoke-vc`     | /proxy/api/v1/request-revoke-vc          | VC 폐기 요청                 | VC 폐기  |
| `confirm-revoke-vc`     | /proxy/api/v1/confirm-revoke-vc          | VC 폐기 완료 확인            | VC 폐기  |

<div style="page-break-after: always; margin-top: 50px;"></div>

## 3. 발급 API

### 3.1. Propose Issue VC

Issuer에게 VC 발급을 제안한다.

| Item          | Description                    | Remarks |
| ------------- | ------------------------------ | ------- |
| Method        | `POST`                         |         |
| Path          | `/proxy/api/v1/propose-issue-vc`|         |

#### 3.1.1. Request

**■ HTTP Headers**

| Header           | Value                            | Remarks |
| ---------------- | -------------------------------- | ------- |
| + `Content-Type` | `application/json;charset=utf-8` |         |     

**■ HTTP Body**

| name       | Type   | Description             | Remarks |
| ---------- | ------ | ----------------------- | ------- |
| `id`       | String | 요청 식별자             |         |
| `vcPlanId` | String | VC 플랜 식별자          |         |
| `issuer`   | String | Issuer 식별자           |         |
| `offerId`  | String | Offer 식별자            |         |

#### 3.1.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | 트랜잭션 식별자        |         |
| `refId`| String | 참조 식별자            |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 3.2. Request Issue Profile

VC 발급 프로파일을 요청한다.

| Item          | Description                       | Remarks |
| ------------- | --------------------------------- | ------- |
| Method        | `POST`                            |         |
| Path          | `/proxy/api/v1/request-issue-profile`|      |

#### 3.2.1. Request

**■ HTTP Headers**

| Header           | Value                            | Remarks |
| ---------------- | -------------------------------- | ------- |
| + `Content-Type` | `application/json;charset=utf-8` |         |

**■ HTTP Body**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `id`   | String | 요청 식별자             |         |
| `txId` | String | 트랜잭션 식별자        |         |
| `userId` | String | 사용자 식별자        | Issuer로 전달 |

#### 3.2.2. Response

**■ Status 200 - Success**

| name        | Type   | Description            | Remarks |
| ----------- | ------ | ---------------------- | ------- |
| `txId`      | String | 트랜잭션 식별자        |         |
| `authNonce` | String | 인증용 넌스            |         |
| `profile`   | Object | 발급 프로파일 상세     |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 3.3. Request Issue VC

인증 정보를 포함하여 VC 발급을 요청한다.

| Item          | Description                    | Remarks |
| ------------- | ------------------------------ | ------- |
| Method        | `POST`                         |         |
| Path          | `/proxy/api/v1/request-issue-vc`|         |

#### 3.3.1. Request

**■ HTTP Body**

| name          | Type   | Description                 | Remarks |
| ------------- | ------ | --------------------------- | ------- |
| `id`          | String | 요청 식별자                 |         |
| `txId`        | String | 트랜잭션 식별자             |         |
| `didAuth`     | Object | DID 인증 데이터             |         |
| `accE2e`      | Object | 종단간 암호화 데이터        |         |
| `encReqVc`    | String | 암호화된 VC 요청            |         |

#### 3.3.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | 트랜잭션 식별자        |         |
| `e2e`  | Object | E2E 암호화 상세         |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 3.4. Confirm Issue VC

VC 발급 완료를 확인한다.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/confirm-issue-vc`|         |

#### 3.4.1. Request

**■ HTTP Body**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `id`   | String | 요청 식별자             |         |
| `txId` | String | 트랜잭션 식별자        |         |
| `vcId` | String | VC 식별자              |         |

#### 3.4.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | 트랜잭션 식별자        |         |

<div style="page-break-after: always; margin-top: 50px;"></div>

## 4. 폐기 API

### 4.1. Propose Revoke VC

Issuer에게 VC 폐기를 제안한다.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/propose-revoke-vc`|         |

#### 4.1.1. Request

**■ HTTP Body**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `id`   | String | 요청 식별자             |         |
| `vcId` | String | VC 식별자              |         |

#### 4.1.2. Response

**■ Status 200 - Success**

| name          | Type    | Description            | Remarks |
| ------------- | ------- | ---------------------- | ------- |
| `txId`        | String  | 트랜잭션 식별자        |         |
| `issuerNonce` | String  | Issuer 넌스            |         |
| `authType`    | Integer | 인증 타입              |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 4.2. Request Revoke VC

VC 폐기를 요청한다.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/request-revoke-vc`|         |

#### 4.2.1. Request

**■ HTTP Body**

| name                 | Type   | Description            | Remarks |
| -------------------- | ------ | ---------------------- | ------- |
| `id`                 | String | 요청 식별자             |         |
| `txId`               | String | 트랜잭션 식별자        |         |
| `request`            | Object | 폐기 요청 정보         |         |


#### 4.2.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | 트랜잭션 식별자        |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 4.3. Confirm Revoke VC

VC 폐기 완료를 확인한다.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/confirm-revoke-vc`|         |

#### 4.3.1. Request

**■ HTTP Body**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `id`   | String | 요청 식별자             |         |
| `txId` | String | 트랜잭션 식별자        |         |

#### 4.3.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | 트랜잭션 식별자        |         |
