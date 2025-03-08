package com.dev.jbs.ecommerce.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductoResponseEnum {
    PRODUCTS_FOUND(200, "Productos encontrados"),
    NO_PRODUCTS_FOUND(404, "No hay productos activos");

    private final int code;
    private final String message;
}