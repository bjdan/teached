INSERT INTO account (account_id, email, login, password, status, first_name, last_name, age, sex, country, state, city)
VALUES (-1, 'User1@mail.com', 'User1', 'password1', 0, 'Super', 'User', 24, 'M', 'Poland', 'lubelskie', 'Lublin'),
       (-2, 'User2@mail.com', 'User2', 'password2', 0, 'Teacher', 'Professor', 50, 'F', 'Poland', 'lubelskie', 'Lublin'),
       (-3, 'User3@mail.com', 'User3', 'password3', 0, 'Student', 'Newbie', 17, 'M', 'Poland', 'lubelskie', 'Lublin');

INSERT INTO  administrator (administrator_account_id, department)
VALUES (-1, 'Accounting');

INSERT INTO  teacher (teacher_account_id, description)
VALUES (-2, 'I have 20 years of experience.');

INSERT INTO  student (student_account_id, budget)
VALUES (-3, 100.50);

INSERT INTO  subject (subject_id, name)
VALUES (-1, 'English'),
(-2, 'Biology'),
(-3, 'Chemistry'),
(-4, 'Geography'),
(-5, 'Physics'),
(-6, 'Math'),
(-7, 'Information Technology'),
(-8, 'History');

INSERT INTO course (course_id, subject_id, status, hours_per_week, lessons_schedule, student_price_per_hour, teacher_pay_rate_per_hour, teacher_id, student_id)
VALUES (-1, -6, 0, 3, 'pon 10-13', 29.90, 15, -2, -3),
(-2, -5, 0, 3, 'wt 10-13', 29.90, 15, -2, -3);

INSERT INTO payment (payment_id, recipient_id, sender_id, status, amount)
VALUES (-1, -2, -3, 0, null),
(-2, -2, -3, 1, 15.0);

INSERT INTO lesson (lesson_id, course_id, status, duration, start_date, end_date, notes, payment_id)
VALUES (-1, -1, 0, null, null, null, null, null),
(-2, -1, 0, null, null, null, null, null),
(-3, -1, 0, null, null, null, null, null),
(-4, -1, 0, null, null, null, null, null),
(-5, -1, 0, null, null, null, null, null);
