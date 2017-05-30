DROP DATABASE COMP31A3;

CREATE DATABASE COMP31A3;

USE COMP31A3;

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
    eventDay DATE,
    eventMonth DATE
);

CREATE TABLE schedule (
    scheduleId INT AUTO_INCREMENT PRIMARY KEY,
    employeeName VARCHAR(25),
    startTime TIME,
    endTime TIME,
    scheduledDay DATE,
    scheduledMonth DATE,
    eventId INT
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

