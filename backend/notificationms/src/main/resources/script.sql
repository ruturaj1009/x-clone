-- Drop the database if it exists
DROP DATABASE IF EXISTS twitter_notification;

-- Create the database
CREATE DATABASE twitter_notification;

-- Use the created database
USE twitter_notification;

-- Drop the table if it exists
DROP TABLE IF EXISTS notifications;

-- Create the notifications table
CREATE TABLE notifications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    type ENUM('LIKE', 'COMMENT', 'FOLLOW', 'MENTION') NOT NULL,
    reference_id BIGINT NOT NULL,
    is_read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert 5 dummy data
INSERT INTO notifications (user_id, type, reference_id, is_read, created_at, updated_at) VALUES
(2, 'LIKE', 101, FALSE, '2023-10-27 10:00:00', '2023-10-27 10:00:00'),
(3, 'FOLLOW', 5, FALSE, '2023-10-27 11:00:00', '2023-10-27 11:00:00'),
(1, 'COMMENT', 201, FALSE, '2023-10-27 12:00:00', '2023-10-27 12:00:00'),
(4, 'MENTION', 105, FALSE, '2023-10-27 13:00:00', '2023-10-27 13:00:00'),
(5, 'LIKE', 102, FALSE, '2023-10-27 14:00:00', '2023-10-27 14:00:00');

-- Select the notifications table
SELECT * FROM notifications;

