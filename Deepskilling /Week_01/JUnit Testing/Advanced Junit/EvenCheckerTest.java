Exercise 1:Parameterized Tests Scenario:You want to test a method that checks if a number is even.Instead of writing multiple test cases,you will use parameterized tests to run the same test with different inputs.Steps:1. Create a new Java class`EvenChecker`with a method`isEven(int number)`.2. Write a parameterized test class`EvenCheckerTest`that tests the`isEven`method with different inputs.3. Use JUnit's`@ParameterizedTest`and`@ValueSource`annotations.

---------------------<--------------------------->------------------------

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenCheckerTest {
    @ParameterizedTest
    @ValueSource(ints = {2,4,3,8,5})

    void testEvenChecker(int  number){
        EvenChecker checker = new EvenChecker();

        assertTrue(checker.isEven(number));
    }
}
------------------<-------------------------->--------------------------

Exercise 2: Test Suites and Categories
Scenario:
You want to group related tests into a test suite and categorize them.
Steps:
1. Create a new test suite class `AllTests`.
2. Add multiple test classes to the suite.
3. Use JUnit's `@Suite` and `@SelectClasses` annotations.

---------------------<--------------------------->------------------------
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({EvenCheckerTest.class, OrderedTests.class, ExceptionThrowerTest.class, PerformanceTesterTest.class})
class AllTests {
    // This class remains empty. It only serves as a holder for the suite annotations.
}
------------------<-------------------------->--------------------------

Exercise 3: Test Execution Order
Scenario:
You want to control the order in which tests are executed.
Steps:
1. Create a test class `OrderedTests`.
2. Use JUnit's `@TestMethodOrder` and `@Order` annotations.

---------------------<--------------------------->------------------------
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests {

    @Test
    @Order(1)
    void firstTest() {
        assertTrue(true);
    }

    @Test
    @Order(2)
    void secondTest() {
        assertTrue(true);
    }

    @Test
    @Order(3)
    void thirdTest() {
        assertTrue(true);
    }
}
------------------<-------------------------->--------------------------

Exercise 4: Exception Testing
Scenario:
You want to test that a method throws the expected exception.
Steps:
1. Create a class `ExceptionThrower` with a method `throwException`.
2. Write a test class `ExceptionThrowerTest` that tests the method for the expected
exception.

---------------------<--------------------------->------------------------
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionThrowerTest {

    @Test
    void testExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
    }
}------------------<-------------------------->--------------------------

Exercise 5:

Timeout and
Performance Testing Scenario:
You want
to ensure
that a
method completes
within a
specified time limit.Steps:1.
Create a class`PerformanceTester`
with a method`performTask`.2.
Write a test class`PerformanceTesterTest`
that tests
the method for timeout.

---------------------<--------------------------->----------------------
--
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class PerformanceTesterTest {

    @Test
    void testPerformanceTimeout() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofMillis(200), () -> {
            tester.performTask();
        });
    }
}
