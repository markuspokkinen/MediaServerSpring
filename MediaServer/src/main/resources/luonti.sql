create table Users(
ID integer not null auto_increment,
username varchar(255),
password varchar(255),
primary key(ID)
)
create table Profiles(
ID integer not null auto_increment,
Ueser_ID integer not null auto_increment,
profileName varchar(255),


primary key(ID)
)