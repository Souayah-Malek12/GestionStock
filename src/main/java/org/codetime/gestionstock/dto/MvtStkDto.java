package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.MvtStk;
import org.codetime.gestionstock.model.TypeMvtStk;
import org.codetime.gestionstock.model.SourceMvtStk;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {
    private Instant dateMvt;
    private BigDecimal quantite;
    private ArticleDto article;
    private TypeMvtStk typeMvt;
    private SourceMvtStk sourceMvt;
    private Integer idEntreprise;

    public static MvtStkDto fromEntity(MvtStk entity) {
        if (entity == null) return null;
        return MvtStkDto.builder()
                .dateMvt(entity.getDateMvt())
                .quantite(entity.getQuantite())
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .typeMvt(entity.getTypeMvt())
                .sourceMvt(entity.getSourceMvt())
                .idEntreprise(entity.getIdEntreprise())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) return null;
        MvtStk entity = new MvtStk();
        entity.setDateMvt(dto.getDateMvt());
        entity.setQuantite(dto.getQuantite());
        entity.setArticle(ArticleDto.toEntity(dto.getArticle()));
        entity.setTypeMvt(dto.getTypeMvt());
        entity.setSourceMvt(dto.getSourceMvt());
        entity.setIdEntreprise(dto.getIdEntreprise());
        return entity;
    }
}