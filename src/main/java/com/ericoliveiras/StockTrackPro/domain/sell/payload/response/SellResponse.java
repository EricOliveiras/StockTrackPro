package com.ericoliveiras.StockTrackPro.domain.sell.payload.response;

import java.util.Date;
import java.util.List;

public class SellResponse {
    private Long id;
    private Date saleDate;
    private List<SellItemResponse> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public List<SellItemResponse> getItems() {
        return items;
    }

    public void setItems(List<SellItemResponse> items) {
        this.items = items;
    }
}