create table tbl_board (
	no int not null,
    title varchar(256) not null,
    content text,
    writer varchar(50) not null,
    reg_date datetime,
    update_date datetime
);

insert into tbl_board values(1, '제목1', '내용1', 'ghldnjs1', current_timestamp, null);
insert into tbl_board values(2, '제목2', '내용2', 'ghldnjs2', current_timestamp, null);
insert into tbl_board values(3, '제목3', '내용3', 'ghldnjs3', current_timestamp, null);
insert into tbl_board values(4, '제목4', '내용4', 'ghldnjs4', current_timestamp, null);
insert into tbl_board values(5, '제목5', '내용5', 'ghldnjs5', current_timestamp, null);
insert into tbl_board values(6, '제목6', '내용6', 'ghldnjs6', current_timestamp, null);
insert into tbl_board values(7, '제목7', '내용7', 'ghldnjs7', current_timestamp, null);
insert into tbl_board values(8, '제목8', '내용8', 'ghldnjs8', current_timestamp, null);
insert into tbl_board values(9, '제목9', '내용9', 'ghldnjs9', current_timestamp, null);
insert into tbl_board values(10, '제목10', '내용10', 'ghldnjs10', current_timestamp, null);

select * from tbl_board;

select no, title, writer from tbl_board;

select * from tbl_board where writer = 'ghldnjs2';