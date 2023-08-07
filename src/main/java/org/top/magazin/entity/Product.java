package org.top.magazin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String manufacturer;

    @Column
    private Date date;

    @Column
    private Integer price;

    @ManyToMany(mappedBy = "Basket")
    private Set<Client> client;

    @ManyToMany(mappedBy = "games")
    private Set<PersonalAccount> personalAccounts;

    @ManyToMany(mappedBy = "product")
    private Set<Admin> admin;

}
