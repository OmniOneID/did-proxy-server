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


# Proxy Server Error

- Date: 2026-01-30
- Version: v3.0.0

| Version | Date       | Changes                      |
|---------|------------|------------------------------|
| v3.0.0  | 2026-01-30 | Initial version              |

<div style="page-break-after: always;"></div>

# Table of Contents
- [Model](#model)
  - [Error Response](#error-response)
- [Error Code](#error-code)
  - [1. Common Errors (000xx)](#1-common-errors-000xx)
  - [2. Issuer Integration Errors (001xx)](#2-issuer-integration-errors-001xx)
  - [3. Transaction Errors (003xx)](#3-transaction-errors-003xx)

# Model

## Error Response

### Description
```
Error struct for Proxy. It has code and message pair.
Code starts with SSRVPRX.
```

### Declaration
```java
public class ErrorResponse {
    private String code;
    private String message;
}
```

### Property

| Name        | Type   | Description         | **M/O** | **Note** |
|-------------|--------|---------------------|---------|----------|
| code        | String | Error code          | M       |          |
| message     | String | Error description   | M       |          |

# Error Code

## 1. Common Errors (000xx)

| Error Code       | Error Message                  | Description | HTTP Status |
|------------------|--------------------------------|-------------|-------------|
| SSRVPRX00000     | Unknown server error occurred. | -           | 500         |
| SSRVPRX00001     | Failed to encode data.         | -           | 500         |
| SSRVPRX00002     | Failed to decode data.         | -           | 500         |
| SSRVPRX00003     | Invalid parameter provided.    | -           | 400         |
| SSRVPRX00004     | JSON processing error.         | -           | 500         |
| SSRVPRX00005     | File processing error.         | -           | 500         |

## 2. Issuer Integration Errors (001xx)

| Error Code       | Error Message                  | Description | HTTP Status |
|------------------|--------------------------------|-------------|-------------|
| SSRVPRX00100     | Failed to connect to Issuer.   | -           | 500         |
| SSRVPRX00101     | Error received from Issuer.    | -           | 500         |

## 3. Transaction Errors (003xx)

| Error Code       | Error Message                  | Description | HTTP Status |
|------------------|--------------------------------|-------------|-------------|
| SSRVPRX00300     | Transaction not found.         | -           | 400         |
| SSRVPRX00301     | Invalid transaction status.    | -           | 400         |
| SSRVPRX00302     | Process execution failed.      | -           | 500         |
