package org.top.magazin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private Date date;

    @Column
    private String role;

    @ManyToMany
    @JoinColumn(name = "produсt_id")
    private Set<Product> Basket;

    public String creationDateFormatted() {
        if(date!=null){
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            return formatter.format(date);
        } return null;
    }
}
