package org.codetime.gestionstock.services;

import org.codetime.gestionstock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);
    ClientDto findById(Integer id);
    List<ClientDto> findAll();
    void delete(Integer id);
}
