package org.top.magazin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class PersonalAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "personalAccount")
    private Client client;

    @ManyToMany
    @JoinColumn(name = "myGames_id")
    private Set<Product> games;

    @ManyToMany(mappedBy = "personalAccount")
    private Set<Admin> adminSet;

}
