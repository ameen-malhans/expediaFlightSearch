CREATE DATABASE IF NOT EXISTS Flight;
DROP TABLE IF EXISTS  flight_details;

CREATE TABLE flight_details(
flight_id INT(20) NOT NULL PRIMARY KEY,
flight_code VARCHAR(255) NOT NULL,
flight_operator VARCHAR(255) NOT NULL,
flight_from VARCHAR(255),
flight_to VARCHAR(255),
departure_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
arrival_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
duration INT(10),
total_seats INT(10)
);
INSERT INTO flight_details (flight_id,flight_code,flight_operator,flight_from,flight_to,departure_time,arrival_time,duration,total_seats) VALUES(1,8099,'Air Canada','MONTREAL','NEW YORK',CONCAT(CURDATE(), '  07:30:0'),CONCAT(CURDATE(),' 07:30:0') + INTERVAL 5 HOUR,TIMESTAMPDIFF(HOUR, CONCAT(CURDATE(),' 07:30:0'), CONCAT(CURDATE(),' 07:30:0') + INTERVAL 5 HOUR),4);
INSERT INTO flight_details (flight_id,flight_code,flight_operator,flight_from,flight_to,departure_time,arrival_time,duration,total_seats) VALUES(2,6115,'United Airlines','MONTREAL','NEW YORK',CONCAT(CURDATE(),' 10:30:0'),CONCAT(CURDATE(),' 10:30:0') + INTERVAL 6 HOUR,TIMESTAMPDIFF(HOUR, CONCAT(CURDATE(),' 10:30:0'), CONCAT(CURDATE(),' 10:30:0') + INTERVAL 6 HOUR),4);
INSERT INTO flight_details (flight_id,flight_code,flight_operator,flight_from,flight_to,departure_time,arrival_time,duration,total_seats) VALUES(3,6456,'WestJet','MONTREAL','NEW YORK',CONCAT(CURDATE(),' 12:30:0'),CONCAT(CURDATE(),' 12:30:0') + INTERVAL 7 HOUR,TIMESTAMPDIFF(HOUR, CONCAT(CURDATE(),' 12:30:0'), CONCAT(CURDATE(),' 12:30:0') + INTERVAL 7 HOUR),4);
INSERT INTO flight_details (flight_id,flight_code,flight_operator,flight_from,flight_to,departure_time,arrival_time,duration,total_seats) VALUES(4,3833,'Delta','MONTREAL','NEW YORK',CONCAT(CURDATE(),' 15:00:0'),CONCAT(CURDATE(),' 15:00:0') + INTERVAL 8 HOUR,TIMESTAMPDIFF(HOUR, CONCAT(CURDATE(),' 15:00:0'), CONCAT(CURDATE(),' 15:00:0') + INTERVAL 8 HOUR),4);