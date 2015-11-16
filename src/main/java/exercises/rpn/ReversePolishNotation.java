package exercises.rpn;

public class ReversePolishNotation {

    private StringBuffer sb = new StringBuffer();

    public String translate(String expression) {
        expression = expression.trim();
        char[] tokens = expression.toCharArray();

        for (char token : tokens) {
            if (token == '+') {
                sb.append(expression.charAt(expression.indexOf(token) - 1));
                sb.append(expression.charAt(expression.indexOf(token) + 1));
                sb.append(expression.charAt(expression.indexOf(token)));
            }
        }

        return sb.toString();
    }
}
