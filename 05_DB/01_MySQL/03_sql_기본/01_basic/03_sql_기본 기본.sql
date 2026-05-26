show databases;

use employees;

show tables;

SELECT first_name FROM employees;

SELECT first_name, last_name, gender FROM employees;

SELECT first_name AS 이름, gender AS 성별, hire_date '회사 입사일' FROM employees;

use sqldb;

select * from usertbl where name = '김경호';

select * from usertbl where height >= 182 and birthYear >= 1970;

select * from usertbl where height between 180 and 183;

select * from usertbl where addr = '경남' or addr = '전남' or addr = '경북';

select * from usertbl where name like '김%';

select name, height from usertbl where height >= (select height from usertbl where name = '김경호');

select * from usertbl order by mdate;

select * from usertbl order by mdate desc;

select * from usertbl order by height desc, name desc;

select distinct addr from usertbl order by addr;

use world;

select * from city where countrycode = 'KOR' order by Population desc;

select countrycode, Population from city order by countrycode, population desc;

select count(*) from city where countrycode = 'KOR';

select * from city where countrycode = 'KOR' or countrycode = 'CHN' or countrycode = 'JPN';

select * from city where countrycode = 'KOR' and population >= 1000000;

select * from city where countrycode = 'KOR' order by population desc limit 10;

select * from city where countrycode = 'KOR' and population between 1000000 and 5000000;