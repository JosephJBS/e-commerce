package com.dev.jbs.ecommerce.service;

import com.dev.jbs.ecommerce.dto.request.ProductoRequest;
import com.dev.jbs.ecommerce.dto.request.ProductoUpdate;
import com.dev.jbs.ecommerce.dto.response.BasicResponse;

public interface ProductoService {
    BasicResponse getProductoById(Long id);

    BasicResponse getActiveProducts();

    BasicResponse createProduct(ProductoRequest producto);

    BasicResponse deactivateProducto(Long id);

    BasicResponse updateProducto(ProductoUpdate productoUpdate);
}
