package com.github.knextsunj.productservice.service;

import com.github.knextsunj.productservice.domain.Product;
import com.github.knextsunj.productservice.dto.ProductDTO;
import com.github.knextsunj.productservice.dto.mapper.ProductMapper;
import com.github.knextsunj.productservice.exception.InvalidInputException;
import com.github.knextsunj.productservice.exception.NotFoundException;
import com.github.knextsunj.productservice.repository.ProductRepository;
import com.github.knextsunj.productservice.util.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    private final ServiceUtil serviceUtil;

    private final ProductRepository repository;

    private final ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper, ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductDTO getProduct(int productId) {

//        logger.debug("/product return the found product for productId={}", productId);
//
//        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);
//
//        if (productId == 13) throw new NotFoundException("No product found for productId: " + productId);
//
//        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
        Optional<Product> productOptional = repository.findByProductId(productId);
        if(productOptional.isPresent()) {
            return mapper.toProductDTO(productOptional.get());
        }
        return null;
    }

    /**
     * Sample usage:
     * <p>
     * curl -X POST $HOST:$PORT/product \
     * -H "Content-Type: application/json" --data \
     * '{"productId":123,"name":"product 123","weight":123}'
     *
     * @param body
     * @return
     */
    @Override
    public ProductDTO createProduct(ProductDTO body) {
      Product product = mapper.fromProductDTO(body);
      return mapper.toProductDTO(repository.save(product));
    }

    /**
     * Sample usage:
     * <p>
     * curl -X DELETE $HOST:$PORT/product/1
     *
     * @param productId
     */
    @Override
    public void deleteProduct(long productId) {
        Optional<Product> productOptional = repository.findById(productId);
        if(productOptional.isPresent()) {
            repository.delete(productOptional.get());
        }
    }
}
