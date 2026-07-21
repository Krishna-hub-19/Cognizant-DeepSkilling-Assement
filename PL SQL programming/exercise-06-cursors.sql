-- Scenario 1: Generate monthly statements for all customers.
SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT TransactionID,
               AccountID,
               TransactionType,
               Amount,
               TransactionDate
        FROM Transactions
        WHERE EXTRACT(MONTH FROM TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_transaction_id   Transactions.TransactionID%TYPE;
    v_account_id       Transactions.AccountID%TYPE;
    v_type             Transactions.TransactionType%TYPE;
    v_amount           Transactions.Amount%TYPE;
    v_date             Transactions.TransactionDate%TYPE;

BEGIN
    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements
        INTO v_transaction_id,
             v_account_id,
             v_type,
             v_amount,
             v_date;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('----------------------------');
        DBMS_OUTPUT.PUT_LINE('Transaction ID : ' || v_transaction_id);
        DBMS_OUTPUT.PUT_LINE('Account ID     : ' || v_account_id);
        DBMS_OUTPUT.PUT_LINE('Type           : ' || v_type);
        DBMS_OUTPUT.PUT_LINE('Amount         : ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('Date           : ' || v_date);
    END LOOP;

    CLOSE GenerateMonthlyStatements;
END;
/

--------------------------------------------------------------------------------

-- Scenario 2: Apply annual fee to all accounts.
SET SERVEROUTPUT ON;

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;

    v_account_id Accounts.AccountID%TYPE;
    v_balance    Accounts.Balance%TYPE;
    v_fee        NUMBER := 500;

BEGIN
    OPEN ApplyAnnualFee;

    LOOP
        FETCH ApplyAnnualFee
        INTO v_account_id, v_balance;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee deducted from Account ID: ' || v_account_id
        );
    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;
END;
/

--------------------------------------------------------------------------------

-- Scenario 3: Update the interest rate for all loans based on a new policy.
SET SERVEROUTPUT ON;

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;

    v_loan_id       Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;

BEGIN
    OPEN UpdateLoanInterestRates;

    LOOP
        FETCH UpdateLoanInterestRates
        INTO v_loan_id, v_interest_rate;

        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE(
            'Updated Loan ID: ' || v_loan_id ||
            ' | New Interest Rate: ' || (v_interest_rate + 0.5)
        );
    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;
END;
/