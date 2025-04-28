-- Drop the database if it exists
DROP DATABASE IF EXISTS twitter_tweet;

-- Create the database
CREATE DATABASE twitter_tweet;

-- Use the created database
USE twitter_tweet;

-- Drop the table if it exists
DROP TABLE IF EXISTS tweets;

-- Create the tweets table
CREATE TABLE tweets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    media_id BIGINT NOT NULL,
    status INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    scheduled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert 5 dummy data
INSERT INTO tweets (content, user_id, media_id, status, created_at, scheduled_at) VALUES
('Just had the best coffee ever! #coffee #morning', 1, 101, 1, '2023-10-27 10:00:00', '2023-10-27 10:00:00'),
('Excited for the weekend! Any fun plans?', 2, 102, 1, '2023-10-27 11:30:00', '2023-10-27 11:30:00'),
('Learning a new programming language today. #coding #learning', 3, 103, 1, '2023-10-27 13:45:00', '2023-10-27 13:45:00'),
('Just finished reading a great book. Highly recommend it!', 4, 104, 1, '2023-10-27 15:20:00', '2023-10-27 15:20:00'),
('Taking a walk in the park. Beautiful day! #nature #relax', 5, 105, 1, '2023-10-27 16:10:00', '2023-10-27 16:10:00');

-- Select the tweets table
SELECT * FROM tweets;



-- Drop the table if it exists
DROP TABLE IF EXISTS likes;

-- Create the likes table
CREATE TABLE likes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    tweet_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert 5 dummy data
INSERT INTO likes (user_id, tweet_id, created_at, updated_at) VALUES
(1, 1, '2023-10-27 10:05:00', '2023-10-27 10:05:00'),
(2, 1, '2023-10-27 10:10:00', '2023-10-27 10:10:00'),
(3, 2, '2023-10-27 11:40:00', '2023-10-27 11:40:00'),
(4, 3, '2023-10-27 13:50:00', '2023-10-27 13:50:00'),
(5, 5, '2023-10-27 16:15:00', '2023-10-27 16:15:00');

-- Select the likes table
SELECT * FROM likes;



-- Drop the table if it exists
DROP TABLE IF EXISTS comments;

-- Create the comments table
CREATE TABLE comments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    tweet_id BIGINT NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


-- Insert 5 dummy data
INSERT INTO comments (user_id, tweet_id, content, created_at, updated_at) VALUES
(1, 1, 'Great coffee!', '2023-10-27 10:07:00', '2023-10-27 10:07:00'),
(2, 1, 'I agree!', '2023-10-27 10:12:00', '2023-10-27 10:12:00'),
(3, 2, 'Sounds fun!', '2023-10-27 11:45:00', '2023-10-27 11:45:00'),
(4, 3, 'Which language?', '2023-10-27 13:55:00', '2023-10-27 13:55:00'),
(5, 5, 'Enjoy the walk!', '2023-10-27 16:20:00', '2023-10-27 16:20:00');

-- Select the comments table
SELECT * FROM comments;