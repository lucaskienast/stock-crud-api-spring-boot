package com.kienast.stockcrudapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StockCrudApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getsAllStocks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void getStockByTicker() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks/byTicker/MSFT")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void getStockByCompanyName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks/byName/Microsoft Inc.")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void addsNewStock() throws Exception {
        String newStock = "{\"ticker\":\"AAPL\",\"companyName\":\"Apple Inc.\",\"sharesOutstanding\":5000000,\"pricePerShare\":111.11}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/stocks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newStock)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }

}
