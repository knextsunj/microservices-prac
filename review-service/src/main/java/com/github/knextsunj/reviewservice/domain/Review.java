package com.github.knextsunj.reviewservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Review {

    private long productId;
    private long id;
    private String author;
    private String subject;
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
