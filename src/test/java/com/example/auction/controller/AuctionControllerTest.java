package com.example.auction.controller;


import com.example.auction.model.Auction;
import com.example.auction.service.AuctionService;
import com.example.auction.controller.AuctionController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuctionController.class)
public class AuctionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuctionService auctionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createAuction_Success() throws Exception {
        Auction auction = new Auction();
        auction.setItemName("Test Item");
        auction.setStartingPrice(BigDecimal.valueOf(100));

        when(auctionService.createAuction(any())).thenReturn(auction);

        mockMvc.perform(post("/api/auctions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(auction)))
                .andExpect(status().isOk());
    }

    @Test
    void getActiveAuctions_Success() throws Exception {
        when(auctionService.getActiveAuctions()).thenReturn(Arrays.asList(new Auction()));

        mockMvc.perform(get("/api/auctions/active"))
                .andExpect(status().isOk());
    }
}