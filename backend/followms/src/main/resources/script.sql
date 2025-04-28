-- Drop the database if it exists
DROP DATABASE IF EXISTS twitter_follow;

-- Create the database
CREATE DATABASE twitter_follow;

-- Use the created database
USE twitter_follow;

-- Drop the table if it exists
DROP TABLE IF EXISTS follows;

-- Create the follows table
CREATE TABLE follows (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    follower_id BIGINT NOT NULL,
    following_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


-- Insert 5 dummy data
INSERT INTO follows (follower_id, following_id, created_at, updated_at) VALUES
(1, 2, '2023-10-27 10:00:00', '2023-10-27 10:00:00'),
(1, 3, '2023-10-27 10:05:00', '2023-10-27 10:05:00'),
(2, 4, '2023-10-27 11:00:00', '2023-10-27 11:00:00'),
(3, 1, '2023-10-27 12:00:00', '2023-10-27 12:00:00'),
(4, 5, '2023-10-27 13:00:00', '2023-10-27 13:00:00');

-- Select the follows table
SELECT * FROM follows;