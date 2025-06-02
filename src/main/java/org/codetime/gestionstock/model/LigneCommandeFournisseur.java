package org.codetime.gestionstock.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Ligne commande Fournisseur")
@EqualsAndHashCode(callSuper = true)

public class LigneCommandeFournisseur extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "commandefournisseur")
    private CommandeFournisseur commandeFournisseur;

}
