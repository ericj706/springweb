DROP DATABASE IF EXISTS practice0826;
CREATE DATABASE practice0826;
USE practice0826;
CREATE TABLE board( 
    phone VARCHAR(255) ,
    num INTEGER
);
insert into board( phone, num )values( "010-1234-1234", 4 ),( "010-9876-9876", 2); 