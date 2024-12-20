package com.example.auction.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String role;
    private List<BidResponse> bids;
}
