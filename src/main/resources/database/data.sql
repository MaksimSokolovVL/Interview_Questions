INSERT INTO interview.roles (role_name)
SELECT 'ROLE_ADMIN' WHERE NOT EXISTS (SELECT 1 FROM interview.roles WHERE role_name = 'ROLE_ADMIN');
INSERT INTO interview.roles (role_name)
SELECT 'ROLE_USER' WHERE NOT EXISTS (SELECT 1 FROM interview.roles WHERE role_name = 'ROLE_USER');

INSERT INTO interview.users (active, email, name, password, surname)
SELECT true, 'volokos2010@gmail.com', 'Maxim', '$2a$08$TrzzrqkCuXAduTND8n3Ffe9n8gXIk6VsLiJjDaj/W8uCqC9MLIIUe', 'Sokolov'
WHERE NOT EXISTS (SELECT 1 FROM interview.users WHERE email = 'volokos2010@gmail.com');
INSERT INTO interview.users (active, email, name, password, surname)
SELECT true, 'user@mail.ru', 'Natasha', '$2a$08$TrzzrqkCuXAduTND8n3Ffe9n8gXIk6VsLiJjDaj/W8uCqC9MLIIUe', 'Sokolova'
WHERE NOT EXISTS (SELECT 1 FROM interview.users WHERE email = 'user@mail.ru');

INSERT INTO interview.users_roles (user_id, role_id)
SELECT 1, 1 WHERE NOT EXISTS (SELECT 1 FROM interview.users_roles WHERE user_id = 1 AND role_id = 1);
INSERT INTO interview.users_roles (user_id, role_id)
SELECT 1, 2 WHERE NOT EXISTS (SELECT 1 FROM interview.users_roles WHERE user_id = 1 AND role_id = 2);
INSERT INTO interview.users_roles (user_id, role_id)
SELECT 2, 2 WHERE NOT EXISTS (SELECT 1 FROM interview.users_roles WHERE user_id = 2 AND role_id = 2);

INSERT INTO interview.sections (section_name)
SELECT 'SQL BASICS' WHERE NOT EXISTS (SELECT 1 FROM interview.sections WHERE section_name = 'SQL BASICS');
INSERT INTO interview.sections (section_name)
SELECT 'CORE BASICS' WHERE NOT EXISTS(SELECT 1 FROM interview.sections WHERE section_name = 'CORE BASICS');

INSERT INTO interview.questions (explanations, images, question_txt, section_id)
SELECT 'test comment', null, 'how SQL?', 1
WHERE NOT EXISTS(SELECT 1 FROM interview.questions WHERE question_txt = 'how SQL?');

INSERT INTO interview.answer (is_correct, text, question_id)
SELECT true, 'this DATA BASE', 1
WHERE NOT EXISTS(SELECT 1 FROM interview.answer WHERE text = 'this DATA BASE');
INSERT INTO interview.answer (is_correct, text, question_id)
SELECT false, 'this Glass', 1
WHERE NOT EXISTS(SELECT 1 FROM interview.answer WHERE text = 'this Glass');
