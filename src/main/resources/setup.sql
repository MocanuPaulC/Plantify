DROP TABLE IF EXISTS DetailsArchive;
DROP TABLE IF EXISTS Details;
DROP TABLE IF EXISTS Plant;
DROP TABLE IF EXISTS Arduino;
DROP TABLE IF EXISTS Client;

CREATE TABLE Client
(
    email    VARCHAR(30) NOT NULL
        PRIMARY KEY,
    password VARCHAR(30) NOT NULL
);

CREATE TABLE Arduino
(
--     dummyId int GENERATED ALWAYS AS IDENTITY
--         PRIMARY KEY,
    physicalIdentifier INT         NOT NULL UNIQUE  PRIMARY KEY ,
    series             VARCHAR(30) NOT NULL,
    ledSetting         BOOLEAN     NOT NULL,
    redCode            SMALLINT    NOT NULL,
    greenCode          SMALLINT    NOT NULL,
    blueCode           SMALLINT    NOT NULL
);



CREATE TABLE Plant
(
    plantID                   INT         NOT NULL
        GENERATED ALWAYS AS IDENTITY
        PRIMARY KEY,
    userEmail                 VARCHAR(30) NOT NULL
        CONSTRAINT fk_userEmail REFERENCES Client (email)
            ON DELETE CASCADE,
    plantName                 VARCHAR(30) NOT NULL,
    plantType                 VARCHAR(30) NOT NULL,
    dateAdded                 TIMESTAMP   NOT NULL
        DEFAULT CURRENT_TIMESTAMP,
    arduinoPhysicalIdentifier INT UNIQUE
        CONSTRAINT fk_arduinoPhysicalIdentifier REFERENCES arduino (physicalIdentifier)
        ON DELETE SET NULL
);

CREATE TABLE Details
(
    ID          INT         NOT NULL
        GENERATED ALWAYS AS IDENTITY
        PRIMARY KEY,
    plantID     INT         NOT NULL
        CONSTRAINT fk_plantID REFERENCES Plant (plantID)
            ON DELETE CASCADE,
    temperature NUMERIC(10) NOT NULL,
    humidity    NUMERIC(10) NOT NULL,
    moisture    NUMERIC(10) NOT NULL,
    light       NUMERIC(10) NOT NULL,
    refreshTime TIMESTAMP   NOT NULL
        DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE DetailsArchive
(
    ID                 INT         NOT NULL
        GENERATED ALWAYS AS IDENTITY
        PRIMARY KEY,
    plantID            INT         NOT NULL
        CONSTRAINT fk_plantID REFERENCES Plant (plantID)
            ON DELETE CASCADE,
    temperatureAvg     NUMERIC(10) NOT NULL,
    humidityAvg        NUMERIC(10) NOT NULL,
    moistureAvg        NUMERIC(10) NOT NULL,
    lightAvg           NUMERIC(10) NOT NULL,
    refreshTime        TIMESTAMP   NOT NULL
        DEFAULT CURRENT_TIMESTAMP,
    minimumTemperature numeric(10) NOT NULL,
    maximumTemperature numeric(10) NOT NULL,
    minimumHumidity    numeric(10) NOT NULL,
    maximumHumidity    numeric(10) NOT NULL,
    minimumMoisture    numeric(10) NOT NULL,
    maximumMoisture    numeric(10) NOT NULL,
    minimumLight       numeric(10) NOT NULL,
    maximumLight       numeric(10) NOT NULL,
    totalRowsArchived  numeric(10) NOT NULL
);



-- rows for db

INSERT INTO public.client (email, password) VALUES ('fake@email.com', '12345');
INSERT INTO public.client (email, password) VALUES ('fake2@email.com', '12345');

INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (101, 'xx', false, 0, 0, 0);

INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (102, 'xx', true, 11, 22, 33);
INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (103, 'xx', false, 0, 0, 0);

INSERT INTO public.arduino (physicalidentifier, series, ledsetting, redcode, greencode, bluecode)
VALUES (104, 'xx', true, 11, 22, 33);

INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake@email.com', 'planty', 'PLAIN', '2022-12-01 20:03:45.000000', 101);

INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake@email.com', 'plantos', 'PLAIN', '2022-12-01 20:04:00.000000', 102);
INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake2@email.com', 'planty2', 'PLAIN', '2022-12-01 20:03:45.000000', 103);

INSERT INTO public.plant (useremail, plantname, planttype, dateadded, arduinophysicalidentifier)
VALUES ('fake2@email.com', 'plantos2', 'PLAIN', '2022-12-01 20:04:00.000000', 104);


-- DELETE FROM arduino WHERE physicalIdentifier=101;


