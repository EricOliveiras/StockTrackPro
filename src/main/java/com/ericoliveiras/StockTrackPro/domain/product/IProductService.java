package com.ericoliveiras.StockTrackPro.domain.product;

import com.ericoliveiras.StockTrackPro.domain.product.payload.request.CreateProductRequest;
import com.ericoliveiras.StockTrackPro.domain.product.payload.response.ProductResponse;

import java.util.List;

public interface IProductService {
    ProductResponse create(CreateProductRequest createProductRequest);

    ProductResponse find(Long id);

    List<ProductResponse> findAllByName(String name);

    List<ProductResponse> findAll();

    ProductResponse update(Long id, CreateProductRequest createProductRequest);
}
