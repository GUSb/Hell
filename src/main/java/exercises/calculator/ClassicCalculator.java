package exercises.calculator;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class ClassicCalculator implements Calculator {

    @Override
    public Double calculate(String expression) {

        if (expression == null || expression.isEmpty()) {
            return 0d;
        }

        Collection<String> tokens = Arrays.asList(expression.split(EXPRESSION_SEPARATOR));
        LinkedList<String> queue = new LinkedList<>(tokens);

        // [1 + 2 - 3] -> [3 - 3] -> [0]
        while (queue.size() > 1) {
            Double first = Double.valueOf(queue.pop());
            Operator sign = Operator.of(queue.pop());
            Double second = Double.valueOf(queue.pop());
            String result = doOperation(sign, first, second);
            queue.addFirst(result);
        }

        String result = queue.get(0);
        return Double.valueOf(result);
    }

    private String doOperation(Operator sign, Double first, Double second) {

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
