-- CREATES TABLES FOR EMPLOYEES, CLIENTS, INVENTORY & ORDERS

create type user_role as enum('ADMIN', 'EMPLOYEE', 'CUSTOMER');
create table tommy_hoang_p0.p0_users(
	user_id serial primary key,
	user_type user_role,
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255),
	phone varchar(10),
	pwd varchar(255)
);
CREATE TABLE tommy_hoang_p0.p0_inventory(
	car_id SERIAL primary key,
	vehicle_details JSONB,
	quantity SMALLINT
);

CREATE TABLE tommy_hoang_p0.p0_orders (
    order_id SERIAL PRIMARY KEY,
    vehicle_details JSONB,
    customer_name VARCHAR(255),
    customer_phone VARCHAR(12),
    customer_email VARCHAR(255),
    quantity SMALLINT DEFAULT 1
);


-- READ

select * from tommy_hoang_p0.p0_users;
select * from tommy_hoang_p0.p0_inventory;
select * from tommy_hoang_p0.p0_orders;

-- INSERT INTO tommy_hoang_p0
INSERT INTO tommy_hoang_p0.p0_inventory (vehicle_details, quantity) VALUES 
('{"make": "Toyota", "model": "Camry", "year": "2021", "color": "Blue", "trim": "XLE"}', 5),
('{"make": "Toyota", "model": "Corolla", "year": "2020", "color": "Red", "trim": "LE"}', 10),
('{"make": "Toyota", "model": "Highlander", "year": "2019", "color": "Black", "trim": "XSE"}', 3),
('{"make": "Toyota", "model": "RAV4", "year": "2018", "color": "White", "trim": "Limited"}', 8),
('{"make": "Toyota", "model": "Prius", "year": "2022", "color": "Silver", "trim": "Prime"}', 12);



INSERT INTO tommy_hoang_p0.p0_orders (vehicle_details, customer_name, customer_phone, customer_email)
VALUES 
('{"make": "Toyota", "model": "Camry", "year": "2021", "color": "Blue", "trim": "XLE"}', 'John Doe', '123-456-7890', 'john.doe@example.com'),
('{"make": "Toyota", "model": "Corolla", "year": "2020", "color": "Red", "trim": "LE"}', 'Jane Smith', '234-567-8901', 'jane.smith@example.com'),
('{"make": "Toyota", "model": "Highlander", "year": "2019", "color": "Black", "trim": "XSE"}', 'Michael Johnson', '345-678-9012', 'michael.johnson@example.com');



-- Insert 1 ADMIN user
INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('ADMIN', 'Admin', 'User', 'admin@example.com', '1234567890', 'adminpwd');

-- Insert 2 EMPLOYEE users
INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('EMPLOYEE', 'Employee1', 'User', 'employee1@example.com', '9876543210', 'emp1pwd');

INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('EMPLOYEE', 'Employee2', 'User', 'employee2@example.com', '5555555555', 'emp2pwd');

-- Insert 5 CUSTOMER users
INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('CUSTOMER', 'Customer1', 'User', 'customer1@example.com', '1111111111', 'cust1pwd');

INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('CUSTOMER', 'Customer2', 'User', 'customer2@example.com', '2222222222', 'cust2pwd');

INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('CUSTOMER', 'Customer3', 'User', 'customer3@example.com', '3333333333', 'cust3pwd');

INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('CUSTOMER', 'Customer4', 'User', 'customer4@example.com', '4444444444', 'cust4pwd');

INSERT INTO tommy_hoang_p0.p0_users (user_type, first_name, last_name, email, phone, pwd)
VALUES ('CUSTOMER', 'Customer5', 'User', 'customer5@example.com', '5555555555', 'cust5pwd');


-- UPDATE INTO tommy_hoang_p0


-- DELETE TABLE

drop table tommy_hoang_p0.p0_users;
drop table tommy_hoang_p0.p0_inventory;
drop table tommy_hoang_p0.p0_orders;

-- TRUNCATE TABLE

truncate table tommy_hoang_p0.p0_users;
truncate table tommy_hoang_p0.p0_inventory;
truncate table tommy_hoang_p0.p0_orders;
