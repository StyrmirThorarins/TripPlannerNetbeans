PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;

DROP TABLE if exists Booking;
DROP TABLE if exists Trip;
DROP TABLE if exists TourCompany;
DROP TABLE if exists Customer;
DROP TABLE if exists Type;
DROP TABLE if exists Area;

CREATE TABLE TourCompany (
  id INTEGER PRIMARY KEY,
  name varchar(50),
  phone int,
  address varchar(50),
  email varchar(50)
);

INSERT INTO "TourCompany" VALUES(1,'Hallóferðir',236346,'Sæmnundargata 25','asdf@adsf.com');
INSERT INTO "TourCompany" VALUES(2,'Bæjóferðir',2364364346,'Suðurgata 125','asdf3546@adsf.com');
INSERT INTO "TourCompany" VALUES(3,'Háskólaferðir',23631111146,'Hjarðarhagi 625','asdf5743s@adsf.com');

CREATE TABLE Area (
  name varchar(50) PRIMARY KEY
);

INSERT INTO "Area" VALUES("Capital area");
INSERT INTO "Area" VALUES("Eastern region");
INSERT INTO "Area" VALUES("Western region");
INSERT INTO "Area" VALUES("Northern region");
INSERT INTO "Area" VALUES("Southern region");
INSERT INTO "Area" VALUES("Highlands of Iceland");

CREATE TABLE Type (
  name varchar(50) PRIMARY KEY
);

INSERT INTO Type VALUES("Golden Circle");
INSERT INTO Type VALUES("Horse Trips");
INSERT INTO Type VALUES("Volcano");
INSERT INTO Type VALUES("Glaciers");
INSERT INTO Type VALUES("Beer Trips");
INSERT INTO Type VALUES("Food Trips");

CREATE TABLE Trip (
  id INTEGER PRIMARY KEY,
  name varchar(50),
  date DATE,
  startTime TIME,
  endTime TIME,
  description varchar(200),
  familyFriendly int,
  accessible int,
  price int,
  typeName varchar(50) REFERENCES Type(name),
  area varchar(50) REFERENCES area(name),
  maxTravelers int,
  availablePlaces int,
  tourCompanyId int REFERENCES TourCompany(id)
);

INSERT INTO "Trip" VALUES(1,'Hestaferðin','2017-06-22','10:00','13:00','Skemmtileg hestaferð',0,0,15000,"Horse Trips","Southern region",10,10,1);
INSERT INTO "Trip" VALUES(2,'Bjórferðin','2017-06-22','11:00','14:00','Skemmtileg bjórferð',0,0,25000,"Beer Trips","Southern region",12,12,2);
INSERT INTO "Trip" VALUES(3,'Eldfjallaferðin','2017-06-22','12:00','15:00','Skemmtileg eldfjallaferð',0,0,29990,"Volcano","Southern region",5,5,3);
INSERT INTO "Trip" VALUES(4,'Jöklaferðin','2017-06-22','13:00','16:00','Skemmtileg jöklferð',0,0,19990,"Glaciers","Southern region",10,10,1);
INSERT INTO "Trip" VALUES(5,'Matarferðin','2017-06-22','14:00','17:00','Skemmtileg matarferð',0,0,10000,"Food Trips","Southern region",15,15,2);
INSERT INTO "Trip" VALUES(6,'Gullni Hringurinn','2017-06-22','15:00','18:00','Skemmtileg fjölskylduferð',1,0,35000,"Golden Circle","Southern region",20,20,3);

CREATE TABLE Customer (
  id INTEGER PRIMARY KEY,
  name varchar(50),
  phone int,
  address varchar(50),
  email varchar(50)
);

CREATE TABLE Booking (
  id INTEGER PRIMARY KEY,
  customerId int REFERENCES Customer(id),
  tripId int REFERENCES Trip(id),
  numTravelers int,
  hotelPickup int,
  active int
);

COMMIT;
