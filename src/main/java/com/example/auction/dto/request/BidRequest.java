package com.example.auction.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BidRequest {
    private Long auctionId;
    private Long userId;
    private BigDecimal amount;
}
