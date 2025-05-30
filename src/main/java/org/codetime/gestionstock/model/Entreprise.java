package org.codetime.gestionstock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="entreprise")
public class Entreprise extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "entreprise")
    private CommandeClient commandeClient;

    @OneToMany(mappedBy = "entreprise")
    private CommandeFournisseur commandeFournisseur;
}
