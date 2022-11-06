package com.github.knextsunj.recommendationservice.service.impl;

import com.github.knextsunj.recommendationservice.domain.Recommendation;
import com.github.knextsunj.recommendationservice.dto.RecommendationDTO;
import com.github.knextsunj.recommendationservice.dto.mapper.RecommendationMapper;
import com.github.knextsunj.recommendationservice.exception.InvalidInputException;
import com.github.knextsunj.recommendationservice.repository.RecommendationRepository;
import com.github.knextsunj.recommendationservice.service.RecommendationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.github.knextsunj.recommendationservice.util.ServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class RecommendationServiceImpl implements RecommendationService {

    private static final Logger logger = LogManager.getLogger(RecommendationServiceImpl.class);

    private final ServiceUtil serviceUtil;

    private final RecommendationRepository repository;

    private final RecommendationMapper mapper;

    @Autowired
    public RecommendationServiceImpl(RecommendationRepository repository, RecommendationMapper mapper,ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
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
        List<Recommendation> recommendations = repository.findByProductId(productId);
        Function<Recommendation,RecommendationDTO> function = recommendation -> mapper.toRecommendationDTO(recommendation);
        return recommendations.parallelStream().map(function).collect(Collectors.toList());
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
        Recommendation recommendation = repository.save(mapper.fromRecommendationDTO(body));
        return mapper.toRecommendationDTO(recommendation);
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
        repository.deleteAll(repository.findByProductId(productId));
    }
}
