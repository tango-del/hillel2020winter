/*------CREATE DATABASE------*/
create database if not exists university;

use university;

/*-------DROP TABLES-------*/
/*
drop table Students;
drop table `Groups`;
drop table Points;
drop table Lessons;
drop table Teachers;
drop table Cathedra;

/*----------------CREATE TABLES WITH PRIMARY KEY----------------*/
create table if not exists Students
(
  students_id int not null auto_increment,
  full_name char(25) not null,
  `group` int not null,
  year_join year not null,
  constraint PK_students primary key (students_id)
);

create table if not exists `Groups`
(
  group_id int not null auto_increment,
  `group` char(10) not null,
  constraint PK_groups primary key (group_id)
);

create table if not exists Points
(
  point_id int not null auto_increment,
  lesson int not null,
  student int not null,
  point int,
  constraint PK_points primary key (point_id)
);

create table if not exists Lessons
(
  lesson_id int not null auto_increment,
  name char(25) not null,
  teacher int not null,
  semester char(25) not null,
  year year,
  constraint PK_lessons primary key (lesson_id)
);

create table if not exists Teachers
(
  teacher_id int not null auto_increment,
  full_name varchar(255) not null,
  cathedra int not null,
  constraint PK_teachers primary key (teacher_id)
);

create table if not exists Cathedra
(
  cathedra_id int not null auto_increment,
  name char(25) not null,
  head_cathedra char(25) not null,
  constraint PK_cathedra primary key (cathedra_id)
);


/*----------------ADD PRIMARY KEY----------------*/
# alter table Cathedra add constraint PK_cathedra primary key (cathedra_id);
#
# alter table Teachers add constraint PK_teachers primary key (teacher_id);
#
# alter table Lessons add constraint PK_lessons primary key (lesson_id);
#
# alter table Points add constraint PK_points primary key (point_id);
#
# alter table Students add constraint PK_students primary key (students_id);
#
# alter table `Groups` add constraint PK_groups primary key (group_id);


/*----------------FOREIGN KEY----------------*/
alter table Teachers add constraint FK_cathedra foreign key (cathedra) references Cathedra (cathedra_id);

alter table Lessons add constraint FK_teacher foreign key (teacher) references Teachers (teacher_id);

alter table Points add constraint FK_lesson foreign key (lesson) references Lessons (lesson_id);

alter table Points add constraint FK_student foreign key (student) references Students (students_id);

alter table Students add constraint FK_group foreign key (`group`) references `Groups` (group_id);


/*
alter table `groups` modify `group` char(10) not null;
alter table students modify full_name char(25) not null;
alter table cathedra modify name char(25) not null, modify head_cathedra char(25) not null;
alter table lessons modify name char(25) not null, modify semester char(25) not null;
*/

/*--------insert value in `groups`--------*/
insert into `groups` (`group`) value ('1a');
insert into `groups` (`group`) value ('1b');
insert into `groups` (`group`) value ('1c');
insert into `groups` (`group`) value ('2a');
insert into `groups` (`group`) value ('2b');
insert into `groups` (`group`) value ('2c');
insert into `groups` (`group`) value ('3a');
insert into `groups` (`group`) value ('3b');
insert into `groups` (`group`) value ('3c');
insert into `groups` (`group`) value ('4a');
insert into `groups` (`group`) value ('4b');
insert into `groups` (`group`) value ('4c');

/*--------insert value in students--------*/
insert into students (full_name, `group`, year_join) values ('Suzanne Baudinelli', 2, 1992);
insert into students (full_name, `group`, year_join) values ('Gwendolen Upcraft', 4, 1985);
insert into students (full_name, `group`, year_join) values ('Violette Weekley', 7, 2006);
insert into students (full_name, `group`, year_join) values ('Melli Ashplant', 3, 1995);
insert into students (full_name, `group`, year_join) values ('Ansel Wickmann', 5, 2000);
insert into students (full_name, `group`, year_join) values ('Gallard Pagram', 12, 2010);
insert into students (full_name, `group`, year_join) values ('Thorny McIlvaney', 2, 1999);
insert into students (full_name, `group`, year_join) values ('Carmelle Goodee', 7, 2011);
insert into students (full_name, `group`, year_join) values ('Marabel Sissland', 11, 2008);
insert into students (full_name, `group`, year_join) values ('Magdalen Coom', 7, 1994);
insert into students (full_name, `group`, year_join) values ('Kenton Udden', 6, 1993);
insert into students (full_name, `group`, year_join) values ('Morgen Suerz', 10, 2000);
insert into students (full_name, `group`, year_join) values ('Issie Francesconi', 1, 2004);
insert into students (full_name, `group`, year_join) values ('Drusilla Prozescky', 12, 1997);
insert into students (full_name, `group`, year_join) values ('Morrie Castilljo', 7, 2007);
insert into students (full_name, `group`, year_join) values ('Raynard Adamini', 6, 2009);
insert into students (full_name, `group`, year_join) values ('Eada Olle', 5, 1992);
insert into students (full_name, `group`, year_join) values ('Kile Lunn', 6, 1992);
insert into students (full_name, `group`, year_join) values ('Andros Joddens', 12, 1997);
insert into students (full_name, `group`, year_join) values ('Gardiner Rowet', 10, 1993);

/*--------insert value in cathedra--------*/
insert into Cathedra (name, head_cathedra) values ('Hovnanian Enterprises Inc', 'Waneta Dilland');
insert into Cathedra (name, head_cathedra) values ('Chantic Holdin, Inc.', 'Nobe Solly');
insert into Cathedra (name, head_cathedra) values ('Qwest Corporation', 'Darbee Simner');
insert into Cathedra (name, head_cathedra) values ('Tyson Foods, Inc.', 'Gerhardt Vines');
insert into Cathedra (name, head_cathedra) values ('China Corporation', 'Brannon Voss');
insert into Cathedra (name, head_cathedra) values ('Perrigo Company', 'Sherrie Pickaver');
insert into Cathedra (name, head_cathedra) values ('Hemisphere Group, Inc.', 'Hanni Swalowe');

/*--------insert value in teachers--------*/
insert into teachers (full_name, cathedra) values ('Brandea Tootell', 5);
insert into teachers (full_name, cathedra) values ('Evita Duddan', 2);
insert into teachers (full_name, cathedra) values ('Henri Avarne', 2);
insert into teachers (full_name, cathedra) values ('Marlyn Douse', 1);
insert into teachers (full_name, cathedra) values ('Hildy Ert', 4);
insert into teachers (full_name, cathedra) values ('Humfrid Weavill', 1);
insert into teachers (full_name, cathedra) values ('Clarance Tynan', 1);
insert into teachers (full_name, cathedra) values ('Patrica Extence', 5);
insert into teachers (full_name, cathedra) values ('Pearle Forgie', 6);
insert into teachers (full_name, cathedra) values ('Aundrea Zaniolo', 3);

/*--------insert value in lessons--------*/
insert into lessons (name, teacher, semester, year) values ('Intellij Idea', 1, 'spring', 2020);
insert into lessons (name, teacher, semester, year) values ('Collections', 10, 'autumn', 2020);
insert into lessons (name, teacher, semester, year) values ('Java Core', 2, 'spring', 2020);
insert into lessons (name, teacher, semester, year) values ('English', 9, 'spring', 2019);
insert into lessons (name, teacher, semester, year) values ('Linux Administrative', 2, 'autumn', 2021);
insert into lessons (name, teacher, semester, year) values ('JavaScript', 10, 'spring', 2019);
insert into lessons (name, teacher, semester, year) values ('REST', 7, 'autumn', 2019);
insert into lessons (name, teacher, semester, year) values ('VCS', 8, 'autumn', 2019);
insert into lessons (name, teacher, semester, year) values ('Stream API', 4, 'autumn', 2020);
insert into lessons (name, teacher, semester, year) values ('Threads', 7, 'spring', 2021);
insert into lessons (name, teacher, semester, year) values ('Vector Illustration', 10, 'autumn', 2020);
insert into lessons (name, teacher, semester, year) values ('Equity Research', 7, 'spring', 2020);
insert into lessons (name, teacher, semester, year) values ('SQL', 8, 'spring', 2021);
insert into lessons (name, teacher, semester, year) values ('MAP', 7, 'autumn', 2021);
insert into lessons (name, teacher, semester, year) values ('Philosophy', 8, 'autumn', 2021);

/*--------insert value in points--------*/
insert into points (lesson, student, point) values (11, 8, 17);
insert into points (lesson, student, point) values (8, 18, 87);
insert into points (lesson, student, point) values (15, 6, 94);
insert into points (lesson, student, point) values (7, 4, 18);
insert into points (lesson, student, point) values (10, 13, 95);
insert into points (lesson, student, point) values (15, 11, 74);
insert into points (lesson, student, point) values (11, 11, 64);
insert into points (lesson, student, point) values (4, 3, 86);
insert into points (lesson, student, point) values (7, 9, 59);
insert into points (lesson, student, point) values (4, 6, 32);
insert into points (lesson, student, point) values (2, 18, 13);
insert into points (lesson, student, point) values (6, 10, 62);
insert into points (lesson, student, point) values (12, 13, 49);
insert into points (lesson, student, point) values (15, 5, 16);
insert into points (lesson, student, point) values (14, 4, 63);
insert into points (lesson, student, point) values (6, 8, 34);
insert into points (lesson, student, point) values (7, 4, 96);
insert into points (lesson, student, point) values (13, 13, 62);
insert into points (lesson, student, point) values (8, 10, 55);
insert into points (lesson, student, point) values (11, 9, 96);
insert into points (lesson, student, point) values (12, 15, 12);
insert into points (lesson, student, point) values (2, 13, 71);
insert into points (lesson, student, point) values (5, 6, 23);
insert into points (lesson, student, point) values (8, 20, 50);
insert into points (lesson, student, point) values (15, 13, 91);
insert into points (lesson, student, point) values (6, 2, 24);
insert into points (lesson, student, point) values (3, 13, 36);
insert into points (lesson, student, point) values (8, 8, 78);
insert into points (lesson, student, point) values (12, 11, 30);
insert into points (lesson, student, point) values (8, 19, 96);
insert into points (lesson, student, point) values (2, 14, 70);
insert into points (lesson, student, point) values (12, 10, 96);
insert into points (lesson, student, point) values (3, 12, 89);
insert into points (lesson, student, point) values (3, 14, 39);
insert into points (lesson, student, point) values (13, 13, 58);
insert into points (lesson, student, point) values (2, 9, 83);
insert into points (lesson, student, point) values (6, 10, 12);
insert into points (lesson, student, point) values (6, 4, 61);
insert into points (lesson, student, point) values (1, 4, 50);
insert into points (lesson, student, point) values (8, 5, 22);
