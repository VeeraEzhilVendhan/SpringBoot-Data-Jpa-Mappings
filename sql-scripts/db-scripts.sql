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
)

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
)