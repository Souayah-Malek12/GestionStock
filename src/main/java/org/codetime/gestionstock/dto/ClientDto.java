package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.Client;

@Data
@Builder
public class ClientDto {
    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto address;
    private String photo;
    private String mail;
    private String numTel;

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .address(AdresseDto.fromEntity(client.getAddress()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .build();
    }

    public static Client toEntity(ClientDto dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setAddress(AdresseDto.toEntity(dto.getAddress()));
        client.setPhoto(dto.getPhoto());
        client.setMail(dto.getMail());
        client.setNumTel(dto.getNumTel());
        return client;
    }


}