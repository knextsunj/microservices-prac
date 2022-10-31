package com.github.knextsunj.productservice.service;

import com.github.knextsunj.productservice.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    @GetMapping(
            value    = "/product/{productId}",
            produces = "application/json")
    Product getProduct(@PathVariable int productId);
}
