USE sqldb;
CREATE TABLE stdtbl
(
    stdName VARCHAR(10) NOT NULL PRIMARY KEY,
    addr    CHAR(4)     NOT NULL
);

CREATE TABLE clubtbl
(
    clubName VARCHAR(10) NOT NULL PRIMARY KEY,
    roomNo   CHAR(4)     NOT NULL
);

CREATE TABLE stdclubtbl
(
    num      int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    stdName  VARCHAR(10)        NOT NULL,
    clubName VARCHAR(10)        NOT NULL,
    FOREIGN KEY (stdName) REFERENCES stdtbl (stdName),
    FOREIGN KEY (clubName) REFERENCES clubtbl (clubName)
);

INSERT INTO stdtbl
VALUES ('김범수', '경남'),
       ('성시경', '서울'),
       ('조용필', '경기'),
       ('은지원', '경북'),
       ('바비킴', '서울');
INSERT INTO clubtbl
VALUES ('수영', '101호'),
       ('바둑', '102호'),
       ('축구', '103호'),
       ('봉사', '104호');
INSERT INTO stdclubtbl
VALUES (NULL, '김범수', '바둑'),
       (NULL, '김범수', '축구'),
       (NULL, '조용필', '축구'),
       (NULL, '은지원', '축구'),
       (NULL, '은지원', '봉사'),
       (NULL, '바비킴', '봉사');

select s.stdName, s.addr, c.clubName, roomNo
from stdtbl s
         join stdclubtbl sc
              on s.stdName = sc.stdName
         join clubtbl c
              on c.clubName = sc.clubName
ORDER BY s.stdName;

select c.clubName, c.roomNo, s.stdName, s.addr
from clubtbl c
         join stdclubtbl sc
              on c.clubName = sc.clubName

         join stdtbl s
              on s.stdName = sc.stdName
ORDER BY c.clubName;

USE sqldb;
CREATE TABLE empTbl
(
    emp     CHAR(3),
    manager CHAR(3),
    empTel  VARCHAR(8)
);

INSERT INTO empTbl
VALUES ('나사장', NULL, '0000');
INSERT INTO empTbl
VALUES ('김재무', '나사장', '2222');
INSERT INTO empTbl
VALUES ('김부장', '김재무', '2222-1');
INSERT INTO empTbl
VALUES ('이부장', '김재무', '2222-2');
INSERT INTO empTbl
VALUES ('우대리', '이부장', '2222-2-1');
INSERT INTO empTbl
VALUES ('지사원', '이부장', '2222-2-2');
INSERT INTO empTbl
VALUES ('이영업', '나사장', '1111');
INSERT INTO empTbl
VALUES ('한과장', '이영업', '1111-1');
INSERT INTO empTbl
VALUES ('최정보', '나사장', '3333');
INSERT INTO empTbl
VALUES ('윤차장', '최정보', '3333-1');
INSERT INTO empTbl
VALUES ('이주임', '윤차장', '3333-1-1');

SELECT a.emp AS '부하직원', b.emp AS '직속상관', b.empTel AS '직속상관연락처'
FROM empTbl a
         INNER JOIN empTbl b ON a.manager = b.emp
WHERE a.emp = '우대리';

use employees;

select e.emp_no, e.first_name, e.last_name, t.title
from employees e
         join titles t
              on e.emp_no = t.emp_no
where t.to_date = '9999-01-01';

select e.*, t.title, s.salary
from employees e
         join titles t
              on e.emp_no = t.emp_no
         join salaries s
              on e.emp_no = s.emp_no
where t.to_date = '9999-01-01';

select e.emp_no, e.first_name, e.last_name, d.dept_name
from employees e
         join dept_emp de
              on e.emp_no = de.emp_no
         join departments d
              on de.dept_no = d.dept_no
where de.to_date = '9999-01-01';

select d.dept_no, d.dept_name, count(*)
from dept_emp de
         join departments d
              on de.dept_no = d.dept_no
where de.to_date = '9999-01-01'
group by d.dept_no;

select e.emp_no, e.first_name, e.last_name, d.dept_name, de.from_date, de.to_date
from employees e
         join dept_emp de
              on e.emp_no = de.emp_no
         join departments d
              on de.dept_no = d.dept_no
where de.emp_no = 10209;