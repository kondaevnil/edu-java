package edu.hw2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static edu.hw2.Task1.Expr.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({"0.0, 0.0", "10.5, 10.5", "1e15, 1e15", "-1e10, -1e10"})
    void constantEvaluateTest(double input, double expected) {
        assertEquals(expected, new Constant(input).evaluate());
    }

    @ParameterizedTest
    @CsvSource({"-0.0, 0.0", "-10.5, 10.5", "-1e15, 1e15", "1e10, -1e10"})
    void negateEvaluateTest(double input, double expected) {
        assertEquals(expected, new Negate(new Constant(input)).evaluate());
    }

    static Stream<Arguments> additionTestCases() {
        return Stream.of(
            arguments(    2,     3, 0.000001d,       5),
            arguments(    0,     0, 0.000001d,       0),
            arguments(   -2,     2, 0.000001d,       0),
            arguments(  1e9,   1e9, 0.000001d, 1e9 * 2),
            arguments( -1e9,   1e9, 0.000001d,       0),
            arguments(1.111, 5.555, 0.000001d,   6.666)
        );
    }

    @ParameterizedTest
    @MethodSource("additionTestCases")
    void additionEvaluateTest(double a, double b, double eps, double expected) {
        assertEquals(expected, new Addition(new Constant(a), new Constant(b)).evaluate(), eps);
    }

    static Stream<Arguments> multiplicationTestCases() {
        return Stream.of(
            Arguments.arguments( 2,  3,   6),
            Arguments.arguments( 0, 10,   0),
            Arguments.arguments(-5,  4, -20),
            Arguments.arguments( 7, -2, -14)
        );
    }

    @ParameterizedTest
    @MethodSource("multiplicationTestCases")
    void testMultiplication(double a, double b, double expected) {
        assertEquals(expected, new Multiplication(new Constant(a), new Constant(b)).evaluate());
    }

    static Stream<Arguments> exponentTestCases() {
        return Stream.of(
            Arguments.arguments( 2,  0,    1),
            Arguments.arguments( 3,  3,   27),
            Arguments.arguments( 5, -2, 0.04),
            Arguments.arguments(-2,  4,   16)
        );
    }

    @ParameterizedTest
    @MethodSource("exponentTestCases")
    void testExponent(double base, double exponent, double expected) {
        assertEquals(expected, new Exponent(new Constant(base), exponent).evaluate(), 0.0001);
    }
}
