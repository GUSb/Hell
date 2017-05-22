package exercises.calculator;

import structures.stack.MapBasedStack;

class CalculatorRunnable implements Runnable {

    private final String expression;

    CalculatorRunnable(String expression) {
        this.expression = expression;
    }

    @Override
    public void run() {
        Calculator calculator = getCalculator(expression);
        Double result = calculator.calculate(expression);
        System.out.println(result);
    }

    private Calculator getCalculator(String expression) {

        String[] tokens = expression.split(Calculator.EXPRESSION_SEPARATOR);
        final boolean isClassic = tokens.length < 2 || Operator.isOperator(tokens[1]);

        if (isClassic) {
            return new ClassicCalculator();
        } else {
            return new RPNCalculator(new MapBasedStack<>());
        }
    }
}
