INSERT INTO  subject (subject_id, name)
VALUES (-1, 'English'),
(-2, 'Biology'),
(-3, 'Chemistry'),
(-4, 'Geography'),
(-5, 'Physics'),
(-6, 'Math'),
(-7, 'Information Technology'),
(-8, 'History');

INSERT INTO account (account_id, email, login, password, status, first_name, last_name, age, sex, country, state, city)
VALUES (-1, 'User1@mail.com', 'User1', 'password1', 0, 'Super', 'User', 24, 'M', 'Poland', 'lubelskie', 'Lublin'),
(-2, 'User2@mail.com', 'User2', 'password2', 0, 'Teacher', 'Professor', 50, 'F', 'Poland', 'lubelskie', 'Lublin'),
(-3, 'User3@mail.com', 'User3', 'password3', 0, 'Student', 'Newbie', 17, 'M', 'Poland', 'lubelskie', 'Lublin'),
(-4, 'User4@mail.com', 'User4', 'password4', 0, 'English', 'Man', 40, 'M', 'Poland', 'lubelskie', 'Lublin'),
(-5, 'User5@mail.com', 'User5', 'password5', 0, 'Biology', 'Woman', 33, 'M', 'Poland', 'mazowieckie', 'Warszawa'),
(-6, 'User6@mail.com', 'User6', 'password6', 0, 'Math', 'Boy', 25, 'M', 'Poland', 'małopolskie', 'Kraków');

INSERT INTO  administrator (administrator_account_id, department)
VALUES (-1, 'Accounting');

INSERT INTO  teacher (teacher_account_id, description)
VALUES (-1, 'Can I help you?'),
(-2, 'I have 25 years of experience.'),
(-4, 'I have 20 years of experience.'),
(-5, 'I love biology.'),
(-6, 'I love math.');

INSERT INTO teacher_subject_assignment(teacher_account_id, subject_id)
VALUES (-2, -7),
(-2, -6),
(-2, -5),
(-4, -1);

INSERT INTO  student (student_account_id, budget)
VALUES (-3, 100.50);

INSERT INTO course (course_id, subject_id, status, hours_per_week, lessons_schedule, student_price_per_hour, teacher_pay_rate_per_hour, teacher_id, student_id)
VALUES (-1, -6, 0, 3, 'pon 10-13', 29.90, 15, -2, -3),
(-2, -5, 0, 3, 'wt 10-13', 29.90, 15, -2, -3);

INSERT INTO payment (payment_id, recipient_id, sender_id, status, amount)
VALUES (-1, -2, -3, 0, null),
(-2, -2, -3, 1, 15.0);

INSERT INTO lesson (lesson_id, course_id, status, duration, start_date, end_date, notes, payment_id)
VALUES (-1, -1, 3, 1, '2020-05-03', '2020-05-10', 'First lesson in course.', -2),
(-2, -1, 0, 2, null, null, null, null),
(-3, -1, 0, 3.5, null, null, null, null),
(-4, -1, 0, null, null, null, null, null),
(-5, -1, 0, 1, null, null, null, null);
