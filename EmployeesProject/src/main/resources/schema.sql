DROP TABLE Employee IF EXISTS;
DROP TABLE Candidate IF EXISTS;
DROP TABLE Position IF EXISTS;


CREATE TABLE Candidate (
  id        int auto_increment, 
  name      varchar(100) NOT NULL, 
  last_name varchar(100) NOT NULL, 
  address   varchar(100), 
  cellphone varchar(30), 
  city_name varchar(100), 
  PRIMARY KEY (id));
CREATE TABLE Employee (
  id       int auto_increment, 
  person   int NOT NULL, 
  position int NOT NULL, 
  salary   numeric(19, 0));
CREATE TABLE Position (
  id   int auto_increment, 
  name varchar(100), 
  PRIMARY KEY (id));
ALTER TABLE Employee ADD CONSTRAINT FKEmployee597609 FOREIGN KEY (position) REFERENCES Position (id);
ALTER TABLE Employee ADD CONSTRAINT FKEmployee937098 FOREIGN KEY (person) REFERENCES Candidate (id);
