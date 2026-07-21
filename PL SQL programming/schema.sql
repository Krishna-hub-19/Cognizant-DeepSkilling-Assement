-- ===========================
-- CUSTOMERS TABLE
-- ===========================

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

-- ===========================
-- ACCOUNTS TABLE
-- ===========================

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID)
    REFERENCES Customers(CustomerID)
);

-- ===========================
-- TRANSACTIONS TABLE
-- ===========================

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(20),
    FOREIGN KEY (AccountID)
    REFERENCES Accounts(AccountID)
);

-- ===========================
-- LOANS TABLE
-- ===========================

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID)
    REFERENCES Customers(CustomerID)
);

-- ===========================
-- EMPLOYEES TABLE
-- ===========================

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);