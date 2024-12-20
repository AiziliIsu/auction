package com.example.auction.service;



import com.example.auction.model.Auction;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.service.impl.AuctionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuctionServiceTest {
    @Mock
    private AuctionRepository auctionRepository;

    private AuctionService auctionService;

    @BeforeEach
    void setUp() {
        auctionService = new AuctionServiceImpl(auctionRepository);
    }

    @Test
    void createAuction_Success() {
        Auction auction = new Auction();
        auction.setItemName("Test Item");

        when(auctionRepository.save(any())).thenReturn(auction);

        Auction savedAuction = auctionService.createAuction(auction);
        assertNotNull(savedAuction);
        assertEquals("Test Item", savedAuction.getItemName());
    }

    @Test
    void getAuctionById_Success() {
        Auction auction = new Auction();
        auction.setId(1L);
        when(auctionRepository.findById(1L)).thenReturn(Optional.of(auction));

        Auction foundAuction = auctionService.getAuctionById(1L);
        assertNotNull(foundAuction);
        assertEquals(1L, foundAuction.getId());
    }
}
