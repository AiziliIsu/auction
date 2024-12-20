package com.example.auction.repository;


import com.example.auction.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByAuctionIdOrderByAmountDesc(Long auctionId);

    List<Bid> findByUserIdOrderByBidTimeDesc(Long userId);
}