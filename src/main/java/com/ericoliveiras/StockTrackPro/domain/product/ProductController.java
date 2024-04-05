package com.ericoliveiras.StockTrackPro.domain.product;

import com.ericoliveiras.StockTrackPro.domain.product.payload.request.CreateProductRequest;
import com.ericoliveiras.StockTrackPro.domain.product.payload.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody CreateProductRequest createProductRequest) {
        ProductResponse productResponse = productService.create(createProductRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.find(id));
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<List<ProductResponse>> findByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllByName(name));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProductResponse> update(Long id, CreateProductRequest createProductRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, createProductRequest));
    }

}
