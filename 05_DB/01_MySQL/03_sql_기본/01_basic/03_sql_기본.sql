/*
 *** 인텔리제이를 이용하여 MySQL 연결하여 사용하기 ***

 1. 데이터 소스 생성
    방법 1) 메인 메뉴에서 `File` | `New` | `Data Source`를 선택하고 `MySQL`을 선택
    방법 2) Database 도구 창에서  `New` 버튼을 클릭하고 `Data Source` 선택 후 `MySQL`을 선택

 2. 드라이버 설정
    - 연결 설정 영역 하단에 `Download missing driver files` 링크가 있는지 확인
    - 있으면 클릭하여 다운로드 수행

 3. 연결 세부 정보 지정
    - `General(일반)` 탭에서 알맞은 정보 입력
        - `Host`: 서버 주소 (예: localhost 또는 127.0.0.1)
        - : MySQL 포트 (기본값: 3306) `Port`
        - `Authentication`: 인증 방식 선택 (일반적으로 `User & Password`)
        - 및 : 사용자 자격 증명 입력
            `User` : root
            `Password` : root 비밀번호
        - `Database`: 연결할 데이터베이스 이름

 4. URL 확인 후 연결 테스트
    - URL : jdbc:mysql://localhost:3306   형태
    - 연결 테스트 클릭 -> 체크 표시 확인

 5. 'Schemas(스키마)' 탭에서 사용하려는 스키마 모두 체크

 6. 확인 클릭

 *** SQL 실행은 CTRL + Enter ***

 - 커서가 올라간 SQL만 실행하고 싶은 경우
    인텔리제이 설정 > 데이터베이스 > 쿼리 실행 > 실행
    > 구문 내 캐럿이 실행될 때 > "최소 하위 쿼리 또는 구문" 선택
*/

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

select * from usertbl where addr in('경남', '전남', '경북');

select * from usertbl where name like '김%';

select name, height from usertbl where height > (select height from usertbl where name = '김경호');

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