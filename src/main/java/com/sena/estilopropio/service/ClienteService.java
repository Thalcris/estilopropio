package com.sena.estilopropio.service;

import com.sena.estilopropio.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    void create(ClienteDTO clienteDTO);

    void update(ClienteDTO clienteDTO);

    List<ClienteDTO> searchAll();

    ClienteDTO searchByCorreo(String correo);

    ClienteDTO searchByTelefono(String telefono);

    void delete(String correo);
}
