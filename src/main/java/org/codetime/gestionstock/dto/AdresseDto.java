package org.codetime.gestionstock.dto;

import lombok.Builder;
import lombok.Data;
import org.codetime.gestionstock.model.Address;

@Data
@Builder
public class AdresseDto {
    private String address1;
    private String address2;
    private String ville;
    private String codePostal;
    private String pays;

    public static AdresseDto fromEntity(Address address) {
        if (address == null) {
            return null;
        }
        return AdresseDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .ville(address.getVille())
                .codePostal(address.getCodePostal())
                .pays(address.getPays())
                .build();
    }

    public static Address toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        Address address = new Address();
        address.setAddress1(adresseDto.getAddress1());
        address.setAddress2(adresseDto.getAddress2());
        address.setVille(adresseDto.getVille());
        address.setCodePostal(adresseDto.getCodePostal());
        address.setPays(adresseDto.getPays());
        return address;
    }
}