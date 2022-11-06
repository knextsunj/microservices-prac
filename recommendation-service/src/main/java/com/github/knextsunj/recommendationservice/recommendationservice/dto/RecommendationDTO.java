package com.github.knextsunj.recommendationservice.recommendationservice.dto;

public record RecommendationDTO(Long id,Long productId,String author,Long rate,String content) {
}
