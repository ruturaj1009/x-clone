-- Drop the database if it exists
DROP DATABASE IF EXISTS twitter_user;

-- Create the database
CREATE DATABASE twitter_user;

-- Use the created database
USE twitter_user;

-- Drop the table if it exists
DROP TABLE IF EXISTS users;

-- Create the users table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    bio TEXT,
    profile_image_url VARCHAR(500),
    cover_image_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert 5 dummy data
INSERT INTO users (username, email, password, full_name, bio, profile_image_url, cover_image_url) VALUES
('user1', 'user1@example.com', 'password123', 'John Doe', 'Software developer', 'https://example.com/profile1.jpg', 'https://example.com/cover1.jpg'),
('user2', 'user2@example.com', 'securePass', 'Jane Smith', 'Data scientist', 'https://example.com/profile2.jpg', 'https://example.com/cover2.jpg'),
('user3', 'user3@example.com', 'mySecret', 'David Lee', 'Graphic designer', 'https://example.com/profile3.jpg', 'https://example.com/cover3.jpg'),
('user4', 'user4@example.com', 'strongPwd', 'Emily Brown', 'Marketing specialist', 'https://example.com/profile4.jpg', 'https://example.com/cover4.jpg'),
('user5', 'user5@example.com', 'pass456', 'Michael Wilson', 'Project manager', 'https://example.com/profile5.jpg', 'https://example.com/cover5.jpg');

-- Select the users table
SELECT * FROM users;