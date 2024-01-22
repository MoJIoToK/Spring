CREATE TABLE IF NOT EXISTS "user" (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age int NOT NULL,
    email varchar(50) NOT NULL
    );

insert into "user" (name, age, email) values ('Nick', 27, '1@mail.ru');
insert into "user" (name, age, email) values ('Petr', 53, '2@yandex.ru');
insert into "user" (name, age, email) values ('Lisa', 33, '3@gmail.com');