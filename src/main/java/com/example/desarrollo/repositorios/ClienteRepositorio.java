package com.example.desarrollo.repositorios;

import com.example.desarrollo.entidades.Cliente;
import com.example.desarrollo.entidades.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {





}
