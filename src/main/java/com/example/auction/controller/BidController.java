package com.example.auction.controller;

import com.example.auction.model.Bid;
import com.example.auction.service.BidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/bids")
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @PostMapping
    public ResponseEntity<Bid> placeBid(@RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.placeBid(bid));
    }

    @GetMapping("/auction/{auctionId}")
    public ResponseEntity<List<Bid>> getBidsByAuction(@PathVariable Long auctionId) {
        return ResponseEntity.ok(bidService.getBidsByAuction(auctionId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bid>> getBidsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bidService.getBidsByUser(userId));
    }

    @GetMapping("/auction/{auctionId}/highest")
    public ResponseEntity<Bid> getHighestBid(@PathVariable Long auctionId) {
        return ResponseEntity.ok(bidService.getHighestBid(auctionId));
    }
}
