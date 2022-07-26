package com.kienast.stockcrudapi.controller;

import com.kienast.stockcrudapi.model.Stock;
import com.kienast.stockcrudapi.model.StockDto;
import com.kienast.stockcrudapi.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    public static final Logger LOG = LoggerFactory.getLogger(StockController.class);

    public final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<Stock> saveNewStock(@RequestBody StockDto stockDto) {
        Stock stock = this.stockService.saveNewStock(stockDto);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = this.stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }


    @GetMapping("/byTicker/{ticker}")
    public ResponseEntity<Stock> getStockByTicker(@PathVariable String ticker) {
        Stock stock = this.stockService.getStockByTicker(ticker);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }


    @GetMapping("/byName/{companyName}")
    public ResponseEntity<Stock> getStockByCompanyName(@PathVariable String companyName) {
        Stock stock = this.stockService.getStockByCompanyName(companyName);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }


}
