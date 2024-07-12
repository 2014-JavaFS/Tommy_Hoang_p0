-- CREATES TABLES FOR EMPLOYEES, CLIENTS, INVENTORY & ORDERS

create table tommy_hoang_p0.p0_employees(
	id_employee int primary key,
	id_role int,
	name_first varchar(255),
	name_last varchar(255),
	email varchar(255)
);
create table tommy_hoang_p0.p0_clients(
	id_client int primary key,
	name_first varchar(255),
	name_last varchar(255),
	street_address varchar(255),
	email varchar(255)
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

