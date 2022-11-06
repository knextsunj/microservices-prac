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

    private final long recommendationId;
    private final String author;
    private final long rate;
    private final String content;

    public RecommendationSummary() {
        this.recommendationId = 0L;
        this.author = null;
        this.rate = 0L;
        this.content = null;
    }

    public RecommendationSummary(long recommendationId, String author, long rate, String content) {
        this.recommendationId = recommendationId;
        this.author = author;
        this.rate = rate;
        this.content = content;
    }




}
