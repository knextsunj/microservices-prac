package com.github.knextsunj.productservice.service;

import com.github.knextsunj.productservice.domain.Product;
import com.github.knextsunj.productservice.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

public interface ProductService {

    /**
     * Sample usage: curl $HOST:$PORT/product/1
     *
     * @param productId
     * @return the product, if found, else null
     */
    @GetMapping(
            value    = "/product/{productId}",
            produces = "application/json")
    ProductDTO getProduct(@PathVariable int productId);

    /**
     * Sample usage:
     *
     * curl -X POST $HOST:$PORT/product \
     *   -H "Content-Type: application/json" --data \
     *   '{"productId":123,"name":"product 123","weight":123}'
     *
     * @param body
     * @return
     */
    @PostMapping(
            value    = "/product",
            consumes = "application/json",
            produces = "application/json")
    ProductDTO createProduct(@RequestBody ProductDTO body);

    /**
     * Sample usage:
     *
     * curl -X DELETE $HOST:$PORT/product/1
     *
     * @param productId
     */
    @DeleteMapping(value = "/product/{productId}")
    void deleteProduct(@PathVariable long productId);
}
