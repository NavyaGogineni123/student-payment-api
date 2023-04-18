CREATE TABLE sys.student (
                             student_id INT PRIMARY KEY,
                             first_name VARCHAR(50),
                             last_name VARCHAR(50),
                             date_of_birth DATE
);



ALTER TABLE sys.student
    ADD user_id INT UNIQUE NOT NULL;


use sys;

-- Inserting a student with ID 1
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (1, 'John', 'Doe', '2000-01-01');

-- Inserting a student with ID 2
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (2, 'Jane', 'Doe', '2002-05-15');

-- Inserting a student with ID 3
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (3, 'Bob', 'Smith', '1999-07-22');

-- Inserting a student with ID 4
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (24, 'Mary', 'Johnson', '2001-09-12');

-- Inserting a student with ID 5
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (5, 'Tom', 'Wilson', '1998-03-28');

-- Inserting a student with ID 6
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (6, 'Samantha', 'Jones', '2003-11-08');

-- Inserting a student with ID 7
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (7, 'Chris', 'Lee', '2002-02-14');

-- Inserting a student with ID 8
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (8, 'Emily', 'Davis', '2000-04-17');

-- Inserting a student with ID 9
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (9, 'David', 'Taylor', '2001-06-30');

-- Inserting a student with ID 10
INSERT INTO student (student_id, first_name, last_name, date_of_birth) VALUES (10, 'Jessica', 'Brown', '1999-10-25');

UPDATE student SET first_name='Naveen' where student_id=11;

delete from student where student_id =6;

select * from student where student_id =6;


commit;

select * from student;



CREATE TABLE sys.marks (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           student_id INT,
                           maths FLOAT,
                           chemistry FLOAT,
                           physics FLOAT,
                           computer_science FLOAT,
                           FOREIGN KEY (student_id) REFERENCES student(student_id)
);
