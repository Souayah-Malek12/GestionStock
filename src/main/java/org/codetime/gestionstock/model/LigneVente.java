package org.codetime.gestionstock.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ligneVente")
@EqualsAndHashCode(callSuper = true)
public class LigneVente extends AbstractEntity{
}
