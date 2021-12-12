CREATE TABLE IF NOT EXISTS szovegek(
    azonosito VARCHAR (150) PRIMARY KEY,
    szoveg VARCHAR (1000) NOT NULL,
    jelszo VARCHAR (100) NOT NULL,
    kulcs VARCHAR (max) NOT NULL
);