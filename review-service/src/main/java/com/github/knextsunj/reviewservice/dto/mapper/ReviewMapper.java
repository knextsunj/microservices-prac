package com.github.knextsunj.reviewservice.dto.mapper;

import com.github.knextsunj.reviewservice.domain.Review;
import com.github.knextsunj.reviewservice.dto.ReviewDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "productId", source = "productId"),
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "author", source = "author"),
            @Mapping(target = "subject", source = "subject"),
            @Mapping(target = "content", source = "content")
    })
    Review fromReviewDTO(ReviewDTO reviewDTO);


    @InheritInverseConfiguration
    ReviewDTO toReviewDTO(Review review);
}
