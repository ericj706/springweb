#day05 / TestEntity sample
drop DATABASE if EXISTS mydb0903;
CREATE DATABASE mydb0903;
use mydb0903;
insert into test(name,descri,price,create_date, update_date)
    value('코카콜라','맛있는',1000,now(),now() ),
    ('사이다','시원한',1500,now(),now() ),
    ('환타','달콤한',700,now(),now() );