drop database university;

create database university;

create table personal_info(
	personal_info_id SERIAL NOT NULL  PRIMARY KEY,
	email VARCHAR(100) NOT NULL,
	adress VARCHAR(100) NOT NULL,
	age int,
	telephone_number VARCHAR(100) NOT NULL
);

create table courses(
	courses_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	year INT
);

create table lessons_type(
	lessons_type_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);

create table teacher(
	teacher_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	personal_info int,
	CONSTRAINT FR_personal_info_teacher FOREIGN KEY (personal_info) REFERENCES personal_info (personal_info_id)
);

create table lessons(
	lessons_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	date date,
	time VARCHAR(100),
	teacher INT,
	lessons_type INT,
	class_room int,
	CONSTRAINT FR_lessons_lessons_type_ FOREIGN KEY (lessons_type) REFERENCES lessons_type (lessons_type_id),
	CONSTRAINT FR_teacher_id_lessons FOREIGN KEY (teacher) REFERENCES teacher (teacher_id)
);


create table groups(
	groups_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	courses INT,
	CONSTRAINT FR_groups_course FOREIGN KEY (courses) REFERENCES courses (courses_id)
);

create table groups_lessons(
	groups_lessons_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	groups INT,
	lessons INT,
	CONSTRAINT FR_groups_id_groups_lessons FOREIGN KEY (groups) REFERENCES groups (groups_id),
	CONSTRAINT FR_lessons_id_groups_lessons FOREIGN KEY (lessons) REFERENCES lessons (lessons_id)
);

create table students(
	students_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	groups int,
	personal_info int,
	CONSTRAINT FR_group_id_students FOREIGN KEY (groups) REFERENCES personal_info (personal_info_id),
	CONSTRAINT FR_personal_info_students FOREIGN KEY (personal_info) REFERENCES personal_info (personal_info_id)
);

INSERT INTO personal_info 
(email, adress, age,telephone_number)
VALUES 
('grec@gmail.com','Gurova 12', 30, '+380-94-234-12-12'),
('coconov@gmail.com','Leno 45', 19, '+380-96-234-12-42'),
('grec@gmail.com','Leno 46', 24, '+380-98-262-12-42'),
('lopov@gmail.com','Gurova 11', 19, '+380-95-254-12-12'),
('lecov@gmail.com','Leno 47', 19, '+380-95-284-12-42'),
('mamonov@gmail.com','Leno 47', 20, '+380-95-162-12-42');

INSERT INTO courses 
(year)
VALUES 
(2021),
(2020),
(2019);

INSERT INTO lessons_type 
(name)
VALUES 
('lectures'),
('practice');

INSERT INTO teacher 
(first_name,last_name,personal_info)
VALUES 
('Roman', 'Beregov', 1),
('Dima', 'Flop', 2),
('Misha', 'Smol', 3);

INSERT INTO lessons 
(name,date,time,teacher,lessons_type, class_room)
VALUES 
('Math', '1999-01-08', '08:00:00', 1, 1, 519),
('Physics', '2022-01-10', '09:50:00', 2, 1, 520),
('Physics', '2022-01-10', '11:30:00', 3, 1, 521);

INSERT INTO groups 
(name, courses)
VALUES 
('PCS-20', 1),
('PCR-20', 1),
('PCN-20', 1);



INSERT INTO groups_lessons 
(groups, lessons)
VALUES 
(1,1),
(1,2),
(1,3),
(2,2),
(3,3);


INSERT INTO students 
(first_name, last_name,groups,personal_info)
VALUES 
('Roman', 'Beregov', 1,1),
('Andry', 'Andry', 1,2),
('Bond', 'Bond', 1,3),
('Filip', 'Filip', 1,4),
('Dima', 'Flop', 2,5),
('Misha', 'Smol', 3,6);


select students.last_name, groups.name, lessons.name, lessons.date, lessons.time from students
	JOIN groups ON groups_id = groups
	JOIN groups_lessons ON groups.groups_id = groups_lessons.groups
	JOIN lessons ON groups_lessons.lessons = lessons.lessons_id;
			
			