package com.kienast.stockcrudapi;

import com.kienast.stockcrudapi.model.Stock;
import com.kienast.stockcrudapi.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockCrudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockCrudApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(StockRepository stockRepository) {
        return (args) -> {
            stockRepository.save(new Stock(null, "MSFT", "Microsoft Inc.", 1000000L, 335.36));
            stockRepository.save(new Stock(null, "TSLA", "Tesla Inc.", 150000L, 124.53));
            stockRepository.save(new Stock(null, "TSMC", "Taiwan Semiconductor Manufacturing Company Inc.", 3400000L, 98.78));
        };
    }

}
