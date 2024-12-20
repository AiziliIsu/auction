package com.example.auction.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AuctionResponse {
    private Long id;
    private String itemName;
    private String description;
    private BigDecimal startingPrice;
    private BigDecimal currentHighestBid;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private List<BidResponse> bids;
}

