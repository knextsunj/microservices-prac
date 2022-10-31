package com.github.knextsunj.productcompositeservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Recommendation {

    private long id;

    private long productId;

    private String author;

    private long rate;

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
