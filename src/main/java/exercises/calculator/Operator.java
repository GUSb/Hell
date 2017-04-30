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
        throw new IllegalOperatorException("The input value " + token + " is not valid operator. Valid operators are + - / *");
    }

    @Override
    public String toString() {
        return sign;
    }
}
