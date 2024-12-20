package com.example.auction.service.impl;

// BidServiceImpl.java

import com.example.auction.model.Bid;
import com.example.auction.repository.BidRepository;
import com.example.auction.service.BidService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    private final BidRepository bidRepository;

    public Bid placeBid(Bid bid) {
        return bidRepository.save(bid);
    }

    public List<Bid> getBidsByAuction(Long auctionId) {
        return bidRepository.findByAuctionIdOrderByAmountDesc(auctionId);
    }

    public List<Bid> getBidsByUser(Long userId) {
        return bidRepository.findByUserIdOrderByBidTimeDesc(userId);
    }

    public Bid getHighestBid(Long auctionId) {
        List<Bid> bids = getBidsByAuction(auctionId);
        return bids.isEmpty() ? null : bids.get(0);
    }
}