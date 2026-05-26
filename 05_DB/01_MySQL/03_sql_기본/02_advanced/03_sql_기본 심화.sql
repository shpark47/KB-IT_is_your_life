use sqldb;

select userid as '사용자 아이디', sum(amount) as '총 구매 개수' from buytbl group by userid order by userid;

select userid as '사용자 아이디', sum(price * amount) as '총 구매액' from buytbl group by userid order by userid;

select avg(amount) as '평균 구매 개수' from buytbl;

select userid, avg(amount) as '평균 구매 개수' from buytbl group by userid;

select name, height from usertbl where height = (select max(height) from usertbl) or height = (select min(height) from usertbl);

select count(mobile1) as '휴대폰이 있는 사용자' from usertbl;

select userid as '사용자', sum(price * amount) as '총 구매액' from buytbl group by userid order by userid;

select userid as '사용자', sum(price * amount) as '총 구매액' from buytbl group by userid having sum(price * amount) >= 1000 order by userid;

use world;

select sum(population) from city where countrycode = 'KOR';

select min(population) as 최소값 from city where countrycode = 'KOR';

select avg(population) from city where countrycode = 'KOR';

select max(population) as 최대값 from city where countrycode = 'KOR';

select length(name) from country;

select concat(upper(substr(name, 1, 3)), substr(name, 4)) from country;

select round(lifeexpectancy, 0) from country;

use employees;

select e.first_name, d.dept_name from employees e, departments d, dept_manager dm where dm.emp_no = e.emp_no and dm.dept_no = d.dept_no and dm.to_date >= CURRENT_DATE();

select e.* from employees e, dept_manager dm where dm.emp_no = e.emp_no and dm.dept_no = 'd005';

select * from employees order by hire_date desc limit 160, 20;

select count(*) from dept_emp where to_date = '9999-01-01';

select avg(salary) from salaries s where to_date = '9999-01-01';

select e.* from employees e, salaries s where e.emp_no = s.emp_no and s.to_date = '9999-01-01' and salary >= (select avg(salary) from employees e, salaries s where e.emp_no = s.emp_no and s.to_date = '9999-01-01');

select count(*), dept_no from dept_emp where to_date = '9999-01-01' group by dept_no order by dept_no;