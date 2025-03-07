package com.dev.jbs.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @GetMapping("/prueba")
    public String pruebaApi(){
        return "Si funciana";
    }

}
