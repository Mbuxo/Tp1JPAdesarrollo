package com.example.desarrollo.entidades;

import com.example.desarrollo.Enumeraciones.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntidad{
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private Integer tiempoEstimadoCocina;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMinimo;
    private String unidadMedida;
    private String receta;



}
