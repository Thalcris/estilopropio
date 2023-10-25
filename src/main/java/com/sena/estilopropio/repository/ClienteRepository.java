package com.sena.estilopropio.repository;

import com.sena.estilopropio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCorreo(String correo);

    Optional<Cliente> findByTelefono(String telefono);
}
