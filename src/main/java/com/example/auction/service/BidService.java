package com.example.auction.service;

import com.example.auction.model.Bid;
import java.util.List;

public interface BidService {
    Bid placeBid(Bid bid);
    List<Bid> getBidsByAuction(Long auctionId);
    List<Bid> getBidsByUser(Long userId);
    Bid getHighestBid(Long auctionId);
}
