package com.softserve.edu;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcTest {
    private Calc calc;

    @BeforeAll
    public void setup() {
        calc = new Calc();
    }

    @Test
    public void checkEquals() {
        double expected = 10.001;
        double actual = calc.add(5, 5);
        Assertions.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void checkNonEquals() {
        double expected = 10.001;
        double actual = calc.add(4, 6);
        Assertions.assertEquals(expected, actual, 0.01);
    }

    @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, expectedSum={2}")
    @CsvSource({
            "5.0, 5.0, 10.0",
            "2.0, 3.0, 5.0"
    })
    void sum(double a, double b, double expectedSum) {
        Assertions.assertEquals(expectedSum, calc.add(a, b), 0.0001);
    }
}
