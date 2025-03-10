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
('user5', 100, 5),
('user5', 300, 4),
('user5', 550, 3),
('user5', 100, 2),
('user6', 300, 1),
('user6', 400, 3),
('user6', 200, 5),
('user7', 2, 4),
('user7', 8, 2),
('user7', 2, 3),
('user8', 100, 5),
('user8', 100, 1),
('user8', 200, 3),
('user8', 300, 2),
('user9', 400, 4),
('user9', 500, 5),
('user9', 600, 3),
('user10', 700, 2),
('user10', 800, 1),
('user10', 900, 5),
('user10', 300, 4);
