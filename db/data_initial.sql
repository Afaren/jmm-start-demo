
# create DB
drop database if exists jmmStartDemo;
CREATE DATABASE jmmStartDemo;

# use DB
use jmmStartDemo;

# create user_info_table
drop table if exists users;
create table users (
    id int not null primary key AUTO_INCREMENT,
    name varchar(100) not null,
    gender varchar(6) not null
);

# insert some user information into table
INSERT INTO users(name, gender) VALUES( 'Bulma', 'female');
INSERT INTO users(name, gender) VALUES( 'Vegeta', 'male');
INSERT INTO users(name, gender) VALUES( 'ChiChi', 'female');
INSERT INTO users(name, gender) VALUES( 'Goku', 'male');
