CREATE DATABASE IF NOT EXISTS movie_library_db;
USE movie_library_db;

CREATE TABLE IF NOT EXISTS ratings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    movie_id INT,
    rating INT
);

INSERT INTO ratings (user_id, movie_id, rating) VALUES
('user1', 550, 4),
('user1', 100, 5),
('user2', 200, 3),
('user2', 550, 2),
('user3', 300, 5),
('user3', 400, 4),
('user3', 500, 3),
('user4', 600, 5),
('user4', 700, 4),
('user4', 800, 4),
('user4', 900, 2),
('user5', 1000, 5),
('user5', 1100, 4),
('user5', 1200, 3),
('user5', 1300, 2),
('user6', 1400, 1),
('user6', 1500, 3),
('user6', 1600, 5),
('user7', 1700, 4),
('user7', 1800, 2),
('user7', 1900, 3),
('user8', 2000, 5),
('user8', 2100, 1),
('user8', 2200, 3),
('user8', 2300, 2),
('user9', 2400, 4),
('user9', 2500, 5),
('user9', 2600, 3),
('user10', 2700, 2),
('user10', 2800, 1),
('user10', 2900, 5),
('user10', 3000, 4);
