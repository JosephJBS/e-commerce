package com.dev.jbs.ecommerce.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductoResponseEnum {
    PRODUCTS_FOUND(200, "Productos encontrados"),
    PRODUCTS_DEACTIVATE(200, "Productos eliminado"),
    PRODUCT_CREATED(201,"Producto Registrado"),
    NO_PRODUCTS_FOUND(404, "No hay productos activos"),
    NO_PRODUCT_FOUND(404, "No se encontro el producto seleccionado"),
    BAD_REQUEST_PRODUCTO(400, "No se registro el producto");

    private final int code;
    private final String message;
}