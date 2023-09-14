package com.example.desarrollo.entidades;

import com.example.desarrollo.Enumeraciones.EstadoPedido;
import com.example.desarrollo.Enumeraciones.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido extends BaseEntidad {
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    private Date fecha;
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoenvio;
    private Double total;




    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallesPedidos = new ArrayList<>();
    public void agregarDetallepedido (DetallePedido detped){
        detallesPedidos.add(detped);
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id",nullable = true)
    private Factura factura;
}
