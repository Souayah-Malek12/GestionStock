package org.codetime.gestionstock.validator;


import java.util.ArrayList;
import java.util.List;

import org.codetime.gestionstock.dto.AdresseDto;
import org.springframework.util.StringUtils;

public class AdresseValidator {

  public static List<String> validate(AdresseDto adresseDto) {
    List<String> errors = new ArrayList<>();

    if (adresseDto == null) {
      errors.add("Veuillez renseigner l'adresse 1'");
      errors.add("Veuillez renseigner la ville'");
      errors.add("Veuillez renseigner le pays'");
      errors.add("Veuillez renseigner le code postal'");
      return errors;
    }
    if (!StringUtils.hasLength(adresseDto.getAddress1())) {
      errors.add("Veuillez renseigner l'adresse 1'");
    }
    if (!StringUtils.hasLength(adresseDto.getVille())) {
      errors.add("Veuillez renseigner la ville'");
    }
    if (!StringUtils.hasLength(adresseDto.getPays())) {
      errors.add("Veuillez renseigner le pays'");
    }
    if (!StringUtils.hasLength(adresseDto.getAddress1())) {
      errors.add("Veuillez renseigner le code postal'");
    }
    return errors;
  }

}
