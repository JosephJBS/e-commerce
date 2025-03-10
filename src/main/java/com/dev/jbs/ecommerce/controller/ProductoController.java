package com.dev.jbs.ecommerce.controller;

import com.dev.jbs.ecommerce.dto.request.ProductoRequest;
import com.dev.jbs.ecommerce.dto.response.BasicResponse;
import com.dev.jbs.ecommerce.model.Producto;
import com.dev.jbs.ecommerce.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<BasicResponse> getProductoById(@PathVariable Long id) {
        try {
            BasicResponse response = productoService.getProductoById(id);

            /*URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand( ((Producto) response.getData()).getId())
                    .toUri();*/


            return ResponseEntity.status(HttpStatus.OK).body(productoService.getProductoById(id));

            //return ResponseEntity.created(location).body(response);

        } catch (Exception e) {
            log.error("Error al obtener productos: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Error al obtener productos")
                            .data(null)
                            .build());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<BasicResponse> getActiveProducts() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.getActiveProducts());
        } catch (Exception e) {
            log.error("Error al obtener productos: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Error al obtener productos")
                            .data(null)
                            .build());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BasicResponse> createProduct(@RequestBody ProductoRequest producto) {
        try {
            // Construimos la URL del nuevo recurso
            BasicResponse nuevoProducto = productoService.createProduct(producto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand((Long) nuevoProducto.getData())
                    .toUri();

            return ResponseEntity.created(location).body(nuevoProducto);

            //return ResponseEntity.status(HttpStatus.OK).body(productoService.createProduct(producto));
        } catch (Exception e) {
            log.error("Error al crear el producto: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Error al crear registro")
                            .data(null)
                            .build());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BasicResponse> desactivarProducto (@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.deactivateProducto(id));
        } catch (Exception e) {
            log.error("Error desactivarProducto: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Error al eliminar producto")
                            .data(null)
                            .build());
        }
    }

}
