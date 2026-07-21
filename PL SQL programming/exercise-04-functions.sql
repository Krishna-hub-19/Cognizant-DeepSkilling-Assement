-- Scenario 1: Calculate the age of customers for eligibility checks.

SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
)
RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);

    RETURN v_age;
END;
/

-- Test
DECLARE
    v_age NUMBER;
BEGIN
    SELECT CalculateAge(DOB)
    INTO v_age
    FROM Customers
    WHERE CustomerID = 1;

    DBMS_OUTPUT.PUT_LINE('Customer Age: ' || v_age);
END;
/

--------------------------------------------------------------------------------

-- Scenario 2: The bank needs to compute the monthly installment for a loan.
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_years IN NUMBER
)
RETURN NUMBER
IS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_power NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_rate := p_interest_rate / 100 / 12;
    v_months := p_years * 12;

    v_power := POWER(1 + v_monthly_rate, v_months);

    v_emi := (p_loan_amount * v_monthly_rate * v_power)
             / (v_power - 1);

    RETURN ROUND(v_emi, 2);
END;
/

-- Test
DECLARE
    v_installment NUMBER;
BEGIN
    v_installment := CalculateMonthlyInstallment(500000, 8.5, 10);

    DBMS_OUTPUT.PUT_LINE('Monthly Installment: ' || v_installment);
END;
/

--------------------------------------------------------------------------------

-- Scenario 3: Check if a customer has sufficient balance before making a transaction.
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
)
RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

-- Test
SET SERVEROUTPUT ON;

DECLARE
    v_result BOOLEAN;
BEGIN
    v_result := HasSufficientBalance(101, 1000);

    IF v_result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient Balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;
END;
/