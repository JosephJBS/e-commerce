package com.dev.jbs.ecommerce.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum Role {
    ADMIN_USER(1, "ADMINISTRADOR","Usuario Administrador"),
    NORMAL_USER(2, "USER","Usuario normal");

    private final int idRole;
    private final String role;
    private final String roleDescription;
}
