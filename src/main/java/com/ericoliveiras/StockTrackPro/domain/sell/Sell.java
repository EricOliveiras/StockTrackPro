package com.ericoliveiras.StockTrackPro.domain.sell;

import com.ericoliveiras.StockTrackPro.domain.product.Product;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_date", nullable = false)
    private Date saleDate;
    @OneToMany(mappedBy = "sell", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Sell() {
    }

    public Sell(Long id, Date saleDate, Set<Product> products) {
        this.id = id;
        this.saleDate = new Date();
        this.products = products;
    }

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
