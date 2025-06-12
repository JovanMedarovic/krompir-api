package com.dragacevoshop.krompirApi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    String imageUrl;
    @Column(nullable = false)
    Float price;
    @Column(nullable = false)
    String unit;
}
