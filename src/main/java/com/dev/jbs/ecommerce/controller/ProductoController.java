package com.dev.jbs.ecommerce.controller;

import com.dev.jbs.ecommerce.dto.response.BasicResponse;
import com.dev.jbs.ecommerce.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/getProducts")
    public ResponseEntity<BasicResponse> getActiveProducts(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productoService.getActiveProducts());
        }catch (Exception e){
            //log.error("Error al obtener productos: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Error al obtener productos")
                            .data(null)
                            .build());
        }
    }

}
