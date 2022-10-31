package com.github.knextsunj.productcompositeservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ReviewSummary {

    private long reviewId;
    private String author;
    private String subject;

    public ReviewSummary(long reviewId, String author, String subject) {
        this.reviewId = reviewId;
        this.author = author;
        this.subject = subject;
    }


}
