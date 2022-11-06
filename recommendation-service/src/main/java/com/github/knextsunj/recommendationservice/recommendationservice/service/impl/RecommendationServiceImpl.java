package com.github.knextsunj.recommendationservice.recommendationservice.service.impl;

import com.github.knextsunj.recommendationservice.recommendationservice.dto.RecommendationDTO;
import com.github.knextsunj.recommendationservice.recommendationservice.service.RecommendationService;
import com.github.knextsunj.recommendationservice.util.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationServiceImpl implements RecommendationService {

    private static final Logger logger = LogManager.getLogger(RecommendationServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public RecommendationServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {
//        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);
//
//        if (productId == 113) {
//            logger.debug("No recommendations found for productId: {}", productId);
//            return  new ArrayList<>();
//        }
//
//        List<Recommendation> list = new ArrayList<>();
//        list.add(new Recommendation(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()));
//        list.add(new Recommendation(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()));
//        list.add(new Recommendation(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress()));
//
//        logger.debug("/recommendation response size: {}", list.size());
//
//        return list;
//    }
        return null;
    }

    /**
     * Sample usage:
     * <p>
     * curl -X POST $HOST:$PORT/recommendation \
     * -H "Content-Type: application/json" --data \
     * '{"productId":123,"recommendationId":456,"author":"me","rate":5,"content":"yada, yada, yada"}'
     *
     * @param body
     * @return
     */
    @Override
    public RecommendationDTO createRecommendation(RecommendationDTO body) {
        return null;
    }

    /**
     * Sample usage:
     * <p>
     * curl -X DELETE $HOST:$PORT/recommendation?productId=1
     *
     * @param productId
     */
    @Override
    public void deleteRecommendations(int productId) {

    }
}
