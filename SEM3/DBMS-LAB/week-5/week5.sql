CREATE TABLE incentives(
	employee_number INT,
    incentive_date DATE PRIMARY KEY,
    incentive_amount DECIMAL(12,2),
	FOREIGN KEY (employee_number) REFERENCES employee(employee_number)
);
CREATE TABLE assigned_to(
	employee_number INT,
    p_no INT,
    job_role VARCHAR(50),
    FOREIGN KEY (employee_number) REFERENCES employee(employee_number),
    FOREIGN KEY (p_no) REFERENCES project(p_no)
);
CREATE TABLE project(
	p_no INT PRIMARY KEY,
    p_loc VARCHAR(50),
    p_name VARCHAR(50)
);
CREATE TABLE employee(
	employee_number INT PRIMARY KEY,
    employee_name VARCHAR(50),
    manager_no INT,
    hire_date DATE,
    salary DECIMAL(12,2),
    dept_no INT,
    FOREIGN KEY (dept_no) REFERENCES department(dept_no)
);
CREATE TABLE department(
	dept_no INT PRIMARY KEY,
    dept_name VARCHAR(50),
    dept_loc VARCHAR(50)
);

desc employee;
desc department;
desc project;
desc assigned_to;
desc incentives;

-- Insert data into DEPT
INSERT INTO department VALUES
(10, 'Sales', 'Bengaluru'),
(20, 'Engineering', 'Hyderabad'),
(30, 'HR', 'Mumbai'),
(40, 'Support', 'Mysuru'),
(50, 'Marketing', 'Delhi'),
(60, 'R&D', 'Bengaluru');
-- Insert data into EMPLOYEE
INSERT INTO employee VALUES
(101, 'Anil Kumar', NULL, '2020-01-10', 80000, 20),
(102, 'Bhavna Singh', 101, '2020-05-15', 75000, 20),
(103, 'Chris Pinto', 101, '2021-03-01', 70000, 10),
(104, 'Diana Dsouza', 103, '2021-07-22', 50000, 10),
(105, 'Eve Francis', 101, '2022-02-11', 90000, 60),
(106, 'Frank Martin', 105, '2022-08-30', 85000, 60),
(107, 'Grace Thomas', 101, '2023-01-05', 45000, 30),
(108, 'Hari Sharma', 101, '2023-05-12', 65000, 40);
-- Insert data into PROJECT
INSERT INTO project VALUES
(1001, 'Bengaluru', 'Project Alpha'),
(1002, 'Hyderabad', 'Project Beta'),
(1003, 'Mysuru', 'Project Gamma'),
(1004, 'Mumbai', 'Project Delta'),
(1005, 'Delhi', 'Project Epsilon'),
(1006, 'Bengaluru', 'Project Zeta');
-- Insert data into ASSIGNED_TO
INSERT INTO assigned_to VALUES
(101, 1002, 'Manager'),
(102, 1002, 'Developer'),
(103, 1001, 'Sales Lead'),
(104, 1004, 'Sales Rep'),
(105, 1006, 'Lead Scientist'),
(106, 1006, 'Scientist'),
(108, 1003, 'Support Eng');
-- Insert data into INCENTIVES
INSERT INTO incentives VALUES
(101, '2025-01-15', 5000),
(103, '2025-02-01', 3000),
(105, '2025-01-20', 6000),
(108, '2025-03-10', 2500);
SELECT * FROM department;
SELECT * FROM project;
SELECT * FROM assigned_to;
SELECT * FROM incentives;
SELECT * FROM employee;


SELECT DISTINCT T1.employee_number
FROM assigned_to T1
JOIN project T2 ON T1.p_no = T2.p_no
WHERE T2.p_loc IN ('Bengaluru', 'Hyderabad', 'Mysuru');
SELECT E.EMPNO
FROM EMPLOYEE E
LEFT JOIN INCENTIVES I ON E.EMPNO = I.EMPNO
WHERE I.EMPNO IS NULL;

SELECT
    E.employee_name,
    E.employee_number,
    D.dept_name,
    A.job_role,
    D.dept_loc AS Department_Location,
    P.p_loc AS Project_Location
FROM employee E
JOIN department D ON E.dept_no = D.dept_no
JOIN assigned_to A ON E.employee_number = A.employee_number
JOIN project P ON A.p_no = P.p_no
WHERE D.dept_loc = P.p_loc;