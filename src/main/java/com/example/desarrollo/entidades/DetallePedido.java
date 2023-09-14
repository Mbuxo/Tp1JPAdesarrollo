package com.example.desarrollo.entidades;

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
public class DetallePedido extends BaseEntidad {
    private Integer cantidad;
    private Double subtotal;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn (name ="producto_id")
private Producto producto;

}
