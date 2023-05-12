CREATE DATABASE trainers_tracker;
USE trainers_tracker;


CREATE TABLE trainers (

id int(40) NOT NULL AUTO_INCREMENT,
fname varchar(45) DEFAULT NULL,
lname varchar(45) DEFAULT NULL,
subject varchar(45) DEFAULT NULL,
PRIMARY KEY (id)

);


INSERT INTO trainers VALUES
(1,'David','Adams','Java') ,
(2,'John','Doe','Java'),
(3,'Nick','Cage','Java'),
(4,'Mary','Smith','C#'),
(5,'Maxwell','Dixon','C#');

SELECT * FROM trainers;