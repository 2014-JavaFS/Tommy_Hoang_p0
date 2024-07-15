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

select * from tommy_hoang_p0.p0_inventory;
select * from tommy_hoang_p0.p0_orders;
select * from tommy_hoang_p0.p0_members;

-- INSERT INTO tommy_hoang_p0

INSERT INTO tommy_hoang_p0.p0_orders (id_order, car_make, car_model, car_year, car_color, car_trims)
VALUES
    (1, 'Toyota', 'Camry', 2012, 'SIL', 'LE'),
    (2, 'Honda', 'Accord', 2019, 'BLK', 'EX'),
    (3, 'Ford', 'F-150', 2014, 'RED', 'Lariat'),
    (4, 'Chevrolet', 'Malibu', 2020, 'GRN', 'LT'),
    (5, 'Nissan', 'Altima', 2010, 'BLU', 'SV');


insert into tommy_hoang_p0.p0_clients (id_client);
INSERT INTO tommy_hoang_p0.p0_inventory (id_car, car_make, car_model, car_year, car_color, car_trims, quantity)
VALUES
(1, 'Toyota', 'Camry', '2023', 'BLK', 'LE', 10),
(2, 'Honda', 'Accord', '2023', 'RED', 'EX-L', 5),
(3, 'Ford', 'F-150', '2023', 'WHT', 'Lariat', 8),
(4, 'Chevrolet', 'Silverado', '2023', 'BLU', 'LTZ', 12),
(5, 'BMW', 'X5', '2023', 'GRY', 'xDrive40i', 6),
(6, 'Audi', 'A4', '2023', 'SIL', 'Premium', 7),
(7, 'Mercedes-Benz', 'E-Class', '2023', 'BLK', 'E 350', 9),
(8, 'Tesla', 'Model S', '2023', 'RED', 'Long Range', 3),
(9, 'Nissan', 'Altima', '2023', 'WHT', 'SV', 11),
(10, 'Volkswagen', 'Golf', '2023', 'BLU', 'SE', 4),
(11, 'Subaru', 'Outback', '2023', 'GRY', 'Limited', 8),
(12, 'Hyundai', 'Tucson', '2023', 'SIL', 'Limited', 6),
(13, 'Kia', 'Sorento', '2023', 'BLK', 'SX', 7),
(14, 'Mazda', 'CX-5', '2023', 'RED', 'Grand Touring', 9),
(15, 'Jeep', 'Grand Cherokee', '2023', 'WHT', 'Limited', 5),
(16, 'Lexus', 'RX', '2023', 'BLU', '350', 10),
(17, 'Infiniti', 'Q50', '2023', 'GRY', '3.0t LUXE', 8),
(18, 'Volvo', 'XC90', '2023', 'SIL', 'Inscription', 4),
(19, 'Porsche', 'Cayenne', '2023', 'BLK', 'S', 6),
(20, 'Jaguar', 'F-Pace', '2023', 'RED', 'P250 S', 7),
(21, 'Land Rover', 'Range Rover', '2023', 'WHT', 'Velar', 5),
(22, 'Acura', 'MDX', '2023', 'BLU', 'Technology', 9),
(23, 'Genesis', 'G80', '2023', 'GRY', '3.5T Prestige', 3),
(24, 'Buick', 'Encore', '2023', 'SIL', 'Preferred', 11),
(25, 'Lincoln', 'Navigator', '2023', 'BLK', 'Reserve', 8),
(26, 'Cadillac', 'Escalade', '2023', 'RED', 'Luxury', 6),
(27, 'Chrysler', '300', '2023', 'WHT', 'Limited', 10),
(28, 'Fiat', '500', '2023', 'BLU', 'Lounge', 4),
(29, 'Maserati', 'Ghibli', '2023', 'GRY', 'S Q4', 7),
(30, 'Alfa Romeo', 'Stelvio', '2023', 'SIL', 'Ti', 9),
(31, 'Mini', 'Cooper', '2023', 'BLK', 'S', 5),
(32, 'Smart', 'Fortwo', '2023', 'RED', 'Passion', 12),
(33, 'Rolls-Royce', 'Phantom', '2023', 'WHT', 'EWB', 6),
(34, 'Bentley', 'Continental GT', '2023', 'BLU', 'V8', 8),
(35, 'Bugatti', 'Chiron', '2023', 'GRY', 'Sport', 4),
(36, 'Ferrari', '488 GTB', '2023', 'SIL', 'Coupe', 9),
(37, 'Lamborghini', 'Aventador', '2023', 'BLK', 'S', 7),
(38, 'McLaren', '720S', '2023', 'RED', 'Performance', 11),
(39, 'Porsche', '911', '2023', 'WHT', 'Carrera', 5),
(40, 'Tesla', 'Model 3', '2023', 'BLU', 'Long Range', 10),
(41, 'Toyota', 'RAV4', '2023', 'GRY', 'XSE Hybrid', 8),
(42, 'Honda', 'CR-V', '2023', 'SIL', 'Touring', 6),
(43, 'Ford', 'Escape', '2023', 'BLK', 'SEL', 7),
(44, 'Chevrolet', 'Equinox', '2023', 'RED', 'Premier', 9),
(45, 'BMW', '3 Series', '2023', 'WHT', '330i', 5),
(46, 'Audi', 'Q5', '2023', 'BLU', 'Premium', 8),
(47, 'Mercedes-Benz', 'GLC', '2023', 'GRY', '300', 4),
(48, 'Nissan', 'Rogue', '2023', 'SIL', 'SV', 6),
(49, 'Volkswagen', 'Tiguan', '2023', 'BLK', 'SE', 7),
(50, 'Subaru', 'Forester', '2023', 'RED', 'Limited', 9);

-- Insert 1 ADMIN member
INSERT INTO tommy_hoang_p0.p0_members (member_type, first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('ADMIN', 'Admin', 'User', 'admin@example.com', '1234567890', 'adminpwd', '123 Admin St');

-- Insert 2 EMPLOYEE members
INSERT INTO tommy_hoang_p0.p0_members (member_type, first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('EMPLOYEE', 'Employee1', 'User', 'employee1@example.com', '9876543210', 'emp1pwd', '456 Employee St');

INSERT INTO tommy_hoang_p0.p0_members (member_type, first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('EMPLOYEE', 'Employee2', 'User', 'employee2@example.com', '5555555555', 'emp2pwd', '789 Employee St');

-- Insert 5 CUSTOMER members
INSERT INTO tommy_hoang_p0.p0_members (first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('Customer1', 'User', 'customer1@example.com', '1111111111', 'cust1pwd', '101 Customer St');

INSERT INTO tommy_hoang_p0.p0_members (first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('Customer2', 'User', 'customer2@example.com', '2222222222', 'cust2pwd', '202 Customer St');

INSERT INTO tommy_hoang_p0.p0_members (first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('Customer3', 'User', 'customer3@example.com', '3333333333', 'cust3pwd', '303 Customer St');

INSERT INTO tommy_hoang_p0.p0_members (first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('Customer4', 'User', 'customer4@example.com', '4444444444', 'cust4pwd', '404 Customer St');

INSERT INTO tommy_hoang_p0.p0_members (first_name, last_name, email, phone_number, pwd, street_address)
VALUES ('Customer5', 'User', 'customer5@example.com', '5555555555', 'cust5pwd', '505 Customer St');


-- UPDATE INTO tommy_hoang_p0


-- DELETE TABLE

drop table tommy_hoang_p0.p0_members;
drop table tommy_hoang_p0.p0_inventory;
drop table tommy_hoang_p0.p0_orders;

-- TRUNCATE TABLE

truncate table tommy_hoang_p0.p0_members;
truncate table tommy_hoang_p0.p0_inventory;
truncate table tommy_hoang_p0.p0_client;
