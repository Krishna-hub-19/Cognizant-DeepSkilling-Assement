-- Scenario 1: Group all customer-related procedures and functions into a package.
CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2
    );

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    )
    RETURN NUMBER;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers(
            CustomerID,
            Name,
            DOB,
            Balance
        )
        VALUES(
            p_customer_id,
            p_name,
            p_dob,
            p_balance
        );
    END AddCustomer;

    PROCEDURE UpdateCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2
    )
    IS
    BEGIN
        UPDATE Customers
        SET Name = p_name
        WHERE CustomerID = p_customer_id;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;

        RETURN v_balance;
    END GetCustomerBalance;

END CustomerManagement;
/

-- Test
BEGIN
    CustomerManagement.UpdateCustomer(
        1,
        'Krishna'
    );
END;
/

-- Varify
SELECT *
FROM Customers
WHERE CustomerID = 1;

--------------------------------------------------------------------------------

-- Scenario 2: Create a package to manage employee data.
CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_employee_id IN NUMBER,
        p_salary IN NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_employee_id IN NUMBER
    )
    RETURN NUMBER;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_employee_id IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2
    )
    IS
    BEGIN
        INSERT INTO Employees(
            EmployeeID,
            Name,
            Position,
            Salary,
            Department
        )
        VALUES(
            p_employee_id,
            p_name,
            p_position,
            p_salary,
            p_department
        );
    END HireEmployee;

    PROCEDURE UpdateEmployee(
        p_employee_id IN NUMBER,
        p_salary IN NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_employee_id;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(
        p_employee_id IN NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/

-- Test
BEGIN
    EmployeeManagement.HireEmployee(
        202,
        'Rahul',
        'Manager',
        50000,
        'Sales'
    );
END;
/

-- Varify
SELECT *
FROM Employees
WHERE EmployeeID = 202;


BEGIN
    EmployeeManagement.UpdateEmployee(
        202,
        55000
    );
END;
/
-- Function to calculate annual salary
SET SERVEROUTPUT ON;

DECLARE
    v_annual_salary NUMBER;
BEGIN
    v_annual_salary :=
        EmployeeManagement.CalculateAnnualSalary(201);

    DBMS_OUTPUT.PUT_LINE(
        'Annual Salary: ' || v_annual_salary
    );
END;
/

--------------------------------------------------------------------------------

-- Scenario 3: Group all account-related operations into a package
CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id IN NUMBER,
        p_customer_id IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance IN NUMBER
    );

    PROCEDURE CloseAccount(
        p_account_id IN NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customer_id IN NUMBER
    )
    RETURN NUMBER;

END AccountOperations;
/


CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id IN NUMBER,
        p_customer_id IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance IN NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts(
            AccountID,
            CustomerID,
            AccountType,
            Balance
        )
        VALUES(
            p_account_id,
            p_customer_id,
            p_account_type,
            p_balance
        );
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_account_id IN NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;
    END CloseAccount;

    FUNCTION GetTotalBalance(
        p_customer_id IN NUMBER
    )
    RETURN NUMBER
    IS
        v_total_balance NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN NVL(v_total_balance, 0);
    END GetTotalBalance;

END AccountOperations;
/


-- Test
BEGIN
    AccountOperations.OpenAccount(
        301,
        1,
        'Savings',
        10000
    );
END;
/

-- Varify
SET SERVEROUTPUT ON;

DECLARE
    v_total NUMBER;
BEGIN
    v_total := AccountOperations.GetTotalBalance(1);

    DBMS_OUTPUT.PUT_LINE(
        'Total Balance: ' || v_total
    );
END;
/

-- Closing Account
BEGIN
    AccountOperations.CloseAccount(301);
END;
/