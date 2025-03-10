package com.dev.jbs.ecommerce.dto.response;

import com.dev.jbs.ecommerce.constants.ProductoResponseEnum;
import com.dev.jbs.ecommerce.model.Producto;

import java.util.List;

public class ProductoResponse extends  BasicResponse{

    public static BasicResponse productoNoEncontrados(){
        return BasicResponse
                .builder()
                .status(ProductoResponseEnum.NO_PRODUCTS_FOUND.getCode())
                .message(ProductoResponseEnum.NO_PRODUCTS_FOUND.getMessage())
                .build();
    }

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

    public static BasicResponse productoNoRegistrado(){
        return BasicResponse
                .builder()
                .status(ProductoResponseEnum.BAD_REQUEST_PRODUCTO.getCode())
                .data(null)
                .message(ProductoResponseEnum.BAD_REQUEST_PRODUCTO.getMessage())
                .metadata(null)
                .build();
    }

    public static BasicResponse productoCreado(Long id){
        return BasicResponse
                .builder()
                .status(ProductoResponseEnum.PRODUCT_CREATED.getCode())
                .data(id)
                .message(ProductoResponseEnum.PRODUCT_CREATED.getMessage())
                .metadata(null)
                .build();
    }

    public static BasicResponse productoEliminado(){
        return BasicResponse
                .builder()
                .status(ProductoResponseEnum.PRODUCTS_DEACTIVATE.getCode())
                .data(null)
                .message(ProductoResponseEnum.PRODUCTS_DEACTIVATE.getMessage())
                .metadata(null)
                .build();
    }
}
