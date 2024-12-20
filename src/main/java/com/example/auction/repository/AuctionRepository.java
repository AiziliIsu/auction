package com.example.auction.repository;


import com.example.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findByStatus(String status);
    List<Auction> findByItemNameContainingIgnoreCase(String itemName);
}