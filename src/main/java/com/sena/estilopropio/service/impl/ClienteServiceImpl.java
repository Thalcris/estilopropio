package com.sena.estilopropio.service.impl;

import com.sena.estilopropio.dto.ClienteDTO;
import com.sena.estilopropio.entity.Cliente;
import com.sena.estilopropio.exeption.ProviderException;
import com.sena.estilopropio.repository.ClienteRepository;
import com.sena.estilopropio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void create(ClienteDTO clienteDTO) {
        Optional<Cliente> result = clienteRepository.findByCorreo(clienteDTO.getCorreo());
        existClient(result, clienteDTO.getCorreo());
        persistData(Cliente.builder()
                .correo(clienteDTO.getCorreo())
                .nombre(clienteDTO.getNombre())
                .password(clienteDTO.getPassword())
                .telefono(clienteDTO.getTelefono())
                .build());
    }

    public void update(ClienteDTO clienteDTO) {
        Optional<Cliente> result = clienteRepository.findByCorreo(clienteDTO.getCorreo());
        validCliente(result, clienteDTO.getCorreo());
        persistData(Cliente.builder()
                .id(result.get().getId())
                .correo(clienteDTO.getCorreo())
                .nombre(clienteDTO.getNombre())
                .password(clienteDTO.getPassword())
                .telefono(clienteDTO.getTelefono())
                .build());
    }

    public List<ClienteDTO> searchAll() {
        List<Cliente> result = clienteRepository.findAll();
        if (CollectionUtils.isEmpty(result)) {
            return Collections.emptyList();
        }
        return result.stream().map(cliente -> ClienteDTO.builder()
                        .id(cliente.getId())
                        .nombre(cliente.getNombre())
                        .password(cliente.getPassword())
                        .telefono(cliente.getTelefono())
                        .correo(cliente.getCorreo())
                        .build())
                .collect(Collectors.toList());
    }

    public ClienteDTO searchByCorreo(String correo){
       Optional<Cliente> result = clienteRepository.findByCorreo(correo);
       validCliente(result, correo);
       Cliente cliente = result.get();
       return ClienteDTO.builder()
               .id(cliente.getId())
               .nombre(cliente.getNombre())
               .password(cliente.getPassword())
               .telefono(cliente.getTelefono())
               .correo(cliente.getCorreo())
               .build();
    }

    public ClienteDTO searchByTelefono(String telefono){
        Optional<Cliente> result = clienteRepository.findByTelefono(telefono);
        validCliente(result, telefono);
        Cliente cliente = result.get();
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .password(cliente.getPassword())
                .telefono(cliente.getTelefono())
                .correo(cliente.getCorreo())
                .build();
    }

    public void delete(String correo) {
        Optional<Cliente> result = clienteRepository.findByCorreo(correo);
        validCliente(result, correo);
        deleteData(result.get());
    }


    private void existClient(Optional<Cliente> result, String correo) {
        if (result.isPresent()) {
            throw new ProviderException(String.format("This client %s is duplicated", correo));
        }
    }

    private void validCliente(Optional<Cliente> result, String dato) {
        if (result.isEmpty()) {
            throw new ProviderException(String.format("This client %s no exists in app", dato));
        }
    }


    @Transactional
    private void persistData(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Transactional
    private void deleteData(Cliente cliente){
        clienteRepository.delete(cliente);
    }

}
