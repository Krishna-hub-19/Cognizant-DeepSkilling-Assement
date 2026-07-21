-- ===========================
-- CUSTOMERS
-- ===========================

INSERT INTO Customers VALUES
(1,'John Doe',TO_DATE('1960-05-15','YYYY-MM-DD'),12000,SYSDATE);

INSERT INTO Customers VALUES
(2,'Jane Smith',TO_DATE('1992-07-20','YYYY-MM-DD'),8000,SYSDATE);

INSERT INTO Customers VALUES
(3,'Robert King',TO_DATE('1955-03-10','YYYY-MM-DD'),25000,SYSDATE);

INSERT INTO Customers VALUES
(4,'Emily Clark',TO_DATE('1988-11-25','YYYY-MM-DD'),6000,SYSDATE);

INSERT INTO Customers VALUES
(5,'Michael Lee',TO_DATE('1975-08-18','YYYY-MM-DD'),18000,SYSDATE);

-- ===========================
-- ACCOUNTS
-- ===========================

INSERT INTO Accounts VALUES
(101,1,'Savings',12000,SYSDATE);

INSERT INTO Accounts VALUES
(102,2,'Checking',8000,SYSDATE);

INSERT INTO Accounts VALUES
(103,3,'Savings',25000,SYSDATE);

INSERT INTO Accounts VALUES
(104,4,'Checking',6000,SYSDATE);

INSERT INTO Accounts VALUES
(105,5,'Savings',18000,SYSDATE);

-- ===========================
-- TRANSACTIONS
-- ===========================

INSERT INTO Transactions VALUES
(1001,101,SYSDATE-2,500,'Deposit');

INSERT INTO Transactions VALUES
(1002,102,SYSDATE-5,300,'Withdrawal');

INSERT INTO Transactions VALUES
(1003,103,SYSDATE-8,700,'Deposit');

INSERT INTO Transactions VALUES
(1004,104,SYSDATE-10,400,'Withdrawal');

INSERT INTO Transactions VALUES
(1005,105,SYSDATE,900,'Deposit');

-- ===========================
-- LOANS
-- ===========================

INSERT INTO Loans VALUES
(201,1,50000,8,SYSDATE,ADD_MONTHS(SYSDATE,12));

INSERT INTO Loans VALUES
(202,3,100000,9,SYSDATE,ADD_MONTHS(SYSDATE,1));

INSERT INTO Loans VALUES
(203,5,75000,7,SYSDATE,ADD_MONTHS(SYSDATE,24));

-- ===========================
-- EMPLOYEES
-- ===========================

INSERT INTO Employees VALUES
(1,'Alice Johnson','Manager',70000,'HR',
TO_DATE('2015-06-15','YYYY-MM-DD'));

INSERT INTO Employees VALUES
(2,'Bob Brown','Developer',60000,'IT',
TO_DATE('2017-03-20','YYYY-MM-DD'));

INSERT INTO Employees VALUES
(3,'David Miller','Analyst',55000,'Finance',
TO_DATE('2018-09-18','YYYY-MM-DD'));

COMMIT;