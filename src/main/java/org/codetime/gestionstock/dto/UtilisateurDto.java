package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codetime.gestionstock.model.Utilisateur;

import java.time.Instant;

@Data
@Builder

public class UtilisateurDto {
    private Integer id;

    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String moteDePasse;
    private AdresseDto adresse;
    private String photo;
    private EntrepriseDto entreprise;

    public static UtilisateurDto fromEntity(Utilisateur entity) {
        if (entity == null) return null;
        return UtilisateurDto.builder()
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .email(entity.getEmail())
                .dateDeNaissance(entity.getDateDeNaissance())
                .moteDePasse(entity.getMoteDePasse())
                .adresse(AdresseDto.fromEntity(entity.getAdresse()))
                .photo(entity.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(entity.getEntreprise()))
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) return null;
        Utilisateur entity = new Utilisateur();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());
        entity.setDateDeNaissance(dto.getDateDeNaissance());
        entity.setMoteDePasse(dto.getMoteDePasse());
        entity.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        entity.setPhoto(dto.getPhoto());
        entity.setEntreprise(EntrepriseDto.toEntity(dto.getEntreprise()));
        return entity;
    }
}