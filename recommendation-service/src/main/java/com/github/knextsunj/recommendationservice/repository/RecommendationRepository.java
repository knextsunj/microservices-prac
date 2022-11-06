package com.github.knextsunj.recommendationservice.repository;

import com.github.knextsunj.recommendationservice.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {

    List<Recommendation> findByProductId(int productId);
}
