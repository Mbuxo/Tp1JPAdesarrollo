package com.example.desarrollo.repositorios;

import com.example.desarrollo.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositorio extends JpaRepository<Factura,Long> {
}
