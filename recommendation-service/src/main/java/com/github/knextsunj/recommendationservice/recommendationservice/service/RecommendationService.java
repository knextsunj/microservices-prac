package com.github.knextsunj.recommendationservice.recommendationservice.service;

import com.github.knextsunj.recommendationservice.recommendationservice.dto.RecommendationDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RecommendationService {

    /**
     * Sample usage:
     *
     * curl $HOST:$PORT/recommendation?productId=1
     *
     * @param productId
     * @return
     */
    @GetMapping(
            value    = "/recommendation",
            produces = "application/json")
    List<RecommendationDTO> getRecommendations(@RequestParam(value = "productId", required = true) int productId);

    /**
     * Sample usage:
     *
     * curl -X POST $HOST:$PORT/recommendation \
     *   -H "Content-Type: application/json" --data \
     *   '{"productId":123,"recommendationId":456,"author":"me","rate":5,"content":"yada, yada, yada"}'
     *
     * @param body
     * @return
     */
    @PostMapping(
            value    = "/recommendation",
            consumes = "application/json",
            produces = "application/json")
    RecommendationDTO createRecommendation(@RequestBody RecommendationDTO body);

    /**
     * Sample usage:
     *
     * curl -X DELETE $HOST:$PORT/recommendation?productId=1
     *
     * @param productId
     */
    @DeleteMapping(value = "/recommendation")
    void deleteRecommendations(@RequestParam(value = "productId", required = true)  int productId);
}
