package com.example.auction.service.impl;

import com.example.auction.model.Auction;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.service.AuctionService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;

    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public Auction getAuctionById(Long id) {
        return auctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auction not found"));
    }

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public List<Auction> getActiveAuctions() {
        return auctionRepository.findByStatus("ACTIVE");
    }

    public Auction updateAuction(Long id, Auction auction) {
        Auction existingAuction = getAuctionById(id);
        existingAuction.setItemName(auction.getItemName());
        existingAuction.setDescription(auction.getDescription());
        existingAuction.setStatus(auction.getStatus());
        return auctionRepository.save(existingAuction);
    }

    public void deleteAuction(Long id) {
        auctionRepository.deleteById(id);
    }
}

