package com.example.auction.util;

import com.example.auction.dto.request.AuctionRequest;
import com.example.auction.dto.request.BidRequest;
import com.example.auction.model.Auction;
import com.example.auction.model.Bid;
import org.springframework.stereotype.Component;


@Component
public class ValidationUtil {
    public void validateAuction(AuctionRequest auction) {
        if (auction.getStartingPrice().signum() <= 0) {
            throw new IllegalArgumentException("Starting price must be greater than 0");
        }

        if (auction.getEndTime().isBefore(auction.getStartTime())) {
            throw new IllegalArgumentException("End time must be after start time");
        }
    }

    public void validateBid(BidRequest bid, Auction auction, Bid highestBid) {
        if (auction.getStatus() != AuctionStatus.ACTIVE.name()) {
            throw new IllegalStateException("Auction is not active");
        }

        if (highestBid != null && bid.getAmount().compareTo(highestBid.getAmount()) <= 0) {
            throw new IllegalArgumentException("Bid amount must be higher than current highest bid");
        }

        if (bid.getAmount().compareTo(auction.getStartingPrice()) < 0) {
            throw new IllegalArgumentException("Bid amount must be greater than starting price");
        }
    }
}



