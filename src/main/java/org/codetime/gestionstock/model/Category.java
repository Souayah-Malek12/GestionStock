package org.codetime.gestionstock.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="Category")
public class Category extends AbstractEntity{
    @Column(name="code")
    private String code;

    @Column(name="designation")
    private String designation;

    @OneToMany(mappedBy ="category")
    private List<Article> articles;


}
