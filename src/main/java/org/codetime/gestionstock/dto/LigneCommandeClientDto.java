package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codetime.gestionstock.model.LigneCommandeClient;

@Data
@Builder
@Getter
@Setter
public class LigneCommandeClientDto {
    private Integer id;

    private ArticleDto article;
    private CommandeClientDto commandeClient;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient entity) {
        if (entity == null) return null;
        return LigneCommandeClientDto.builder()
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .commandeClient(CommandeClientDto.fromEntity(entity.getCommandeClient()))
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto dto) {
        if (dto == null) return null;
        LigneCommandeClient entity = new LigneCommandeClient();
        entity.setArticle(ArticleDto.toEntity(dto.getArticle()));
        entity.setCommandeClient(CommandeClientDto.toEntity(dto.getCommandeClient()));
        return entity;
    }
}