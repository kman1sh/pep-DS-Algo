import java.util.Arrays;
import java.util.Stack;

public class Client {

    public static void main(String[] args) {
        // MyStack dStack = new MyStack(10);
        // Queue q = new LinkedList<>();

        // MyQueue que = new MyQueue();

        // DynamicStack dStack = new DynamicStack(10);
        // dStack.push(10);
        // dStack.push(20);
        // dStack.push(30);
        // dStack.push(40);
        // dStack.push(50);
        // dStack.push(60);
        // dStack.push(70);
        // dStack.push(80);
        // dStack.push(90);
        // dStack.push(100);
        // dStack.push(110);
        // System.out.println(dStack);

        // DynamicQueue dQueue = new DynamicQueue(5);
        // dQueue.add(10);
        // dQueue.add(20);
        // dQueue.add(30);
        // dQueue.add(40);
        // dQueue.add(50);
        // dQueue.add(60);
        // dQueue.add(70);
        // dQueue.add(80);
        // System.out.println(dQueue);
        // System.out.println(dQueue.size + ":" + dQueue.start + ":" + dQueue.end);
        // dQueue.poll();
        // dQueue.poll();
        // dQueue.poll();
        // System.out.println(dQueue.size + ":" + dQueue.start + ":" + dQueue.end);

        // =========== Construnction END ====================
        // infixEvaluation ("9/3*4"); // 8+4*3-9/3^(2-1) //"2^4^2 this case not handled

        // // str: "a+b*c-d^(e+f)" , "8+4*3-9/3^(2-1)"
        // infixTo("a+b*c-d^(e+f)", true); // true : solve as preFix
        // infixTo("8+4*3-9/3^(2-1)", false); // false: solve as postfix

        // prefixEval("+9*26"); // "+9*26" : 21 , "-+8*43/9^3-21" : 17
        // PostfixEval("843*+9321-^/-");

        // ================== Infix - Prefix - postfix Ends ============

        // { 1,3,2,4,8,6,5,9,1}; :: [-1,-1,3,-1,-1,8,6,-1,9]
        // int[] arr = { 1, 3, 2, 4, 8, 6, 5, 9, 1 };
        // nextGreaterLeft(arr);

        // { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // { 4, 6, 5, 2, 4, 6, 5 };
        // int[] histogram = { 6, 2, 5, 5, 5, 4, 5, 1 };
        // maximumHistogramArea(histogram);

        // char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
        // { '1', '1', '1', '1', '1' },
        // { '1', '0', '0', '1', '0' } };
        // maximumRectInMatrix(matrix);

        // ==============MinStack getMin: O(1) ============================
        /**
         * if stack empty toh min = jo ele aaya. and push that ele in stack as it is. if
         * coming elements > min--> directly push in stack. <br>
         * if coming element < min => new Min found. update min and push this ele in
         * stack in encoded form such that: <br>
         * 1) encoded form stores the privous minimum somehow. <br>
         * 2) encoded form is less than orginalForm (or new Min becoz this ele is our
         * new min now). Why "encodedForm < OrginalForm"? becoz pop k tym ye min se
         * chhota dikhega. jisse idea mil jayega ki ye encoded element hai or min
         * Element pop hua hai. So, now update min with oldMin (jo ki encoded ele mai
         * store hoga) and return curr Min becoz currMin = orginalForm of encoded
         * number.
         * 
         * when element X < CurMin. update "min" and encode X. <br>
         * encodedForm: (y) = 2 * X - curMin. Note: y < X, always. becoz X - curMin < 0
         * min = X; decoding to get OldMin => 2 * min - y;
         */

        // MinStack mStack = new MinStack();
        // mStack.push(6);
        // System.out.println(mStack.getMin());
        // mStack.push(10);
        // mStack.push(2);
        // System.out.println(mStack.getMin());
        // mStack.push(5);
        // mStack.push(8);
        // System.out.println(mStack.getMin());
        // mStack.push(1);
        // System.out.println(mStack.getMin());
        // mStack.push(9);
        // System.out.println(mStack.getMin());

        // ===================================================================
        // "[(])"; : false // "[()]{}{[()()]()}"; : true
        String str = "{()}[]"; 
        System.out.println(isBalancedBracket(str));

    }

    public static void infixEvaluation(String str) {
        Stack<Integer> numStack = new Stack<>(); // OperandStack
        Stack<Character> opStack = new Stack<>(); // operatorStack

        for (char ch : str.toCharArray()) {

            if (isValidOperator(ch)) {
                if (opStack.isEmpty())
                    opStack.push(ch);
                else {
                    if (rank(ch) > rank(opStack.peek())) {
                        opStack.push(ch);
                    } else {
                        while (!opStack.isEmpty() && rank(ch) <= rank(opStack.peek())) {
                            int result = popAndSolve(opStack, numStack);
                            numStack.push(result);
                        }
                        opStack.push(ch);
                    }
                }
            } else if (ch == '(' || ch == ')') {
                if (ch == '(')
                    opStack.push(ch);
                else { // ch is ')'
                    while (opStack.peek() != '(') {
                        int result = popAndSolve(opStack, numStack);
                        numStack.push(result);
                    }
                    opStack.pop(); // remove '('
                }

            } else { // ch is num.
                numStack.push(ch - '0');
            }

            // System.out.println("op " +opStack);
            // System.out.println("num " +numStack);

        }

        while (!opStack.isEmpty()) {
            int result = popAndSolve(opStack, numStack);
            numStack.push(result);
        }
        System.out.println(numStack);
    }

    public static boolean isValidOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^';
    }

    public static int rank(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                // ch == '(', kyuki ye stack mai push hoga toh rank dena padega.
                return 0;
        }
    }

    public static int popAndSolve(Stack<Character> opStack, Stack<Integer> numStack) {
        char operator = opStack.pop();
        int val1 = numStack.pop();
        int val2 = numStack.pop();

        // +,-, *,/,%, ^
        switch (operator) {
            case '+':
                return val2 + val1;
            case '-':
                return val2 - val1;
            case '/':
                return val2 / val1;
            case '*':
                return val2 * val1;
            case '%':
                return val2 % val1;
            default: // operator = '^'
                return (int) Math.pow(val2, val1);
        }
    }

    // =======================================================================

    public static void infixTo(String str, boolean asPrefix) {
        Stack<String> numStack = new Stack<>(); // OperandStack
        Stack<Character> opStack = new Stack<>(); // operatorStack

        for (char ch : str.toCharArray()) {

            if (isValidOperator(ch)) {
                if (opStack.isEmpty() || rank(ch) > rank(opStack.peek())) {
                    opStack.push(ch);
                } else {
                    while (!opStack.isEmpty() && rank(ch) <= rank(opStack.peek())) {
                        String result = solve(opStack, numStack, asPrefix);
                        numStack.push(result);
                    }
                    opStack.push(ch);
                }

            } else if (ch == '(' || ch == ')') {
                if (ch == '(')
                    opStack.push(ch);
                else {
                    while (opStack.peek() != '(') {
                        String result = solve(opStack, numStack, asPrefix);
                        numStack.push(result);
                    }
                    opStack.pop(); // removes '(' from top.
                }

            } else { // it is a number
                numStack.push(ch + "");
            }
        }

        while (!opStack.isEmpty()) {
            String result = solve(opStack, numStack, asPrefix);
            numStack.push(result);
        }

        System.out.println(numStack);
    }

    public static String solve(Stack<Character> opStack, Stack<String> numStack, boolean asPrefix) {
        String val1 = numStack.pop();
        String val2 = numStack.pop();
        char operator = opStack.pop();
        if (asPrefix)
            return operator + val2 + val1;
        else
            return val2 + val1 + operator;
    }

    public static void prefixEval(String str) {
        Stack<Integer> numStack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (!isValidOperator(ch)) { // it is a number
                numStack.push(ch - '0');
            } else { // it is an operator
                int val2 = numStack.pop();
                int val1 = numStack.pop();
                int result = solve_(ch, val2, val1);
                numStack.push(result);
            }
        }

        System.out.println(numStack);
    }

    public static int solve_(char operator, int val2, int val1) {

        switch (operator) {
            case '+':
                return val2 + val1;
            case '-':
                return val2 - val1;
            case '/':
                return val2 / val1;
            case '*':
                return val2 * val1;
            case '%':
                return val2 % val1;
            default: // operator = '^'
                return (int) Math.pow(val2, val1);
        }
    }

    // forloop ko aagey se chla do postfix Evaluation, pichhe se chla do prefix
    // evaluation.
    public static void PostfixEval(String str) {
        Stack<Integer> numStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isValidOperator(ch)) { // it is a number
                numStack.push(ch - '0');
            } else { // it is an operator
                int val2 = numStack.pop();
                int val1 = numStack.pop();
                int result = solve_(ch, val1, val2);
                numStack.push(result);
            }
        }

        System.out.println(numStack);
    }

    // Next Greater on Left: for element i in array, find the "first" greater
    // element that comes on its left. If no array in left(0th idx) or no greater
    // element found, ans is -1 for i. Do the same for all elements. Note: sabse
    // pehla aur i se bada element. resulting element left part mai sabse bada ho ye
    // jaruri nai. e,g {25, 4, 2, 13} : {-1, 25, 4, 25}. See, 2 k liye nextGreater
    // on left is 4 and not 25. becoz 4 pehle aaya.
    // algo: https://drive.google.com/open?id=1P9rqB2rfq0kd_PfOauRO70XKB3rqkNjJ

    public static void nextGreaterLeft(int[] arr) {
        int[] ansArr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                ansArr[i] = -1;
                stack.push(arr[i]);
            } else if (stack.peek() > arr[i]) {
                ansArr[i] = stack.peek();
                stack.push(arr[i]);
            } else if (stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    ansArr[i] = stack.peek();
                } else {
                    ansArr[i] = -1;
                }
                stack.push(arr[i]);
            }
        }

        System.out.println(Arrays.toString(ansArr));
    }

    // VeryGOOD Question: Revise Again.
    // Time: O(N). worst case(when bars are in inc. order) : O(N^2). Space: O(N)
    // FAITH: Find the rectangular area ele "x" can generate. Basically wo konsa bar
    // hai jise maxArea of Rectangle bn skta hai. So find rect area w.r.t each bar
    // and maximum alomg them will be our answer. How to find rect Area for ele "x"?
    // find smaller bar just left to "x" and smaller bar just right to "x". Left aur
    // right k bich jitne
    // bars hai wo sab "x" ka area bnane mai contribute krege, becoz either they are
    // equal to "x" or greater than x. So area of "x" = hist[x] * width.
    // calculate width from left and right idx.
    // How to find Left and right idx? Maintain a stack, jisme har element k niche
    // wala ele uss element ka just left smaller element hoga. or we can say mere se
    // niche wala element mere se small hoga. Stack is in inc. order.
    // rightIdx: if ele daalne jo aaya, is less than the top ele. it can't be pushed
    // in. and this ele is right for the top ele. So top k liye right and left dono
    // mil gaye. resolve the top. and keep resolving untill ele jo dalne aaya hai wo
    // dal jaye.

    public static int maximumHistogramArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < hist.length; i++) {
            if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) { // equal to k conditon k bina bi chalega
                stack.push(i);
            } else {
                while (!stack.isEmpty() && hist[i] < hist[stack.peek()]) {
                    int top = stack.pop();
                    int leftIdx = (stack.isEmpty()) ? -1 : stack.peek();
                    int rightIdx = i;
                    int width = rightIdx - leftIdx - 1;
                    // calc area w.r.t to top element popped. left: smaller value just on left.
                    // right: smaller value just right w.r.t to hist[top]
                    int area = hist[top] * width;
                    maxArea = Math.max(maxArea, area);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int leftIdx = (stack.isEmpty()) ? -1 : stack.peek();
            int rightIdx = hist.length;
            int width = rightIdx - leftIdx - 1;

            int area = hist[top] * width;
            maxArea = Math.max(maxArea, area);
        }
        // System.out.println(maxArea);
        return maxArea;
    }

    // https://leetcode.com/problems/maximal-rectangle/
    // Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
    // containing only 1's.
    // Input:[
    // ["1","0","1","0","0"],
    // ["1","0","1","1","1"],
    // ["1","1","1","1","1"],
    // ["1","0","0","1","0"]];
    // Output: 6

    // Same question DP mai kra hai, Find largest "square area" in given 2D matrix.
    // DP Sol. T: O(R*C) : size of matrix; S: O(R*C)
    // Stack Sol. T: O(m*n). Space : O(C), stack of upto column size is required.

    public static void maximumRectInMatrix(char[][] matrix) {
        int[] ar = new int[matrix[0].length];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                ar[j] = (matrix[i][j] == '0') ? 0 : ar[j] + 1;
            }

            int area = maximumHistogramArea(ar);
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);

    }

    // TODO:
    // 1) is Balanced Bracket Expression? T/F : DONE
    // 2) Min brackets to be removed to make brackets balanced. Hint: recursionBTrck
    // 3) Extra Bracket? T/F
    // 4) longest balanced bracket in String.

    public static boolean isBalancedBracket(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (stack.isEmpty() && isClosingParath(ch)) {
                return false;
            }

            if (isOpeningParanth(ch)) {
                stack.push(ch);
            } else if (isClosingParath(ch)) {

                if (ch == ')' && stack.pop() != '(')
                    return false;
                else if (ch == ']' && stack.pop() != '[')
                    return false;
                else if (ch == '}' && stack.pop() != '{')
                    return false;
            }
        }
        return true;
    }

    public static boolean isOpeningParanth(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isClosingParath(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

}