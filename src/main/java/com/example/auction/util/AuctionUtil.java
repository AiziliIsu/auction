package com.example.auction.util;

import com.example.auction.dto.response.AuctionResponse;
import com.example.auction.dto.response.BidResponse;
import com.example.auction.model.Auction;
import com.example.auction.model.Bid;

import java.util.List;
import java.util.stream.Collectors;

public class AuctionUtil {
    public static AuctionResponse toAuctionResponse(Auction auction, List<Bid> bids) {
        AuctionResponse response = new AuctionResponse();
        response.setId(auction.getId());
        response.setItemName(auction.getItemName());
        response.setDescription(auction.getDescription());
        response.setStartingPrice(auction.getStartingPrice());
        response.setStartTime(auction.getStartTime());
        response.setEndTime(auction.getEndTime());
        response.setStatus(auction.getStatus());

        if (!bids.isEmpty()) {
            response.setCurrentHighestBid(bids.get(0).getAmount());
            response.setBids(bids.stream()
                    .map(AuctionUtil::toBidResponse)
                    .collect(Collectors.toList()));
        }

        return response;
    }

    public static BidResponse toBidResponse(Bid bid) {
        BidResponse response = new BidResponse();
        response.setId(bid.getId());
        response.setBidderUsername(bid.getUser().getUsername());
        response.setAmount(bid.getAmount());
        response.setBidTime(bid.getBidTime());
        response.setAuctionItemName(bid.getAuction().getItemName());
        return response;
    }
}

