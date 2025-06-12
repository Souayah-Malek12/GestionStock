package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.Fournisseur;

@Data
@Builder
public class FournisseurDto {
    private Integer id;

    private String nom;
    private String prenom;
    private AdresseDto address;
    private String photo;
    private String mail;
    private String numTel;

    public static FournisseurDto fromEntity(Fournisseur entity) {
        if (entity == null) return null;
        return FournisseurDto.builder()
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .address(AdresseDto.fromEntity(entity.getAddress()))
                .photo(entity.getPhoto())
                .mail(entity.getMail())
                .numTel(entity.getNumTel())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto dto) {
        if (dto == null) return null;
        Fournisseur entity = new Fournisseur();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setAddress(AdresseDto.toEntity(dto.getAddress()));
        entity.setPhoto(dto.getPhoto());
        entity.setMail(dto.getMail());
        entity.setNumTel(dto.getNumTel());
        return entity;
    }
}