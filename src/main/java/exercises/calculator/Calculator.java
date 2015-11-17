package exercises.calculator;

import exercises.stack.MapBasedStack;
import exercises.stack.Stack;

public class Calculator {

    private static Stack<String> stack;
    private static String result;

    public static String calculate(String expression) {
        stack = new MapBasedStack<>();
        result = "";

        for (char token : expression.toCharArray()) {

            if (isNotOperator(token)) {
                stack.push(String.valueOf(token));
            } else {
                doArithmeticalOperation(token);
                stack.push(result);
            }
        }

        return result;
    }

    private static void doArithmeticalOperation(char token) {
        switch (token) {
            case '+' : {
                add();
                break;
            }
            case '-' : {
                subtract();
                break;
            }
            case '/' : {
                divide();
                break;
            }
            case '*' : {
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

    private static boolean isNotOperator(char token) {
        return token != '+' && token != '-' && token != '*' && token != '/'  ;
    }
}
