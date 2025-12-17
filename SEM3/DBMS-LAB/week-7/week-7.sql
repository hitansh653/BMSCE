CREATE DATABASE SUPPLY;
USE SUPPLY;

CREATE TABLE SUPPLIERS (
    sid INT PRIMARY KEY,
    sname VARCHAR(50),
    city VARCHAR(50)
);

CREATE TABLE PARTS (
    pid INT PRIMARY KEY,
    pname VARCHAR(50),
    color VARCHAR(20)
);

CREATE TABLE CATALOG (
    sid INT,
    pid INT,
    cost DECIMAL(10, 2),
    PRIMARY KEY (sid, pid),
    FOREIGN KEY (sid) REFERENCES SUPPLIERS(sid),
    FOREIGN KEY (pid) REFERENCES PARTS(pid)
);


-- Inserting Suppliers
INSERT INTO SUPPLIERS (sid, sname, city) VALUES
(10001, 'Acme Widget', 'Bangalore'),
(10002, 'Johns', 'Kolkata'),
(10003, 'Vimal', 'Mumbai'),
(10004, 'Reliance', 'Delhi');

-- Inserting Parts
INSERT INTO PARTS (pid, pname, color) VALUES
(20001, 'Book', 'Red'),
(20002, 'Pen', 'Red'),
(20003, 'Pencil', 'Green'),
(20004, 'Mobile', 'Green'),
(20005, 'Charger', 'Black');

-- Inserting Catalog Data
INSERT INTO CATALOG (sid, pid, cost) VALUES
(10001, 20001, 10),
(10001, 20002, 10),
(10001, 20003, 30),
(10001, 20004, 10),
(10001, 20005, 10),
(10002, 20001, 10),
(10002, 20002, 20),
(10003, 20003, 30),
(10004, 20003, 40);
SHOW TABLES;
DESC catalog;
DESC parts;
DESC suppliers;
SELECT * FROM catalog;
SELECT * FROM parts;
SELECT * FROM suppliers;

SELECT DISTINCT P.pname
FROM PARTS P
JOIN CATALOG C ON P.pid = C.pid;


SELECT S.sname
FROM SUPPLIERS S
JOIN CATALOG C ON S.sid = C.sid
GROUP BY S.sid, S.sname
HAVING COUNT(DISTINCT C.pid) = (SELECT COUNT(*) FROM PARTS);


SELECT S.sname
FROM SUPPLIERS S
JOIN CATALOG C ON S.sid = C.sid
JOIN PARTS P ON C.pid = P.pid
WHERE P.color = 'Red'
GROUP BY S.sid, S.sname
HAVING COUNT(DISTINCT C.pid) = (SELECT COUNT(*) FROM PARTS WHERE color = 'Red');


SELECT P.pname
FROM PARTS P
JOIN CATALOG C ON P.pid = C.pid
JOIN SUPPLIERS S ON C.sid = S.sid
WHERE S.sname = 'Acme Widget'
AND P.pid NOT IN (
    SELECT C2.pid
    FROM CATALOG C2
    JOIN SUPPLIERS S2 ON C2.sid = S2.sid
    WHERE S2.sname <> 'Acme Widget'
);


SELECT DISTINCT C.sid
FROM CATALOG C
JOIN (
    SELECT pid, AVG(cost) as avg_cost
    FROM CATALOG
    GROUP BY pid
) AS AverageTable ON C.pid = AverageTable.pid
WHERE C.cost > AverageTable.avg_cost;



SELECT P.pname, S.sname, C.cost
FROM PARTS P
JOIN CATALOG C ON P.pid = C.pid
JOIN SUPPLIERS S ON C.sid = S.sid
WHERE C.cost = (
    SELECT MAX(C2.cost)
    FROM CATALOG C2
    WHERE C2.pid = C.pid
);


-- Additional queries
SELECT P.pname, S.sname, C.cost
FROM CATALOG C
JOIN SUPPLIERS S ON C.sid = S.sid
JOIN PARTS P ON C.pid = P.pid
WHERE C.cost = (SELECT MAX(cost) FROM CATALOG);


SELECT sname
FROM SUPPLIERS
WHERE sid NOT IN (
    SELECT C.sid
    FROM CATALOG C
    JOIN PARTS P ON C.pid = P.pid
    WHERE P.color = 'Red'
);


SELECT S.sname, SUM(C.cost) AS total_value
FROM SUPPLIERS S
JOIN CATALOG C ON S.sid = C.sid
GROUP BY S.sid, S.sname;


SELECT S.sname
FROM SUPPLIERS S
JOIN CATALOG C ON S.sid = C.sid
WHERE C.cost < 20
GROUP BY S.sid, S.sname
HAVING COUNT(*) >= 2;


SELECT P.pname, S.sname, C.cost
FROM CATALOG C
JOIN PARTS P ON C.pid = P.pid
JOIN SUPPLIERS S ON C.sid = S.sid
WHERE C.cost = (
    SELECT MIN(C2.cost)
    FROM CATALOG C2
    WHERE C2.pid = C.pid
);


CREATE VIEW Supplier_Part_Counts AS
SELECT S.sname, COUNT(C.pid) AS part_count
FROM SUPPLIERS S
LEFT JOIN CATALOG C ON S.sid = C.sid
GROUP BY S.sid, S.sname;

SELECT * FROM Supplier_Part_Counts;


CREATE VIEW Expensive_Suppliers AS
SELECT P.pname, S.sname, C.cost
FROM CATALOG C
JOIN PARTS P ON C.pid = P.pid
JOIN SUPPLIERS S ON C.sid = S.sid
WHERE C.cost = (
    SELECT MAX(C2.cost)
    FROM CATALOG C2
    WHERE C2.pid = C.pid
);

SELECT * FROM Expensive_Suppliers;


DELIMITER //

CREATE TRIGGER Prevent_Low_Cost
BEFORE INSERT ON CATALOG
FOR EACH ROW
BEGIN
    IF NEW.cost < 1 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Cost cannot be less than 1';
    END IF;
END;
//

DELIMITER ;


DELIMITER //

CREATE TRIGGER Set_Default_Cost
BEFORE INSERT ON CATALOG
FOR EACH ROW
BEGIN
    IF NEW.cost IS NULL THEN
        SET NEW.cost = 10;
    END IF;
END;
//

DELIMITER ;