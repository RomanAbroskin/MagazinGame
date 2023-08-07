package org.top.magazin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String account;

    @ManyToMany(mappedBy = "client")
    private Set<Admin> admins;

    @OneToOne
    @JoinColumn(name = "personalAccount_id")
    private PersonalAccount personalAccount;

    @ManyToMany
    @JoinColumn(name = "produсt_id")
    private Set<Product> Basket;


}
