
# create DB
DROP DATABASE IF EXISTS jmmStartDemo;
CREATE DATABASE jmmStartDemo;

# use DB
USE jmmStartDemo;

# create user_info_table
DROP TABLE IF EXISTS  users;
CREATE TABLE  users (
    id int not null primary key AUTO_INCREMENT,
    name varchar(100) not null,
    gender varchar(6) not null
);

# insert some user information into table
INSERT INTO users(name, gender) VALUES( 'Bulma', 'female');
INSERT INTO users(name, gender) VALUES( 'Vegeta', 'male');
INSERT INTO users(name, gender) VALUES( 'ChiChi', 'female');
INSERT INTO users(name, gender) VALUES( 'Goku', 'male');

# show all user information from users
SELECT * FROM jmmStartDemo.users;