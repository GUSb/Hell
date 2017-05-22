package exercises.calculator;

import structures.stack.MapBasedStack;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type expression or q to exit");

        while (true) {

            String line = scanner.nextLine();

            if (line.equals("q")) {
                System.exit(0);
            }

            Thread thread = new Thread(new CalculatorRunnable(line));
            thread.start();
        }
    }

    private static class CalculatorRunnable implements Runnable {

        private final String expression;

        public CalculatorRunnable(String expression) {
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
}
