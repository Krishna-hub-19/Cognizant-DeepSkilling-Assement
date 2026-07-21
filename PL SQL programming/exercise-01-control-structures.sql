-- Scenario 1: Apply a 1% discount to loan interest rates for customers above 60 years old.

SET SERVEROUTPUT ON;

BEGIN
    FOR customer_rec IN (
        SELECT c.CustomerID,
               FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age
        FROM Customers c
    )
    LOOP
        IF customer_rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied for Customer ID: '
                || customer_rec.CustomerID
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/


--------------------------------------------------------------------------------

-- Scenario 2: Customers having balance greater than 10000 become VIP.

SET SERVEROUTPUT ON;

BEGIN
    FOR customer_rec IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer '
                || customer_rec.CustomerID
                || ' promoted to VIP.'
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/

--------------------------------------------------------------------------------

-- Scenario 3: Print reminder for loans due in next 30 days.

UPDATE Loans
SET EndDate = SYSDATE + 15
WHERE CustomerID = 1;

COMMIT;

BEGIN
    FOR loan_rec IN (
        SELECT LoanID,
               CustomerID,
               EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE
                          AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer '
            || loan_rec.CustomerID
            || ' has Loan '
            || loan_rec.LoanID
            || ' due on '
            || TO_CHAR(loan_rec.EndDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/
