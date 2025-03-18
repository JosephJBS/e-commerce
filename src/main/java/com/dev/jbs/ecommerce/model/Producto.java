package com.dev.jbs.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer cantidad;
    private boolean estado;


}
