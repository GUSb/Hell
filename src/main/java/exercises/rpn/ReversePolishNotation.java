package exercises.rpn;

import structures.stack.MapBasedStack;
import structures.stack.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static exercises.calculator.Operator.isOperator;

public class ReversePolishNotation {

    private final String RPN_TOKENS_SEPARATOR = " ";

    private Pattern pattern = Pattern.compile("[0-9]+|[\\+\\-\\*/]");
    private StringBuilder sb = new StringBuilder();

    public String translate(String expression) {
        Stack<String> operators = new MapBasedStack<>();
        expression = expression.trim();
        Stack<String> rpnTokens = findMatches(expression).reverse();

        while (!rpnTokens.isEmpty()) {
            String token = rpnTokens.pop();
            
            if (!isOperator(token)) {
                sb.append(token).append(RPN_TOKENS_SEPARATOR);
            } else if (isOperator(token)){
                operators.push(token);

                if (rpnTokens.isEmpty()) {
                    sb.append(operators.pop());
                }
                else if ((!rpnTokens.isEmpty()) && operators.size() > 0) {
                    sb.append(operators.pop()).append(RPN_TOKENS_SEPARATOR);
                }
            }
        }

        return sb.toString();
    }

    private Stack<String> findMatches(String expression) {
        Matcher matcher = pattern.matcher(expression);
        Stack<String> rpnTokens = new MapBasedStack<>();
        while (matcher.find()) {
            rpnTokens.push(matcher.group().trim());
        }
        return rpnTokens;
    }
}
