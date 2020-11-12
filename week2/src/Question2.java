import java.util.Stack;

public class Question2 {
    public static void main(String[] args) {
        new Question2().program();
    }

    private void program() {
        String program = "This (*COMMENT*) is a test of the removeComments-method.";
        System.out.println(program);
        System.out.println(removeComments(program));
    }

    private String removeComments(String str) {
        Stack<Integer> commentTags = new Stack<>();
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(' && str.charAt(i + 1) == '*') {
                commentTags.push(1);
                i++;
            }
            if (commentTags.isEmpty()){
                finalString.append(str.charAt(i));
            }
            if (!commentTags.isEmpty() && str.charAt(i) == '*' && str.charAt(i + 1) == ')') {
                commentTags.pop();
                i++;
            }
        }

        return finalString.toString();
    }
}
