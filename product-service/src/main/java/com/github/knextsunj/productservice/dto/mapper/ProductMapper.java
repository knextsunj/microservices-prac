package com.github.knextsunj.productservice.dto.mapper;

import com.github.knextsunj.productservice.domain.Product;
import com.github.knextsunj.productservice.dto.ProductDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
        @Mapping(target = "serviceAddress", ignore = true),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "weight", source = "weight")
    })
    Product fromProductDTO(ProductDTO productDTO);


    @InheritInverseConfiguration
    ProductDTO toProductDTO(Product product);
}
