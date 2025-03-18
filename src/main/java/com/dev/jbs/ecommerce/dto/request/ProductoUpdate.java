package com.dev.jbs.ecommerce.dto.request;

import java.math.BigDecimal;

public record ProductoUpdate(
        Long id,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Integer cantidad
) {
}
