CREATE DATABASE SQL_Practice;
################################## Create Employee Table ######################
create table Employee
(
empID INT AUTO_INCREMENT,
empFname varchar(20),
empLname varchar(20),
department varchar(20),
salary double,
genger varchar(10),
PRIMARY KEY (empID)
);

################################## Create Position Table ######################
create table Position
(
empID INT NOT NULL,
position varchar(20),
bonas double,
joiningDate DATE,
 FOREIGN KEY (empID) REFERENCES Employee(empID)
);

################################# Inser Data into Employee #######################
INSERT INTO Employee (empFname,empLname,department,salary,genger) 
values("Jhon", "Smith", "HR", 5000.00,"M");

INSERT INTO Employee (empFname,empLname,department,salary,genger) 
values("Elsa", "Ferdinand", "Admin", 8000.00,"F");

INSERT INTO Employee (empFname,empLname,department,salary,genger) 
values("Ronaldo", "Guzman", "Account", 3000.00,"M");

INSERT INTO Employee (empFname,empLname,department,salary,genger) 
values("Suzan", "Alex", "HR", 7000.00,"F");

INSERT INTO Employee (empFname,empLname,department,salary,genger) 
values("Sajin", "Guzman", "Security", 10000.00,"M");

INSERT INTO Employee (empFname,empLname,department,salary,genger) 
values("Rodrigoz", "Garcia", "Engineer", 10000.00,"M");

INSERT INTO Employee (empFname,empLname,department,salary,genger) 
values("Sashi", "Martinez", "HR", 5000.00,"M");

################################# Inser Data into Position #######################

INSERT INTO Position (empID,position,bonas,joiningDate) 
values(1,"MANAGER",1000.00,"2000-01-01");

INSERT INTO Position (empID,position,bonas,joiningDate) 
values(2,"EXCUTIVE",2000.00,"2010-01-01");

INSERT INTO Position (empID,position,bonas,joiningDate) 
values(3,"LEAD",1500.00,"2016-02-01");

INSERT INTO Position (empID,position,bonas,joiningDate) 
values(4,"MANAGER",1000.00,"2001-08-01");

INSERT INTO Position (empID,position,bonas,joiningDate) 
values(5,"SUPER VISER",150.00,"2008-08-01");

INSERT INTO Position (empID,position,bonas,joiningDate)  
values(6,"TEAM LEAD",600.00,"2012-02-09");

INSERT INTO Position (empID,position,bonas,joiningDate)  
values(7,"TEAM LEAD",600.00,"2012-05-06");

INSERT INTO Position (empID,position,bonas,joiningDate) 
values(8,"TEAM LEAD",600.00,"2012-03-03");

################################# View, Drop, Check Data #######################
-- To view records inside the table
SELECT * FROM Employee;
SELECT * FROM Position;
-- To Delete table 
DROP TABLE Employee;
DROP TABLE Position;
-- To Delete All recods inside the table. 
TRUNCATE TABLE Employee; 
TRUNCATE TABLE Position; 

################################# Query Problems #######################
-- Q1, Query empFname in upper Case and use alias nbame as Emplpyee Name.
SELECT UPPER(empFname) AS 'Employee Name'
From Employee;

-- Q2, Query number of Employee working in HR?
SELECT COUNT(empFname)
From Employee
WHERE DEPARTMENT = 'HR';

-- Q3, Query current date?
SELECT CURDATE();

-- 4, Query all Employee whose salary is between 5000 to 10000
SELECT * 
FROM Employee
WHERE salary BETWEEN 5000.00 AND 10000.00;

-- Q5, Query name of Employee that begin with 'S'
SELECT *
FROM Employee
WHERE empFname LIKE 'S%';

-- Q6, Query 2 Employee with salary greater than 7000.00.
SELECT *
FROM Employee
WHERE salary > 7000.00
LIMIT 2;

-- Q7, Query All Employees with top salary?
SELECT *
FROM Employee
WHERE Salary = (SELECT MAX(Salary) 
				FROM Employee);

-- Q8, Query Employee with 2 top salary?
 SELECT *
 FROM Employee 
 ORDER BY Salary DESC LIMIT 2;

-- Q9, Query Employee first and last name separated by space as full name?
SELECT  CONCAT(empFname, ' ' , empLname) AS 'Full Name' 
FROM Employee;

-- Q10, Query all Employee ordered by last name decendently?
SELECT *
FROM Employee
ORDER BY empLname DESC;

-- Q11, Query all Employee except Sajin and Rodrigoz?
SELECT *
FROM Employee
WHERE empFname NOT IN ('Sajin', 'Rodrigoz');

 -- Alternating way
SELECT *
FROM Employee
WHERE empFname != 'Sajin' 'Rodrigoz';

-- Q12, Write a query to fetch all Employees who also hold the managerial position.
-- Solution using JOIN statement 
SELECT * 
FROM Employee e , Position p
WHERE e.empID = p.empID AND p.position = 'MANAGER';
 
  -- Alternating way using INNER JOIN, AND, & IN
 SELECT *
 FROM Employee e
 INNER JOIN Position p
 ON e.empID = p.empID AND p.position IN ('MANAGER');

 -- Alternating way using INNER JOIN & WHERE
 SELECT *
 FROM Employee e
 INNER JOIN Position p
 ON e.empID = p.empID
 WHERE p.posItion = 'MANAGER';

 -- Q13, Write a query to retrieve employee details from Employee table who have a date of joining in the Postion table.
    -- Solution using JOIN & EXISTS
   SELECT *
   FROM Employee e, Position p 
   WHERE EXISTS( SELECT * FROM Position WHERE e.empID = p.empID);
   
    -- Alternating way using JOIN
   SELECT *
   FROM Employee e, Position p 
   WHERE e.empID = p.empID;

-- Q14, Write a query to retrieve two maximum bonas from the Position table.
-- Solution using colerated query 
  SELECT DISTINCT bonas FROM Position p
  WHERE 2 >= (SELECT COUNT(DISTINCT bonas)
				FROM Position p1 
				WHERE p1.bonas >= p.bonas) ORDER BY p.bonas DESC;
                
-- Q15, Write a query to retrieve two maximum bonas from the Position table.
-- Solution using colerated query 
  SELECT DISTINCT bonas FROM Position p
  WHERE 2 >= (SELECT COUNT(DISTINCT bonas)
				FROM Position p1 
				WHERE p1.bonas <= p.bonas) ORDER BY p.bonas DESC;     
                
-- Q16, Write a query to find the 3rd highest salary from the table without using TOP/limit keyword.
	SELECT DISTINCT salary FROM Employee e
	WHERE 2 = (SELECT COUNT(DISTINCT salary)
				FROM Employee e1
				WHERE e1.salary > e.salary);
 
-- Q17, Write a query to retrieve duplicate records from a table.
	SELECT empID, position, COUNT(*) 
	FROM Position 
    GROUP BY empID, position, bonas
	HAVING COUNT(*) > 1;

-- Q18,Write a query to retrieve the list of employees working in the same department.
SELECT DISTINCT e.empID, e.empFname, e.department 
FROM Employee e, Employee e1
WHERE e.department = e1.Department AND e.empID != e1.empID
ORDER BY department;

-- Alternating way using IN
SELECT empID, empFname,department 
FROM Employee
WHERE department IN (SELECT department
					 FROM Employee
					 GROUP BY department
					 HAVING COUNT(*) > 1);

-- Order Position 
-- With non duplicate ID 
-- Q19, Write a query to retrieve the last 3 records from the EmployeeInfo table(No duplicate ID)
(SELECT * 
FROM Position 
ORDER BY empID DESC 
LIMIT 3)
ORDER BY empID ASC;

-- Alternating way using count which return single number   
SELECT * 
FROM Employee
WHERE empID > (SELECT COUNT(*) FROM Employee) - 3;

			-- Common Solution Works for Many Problems --
-- Max & Min With dublicate value
-- Q20, Write a query to find the third-highest salary from the Employee table.
-- Solution using Limit & offset. It works for duplicate bonas
-- If the second statment return multiple value, it can't be assigned to boass with WHERE claus
SELECT *
FROM Position
WHERE bonas = (SELECT DISTINCT bonas
			   FROM Position
			   ORDER BY bonas DESC
			   LIMIT 1 OFFSET 2)
LIMIT 1;

-- Solution only work for non duplicae bonas
SELECT *
FROM Position
ORDER BY bonas DESC
LIMIT 1 OFFSET 2;

-- Q21, Write a query to display the first record from the Employee table.
SELECT * 
FROM Employee
LIMIT 1;

-- Alternating way 
SELECT * 
FROM Employee
WHERE empID = (SELECT MIN(empID) FROM Employee);

-- Q22, Write a query to display the last record from the Employee table.
SELECT * 
FROM Employee
ORDER BY empID DESC
LIMIT 1;

-- Alternating way 
SELECT * 
FROM Employee
WHERE empID = (SELECT MAX(empID) FROM Employee);

-- Q23 Write a query to retrieve departments who have less than 2 employees working in it.
SELECT department, COUNT(empID)  as 'EmpNo' 
FROM Employee 
GROUP BY department 
HAVING COUNT(empID) = 1;

-- Q24, Write a query to retrieve Postion along with total bonas paid for each of them
SELECT position, SUM(bonas)
FROM Position
GROUP BY position;

-- Q25, Write a query to fetch 50% records from the Employee table.
SELECT * 
FROM Employee
WHERE empID <= (SELECT COUNT(EmpID)/2
				FROM Employee);


