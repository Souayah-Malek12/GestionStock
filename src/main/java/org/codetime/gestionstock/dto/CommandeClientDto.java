package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codetime.gestionstock.model.CommandeClient;
import org.codetime.gestionstock.model.EtatCommande;

import java.time.Instant;

@Data
@Builder
@Getter
@Setter
public class CommandeClientDto {
    private Integer id;
    private EtatCommande etatCommande;
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
    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }

    public ClientDto getClient() {
        return client;
    }

    public Integer getId() {
        return id;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public Instant getDateCommande() {
        return dateCommande;
    }

    public String getCode() {
        return code;
    }
}