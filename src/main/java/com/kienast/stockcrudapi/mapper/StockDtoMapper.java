package com.kienast.stockcrudapi.mapper;

import com.kienast.stockcrudapi.model.Stock;
import com.kienast.stockcrudapi.model.StockDto;
import org.springframework.stereotype.Component;

@Component
public class StockDtoMapper {

    public Stock dtoToStock(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setTicker(stockDto.getTicker());
        stock.setCompanyName(stockDto.getCompanyName());
        stock.setSharesOutstanding(stockDto.getSharesOutstanding());
        stock.setPricePerShare(stockDto.getPricePerShare());
        return stock;
    }

}
