INSERT INTO account (account_id, email, login, password, status)
VALUES (-1, 'User1@mail.com', 'User1', 'password1', 0),
       (-2, 'User2@mail.com', 'User2', 'password2', 0),
       (-3, 'User3@mail.com', 'User3', 'password3', 0);

INSERT INTO  administrator (administrator_account_id, first_name, last_name, age, sex)
VALUES (-1, 'Super', 'User', 24, 'M');

INSERT INTO  teacher (teacher_account_id, first_name, last_name, age, sex, country, state, city, description)
VALUES (-2, 'Teacher', 'Professor', 50, 'F', 'Poland', 'lubelskie', 'Lublin', 'I have 20 years of experience.');

INSERT INTO  student (student_account_id, first_name, last_name, age, sex, country, state, city)
VALUES (-3, 'Student', 'Newbie', 17, 'M', 'Poland', 'lubelskie', 'Lublin');

INSERT INTO  subject (subject_id, name)
VALUES (-1, 'English'),
(-2, 'Biology'),
(-3, 'Chemistry'),
(-4, 'Geography'),
(-5, 'Physics'),
(-6, 'Math'),
(-7, 'Information Technology'),
(-8, 'History');

INSERT INTO course (course_id, subject_id, status, gross_price, teacher_id, student_id)
VALUES (-1, -6, 0, 60, -2, -3);

INSERT INTO lesson (lesson_id, course_id, status, duration, start_date, end_date, notes, payment_id)
VALUES (-1, -1, 0, null, null, null, null, null),
(-2, -1, 0, null, null, null, null, null),
(-3, -1, 0, null, null, null, null, null),
(-4, -1, 0, null, null, null, null, null),
(-5, -1, 0, null, null, null, null, null);
