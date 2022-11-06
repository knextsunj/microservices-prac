package com.github.knextsunj.reviewservice.service.impl;

import com.github.knextsunj.reviewservice.domain.Review;
import com.github.knextsunj.reviewservice.dto.ReviewDTO;
import com.github.knextsunj.reviewservice.dto.mapper.ReviewMapper;
import com.github.knextsunj.reviewservice.exception.InvalidInputException;
import com.github.knextsunj.reviewservice.repository.ReviewRepository;
import com.github.knextsunj.reviewservice.service.ReviewService;
import com.github.knextsunj.reviewservice.util.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LogManager.getLogger(ReviewServiceImpl.class);

    private final ServiceUtil serviceUtil;

    private final ReviewRepository repository;

    private final ReviewMapper mapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository, ReviewMapper mapper, ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ReviewDTO> getReviews(int productId) {
//        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);
//
//        if (productId == 213) {
//            logger.debug("No reviews found for productId: {}", productId);
//            return  new ArrayList<>();
//        }
//
//        List<Review> list = new ArrayList<>();
//        list.add(new Review(productId, 1, "Author 1", "Subject 1", "Content 1", serviceUtil.getServiceAddress()));
//        list.add(new Review(productId, 2, "Author 2", "Subject 2", "Content 2", serviceUtil.getServiceAddress()));
//        list.add(new Review(productId, 3, "Author 3", "Subject 3", "Content 3", serviceUtil.getServiceAddress()));
//
//        logger.debug("/reviews response size: {}", list.size());
//
//        return list;
        Function<Review, ReviewDTO> function = review -> mapper.toReviewDTO(review);
        List<Review> reviewList = repository.findByProductId(productId);
        return reviewList.parallelStream().map(function).collect(Collectors.toList());
    }

    /**
     * Sample usage:
     * <p>
     * curl -X POST $HOST:$PORT/review \
     * -H "Content-Type: application/json" --data \
     * '{"productId":123,"reviewId":456,"author":"me","subject":"yada, yada, yada","content":"yada, yada, yada"}'
     *
     * @param body
     * @return
     */
    @Override
    public ReviewDTO createReview(ReviewDTO body) {
        Review savedReview = repository.save(mapper.fromReviewDTO(body));
        return mapper.toReviewDTO(savedReview);
    }

    /**
     * Sample usage:
     * <p>
     * curl -X DELETE $HOST:$PORT/review?productId=1
     *
     * @param productId
     */
    @Override
    public void deleteReviews(int productId) {
        List<Review> reviews = repository.findByProductId(productId);
        repository.deleteAll(reviews);
    }
}
