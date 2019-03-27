CREATE SCHEMA Car;

CREATE DATABASE CarDB;

USE CarDB;

CREATE TABLE Car(
  Id INT NOT NULL AUTO_INCREMENT,
  Make VARCHAR(30) NOT NULL,
  Model VARCHAR(30) NOT NULL,
  Year YEAR(4),
  Color VARCHAR(30),
  VIN VARCHAR(17),
  PRIMARY KEY (Id)
);

INSERT INTO Car (Make, Model, Year, Color, VIN)
VALUES ("Toyota","Camry",2002,"White","3039AB5629RF40292");

INSERT INTO Car (Make, Model, Year, Color, VIN)
VALUES ("Honda","Civic",2017,"Grey","345879FHI54WHDH29");

INSERT INTO Car (Make, Model, Year, Color, VIN)
VALUES ("Jetta","Volkswagon",2005,"Silver","B3323480HGU49G0H6");

INSERT INTO Car (Make, Model, Year, Color, VIN)
VALUES ("Audi","A3",2017,"Gold","TH34389HEO47EUE48");

INSERT INTO Car (Make, Model, Year, Color, VIN)
VALUES ("Ford","Taurus",2013,"Black","FIIH45202DFJDKW38");