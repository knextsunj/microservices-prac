package com.github.knextsunj.productcompositeservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProductAggregate {
    private long productId;
    private String name;
    private  long weight;
    private List<RecommendationSummary> recommendations;
    private List<ReviewSummary> reviews;
    private ServiceAddresses serviceAddresses;

    public ProductAggregate(
        long productId,
        String name,
        long weight,
        List<RecommendationSummary> recommendations,
        List<ReviewSummary> reviews,
        ServiceAddresses serviceAddresses) {

        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.serviceAddresses = serviceAddresses;
    }

 }
