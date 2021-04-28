package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RomanNumeralsTest {

  @ParameterizedTest(name = "[{index}]Asserting parse({0}) == {1}")
  @MethodSource("parse")
  void parse(String input, int expected) {
    assertEquals(expected, RomanNumerals.parse(input));
  }

  static Stream<Arguments> parse() {
    return Stream.of(
        Arguments.of("VI", 6),
        Arguments.of("LXX", 70),
        Arguments.of("MCC", 1200),
        Arguments.of("IV", 4),
        Arguments.of("XC", 90),
        Arguments.of("CM", 900),
        Arguments.of("XCV", 95),
        Arguments.of("XIII", 13),
        Arguments.of("XCIX", 99)
    );
  }

}