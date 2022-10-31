package com.github.knextsunj.reviewservice.service.impl;

import com.github.knextsunj.reviewservice.domain.Review;
import com.github.knextsunj.reviewservice.exception.InvalidInputException;
import com.github.knextsunj.reviewservice.service.ReviewService;
import com.github.knextsunj.reviewservice.util.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LogManager.getLogger(ReviewServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public ReviewServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Review> getReviews(int productId) {
        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);

        if (productId == 213) {
            logger.debug("No reviews found for productId: {}", productId);
            return  new ArrayList<>();
        }

        List<Review> list = new ArrayList<>();
        list.add(new Review(productId, 1, "Author 1", "Subject 1", "Content 1", serviceUtil.getServiceAddress()));
        list.add(new Review(productId, 2, "Author 2", "Subject 2", "Content 2", serviceUtil.getServiceAddress()));
        list.add(new Review(productId, 3, "Author 3", "Subject 3", "Content 3", serviceUtil.getServiceAddress()));

        logger.debug("/reviews response size: {}", list.size());

        return list;
    }
}
