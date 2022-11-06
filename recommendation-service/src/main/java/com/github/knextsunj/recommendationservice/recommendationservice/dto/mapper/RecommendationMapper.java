package com.github.knextsunj.recommendationservice.recommendationservice.dto.mapper;

import com.github.knextsunj.recommendationservice.recommendationservice.domain.Recommendation;
import com.github.knextsunj.recommendationservice.recommendationservice.dto.RecommendationDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "productId", source = "productId"),
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "author", source = "author"),
            @Mapping(target = "rate", source = "rate"),
            @Mapping(target = "content", source = "content")
    })
    Recommendation fromRecommendationDTO(RecommendationDTO recommendationDTO);


    @InheritInverseConfiguration
    RecommendationDTO toRecommendationDTO(Recommendation recommendation);
}
