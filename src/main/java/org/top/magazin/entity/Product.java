package org.top.magazin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
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
    private Double price;

    @Column(length = 1024)
    private String description;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String img;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateGod;

    @ManyToMany(mappedBy = "Basket")
    private Set<Client> client;
    
    public String creationDateFormatted() {
        if(date!=null){
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            return formatter.format(date);
        } return null;
    }
}
