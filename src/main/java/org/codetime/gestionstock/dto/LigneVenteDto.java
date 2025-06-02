package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.LigneVente;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {
    private VentesDto vente;
    private ArticleDto article;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;

    public static LigneVenteDto fromEntity(LigneVente entity) {
        if (entity == null) return null;
        return LigneVenteDto.builder()
                .vente(VentesDto.fromEntity(entity.getVente()))
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .quantite(entity.getQuantite())
                .prixUnitaire(entity.getPrixUnitaire())
                .idEntreprise(entity.getIdEntreprise())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto dto) {
        if (dto == null) return null;
        LigneVente entity = new LigneVente();
        entity.setVente(VentesDto.toEntity(dto.getVente()));
        entity.setArticle(ArticleDto.toEntity(dto.getArticle()));
        entity.setQuantite(dto.getQuantite());
        entity.setPrixUnitaire(dto.getPrixUnitaire());
        entity.setIdEntreprise(dto.getIdEntreprise());
        return entity;
    }
}