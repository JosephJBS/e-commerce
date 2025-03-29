package com.dev.jbs.ecommerce.constants;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;

public class Constants {
    public static final String SECRET_KEY = "Blp1yKfXrG22FH7pgcUk5rGjU4gSrPk274dwvvDE3IM=";

    public static SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY); // Decodifica Base64
        return Keys.hmacShaKeyFor(keyBytes); // Crea la clave de firma
    }
}
