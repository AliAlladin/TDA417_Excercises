import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {
        new Question3().program();
    }

    private void program() {
        String postfixExpression = "4 3 +";
        int result = evaluatePostfix(postfixExpression);
        System.out.println(result);
    }

    private int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            Character character = postfixExpression.charAt(i);
            if (isOperator(character)){
                switch (character){
                    case '+' :
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '-' :
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case '*' :
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '/' :
                        stack.push(stack.pop() / stack.pop());
                        break;
                }
            } else if (Character.isDigit(character)){
                stack.push(Character.getNumericValue(character));
            } else if (Character.isWhitespace(character)){
                continue;
            }
        }
        return stack.pop();
    }

    private boolean isOperator(char c) {
        String operators = "+-*/^";
        return operators.contains(String.valueOf(c));
    }
}
