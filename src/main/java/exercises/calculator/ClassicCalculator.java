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

        while (queue.size() > 1) {
            Double first = Double.valueOf(queue.pop());
            Operator sign = Operator.of(queue.pop());
            Double second = Double.valueOf(queue.pop());
            String result = Operator.doOperation(sign, first, second);
            queue.addFirst(result);
        }

        String result = queue.get(0);
        return Double.valueOf(result);
    }
}
