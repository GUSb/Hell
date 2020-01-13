package exercises.calculator;

public enum Operator {

  PLUS("+"),
  MINUS("-"),
  DIVIDER("/"),
  MULTIPLIER("*");

  private String sign;

  Operator(String sign) {
    this.sign = sign;
  }

  public static boolean isOperator(String token) {
    return token.equals(PLUS.toString()) ||
        token.equals(MINUS.toString()) ||
        token.equals(DIVIDER.toString()) ||
        token.equals(MULTIPLIER.toString());
  }

  public static Operator of(String token) {

    for (Operator operator : Operator.values()) {
      if (operator.toString().equals(token)) {
        return operator;
      }
    }
    throw new IllegalOperatorException(
        "The input value " + token + " is not valid operator. Valid operators are + - / *");
  }

  public static String doOperation(Operator sign, Double first, Double second) {

    Double result = 0d;

    switch (sign) {
      case PLUS: {
        result = add(first, second);
        break;
      }
      case MINUS: {
        result = subtract(first, second);
        break;
      }
      case DIVIDER: {
        result = divide(first, second);
        break;
      }
      case MULTIPLIER: {
        result = multiply(first, second);
        break;
      }
    }

    return String.valueOf(result);
  }

  private static Double add(Double first, Double second) {
    return first + second;
  }

  private static Double subtract(Double first, Double second) {
    return first - second;
  }

  private static Double divide(Double first, Double second) {
    return first / second;
  }

  private static Double multiply(Double first, Double second) {
    return first * second;
  }

  @Override
  public String toString() {
    return sign;
  }
}
