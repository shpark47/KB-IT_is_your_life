select * from usertbl u inner join buytbl b on u.userID = b.userID;

select * from usertbl u inner join buytbl b on u.userID = b.userID where b.userID = 'JYP';

select u.userID, name, prodName, addr,concat(mobile1, mobile2) as 연락처
from usertbl u left outer join buytbl b on u.userID = b.userID order by userID;

select * from usertbl where mobile1 is not null and mobile2 is not null;

select * from usertbl where mobile1 is null and mobile2 is null;