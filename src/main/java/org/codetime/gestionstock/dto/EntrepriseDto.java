package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.Entreprise;

@Data
@Builder
public class EntrepriseDto {
    private Integer id;

    private String nom;
    private String description;
    private AdresseDto addresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numTel;
    private String steWeb;

    public static EntrepriseDto fromEntity(Entreprise entity) {
        if (entity == null) return null;
        return EntrepriseDto.builder()
                .nom(entity.getNom())
                .description(entity.getDescription())
                .addresse(AdresseDto.fromEntity(entity.getAddresse()))
                .codeFiscal(entity.getCodeFiscal())
                .photo(entity.getPhoto())
                .email(entity.getEmail())
                .numTel(entity.getNumTel())
                .steWeb(entity.getSteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto dto) {
        if (dto == null) return null;
        Entreprise entity = new Entreprise();
        entity.setNom(dto.getNom());
        entity.setDescription(dto.getDescription());
        entity.setAddresse(AdresseDto.toEntity(dto.getAddresse()));
        entity.setCodeFiscal(dto.getCodeFiscal());
        entity.setPhoto(dto.getPhoto());
        entity.setEmail(dto.getEmail());
        entity.setNumTel(dto.getNumTel());
        entity.setSteWeb(dto.getSteWeb());
        return entity;
    }
}