package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.CommandeFournisseur;

import java.time.Instant;

@Data
@Builder
public class CommandeFournisseurDto {
    private String code;
    private Instant dateCommande;
    private FournisseurDto fournisseur;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur entity) {
        if (entity == null) {
            return null;
        }
        return CommandeFournisseurDto.builder()
                .code(entity.getCode())
                .dateCommande(entity.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(entity.getFournisseur()))
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeFournisseur entity = new CommandeFournisseur();
        entity.setCode(dto.getCode());
        entity.setDateCommande(dto.getDateCommande());
        entity.setFournisseur(FournisseurDto.toEntity(dto.getFournisseur()));
        return entity;
    }
}