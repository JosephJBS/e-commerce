package com.dev.jbs.ecommerce.dto.response;

import com.dev.jbs.ecommerce.constants.ProductoResponseEnum;
import com.dev.jbs.ecommerce.model.Producto;

import java.util.List;

public class ProductoResponse extends  BasicResponse{

    public static BasicResponse productosNoEncontrados(){
        return BasicResponse
                .builder()
                .status(ProductoResponseEnum.NO_PRODUCTS_FOUND.getCode())
                .message(ProductoResponseEnum.NO_PRODUCTS_FOUND.getMessage())
                .build();
    }

    public static BasicResponse productosEncontrados(List<Producto> findProducts){
        return BasicResponse
                .builder()
                .status(ProductoResponseEnum.PRODUCTS_FOUND.getCode())
                .data(findProducts)
                .message(ProductoResponseEnum.PRODUCTS_FOUND.getMessage())
                .metadata("CANTIDAD: " + findProducts.size())
                .build();
    }
}
