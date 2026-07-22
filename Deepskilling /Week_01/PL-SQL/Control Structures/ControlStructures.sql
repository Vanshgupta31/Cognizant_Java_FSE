SET SERVEROUTPUT ON;

---------------------------------------------------------
-- Scenario 1
-- Apply 1% interest rate discount for customers above 60
---------------------------------------------------------

BEGIN
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Interest rate discount applied successfully.');
END;
/

---------------------------------------------------------
-- Scenario 2
-- Mark customers as VIP if balance exceeds 10000
---------------------------------------------------------

BEGIN
    FOR rec IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP = TRUE
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');
END;
/

---------------------------------------------------------
-- Scenario 3
-- Print reminders for loans due within 30 days
---------------------------------------------------------

BEGIN
    FOR rec IN (
        SELECT c.Name,
               l.LoanID,
               l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan '
            || rec.LoanID
            || ' for '
            || rec.Name
            || ' is due on '
            || TO_CHAR(rec.DueDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/