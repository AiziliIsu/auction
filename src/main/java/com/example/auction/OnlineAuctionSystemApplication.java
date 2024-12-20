package com.example.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnlineAuctionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAuctionSystemApplication.class, args);
	}

}


