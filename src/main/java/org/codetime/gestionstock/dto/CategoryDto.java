package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.Category;

@Data
@Builder
public class CategoryDto {
    private String code;
    private String designation;
    private Integer idEntreprise;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        }
        return CategoryDto.builder()
                .code(category.getCode())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }

    public static Category toEntity(CategoryDto dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category();
        category.setCode(dto.getCode());
        category.setDesignation(dto.getDesignation());
        category.setIdEntreprise(dto.getIdEntreprise());
        return category;
    }
}