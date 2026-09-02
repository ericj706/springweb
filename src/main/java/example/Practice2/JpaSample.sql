
drop DATABASE if EXISTS jpaDB;
CREATE DATABASE jpaDB;
use jpaDB;
CREATE TABLE practice2(
    no INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(50),
    writer VARCHAR(10)
);

INSERT INTO practice2(content, writer)VALUES('안녕1','유재석');
INSERT INTO practice2(content, writer)VALUES('안녕2','강호동');
