package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.LigneCommandeFournisseur;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private ArticleDto article;
    private CommandeFournisseurDto commandeFournisseur;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur entity) {
        if (entity == null) return null;
        return LigneCommandeFournisseurDto.builder()
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .commandeFournisseur(CommandeFournisseurDto.fromEntity(entity.getCommandeFournisseur()))
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto dto) {
        if (dto == null) return null;
        LigneCommandeFournisseur entity = new LigneCommandeFournisseur();
        entity.setArticle(ArticleDto.toEntity(dto.getArticle()));
        entity.setCommandeFournisseur(CommandeFournisseurDto.toEntity(dto.getCommandeFournisseur()));
        return entity;
    }
}