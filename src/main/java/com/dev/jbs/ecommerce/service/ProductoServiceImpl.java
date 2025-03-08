package com.dev.jbs.ecommerce.service;

import com.dev.jbs.ecommerce.dto.response.BasicResponse;
import com.dev.jbs.ecommerce.dto.response.ProductoResponse;
import com.dev.jbs.ecommerce.model.Producto;
import com.dev.jbs.ecommerce.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public BasicResponse getActiveProducts() {

        List<Producto> findProducts = productoRepository.findByEstado(true);

        if(findProducts.isEmpty()) return ProductoResponse.productosNoEncontrados();

        //log.info("Informacion obtenida - {}", findProducts);

        return ProductoResponse.productosEncontrados(findProducts);
    }
}
