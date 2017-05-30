DROP DATABASE COMP31A2;

CREATE DATABASE COMP31A2;

USE COMP31A2;

CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    loginName VARCHAR(25),
    password VARCHAR(25)
);

CREATE TABLE employee (
    employeeId INT AUTO_INCREMENT PRIMARY KEY,
    employeeName VARCHAR(25)
);

CREATE TABLE equipment (
    equipmentId INT AUTO_INCREMENT PRIMARY KEY,
    equipmentName VARCHAR(25)
);

CREATE TABLE locations (
    locationsId INT AUTO_INCREMENT PRIMARY KEY,
    locationName VARCHAR(25)
);

CREATE TABLE events (
    eventId INT AUTO_INCREMENT PRIMARY KEY,
    eventName VARCHAR(25),
    eventStartTime TIME,
    eventEndTime TIME,
    location VARCHAR(25),
    equipment VARCHAR(25),
    eventDay DATE
);

CREATE TABLE schedule (
    scheduleId INT AUTO_INCREMENT PRIMARY KEY,
    employeeName VARCHAR(25),
    startTime TIME,
    endTime TIME,
    scheduledDay VARCHAR(25),
    eventId INT,
    FOREIGN KEY (eventId) REFERENCES events (eventId)
);

INSERT INTO employee VALUES 
(NULL,"Real Ortelli"),
(NULL,"Mike Oag"),
(NULL,"Graham Berry"),
(NULL,"Skyler IrishMan");

INSERT INTO equipment VALUES
(NULL, "Tractor"),
(NULL, "Fences"),
(NULL, "Speakers"),
(NULL, "Tables"),
(NULL, "Generator");

INSERT INTO locations VALUES
(NULL, "Site A"),
(NULL, "Site B"),
(NULL, "Site C"),
(NULL, "Site D"),
(NULL, "Site E");

INSERT INTO users VALUES
(NULL, "manager", "pwd1"),
(NULL, "event planner", "pwd2");

INSERT INTO events VALUES
(NULL, "Super Fun", "01:45", "02:45", "Site B", "Tractor", "1970-01-27"),
(NULL, "Awesome Fun", "02:45", "03:45", "Site C", "Fences", "1970-01-12");

INSERT INTO schedule VALUES
(NULL, "Mike Oag", "11:30", "12:30", "12", NULL),
(NULL, "Real Ortelli", "10:30", "12:30", "23", NULL);
