package exercises.calculator;

import static exercises.calculator.Operator.isOperator;

import structures.stack.Stack;

public class RPNCalculator implements Calculator {

  private Stack<String> stack;

  public RPNCalculator(Stack<String> stack) {
    this.stack = stack;
  }

  @Override
  public Double calculate(String expression) {

    for (String token : expression.split(EXPRESSION_SEPARATOR)) {
      if (isOperator(token)) {
        Double first = Double.valueOf(stack.pop());
        Double second = Double.valueOf(stack.pop());
        Operator sign = Operator.of(token);
        String result = Operator.doOperation(sign, second, first);
        stack.push(result);
      } else {
        stack.push(token);
      }
    }

    return Double.valueOf(stack.pop());
  }
}
