# create student profile 
create table student_profile
(
	id int not null auto_increment,
    hobby varchar(30),
    fav_sport varchar(30),
    primary key(id)
);



# create student
create table student
(
	id int not null auto_increment,
    name varchar(30),
    gender varchar(10),
    grade varchar(10),
    email varchar(40),
    student_profile_id int,
    primary key(id),
    key `FK_STUDENT_PROFILE_IDX` (student_profile_id),
    constraint `FK_STUDENT_PROFILE` foreign key (student_profile_id) references student_profile (id) on delete no action
    on update no action    
);

# create book
create table book
(
    id int not null auto_increment,
    subject_name varchar(20),
    edition int(4),
    student_id int,
    primary key(id),
    key `FK_STUDENT_BOOK_IDX` (student_id),
    constraint `FK_STUDENT` foreign key (student_id) references student (id) on delete no action on update no action
);

# create course
create table course
(
    id int not null auto_increment,
    course_name varchar(30),
    duration_weeks int,
    primary key(id)
);

# create student_course
create table student_course
(
    `course_id` int(11) not null,
    `student_id` int(11) not null,
     primary key (`course_id`,`student_id`),

     constraint `FK_COURSE_05` foreign key (`course_id`)
     references `course` (`id`)
     on delete no action on update no action,

     constraint `FK_STUDENT` foreign key (`student_id`)
     references `student` (`id`)
     on delete no action on update no action
)