DELETE FROM user_role;
DELETE FROM meals;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO meals(dateTime, description, calories, user_id)
VALUES ('2022-10-10 11:30:30', 'Breakfast', 200, 100000),
       ('2022-10-10 14:30:00','Lunch', 500, 100000),
       ('2022-10-10 19:30:00', 'Dinner', 1000, 100000);