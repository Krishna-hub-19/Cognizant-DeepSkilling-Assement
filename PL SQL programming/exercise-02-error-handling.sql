-- Scenario 1: Handle exceptions during fund transfers between accounts
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    -- Check sender balance
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
    END IF;

    -- Debit sender
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    -- Credit receiver
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Source account not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/


-- Test
BEGIN
    SafeTransferFunds(101,102,500);
END;
/
--------------------------------------------------------------------------------

-- Scenario 2: Manage errors when updating employee salaries.
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage  IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_employee_id || ' does not exist.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

-- Test
BEGIN
    UpdateSalary(1,10);
END;
/

--------------------------------------------------------------------------------

-- Scenario 3: Ensure data integrity when adding a new customer.
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_dob         IN DATE,
    p_balance     IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers(
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified
    )
    VALUES(
        p_customer_id,
        p_name,
        p_dob,
        p_balance,
        SYSDATE
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

-- Test
BEGIN
    AddNewCustomer(
        11,
        'Rahul',
        DATE '1998-05-10',
        25000
    );
END;
/