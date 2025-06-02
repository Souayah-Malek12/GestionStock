package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.Roles;

@Data
@Builder
public class RolesDto {
    private String roleName;
    private UtilisateurDto utilisateur;

    public static RolesDto fromEntity(Roles entity) {
        if (entity == null) return null;
        return RolesDto.builder()
                .roleName(entity.getRoleName())
                .utilisateur(UtilisateurDto.fromEntity(entity.getUtilisateur()))
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if (dto == null) return null;
        Roles entity = new Roles();
        entity.setRoleName(dto.getRoleName());
        entity.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateur()));
        return entity;
    }
}