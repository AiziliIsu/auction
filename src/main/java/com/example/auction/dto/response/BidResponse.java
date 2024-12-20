package com.example.auction.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BidResponse {
    private Long id;
    private String bidderUsername;
    private BigDecimal amount;
    private LocalDateTime bidTime;
    private String auctionItemName;
}
