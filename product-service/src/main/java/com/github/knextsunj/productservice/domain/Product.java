package com.github.knextsunj.productservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private long weight;

    private final String serviceAddress;

    public Product() {
        id = 0L;
        name = null;
        weight = 0L;
        serviceAddress = null;
    }

    public Product(long productId, String name, long weight, String serviceAddress) {
        this.id = productId;
        this.name = name;
        this.weight = weight;
        this.serviceAddress = serviceAddress;
    }
}
