package exercises.calculator;

import exercises.stack.MapBasedStack;
import exercises.stack.Stack;

import static exercises.calculator.Operator.isOperator;

public class Calculator {

    private static final String EXPRESSION_SEPARATOR = " ";
    private static Stack<String> stack;
    private static String result;

    public static String calculate(String expression) {
        stack = new MapBasedStack<>();
        result = "";

        for (String token : expression.split(EXPRESSION_SEPARATOR)) {
            if (!isOperator(token)) {
                stack.push(token);
            } else {
                doArithmeticalOperation(token);
                stack.push(result);
            }
        }

        return result;
    }

    private static void doArithmeticalOperation(String token) {
        switch (Operator.of(token)) {
            case PLUS : {
                add();
                break;
            }
            case MINUS : {
                subtract();
                break;
            }
            case DIVIDER : {
                divide();
                break;
            }
            case MULTIPLIER : {
                multiply();
                break;
            }
        }
    }

    private static void multiply() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(first) * Integer.valueOf(second));
    }

    private static void divide() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(second) / Integer.valueOf(first));
    }

    private static void subtract() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(second) - Integer.valueOf(first));
    }

    private static void add() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(first) + Integer.valueOf(second));
    }
}
