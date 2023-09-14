package com.example.desarrollo.entidades;



import com.example.desarrollo.Enumeraciones.FormadePago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura extends BaseEntidad {
    private Integer numero;
   private Date fecha;
    private Double descuento;
    @Enumerated (EnumType.STRING)
    private FormadePago formapago;
    private Double total;

    public void calcularTotalConDescuento() {
        if (descuento != null && descuento > 0) {
            double descuentoAplicado = total * (descuento / 100.0);

            total = total - descuentoAplicado;
        } else {
            total = total;
        }
    }
}



