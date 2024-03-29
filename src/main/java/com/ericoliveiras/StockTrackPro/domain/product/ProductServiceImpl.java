package com.ericoliveiras.StockTrackPro.domain.product;

import com.ericoliveiras.StockTrackPro.config.error.CustomException;
import com.ericoliveiras.StockTrackPro.domain.product.payload.request.CreateProductRequest;
import com.ericoliveiras.StockTrackPro.domain.product.payload.response.ProductResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
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
        findByName(product.getName());
        product.setName(product.getName().toLowerCase());
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductResponse find(Long id) {
        return productMapper.toDto(findProduct(id));
    }

    @Override
    public List<ProductResponse> findAllByName(String name) {
        return productMapper.toDto(findProductsByName(name));
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

    @Override
    public ProductResponse update(Long id, CreateProductRequest createProductRequest) {
        Product product = findProduct(id);
        BeanUtils.copyProperties(createProductRequest, product, "id");
        product.setName(createProductRequest.getName().toLowerCase());
        return productMapper.toDto(productRepository.save(product));
    }

    private Product findProduct(long id) {
        return productRepository.
                findById(id).
                orElseThrow(
                        () -> new CustomException("product not found.", HttpStatus.NOT_FOUND)
                );
    }


    private @NotNull List<Product> findProductsByName(@NotNull String name) {
        List<Product> products = productRepository.findAllByName(name.toLowerCase());
        if (products.isEmpty()) {
            throw new CustomException("products not found.", HttpStatus.NOT_FOUND);
        }
        return products;
    }

    private void findByName(String name) {
        Product product = productRepository.findByName(name.toLowerCase());
        if (product != null) {
            throw new CustomException("there is already a product registered with this name.", HttpStatus.CONFLICT);
        }
    }
}
