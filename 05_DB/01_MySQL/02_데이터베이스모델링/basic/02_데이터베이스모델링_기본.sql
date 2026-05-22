create table productTBL (
	productName char(4) not null,
	cost int not null,
	makeDate date,
	company char(5),
	amount int not null
); 

insert into membertbl values('Dang', '당탕이', '경기 부천시 중동');
insert into membertbl values('Jee', '지운이', '서울 은평구 증산동');
insert into membertbl values('Han', '한주연', '인천 남구 주안동');
insert into membertbl values('Sang', '상길이', '경기 성남시 분당구');

insert into producttbl values('컴퓨터', 10, '2021-01-01', '삼성', 17);
insert into producttbl values('세탁기', 20, '2022-09-01', 'LG', 3);
insert into producttbl values('냉장고', 5, '2023-02-01', '대우', 22);

select * from producttbl;

select memberName, memberAddress from membertbl;

select * from membertbl where memberName = '지운이';