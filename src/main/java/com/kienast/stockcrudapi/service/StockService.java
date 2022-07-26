package com.kienast.stockcrudapi.service;

import com.kienast.stockcrudapi.mapper.StockDtoMapper;
import com.kienast.stockcrudapi.model.Stock;
import com.kienast.stockcrudapi.model.StockDto;
import com.kienast.stockcrudapi.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    public static final Logger LOG = LoggerFactory.getLogger(StockService.class);

    public final StockRepository stockRepository;
    public final StockDtoMapper stockDtoMapper;


    @Autowired
    public StockService(StockRepository stockRepository, StockDtoMapper stockDtoMapper) {
        this.stockRepository = stockRepository;
        this.stockDtoMapper = stockDtoMapper;
    }


    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }


    public Stock getStockByTicker(String ticker) {
        LOG.info("Getting stock with ticker -> {}", ticker);
        return stockRepository.findByTicker(ticker);
    }


    public Stock getStockByCompanyName(String companyName) {
        LOG.info("Getting stock with company name -> {}", companyName);
        return stockRepository.findByCompanyName(companyName);
    }

    public Stock saveNewStock(StockDto stockDto) {
        LOG.info("Saving stock with details -> {}", stockDto);
        Stock stock = this.stockDtoMapper.dtoToStock(stockDto);
        return this.stockRepository.save(stock);
    }


}
