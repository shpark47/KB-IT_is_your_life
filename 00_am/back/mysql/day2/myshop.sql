CREATE TABLE `userTBL` (
	`userName`	varchar(3)	NOT NULL,
	`birthYear`	int	NOT NULL,
	`addr`	varchar(2)	NOT NULL,
	`mobile`	varchar(2)	NULL
);

CREATE TABLE `buyTBL` (
	`userName`	varchar(3)	NOT NULL,
	`prodName`	varchar(3)	NOT NULL,
	`price`	int	NOT NULL,
	`amount`	int	NOT NULL
);

ALTER TABLE `userTBL` ADD CONSTRAINT `PK_USERTBL` PRIMARY KEY (
	`userName`
);

ALTER TABLE `buyTBL` ADD CONSTRAINT `PK_BUYTBL` PRIMARY KEY (
	`userName`
);

ALTER TABLE `buyTBL` ADD CONSTRAINT `FK_userTBL_TO_buyTBL_1` FOREIGN KEY (
	`userName`
)
REFERENCES `userTBL` (
	`userName`
);

CREATE TABLE `memberTBL` (
	`memberID`	varchar(256)	NOT NULL,
	`memberName`	varchar(256)	NULL,
	`memberAddress`	varchar(256)	NULL
);

CREATE TABLE `productTBL` (
	`productName`	varchar(256)	NOT NULL,
	`cost`	int	NULL,
	`makeDate`	date	NULL,
	`company`	varchar(256)	NULL,
	`amount`	int	NULL
);

ALTER TABLE `memberTBL` ADD CONSTRAINT `PK_MEMBERTBL` PRIMARY KEY (
	`memberID`
);

ALTER TABLE `productTBL` ADD CONSTRAINT `PK_PRODUCTTBL` PRIMARY KEY (
	`productName`
);
