package exercises.calculator;

import structures.stack.MapBasedStack;
import structures.stack.Stack;

import static exercises.calculator.Operator.isOperator;

public class Calculator {

    private static final String EXPRESSION_SEPARATOR = " ";
    private Stack<String> stack;
    private String result;

    public String calculate(String expression) {
        stack = new MapBasedStack<>();
        result = "";

        for (String token : expression.split(EXPRESSION_SEPARATOR)) {
            if (isOperator(token)) {
                doArithmeticalOperation(token);
                stack.push(result);
            } else {
                stack.push(token);
            }
        }

        return result;
    }

    private void doArithmeticalOperation(String token) {
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

    private void multiply() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(first) * Integer.valueOf(second));
    }

    private void divide() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(second) / Integer.valueOf(first));
    }

    private void subtract() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(second) - Integer.valueOf(first));
    }

    private void add() {
        String first = stack.pop();
        String second = stack.pop();
        result = String.valueOf(Integer.valueOf(first) + Integer.valueOf(second));
    }
}
