package com.github.knextsunj.recommendationservice.recommendationservice.repository;

import com.github.knextsunj.recommendationservice.recommendationservice.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {
}
