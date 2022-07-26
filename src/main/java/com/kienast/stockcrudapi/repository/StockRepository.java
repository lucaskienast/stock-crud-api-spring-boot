package com.kienast.stockcrudapi.repository;

import com.kienast.stockcrudapi.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByTicker(String ticker);

    Stock findByCompanyName(String companyName);

}
