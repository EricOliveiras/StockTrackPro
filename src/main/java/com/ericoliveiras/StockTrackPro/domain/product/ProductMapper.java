package com.ericoliveiras.StockTrackPro.domain.product;

import com.ericoliveiras.StockTrackPro.domain.product.payload.request.CreateProductRequest;
import com.ericoliveiras.StockTrackPro.domain.product.payload.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(CreateProductRequest createProductRequest);
    ProductResponse toDto(Product product);
    List<ProductResponse> toDto(List<Product> products);
}
