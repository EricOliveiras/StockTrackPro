package com.ericoliveiras.StockTrackPro.domain.sell.payload.request;

import java.util.List;

public class SellCreateRequest {
    private List<SellProductRequest> products;

    public List<SellProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<SellProductRequest> products) {
        this.products = products;
    }
}
