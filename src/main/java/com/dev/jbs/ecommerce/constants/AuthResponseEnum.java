package com.dev.jbs.ecommerce.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum AuthResponseEnum {

    SUCCESS_LOGIN(200,"Ingreso valido"),
    NO_USER_FOUND(400,"Usuario no encontrado"),
    PASSWORD_INCORRECT(401,"Credenciales Incorrectas");

    private final int code;
    private final String message;
}
