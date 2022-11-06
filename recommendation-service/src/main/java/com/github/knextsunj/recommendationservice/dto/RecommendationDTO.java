package com.github.knextsunj.recommendationservice.dto;

public record RecommendationDTO(Long id,Long productId,String author,Long rate,String content) {
}
