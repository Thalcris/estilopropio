package com.sena.estilopropio.controller;

import com.sena.estilopropio.dto.ClienteDTO;
import com.sena.estilopropio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/estilopropio")
@CrossOrigin("*")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(value = "/v1/cliente")
    public ResponseEntity<Void> create(@Valid @RequestBody ClienteDTO clienteDTO) {
        clienteService.create(clienteDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/v1/cliente")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO clienteDTO) {
        clienteService.update(clienteDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/v1/cliente")
    public ResponseEntity<List<ClienteDTO>> searchAll() {
        return ResponseEntity.ok(clienteService.searchAll());
    }

    @GetMapping(value = "/v1/cliente/by-correo/{correo}")
    public ResponseEntity<ClienteDTO> searchByCorreo(@PathVariable String correo) {
        return ResponseEntity.ok(clienteService.searchByCorreo(correo));
    }

    @GetMapping(value = "/v1/cliente/by-telefono/{telefono}")
    public ResponseEntity<ClienteDTO> searchByTelefono(@PathVariable String telefono) {
        return ResponseEntity.ok(clienteService.searchByTelefono(telefono));
    }

    @DeleteMapping(value = "/v1/cliente/{correo}")
    public ResponseEntity<Void> delete(@PathVariable String correo) {
        clienteService.delete(correo);
        return ResponseEntity.noContent().build();
    }

}
