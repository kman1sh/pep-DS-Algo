import java.util.Arrays;
import java.util.Stack;

public class StackHm {

    public static void main(String[] args) {
        // ******** Infix Evaluation *************
        String str = "9/3*4"; // "256/32+64/2"; // "12*4/2*3"; // "2^4^2";
        // //"8+4+3-9/3^(2-1)";
        System.out.println(infixEval(str));

        // ******** Infix -> Prefix *************
        // String infixExpression = "8+4+3-9/3^(2-1)"; // "(a^(b*c-d))+e-f/g"; //
        // "a+b-c/d^(e-f)";
        // System.out.println(InfixToPrefix(infixExpression));

        // ******** Prefix Evaluation *************
        // String prefixExp =  "/*68*23"; // "-+8+43/9^3-21";
        // System.out.println(prefixEval(prefixExp));
        
        // ******** Postfix Evaluation *************


    }

    /*****************************************
     * Infix Evaluation
     */

    public static int infixEval(String str) {
        if (str.length() == 0 || str.equals(" "))
            return -1;

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> optrStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isValidOperator(ch)) {
                if (optrStack.empty())
                    optrStack.push(ch);
                else {
                    if (priortyOf(ch) < priortyOf(optrStack.peek())) {

                        while (!optrStack.isEmpty() && priortyOf(ch) < priortyOf(optrStack.peek())) {
                            char op = optrStack.pop();
                            int val1 = numStack.pop();
                            int val2 = numStack.pop();
                            int ans = performOperation(op, val2, val1);
                            numStack.push(ans);
                        }
                        optrStack.push(ch);

                    } else
                        optrStack.push(ch);
                }

            } else if (ch == '(')
                optrStack.push(ch);

            else if (ch == ')') { // resplve till we get ')'
                while (optrStack.peek() != '(') {
                    char op = optrStack.pop();
                    int val1 = numStack.pop();
                    int val2 = numStack.pop();
                    int ans = performOperation(op, val2, val1);
                    numStack.push(ans);
                }
                optrStack.pop(); // removes opening bracket.

            } else { // ch is number
                // upto i = idx-1; is code when numbers are of more than 1 digits
                int idx = i;
                while (idx < str.length() && !isValidOperator(str.charAt(idx))) {
                    idx++;
                }
                int num = Integer.parseInt(str.substring(i, idx));
                numStack.push(num);
                i = idx - 1;
                // numStack.push(ch - '0');
            }
        }

        while (!optrStack.isEmpty()) {
            char op = optrStack.pop();
            int val1 = numStack.pop();
            int val2 = numStack.pop();
            int ans = performOperation(op, val2, val1);
            numStack.push(ans);
        }
        return numStack.peek();
    }

    public static int priortyOf(char ch) {
        if (ch == '-')
            return 1;
        if (ch == '+')
            return 2;
        if (ch == '*')
            return 3;
        if (ch == '/')
            return 4;
        if (ch == '^')
            return 5;
        return -1;
    }

    public static boolean isValidOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^';

    }

    public static int performOperation(char operator, int v2, int v1) {

        switch (operator) {
        case '+':
            return v2 + v1;
        case '-':
            return v2 - v1;
        case '/':
            return v2 / v1;
        case '*':
            return v2 * v1;
        default:
            return (int) Math.pow(v2, v1);
        }
    }

    /*******************************************
     * InFix -> PreFix *****************************************
     */

    public static String InfixToPrefix(String str) {
        // if (str.length() == 0 || str.equals(" "))
        // return "Invalid Expression";

        Stack<String> numStack = new Stack<>();
        Stack<Character> optrStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isValidOperator(ch)) {

                if (optrStack.isEmpty())
                    optrStack.push(ch);

                else if (priortyOf(ch) < priortyOf(optrStack.peek())) {

                    while (!optrStack.isEmpty() && priortyOf(ch) < priortyOf(optrStack.peek())) {
                        String ans = perform_Prefix_Operation(optrStack, numStack);
                        numStack.push(ans);
                    }
                    optrStack.push(ch);

                } else
                    optrStack.push(ch);

            } else if (ch == '(') {

                optrStack.push(ch);

            } else if (ch == ')') {

                while (optrStack.peek() != '(') {
                    String ans = perform_Prefix_Operation(optrStack, numStack);
                    numStack.push(ans);
                }

                optrStack.pop(); // removes opening bracket.

            } else { // ch is a number
                numStack.push(ch + "");
            }
        }

        while (!optrStack.isEmpty()) {
            String ans = perform_Prefix_Operation(optrStack, numStack);
            numStack.push(ans);
        }
        return numStack.peek();
    }

    public static String perform_Prefix_Operation(Stack<Character> optrStack, Stack<String> numStack) {
        char operator = optrStack.pop();
        String operand1 = numStack.pop();
        String operand2 = numStack.pop();

        return operator + operand2 + operand1;
    }

    /**********************************
     * InFix -> PostFix
     */

    /**********************************
     * PreFix Evaluation
     */

    public static int prefixEval(String str) {
        if (str.length() == 0 || str.equals(" "))
            return -1;

        Stack<Integer> numStack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (!isValidOperator(ch)) { // means it's a number: push in numStack
                numStack.push(ch - '0');
            } else {
                int val2 = numStack.pop();
                int val1 = numStack.pop();
                int ans = performOperation(ch, val2, val1);
                numStack.push(ans);
            }
        }
        return numStack.peek();
    }

    /**********************************
     * PostFix Evaluation
     */

}