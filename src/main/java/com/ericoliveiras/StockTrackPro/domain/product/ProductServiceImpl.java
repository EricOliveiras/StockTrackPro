package com.ericoliveiras.StockTrackPro.domain.product;

import com.ericoliveiras.StockTrackPro.domain.product.payload.request.CreateProductRequest;
import com.ericoliveiras.StockTrackPro.domain.product.payload.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse create(CreateProductRequest createProductRequest) {
        Product product = productMapper.toEntity(createProductRequest);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductResponse find(Long id) {
        return productMapper.toDto(findProduct(id));
    }

    @Override
    public List<ProductResponse> findAll() {
        Page<Product> products = productRepository.findAll(
                PageRequest.of(0, 20, Sort.by("name"))
        );
        return products.
                stream().
                map(productMapper::toDto).
                collect(Collectors.toList());
    }

    private Product findProduct(long id) {
        return productRepository.
                findById(id).
                orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found.")
                );
    }
}
