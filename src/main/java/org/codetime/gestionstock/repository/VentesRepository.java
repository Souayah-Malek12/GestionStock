package org.codetime.gestionstock.repository;


import java.util.Optional;

import org.codetime.gestionstock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

  Optional<Ventes> findVentesByCode(String code);
}
