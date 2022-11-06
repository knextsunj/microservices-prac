package com.github.knextsunj.recommendationservice.recommendationservice.domain;

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
@Table(name = "recommendation")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "product_id")
    private long productId;
    @Column(name = "author")
    private String author;

    @Column(name = "rate")
    private long rate;

    @Column(name = "content")
    private String content;

    private String serviceAddress;

    public Recommendation() {
        productId = 0L;
        id = 0L;
        author = null;
        rate = 0L;
        content = null;
        serviceAddress = null;
    }

    public Recommendation(long productId, long recommendationId, String author, long rate, String content, String serviceAddress) {
        this.productId = productId;
        this.id = recommendationId;
        this.author = author;
        this.rate = rate;
        this.content = content;
        this.serviceAddress = serviceAddress;
    }
}
