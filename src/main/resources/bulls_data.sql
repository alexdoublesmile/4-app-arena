INSERT INTO web_user(user_first_name, user_last_name, user_login, user_password, user_score)
VALUES
('Иван', 'Тестовый', 'PGcreated', 'test', 0),
('Саша', 'Тестовый', 'alex', 'test', 0);

INSERT INTO web_role(role_id, role_name)
VALUES
('1', 'ADMIN'),
('2', 'USER');

INSERT INTO user_role(user_id, role_id)
VALUES
('1', '2'),
('2', '1');
