package com.example.auction.service;

import com.example.auction.model.Auction;
import java.util.List;

public interface AuctionService {
    Auction createAuction(Auction auction);
    Auction getAuctionById(Long id);
    List<Auction> getAllAuctions();
    List<Auction> getActiveAuctions();
    Auction updateAuction(Long id, Auction auction);
    void deleteAuction(Long id);
}
