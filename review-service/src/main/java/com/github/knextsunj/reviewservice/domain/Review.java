package com.github.knextsunj.reviewservice.domain;

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
@Table(name = "review")
public class Review {

    @Column(name = "product_id")
    private long productId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "author")
    private String author;
    @Column(name = "subject")
    private String subject;
    @Column(name = "content")
    private String content;
    private String serviceAddress;

    public Review() {
        productId = 0L;
        id = 0L;
        author = null;
        subject = null;
        content = null;
        serviceAddress = null;
    }

    public Review(int productId, int reviewId, String author, String subject, String content, String serviceAddress) {
        this.productId = productId;
        this.id = reviewId;
        this.author = author;
        this.subject = subject;
        this.content = content;
        this.serviceAddress = serviceAddress;
    }


}
