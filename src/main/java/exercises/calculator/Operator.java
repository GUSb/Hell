package exercises.calculator;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    DIVIDER("/"),
    MULTIPLIER("*");

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public static boolean isOperator(String token) {
        return token.equals(PLUS.toString()) || token.equals(MINUS.toString()) ||
                token.equals(MULTIPLIER.toString()) || token.equals(DIVIDER.toString());
    }

    @Override
    public String toString() {
        return value;
    }

    public static Operator of(String token) {
        Operator operator = null;
        for (Operator op : Operator.values()) {
            if (op.toString().equals(token)) {
                operator = op;
                break;
            }
        }
        if (operator == null) {
            throw new IllegalOperatorException("The input value " + token + " is not ");
        }
        return operator;
    }
}
