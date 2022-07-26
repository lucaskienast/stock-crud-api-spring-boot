package com.kienast.stockcrudapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="TICKER", nullable = false, unique = true)
    private String ticker;

    @Column(name="COMPANY_NAME", nullable = false, unique = true)
    private String companyName;

    @Column(name="SHARES_OUTSTANDING", nullable = false)
    private Long sharesOutstanding;

    @Column(name="PRICE_PER_SHARE", nullable = false)
    private Double pricePerShare;

    public Stock() {
    }

    public Stock(Long id, String ticker, String companyName, Long sharesOutstanding, Double pricePerShare) {
        this.id = id;
        this.ticker = ticker;
        this.companyName = companyName;
        this.sharesOutstanding = sharesOutstanding;
        this.pricePerShare = pricePerShare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(Long sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    public Double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(Double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(ticker, stock.ticker) && Objects.equals(companyName, stock.companyName) && Objects.equals(sharesOutstanding, stock.sharesOutstanding) && Objects.equals(pricePerShare, stock.pricePerShare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticker, companyName, sharesOutstanding, pricePerShare);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sharesOutstanding=" + sharesOutstanding +
                ", pricePerShare=" + pricePerShare +
                '}';
    }
}
