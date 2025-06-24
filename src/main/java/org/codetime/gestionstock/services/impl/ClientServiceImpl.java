package org.codetime.gestionstock.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.codetime.gestionstock.dto.ClientDto;
import org.codetime.gestionstock.exception.EntityNotFoundException;
import org.codetime.gestionstock.exception.ErrorCodes;
import org.codetime.gestionstock.exception.InvalidEntityException;
import org.codetime.gestionstock.exception.InvalidOperationException;
import org.codetime.gestionstock.model.CommandeClient;
import org.codetime.gestionstock.repository.ClientRepository;
import org.codetime.gestionstock.repository.CommandeClientRepository;
import org.codetime.gestionstock.services.ClientService;
import org.codetime.gestionstock.validator.ClientValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {


    private ClientRepository clientRepository;
    private CommandeClientRepository commandeClientRepository;

    public ClientServiceImpl(ClientRepository clientRepository, CommandeClientRepository commandeClientRepository) {
        this.clientRepository = clientRepository;
        this.commandeClientRepository = commandeClientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto){
        List<String> errors = ClientValidator.validate(clientDto);

        if(!errors.isEmpty()){
            log.error("Client is not valid {}", clientDto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);

        }

        return ClientDto.fromEntity(
                clientRepository.save(ClientDto.toEntity(clientDto))
        );
    }

    @Override
    public ClientDto findById(Integer Id){
            if(Id==null){
                log.error("Client ID is null");
                return null;
            }

            return clientRepository.findById(Id)
                    .map(ClientDto::fromEntity)
                    .orElseThrow(
                            ()->new EntityNotFoundException(
                                    "Aucun Client avec l'ID = " + Id + " n' ete trouve dans la BDD",
                                    ErrorCodes.CLIENT_NOT_FOUND)
                    );
    }

    @Override
    public List<ClientDto> findAll(){
       return  clientRepository.findAll()
               .stream()
               .map(ClientDto::fromEntity)
               .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if(id==null){
            log.error("Client ID is null");
            return;
        }

        List<CommandeClient> commandeClients = commandeClientRepository.findAllByClientId(id);
        if(!commandeClients.isEmpty()){
            throw new InvalidOperationException("Impossible de supprimer un client qui a deja des commande clients",
                    ErrorCodes.CLIENT_ALREADY_IN_USE);        }

        clientRepository.deleteById(id);
    }

}
