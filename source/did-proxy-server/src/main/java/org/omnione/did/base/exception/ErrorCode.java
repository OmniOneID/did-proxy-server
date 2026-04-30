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

package org.omnione.did.base.exception;

import lombok.Getter;

/**
 * Enumeration of error codes used in the Proxy system.
 * Each error code contains a unique identifier, a descriptive message, and an associated HTTP status code.
 * Format: SSRVPRX00000
 */
@Getter
public enum ErrorCode {

    UNKNOWN_SERVER_ERROR("SSRVPRX00000", "Unknown server error occurred.", 500),
    ENCODING_FAILED("SSRVPRX00001", "Failed to encode data.", 500),
    DECODING_FAILED("SSRVPRX00002", "Failed to decode data.", 500),
    INVALID_PARAMETER("SSRVPRX00003", "Invalid parameter provided.", 400),
    JSON_PROCESSING_ERROR("SSRVPRX00004", "JSON processing error.", 500),
    FILE_PROCESSING_ERROR("SSRVPRX00005", "File processing error.", 500),

    ISSUER_CONNECTION_ERROR("SSRVPRX00100", "Failed to connect to Issuer.", 500),
    ISSUER_RESPONSE_ERROR("SSRVPRX00101", "Error received from Issuer.", 500),

    TRANSACTION_NOT_FOUND("SSRVPRX00300", "Transaction not found.", 400),
    INVALID_TRANSACTION_STATUS("SSRVPRX00301", "Invalid transaction status.", 400),
    PROCESS_FAILED("SSRVPRX00302", "Process execution failed.", 500);

    private final String code;
    private final String message;
    private final int httpStatus;

    /**
     * Constructor for ErrorCode enum.
     *
     * @param code The unique error code.
     * @param message The descriptive error message.
     * @param httpStatus The associated HTTP status code.
     */
    ErrorCode(String code, String message, int httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * Retrieves the error message associated with a given error code.
     *
     * @param code The error code to look up.
     * @return The corresponding error message, or a default message if the code is not found.
     */
    public static String getMessageByCode(String code) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.getCode().equals(code)) {
                return errorCode.getMessage();
            }
        }
        return "Unknown error code: " + code;
    }
}
