package com.northwind.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories", schema = "dbo")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid", updatable = false, nullable = false)
    private Long categoryId;
    @Column(name = "categoryname")
    private String categoryName;
    @Column(name = "description")
    private String description;
}
