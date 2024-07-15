-- CREATES TABLES FOR EMPLOYEES, CLIENTS, INVENTORY & ORDERS

create type member_role as enum('ADMIN', 'EMPLOYEE', 'CUSTOMER');
create table tommy_hoang_p0.p0_members(
	id_member int primary key,
	member_type member_role default 'CUSTOMER',
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255),
	phone_number char(10),
	pwd varchar(255),
	street_address varchar(255)
);

create table tommy_hoang_p0.p0_inventory(
	id_car int primary key,
	car_make varchar(255),
	car_model varchar(20),
	car_year char(4),
	car_color char(3),
	car_trims varchar(255)
);

create table tommy_hoang_p0.p0_orders(
	id_order int primary key,
	car_make varchar(255),
	car_model varchar(20),
	car_year char(4),
	car_color char(3),
	car_trims varchar(255)
);

-- READ

SELECT * FROM tommy_hoang_p0.p0_members;
SELECT * FROM tommy_hoang_p0.p0_inventory;
SELECT * FROM tommy_hoang_p0.p0_orders;

-- INSERT INTO tommy_hoang_p0


-- UPDATE INTO tommy_hoang_p0


-- DELETE TABLE

drop table tommy_hoang_p0.p0_members;
drop table tommy_hoang_p0.p0_inventory;
drop table tommy_hoang_p0.p0_orders;

-- TRUNCATE TABLE

truncate table tommy_hoang_p0.p0_members;
truncate table tommy_hoang_p0.p0_inventory;
truncate table tommy_hoang_p0.p0_client;
