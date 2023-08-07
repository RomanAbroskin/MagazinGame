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
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToMany
    @JoinColumn(name = "client_id")
    private Set<Client> client;

    @ManyToMany
    @JoinColumn(name = "PersonalAccount_id")
    private Set<PersonalAccount> personalAccount;

    @ManyToMany
    @JoinColumn(name = "product_id")
    private Set<Product> product;








}
