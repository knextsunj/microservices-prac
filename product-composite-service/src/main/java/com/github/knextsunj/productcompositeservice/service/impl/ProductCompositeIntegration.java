package com.github.knextsunj.productcompositeservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.knextsunj.productcompositeservice.domain.Product;
import com.github.knextsunj.productcompositeservice.domain.Recommendation;
import com.github.knextsunj.productcompositeservice.domain.Review;
import com.github.knextsunj.productcompositeservice.exception.InvalidInputException;
import com.github.knextsunj.productcompositeservice.exception.NotFoundException;
import com.github.knextsunj.productcompositeservice.util.HttpErrorInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Component
public class ProductCompositeIntegration {

    private static final Logger logger = LogManager.getLogger(ProductCompositeIntegration.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    @Autowired
    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,

            @Value("${app.product-service.host}") String productServiceHost,
            @Value("${app.product-service.port}") int    productServicePort,

            @Value("${app.recommendation-service.host}") String recommendationServiceHost,
            @Value("${app.recommendation-service.port}") int    recommendationServicePort,

            @Value("${app.review-service.host}") String reviewServiceHost,
            @Value("${app.review-service.port}") int    reviewServicePort
    ) {

        this.restTemplate = restTemplate;
        this.mapper = mapper;

        productServiceUrl        = "http://" + productServiceHost + ":" + productServicePort + "/product/";
        recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort + "/recommendation?productId=";
        reviewServiceUrl         = "http://" + reviewServiceHost + ":" + reviewServicePort + "/review?productId=";
    }

    public Product getProduct(int productId) {

        try {
            String url = productServiceUrl + productId;
            logger.debug("Will call getProduct API on URL: {}", url);

            Product product = restTemplate.getForObject(url, Product.class);
            logger.debug("Found a product with id: {}", product.getId());

            return product;

        } catch (HttpClientErrorException ex) {

            switch (ex.getStatusCode()) {

                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY :
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    logger.warn("Got a unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    logger.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        } catch (IOException ioex) {
            return ex.getMessage();
        }
    }

    public List<Recommendation> getRecommendations(int productId) {

        try {
            String url = recommendationServiceUrl + productId;

            logger.debug("Will call getRecommendations API on URL: {}", url);
            List<Recommendation> recommendations = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Recommendation>>() {}).getBody();

            logger.debug("Found {} recommendations for a product with id: {}", recommendations.size(), productId);
            return recommendations;

        } catch (Exception ex) {
            logger.warn("Got an exception while requesting recommendations, return zero recommendations: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Review> getReviews(int productId) {

        try {
            String url = reviewServiceUrl + productId;

            logger.debug("Will call getReviews API on URL: {}", url);
            List<Review> reviews = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Review>>() {}).getBody();

            logger.debug("Found {} reviews for a product with id: {}", reviews.size(), productId);
            return reviews;

        } catch (Exception ex) {
            logger.warn("Got an exception while requesting reviews, return zero reviews: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }


}
