package com.lastchain.legacynft.global.security;

public enum AuthError {
    MISSING_TOKEN,
    MALFORMED_TOKEN,
    EXPIRED_TOKEN,
    INVALID_SIGNATURE,
    UNSUPPORTED_TOKEN,
    BLACKLISTED_TOKEN
}
