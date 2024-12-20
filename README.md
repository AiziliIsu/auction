Online Auction System
A Spring Boot-based online auction system that allows users to create auctions, place bids, and manage the auction lifecycle.
Project Overview
This Online Auction System is built using Spring Boot 3.4 with a PostgreSQL database. The system provides RESTful APIs for user registration, auction management, and bidding functionality.
Key Features

User registration and authentication
Create and manage auctions
Place bids on active auctions
Track auction status (PENDING, ACTIVE, ENDED, CANCELLED)
View bid history and auction winners
Real-time validation of bids and auction status

Technology Stack

Java 17
Spring Boot 3.4
Spring Security
Spring Data JPA
PostgreSQL Database
Gradle
JUnit 5 & Mockito for testing
Swagger/OpenAPI for API documentation

Database Schema
The system uses three main tables:

users: Stores user information and authentication details
auctions: Manages auction items and their status
bids: Tracks all bids placed on auctions

Setup Instructions

Prerequisites

Java 17 or higher
PostgreSQL 12 or higher
Gradle 7.x


Database Setup
sqlCopyCREATE DATABASE auction_system;
\c auction_system;
-- Tables are created automatically via JPA

Application Configuration

Update application.properties with your database credentials
Default port: 8080


Build & Run
bashCopy./gradlew build
./gradlew bootRun


API Endpoints
User Management

POST /api/users/register - Register new user
GET /api/users/{id} - Get user details

Auction Management

POST /api/auctions - Create new auction
GET /api/auctions/{id} - Get auction details
GET /api/auctions/active - List active auctions
PUT /api/auctions/{id} - Update auction
DELETE /api/auctions/{id} - Delete auction

Bid Management

POST /api/bids - Place bid
GET /api/bids/auction/{auctionId} - Get auction bids
GET /api/bids/user/{userId} - Get user bids
GET /api/bids/auction/{auctionId}/highest - Get highest bid

Testing
The project includes comprehensive test coverage:

Controller tests using MockMvc
Service layer tests with Mockito
Integration tests for critical workflows

API Documentation
Access the Swagger UI documentation at:
Copyhttp://localhost:8080/swagger-ui.html
Future Enhancements

Real-time notifications for bid updates
Payment integration
User ratings and feedback
Advanced search and filtering
Auction categories and tags
