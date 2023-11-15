package com.northwind.api.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "productphoto")
@AllArgsConstructor
@NoArgsConstructor
public class ProductPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prohoid")
    private Long prohoId;

    @Column(name = "prohofilename")
    private String prohoFileName;

    @Column(name = "prohofiletype")
    private String prohoFileType;

    @Column(name = "prohosize")
    private Long prohoSize;

    @Column(name = "prohourl")
    private String prohoUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productid", nullable = false)
    private Product product;

}
