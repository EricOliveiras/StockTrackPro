package com.ericoliveiras.StockTrackPro.domain.sell;

import com.ericoliveiras.StockTrackPro.domain.sell.payload.request.SellCreateRequest;
import com.ericoliveiras.StockTrackPro.domain.sell.payload.response.SellResponse;

import java.util.List;

public interface ISellService {
    SellResponse createSell(SellCreateRequest sellCreateRequest);

    List<SellResponse> getAllSells();

    SellResponse getSellById(Long sellId);

    SellResponse updateSell(Long sellId, SellCreateRequest sellCreateRequest);

    void deleteSell(Long sellId);
}
