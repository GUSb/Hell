package exercises.calculator;

import structures.stack.MapBasedStack;
import structures.stack.Stack;

import static exercises.calculator.Operator.isOperator;

public class RPNCalculator implements Calculator {

    @Override
    public Double calculate(String expression) {
        Stack<String> stack = new MapBasedStack<>();

        for (String token : expression.split(EXPRESSION_SEPARATOR)) {
            if (isOperator(token)) {
                Double first = Double.valueOf(stack.pop());
                Double second = Double.valueOf(stack.pop());
                Operator sign = Operator.of(token);
                String result = doOperation(sign, first, second);
                stack.push(result);
            } else {
                stack.push(token);
            }
        }

        return Double.valueOf(stack.pop());
    }

    private String doOperation(Operator sign, Double first, Double second) {

        Double result = 0d;

        switch (sign) {
            case PLUS: {
                result = add(second, first);
                break;
            }
            case MINUS: {
                result = subtract(second, first);
                break;
            }
            case DIVIDER: {
                result = divide(second, first);
                break;
            }
            case MULTIPLIER: {
                result = multiply(second, first);
                break;
            }
        }

        return String.valueOf(result);
    }

    private Double add(Double first, Double second) {
        return first + second;
    }

    private Double subtract(Double first, Double second) {
        return first - second;
    }

    private Double divide(Double first, Double second) {
        return first / second;
    }

    private Double multiply(Double first, Double second) {
        return first * second;
    }
}
