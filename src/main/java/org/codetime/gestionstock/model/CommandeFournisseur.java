    package org.codetime.gestionstock.model;


    import jakarta.persistence.*;
    import lombok.*;
    import lombok.experimental.SuperBuilder;

    import java.time.Instant;
    import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name="commande fournisseur")
    @EqualsAndHashCode(callSuper = true)
    public class CommandeFournisseur extends AbstractEntity{

        @Column(name="code")
        private String code;

        @Column(name="dateCommande")
        private Instant dateCommande;

        @ManyToOne
        @JoinColumn(name = "idFournisseur")
        private Fournisseur fournisseur;

        @OneToMany(mappedBy = "commandeFournisseur")
        private List<LigneCommandeFournisseur>  ligneCommandeFournisseurs;
    }
