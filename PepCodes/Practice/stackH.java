import java.util.Arrays;
import java.util.Stack;

public class stackH {
    public static void main(String[] args) {

        // String str = "manish";
        // String result = stringReverser(str);
        // System.out.println(result);

        // System.out.println(isBalanced("(<<a>+[b]>))"));
        System.out.println(isBalancedV02("<<a>+[b]>"));

    }

    public static String stringReverser(String input) {
        if (input == null) {
            return "invalid input";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String ans = "";

        while (!stack.empty()) {
            ans += stack.pop();
        }

        return ans;

    }

    public static boolean isBalanced(String input) { // (1+2)
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (Arrays.asList('(', '[', '<').contains(ch))
                stack.push(ch);
            else if (Arrays.asList(')', ']', '>').contains(ch)) {
                if (stack.empty())
                    return false;
                char v = stack.pop();
                switch (ch) {
                case ')':
                    if (v != '(')
                        return false;
                    break;
                case ']':
                    if (v != '[')
                        return false;
                    break;
                case '>':
                    if (v != '<')
                        return false;
                    break;
                }
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }

    public static boolean isBalancedV02(String input) { // (1+2)
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (Arrays.asList('(', '[', '<').contains(ch))
                stack.push(ch);
            else if (Arrays.asList(')', ']', '>').contains(ch)) {
                if (stack.empty())
                    return false;
                stack.pop();
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }

}