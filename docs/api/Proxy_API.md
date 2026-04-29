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

- Date: 2026-02-26
- Version: v3.0.0
  
Table of Contents
---
<!-- TOC tocDepth:2..3 chapterDepth:2..6 -->

- [1. Overview](#1-overview)
- [2. API List](#2-api-list)
    - [2.1. Issuance API](#21-issuance-api)
    - [2.2. Revocation API](#22-revocation-api)
- [3. Issuance API](#3-issuance-api)
    - [3.1. Propose Issue VC](#31-propose-issue-vc)
    - [3.2. Request Issue Profile](#32-request-issue-profile)
    - [3.3. Request Issue VC](#33-request-issue-vc)
    - [3.4. Confirm Issue VC](#34-confirm-issue-vc)
- [4. Revocation API](#4-revocation-api)
    - [4.1. Propose Revoke VC](#41-propose-revoke-vc)
    - [4.2. Request Revoke VC](#42-request-revoke-vc)
    - [4.3. Confirm Revoke VC](#43-confirm-revoke-vc)

<!-- /TOC -->


## 1. Overview

This document defines the APIs provided by the Proxy Service.

<div style="page-break-after: always; margin-top: 50px;"></div>


## 2. API List

### 2.1. Issuance API

| API                     | URL                                      | Description                    | Protocol |
| ----------------------- | ---------------------------------------- | ------------------------------ | -------- |
| `propose-issue-vc`      | /proxy/api/v1/propose-issue-vc           | Propose VC issuance            | VC Issue |
| `request-issue-profile` | /proxy/api/v1/request-issue-profile      | Request VC issuance profile    | VC Issue |
| `request-issue-vc`      | /proxy/api/v1/request-issue-vc           | Request VC issuance            | VC Issue |
| `confirm-issue-vc`      | /proxy/api/v1/confirm-issue-vc           | Confirm VC issuance completion | VC Issue |

### 2.2. Revocation API

| API                     | URL                                      | Description                    | Protocol  |
| ----------------------- | ---------------------------------------- | ------------------------------ | --------- |
| `propose-revoke-vc`     | /proxy/api/v1/propose-revoke-vc          | Propose VC revocation          | VC Revoke |
| `request-revoke-vc`     | /proxy/api/v1/request-revoke-vc          | Request VC revocation          | VC Revoke |
| `confirm-revoke-vc`     | /proxy/api/v1/confirm-revoke-vc          | Confirm VC revocation          | VC Revoke |

<div style="page-break-after: always; margin-top: 50px;"></div>

## 3. Issuance API

### 3.1. Propose Issue VC

Propose VC issuance to the issuer.

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
| `id`       | String | Request identifier      |         |
| `vcPlanId` | String | VC Plan identifier      |         |
| `issuer`   | String | Issuer identifier       |         |
| `offerId`  | String | Offer identifier        |         |

#### 3.1.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | Transaction identifier |         |
| `refId`| String | Reference identifier   |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 3.2. Request Issue Profile

Request VC issuance profile.

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
| `id`   | String | Request identifier      |         |
| `txId` | String | Transaction identifier |         |
| `userId` | String | User identifier      | Forwarded to issuer |

#### 3.2.2. Response

**■ Status 200 - Success**

| name        | Type   | Description            | Remarks |
| ----------- | ------ | ---------------------- | ------- |
| `txId`      | String | Transaction identifier |         |
| `authNonce` | String | Authentication nonce   |         |
| `profile`   | Object | Issue profile details  |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 3.3. Request Issue VC

Request VC issuance with authentication.

| Item          | Description                    | Remarks |
| ------------- | ------------------------------ | ------- |
| Method        | `POST`                         |         |
| Path          | `/proxy/api/v1/request-issue-vc`|         |

#### 3.3.1. Request

**■ HTTP Body**

| name          | Type   | Description                 | Remarks |
| ------------- | ------ | --------------------------- | ------- |
| `id`          | String | Request identifier          |         |
| `txId`        | String | Transaction identifier      |         |
| `didAuth`     | Object | DID Authentication data     |         |
| `accE2e`      | Object | End-to-end encryption data  |         |
| `encReqVc`    | String | Encrypted VC request        |         |

#### 3.3.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | Transaction identifier |         |
| `e2e`  | Object | E2E encryption details  |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 3.4. Confirm Issue VC

Confirm the completion of VC issuance.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/confirm-issue-vc`|         |

#### 3.4.1. Request

**■ HTTP Body**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `id`   | String | Request identifier      |         |
| `txId` | String | Transaction identifier |         |
| `vcId` | String | VC identifier          |         |

#### 3.4.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | Transaction identifier |         |

<div style="page-break-after: always; margin-top: 50px;"></div>

## 4. Revocation API

### 4.1. Propose Revoke VC

Propose VC revocation to the issuer.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/propose-revoke-vc`|         |

#### 4.1.1. Request

**■ HTTP Body**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `id`   | String | Request identifier      |         |
| `vcId` | String | VC identifier          |         |

#### 4.1.2. Response

**■ Status 200 - Success**

| name          | Type    | Description            | Remarks |
| ------------- | ------- | ---------------------- | ------- |
| `txId`        | String  | Transaction identifier |         |
| `issuerNonce` | String  | Issuer nonce           |         |
| `authType`    | Integer | Authentication type    |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 4.2. Request Revoke VC

Request VC revocation.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/request-revoke-vc`|         |

#### 4.2.1. Request

**■ HTTP Body**

| name                 | Type   | Description            | Remarks |
| -------------------- | ------ | ---------------------- | ------- |
| `id`                 | String | Request identifier      |         |
| `txId`               | String | Transaction identifier |         |
| `request`            | Object | Revocation request info|         |

#### 4.2.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | Transaction identifier |         |

<div style="page-break-after: always; margin-top: 40px;"></div>

### 4.3. Confirm Revoke VC

Confirm the completion of VC revocation.

| Item          | Description                     | Remarks |
| ------------- | ------------------------------- | ------- |
| Method        | `POST`                          |         |
| Path          | `/proxy/api/v1/confirm-revoke-vc`|         |

#### 4.3.1. Request

**■ HTTP Body**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `id`   | String | Request identifier      |         |
| `txId` | String | Transaction identifier |         |

#### 4.3.2. Response

**■ Status 200 - Success**

| name   | Type   | Description            | Remarks |
| ------ | ------ | ---------------------- | ------- |
| `txId` | String | Transaction identifier |         |
