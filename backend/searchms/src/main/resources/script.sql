-- Drop the database if it exists
DROP DATABASE IF EXISTS twitter_search;

-- Create the database
CREATE DATABASE twitter_search;

-- Use the created database
USE twitter_search;

-- Drop the table if it exists
DROP TABLE IF EXISTS search_index;

-- Create the search_index table
CREATE TABLE search_index (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    entity_type ENUM('TWEET', 'USER', 'HASHTAG') NOT NULL,
    reference_id BIGINT NOT NULL,
    keyword VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FULLTEXT INDEX keyword_fulltext (keyword),
    INDEX entity_type_index (entity_type),
    INDEX reference_id_index (reference_id)
);

-- Insert 5 dummy data
INSERT INTO search_index (entity_type, reference_id, keyword, created_at, updated_at) VALUES
('TWEET', 101, 'coding challenge', '2023-10-27 10:00:00', '2023-10-27 10:00:00'),
('USER', 5, 'john_doe', '2023-10-27 11:00:00', '2023-10-27 11:00:00'),
('HASHTAG', 1, 'travelphotography', '2023-10-27 12:00:00', '2023-10-27 12:00:00'),
('TWEET', 102, 'spring boot tutorial', '2023-10-27 13:00:00', '2023-10-27 13:00:00'),
('USER', 10, 'jane_smith', '2023-10-27 14:00:00', '2023-10-27 14:00:00');

-- Select the notifications table
SELECT * FROM search_index;

