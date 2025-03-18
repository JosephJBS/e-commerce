package com.dev.jbs.ecommerce.service;

import com.dev.jbs.ecommerce.dto.request.ProductoRequest;
import com.dev.jbs.ecommerce.dto.request.ProductoUpdate;
import com.dev.jbs.ecommerce.dto.response.BasicResponse;
import com.dev.jbs.ecommerce.dto.response.ProductoResponse;
import com.dev.jbs.ecommerce.model.Producto;
import com.dev.jbs.ecommerce.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public BasicResponse getProductoById(Long id) {
        Optional<Producto> findProducto = productoRepository.findById(id);

        return BasicResponse
                .builder()
                .status(200)
                .data(findProducto.get())
                .message("Producto Encontrado")
                .build();
    }

    @Override
    public BasicResponse getActiveProducts() {

        List<Producto> findProducts = productoRepository.findByEstado(true);

        if(findProducts.isEmpty()) return ProductoResponse.productosNoEncontrados();

        log.info("Informacion obtenida - {}", findProducts);

        return ProductoResponse.productosEncontrados(findProducts);
    }

    @Override
    public BasicResponse createProduct(ProductoRequest producto) {

        if(producto == null) return ProductoResponse.productoNoRegistrado();

         Producto createProducto = productoRepository
                .save(Producto
                        .builder()
                        .nombre(producto.nombre())
                        .descripcion(producto.descripcion())
                        .precio(producto.precio())
                        .estado(producto.estado())
                        .cantidad(10)
                        .build());

         return ProductoResponse.productoCreado(createProducto.getId());
    }

    @Override
    public BasicResponse deactivateProducto(Long id) {

        int modifiedRows = productoRepository.deactivateProducto(id);

        if(modifiedRows == 0) return ProductoResponse.productoNoEncontrado();

        return ProductoResponse.productoEliminado();

    }

    @Override
    public BasicResponse updateProducto(ProductoUpdate productoUpdate) {
        Optional<Producto> productoOptional = productoRepository.findById(productoUpdate.id());

        if(!productoOptional.isPresent()) return ProductoResponse.productoNoEncontrado();

        Producto producto = productoOptional.get();

        if(!producto.isEstado()) return ProductoResponse.productosInactivo();

        Optional.ofNullable(productoUpdate.descripcion()).ifPresent(producto::setDescripcion);
        Optional.ofNullable(productoUpdate.nombre()).ifPresent(producto::setNombre);
        Optional.ofNullable(productoUpdate.precio()).ifPresent(producto::setPrecio);
        Optional.ofNullable(productoUpdate.cantidad()).ifPresent(producto::setCantidad);

        productoRepository.save(producto);

        return ProductoResponse.productoEditado(producto);
    }

}
