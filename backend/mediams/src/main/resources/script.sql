-- Drop the database if it exists
DROP DATABASE IF EXISTS twitter_media;

-- Create the database
CREATE DATABASE twitter_media;

-- Use the created database
USE twitter_media;

-- Drop the table if it exists
DROP TABLE IF EXISTS medias;

-- Create the medias table
CREATE TABLE medias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    media_url VARCHAR(500) NOT NULL,
    media_type ENUM('IMAGE', 'VIDEO', 'GIF') NOT NULL,
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Insert 5 dummy data
INSERT INTO medias (user_id, media_url, media_type, uploaded_at) VALUES
(1, 'https://example.com/images/image1.jpg', 'IMAGE', '2023-10-27 10:00:00'),
(2, 'https://example.com/videos/video1.mp4', 'VIDEO', '2023-10-27 11:00:00'),
(3, 'https://example.com/gifs/gif1.gif', 'GIF', '2023-10-27 12:00:00'),
(4, 'https://example.com/images/image2.png', 'IMAGE', '2023-10-27 13:00:00'),
(5, 'https://example.com/videos/video2.avi', 'VIDEO', '2023-10-27 14:00:00');

-- Select the medias table
SELECT * FROM medias;