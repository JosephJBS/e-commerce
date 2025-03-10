package com.dev.jbs.ecommerce.dto.request;

import java.math.BigDecimal;

public record ProductoRequest(
        String nombre,
        String descripcion,
        BigDecimal precio,
        int cantidad,
        boolean estado
) {}