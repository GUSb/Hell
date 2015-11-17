package exercises.rpn;

public class ReversePolishNotation {

    private StringBuffer sb = new StringBuffer();

    public String translate(String expression) {
        expression = expression.trim();
        char[] tokens = expression.toCharArray();

        for (char token : tokens) {

            if (token == '+' || token == '-') {

                if (!(expression.startsWith("+") || (expression.startsWith("-")))) {
                    sb.append(expression.charAt(expression.indexOf(token) - 1));
                }

                sb.append(expression.charAt(expression.indexOf(token) + 1));
                sb.append(expression.charAt(expression.indexOf(token)));

                if (expression.length() > expression.indexOf(token) + 2) {

                    expression = expression.substring(expression.indexOf(token) + 2);

                    if (isExpressionHaveOperands(expression)) {
                        translate(expression);
                        break;
                    }
                }
            }
        }

        return sb.toString();
    }

    private boolean isExpressionHaveOperands(String expression) {
        return expression.contains("+") || expression.contains("-");
    }
}
