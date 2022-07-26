package com.kienast.stockcrudapi.model;

import java.util.Objects;

public class StockDto {

    private String ticker;
    private String companyName;
    private Long sharesOutstanding;
    private Double pricePerShare;

    public StockDto() {
    }

    public StockDto(String ticker, String companyName, Long sharesOutstanding, Double pricePerShare) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.sharesOutstanding = sharesOutstanding;
        this.pricePerShare = pricePerShare;
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
        StockDto stockDto = (StockDto) o;
        return Objects.equals(ticker, stockDto.ticker) && Objects.equals(companyName, stockDto.companyName) && Objects.equals(sharesOutstanding, stockDto.sharesOutstanding) && Objects.equals(pricePerShare, stockDto.pricePerShare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, companyName, sharesOutstanding, pricePerShare);
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "ticker='" + ticker + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sharesOutstanding=" + sharesOutstanding +
                ", pricePerShare=" + pricePerShare +
                '}';
    }
}
