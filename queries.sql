create database slamz;

use slamz;

create table users (
	id serial primary key,
    name varchar(50) not null,
    email varchar(50) not null,
    password varchar(50) not null,
    unique (name),
    unique (email)
);

create table questions (
	id serial primary key,
    content varchar(200) not null,
    user_id bigint unsigned,
    version int not null,
	foreign key (user_id) references users(id) on delete set null
);

insert into questions (content,user_id,version) values ("What do you like about me?",null,1);
insert into questions (content,user_id,version) values ("When did we first meet?",null,2);
insert into questions (content,user_id,version) values ("Write about a memory or time we spent together?",null,3);


create table answers (
	id serial primary key,
    content varchar(200) not null,
    user_id bigint unsigned,
    ques_id bigint unsigned,
    foreign key (ques_id) references questions(id) on delete cascade,
	foreign key (user_id) references users(id) on delete set null
);

create table invites (
	id serial primary key,
    from_id bigint unsigned not null,
    to_id bigint unsigned not null,
    foreign key (from_id) references users(id) on delete cascade,
	foreign key (to_id) references users(id) on delete cascade
);




