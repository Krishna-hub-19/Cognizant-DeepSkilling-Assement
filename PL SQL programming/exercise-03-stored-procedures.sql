-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE UPPER(AccountType) = 'SAVINGS';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/


-- Test
BEGIN
    ProcessMonthlyInterest;
END;
/

--------------------------------------------------------------------------------

-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus      IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus / 100)
    WHERE UPPER(Department) = UPPER(p_department);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');
END;
/

-- Test
BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/

--------------------------------------------------------------------------------

-- Scenario 3: Customers should be able to transfer funds between their accounts.
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_amount,
            LastModified = SYSDATE
        WHERE AccountID = p_from_account;

        UPDATE Accounts
        SET Balance = Balance + p_amount,
            LastModified = SYSDATE
        WHERE AccountID = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');

    END IF;

END;
/

-- Test
BEGIN
    TransferFunds(101,102,1000);
END;
/