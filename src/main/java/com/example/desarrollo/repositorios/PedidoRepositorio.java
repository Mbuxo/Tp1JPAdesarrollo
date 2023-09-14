package com.example.desarrollo.repositorios;

import com.example.desarrollo.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido,Long> {
}
