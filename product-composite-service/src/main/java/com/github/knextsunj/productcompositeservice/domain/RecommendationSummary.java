package com.github.knextsunj.productcompositeservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RecommendationSummary {

    private long recommendationId;
    private final String author;
    private long rate;

    public RecommendationSummary(long recommendationId, String author, long rate) {
        this.recommendationId = recommendationId;
        this.author = author;
        this.rate = rate;
    }


}
