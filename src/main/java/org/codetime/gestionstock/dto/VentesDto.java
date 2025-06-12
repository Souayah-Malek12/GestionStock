package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.Ventes;

import java.time.Instant;

@Data
@Builder
public class VentesDto {
    private Integer id;

    private String code;
    private Instant dateVente;
    private String commentaire;
    private Integer idEntreprise;

    public static VentesDto fromEntity(Ventes entity) {
        if (entity == null) return null;
        return VentesDto.builder()
                .code(entity.getCode())
                .dateVente(entity.getDateVente())
                .commentaire(entity.getCommentaire())
                .idEntreprise(entity.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VentesDto dto) {
        if (dto == null) return null;
        Ventes entity = new Ventes();
        entity.setCode(dto.getCode());
        entity.setDateVente(dto.getDateVente());
        entity.setCommentaire(dto.getCommentaire());
        entity.setIdEntreprise(dto.getIdEntreprise());
        return entity;
    }
}