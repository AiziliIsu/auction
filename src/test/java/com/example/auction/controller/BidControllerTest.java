package com.example.auction.controller;


import com.example.auction.model.Bid;
import com.example.auction.service.BidService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BidController.class)
public class BidControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BidService bidService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void placeBid_Success() throws Exception {
        Bid bid = new Bid();
        bid.setAmount(BigDecimal.valueOf(150));

        when(bidService.placeBid(any())).thenReturn(bid);

        mockMvc.perform(post("/api/bids")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bid)))
                .andExpect(status().isOk());
    }

    @Test
    void getBidsByAuction_Success() throws Exception {
        when(bidService.getBidsByAuction(1L)).thenReturn(Arrays.asList(new Bid()));

        mockMvc.perform(get("/api/bids/auction/1"))
                .andExpect(status().isOk());
    }
}





