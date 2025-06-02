package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.CommandeClient;

import java.time.Instant;

@Data
@Builder
public class CommandeClientDto {
    private String code;
    private Instant dateCommande;
    private ClientDto client;

    public static CommandeClientDto fromEntity(CommandeClient entity) {
        if (entity == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .code(entity.getCode())
                .dateCommande(entity.getDateCommande())
                .client(ClientDto.fromEntity(entity.getClient()))
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeClient entity = new CommandeClient();
        entity.setCode(dto.getCode());
        entity.setDateCommande(dto.getDateCommande());
        entity.setClient(ClientDto.toEntity(dto.getClient()));
        return entity;
    }
}