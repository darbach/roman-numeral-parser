package edu.cnm.deepdive;

import java.util.Map;

public abstract class RomanNumerals {

  private static final Map<String, Integer> values;

  static {
    values = Map.of(
        "I", 1,
        "V", 5,
        "X", 10,
        "L", 50,
        "C", 100,
        "D", 500,
        "M", 1_000);
  }

  /**
   * Parses and converts a Roman numeral to an integer value. It is up to the user to ensure that
   * the numeral is properly formatted per the rules at
   * <a href="https://www.factmonster.com/math-science/mathematics/roman-numerals">https://www.factmonster.com/math-science/mathematics/roman-numerals</a><br/>
   * <br/> The values are:
   *
   * <table>
   *   <tr>
   *     <th>Roman Numeral</th><th>Decimal Value</th>
   *   </tr>
   *   <tr>
   *     <td>I</td><td>1</td>
   *   </tr>
   *   <tr>
   *     <td>V</td><td>5</td>
   *   </tr>
   *   <tr>
   *     <td>X</td><td>10</td>
   *   </tr>
   *   <tr>
   *     <td>L</td><td>50</td>
   *   </tr>
   *   <tr>
   *     <td>C</td><td>100</td>
   *   </tr>
   *   <tr>
   *     <td>D</td><td>500</td>
   *   </tr>
   *   <tr>
   *     <td>M</td><td>1,000</td>
   *   </tr>
   * </table>
   *
   * @param romanNumeral The string representation of a Roman numeral.
   * @return The integer equivalent
   */
  public static int parse(String romanNumeral) {
    char[] working = romanNumeral.toCharArray();
    int tally = 0;
    for (int i = 0; i < working.length; i++) {
      // FIXME debugger will not step past following line
      int current = values.get(working[i]);
      if (i + 1 < working.length) {
        int next = values.get(working[i + 1]);
        if (current >= next) {
          tally += current;
        } else {
          tally += (next - current);
          i++;
        }
      } else {
        tally += current;
      }
    }
    return tally;
  }

}
