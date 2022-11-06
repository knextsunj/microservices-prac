package com.github.knextsunj.reviewservice.repository;

import com.github.knextsunj.reviewservice.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Transactional(readOnly = true)
    List<Review> findByProductId(int productId);
}
