INSERT INTO web_user(user_first_name, user_last_name, user_login, user_password, user_score)
VALUES

('Александр', 'Плохой', 'admin', 'test', 0),
('Иван', 'Тестовый', 'moder', 'test', 0);

INSERT INTO web_role(role_id, role_name)
VALUES
('1', 'ADMIN'),
('2', 'MODER'),
('3', 'USER');

INSERT INTO user_role(user_id, role_id)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '2'),
('2', '3');

INSERT INTO time(time_id, time_point_name, time_value)
VALUES
('1', 'mainPoint', '1583756263503');

