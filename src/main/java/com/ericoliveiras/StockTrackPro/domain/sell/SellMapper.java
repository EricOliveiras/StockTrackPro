package com.ericoliveiras.StockTrackPro.domain.sell;

import com.ericoliveiras.StockTrackPro.domain.sell.payload.request.SellCreateRequest;
import com.ericoliveiras.StockTrackPro.domain.sell.payload.response.SellResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellMapper {
    Sell toEntity(SellCreateRequest sellCreateRequest);
    SellResponse toDto(Sell sell);
    List<SellResponse> toDto(List<Sell> sells);
}
