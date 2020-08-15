import java.lang.annotation.Documented;
import java.util.Arrays;
import java.util.Stack;

public class SNQ {

    public static void main(String[] args) {

        // System.out.println(infixEval("3*(2+5^4)/9 ")); // 8+4*3-9/3^(2-1)
        // System.out.println(infixEval2("8+4*3-9/3^(2-1)"));
        int arr[] = { 1, 3, 2, 4, 8, 6, 5, 9, 1 };
        // nextGreatestOnLeft(arr);
        int[] height = { 2, 5, 5, 5, 4, 4, 4, 5, 3, 1 };

        // System.out.println(maxAreaHistogram(height));
        // char[][] rectMat = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1'
        // }, { '1', '1', '1', '1', '1' },
        // { '1', '0', '0', '1', '0' }, };
        // System.out.println(maxAreaInMatrix(rectMat));

        minStack mStack = new minStack();
        int mStackVals = { 2, 5, 4, 6, 7, 10 };
        for (int i = 0; i < height.length; i++) {
            
        }

    }

    public static int infixEval2(String que) {
        Stack<Integer> numSt = new Stack<>();
        Stack<Character> opSt = new Stack<>();

        for (int i = 0; i < que.length(); i++) {
            char ch = que.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numSt.push(ch - '0');
            } else if (ch == '(') {
                opSt.push(ch);
            } else if (isOperator(ch)) { //
                if (opSt.size() != 0 && priority(opSt.peek()) < priority(ch)) { // add operator when current char
                                                                                // priority > opSt.top
                    opSt.push(ch);
                } else if (opSt.size() != 0) { // prority is opposite
                    while (opSt.size() != 0 && priority(opSt.peek()) > priority(ch) && opSt.peek() != '(') {
                        int val1 = numSt.pop();
                        int val2 = numSt.pop();
                        char rch = opSt.pop();

                        int ans = solve(rch, val2, val1);
                        numSt.push(ans);
                    }
                }
            } else { // ")" encounter
                while (opSt.peek() != '(') {
                    int val1 = numSt.pop();
                    int val2 = numSt.pop();
                    char rch = opSt.pop();

                    int ans = solve(rch, val2, val1);
                    numSt.push(ans);
                }
                opSt.pop(); // pop '(' in the last
            }
            while (!opSt.empty()) { // may be operator Stack is not empty
                System.out.println("jffjf");
                int val1 = numSt.pop();
                int val2 = numSt.pop();
                char rch = opSt.pop();

                int ans = solve(rch, val2, val1);
                numSt.push(ans);
            }

        }
        System.out.println(numSt);
        return numSt.size();
    }

    public static boolean isOperator(char ch) {
        return Arrays.asList('+', '-', '*', '/', '%', '^').contains(ch);
    }

    public static int priority(char ch) {
        if (Arrays.asList('+', '-').contains(ch))
            return 0;
        if (Arrays.asList('*', '/', '%').contains(ch))
            return 1;
        if (ch == '^')
            return 2;

        /**
         * why return -1?? char is either opening/closing brackt or invalid char opning
         * brkt priority is lowest of all but for closing brkt it is highest so why -1
         * for CBrkt? becoz we're handling it separately so -1 for CBrkt kahi use nhi
         * hoga
         */
        return -1;
    }

    public static int solve(char ch, int val2, int val1) {

        switch (ch) {
        case '+':
            return val2 + val1;
        case '-':
            return val2 - val1;
        case '*':
            return val2 * val1;
        case '/':
            return val2 / val1;

        case '%':
            return val2 % val1;
        default:
            return (int) Math.pow(val2, val1);

        }
    }

    public static int infixEval(String str) {
        Stack<Integer> numSt = new Stack<>();
        Stack<Character> opSt = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // op mila toh OPstack mai push (T&C): opStack: Empty OR Not Empty
            // if OpStack empty : directly push else priority sahi honi chahiye toh push
            // karo
            // if priority is not in order: pop and solve jab tk priority order sahi na ho
            // jaye.
            if (isOperator(ch)) {
                if (!opSt.isEmpty()) {
                    if (priority(ch) > priority(opSt.peek())) {
                        opSt.push(ch);
                    } else {
                        while (!opSt.isEmpty() && priority(ch) < priority(opSt.peek())) {
                            int ans = popAndSolve(numSt, opSt);
                            numSt.push(ans);
                        }
                        opSt.push(ch);
                    }
                } else
                    opSt.push(ch);
            } else if (ch == '(')
                opSt.push(ch);
            else if (ch == ')') {
                while (opSt.peek() != '(') {
                    int ans = popAndSolve(numSt, opSt);
                    numSt.push(ans);
                }
                opSt.pop(); // removing '(' from stack
            } else { // upr kahi nhi fasa means ch is a number. push it into numSt
                numSt.push(ch - '0');
            }
        }
        while (!opSt.isEmpty()) {
            int ans = popAndSolve(numSt, opSt);
            numSt.push(ans);
        }
        return numSt.peek();
    }

    public static int popAndSolve(Stack<Integer> numSt, Stack<Character> opSt) {
        char op = opSt.pop();
        int val1 = numSt.pop();
        int val2 = numSt.pop();
        return solve(op, val2, val1);
    }

    public static void nextGreatestOnLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] AnsArr = new int[arr.length];

        stack.push(arr[0]);
        AnsArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currNum = arr[i];
            if (stack.peek() > currNum) {
                AnsArr[i] = stack.peek();
                stack.push(currNum);
            } else {
                while (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty() && stack.peek() > currNum) {
                        AnsArr[i] = stack.peek();
                        stack.push(currNum);
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    stack.push(currNum);
                    AnsArr[i] = -1;
                }
            }
        }
        System.out.println(Arrays.toString(AnsArr));
    }

    public static int maxAreaHistogram(int[] height) {
        Stack<Integer> stack = new Stack<>();
        // (-1) stack empty condition check se bchne k liye
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {

            // height[stack.peek()] >= height[i] equal to stack to optimize krne k liye
            // stack utna hi bnega jitna required hai.
            while (stack.peek() != -1 && height[stack.peek()] >= height[i]) {
                int ht = height[stack.pop()];
                int area = ht * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);

        }
        while (stack.peek() != -1) {
            int ht = height[stack.pop()];
            int area = ht * (height.length - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int maxAreaInMatrix(char[][] mat) {
        int[] arr = new int[mat[0].length];
        int maxArea = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                arr[j] = (mat[i][j] == '0') ? 0 : arr[j] + 1;
            }
            int area = maxAreaHistogram(arr);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    class minStack {
        Stack<Integer> st = new Stack<>();
        int minSf = 0;

        public void push(int num) {
            if (st.isEmpty()) {
                st.push(num);
                minSf = num;
                return;
            }

            if (num > minSf)
                st.push(num);
            else {
                minSf = num;
                int dummy = num + num - minSf;
                st.push(dummy);
            }
        }

        public int top() {
            if (st.isEmpty())
                return -1;

            if (st.peek() > minSf)
                return st.peek();
            else { // peek chhota ho gya => minSf is at top (real value)
                return minSf;
            }

        }

        public int pop() {
            if (st.isEmpty())
                return -1;
            if (st.peek() > minSf)
                return st.pop();
            else { // min ko karo update before returning pop value
                minSf = 2 * minSf - st.peek();
                return minSf;
            }
        }

        public int getMin() {
            if (st.isEmpty())
                return -1;

            return minSf;
        }
    }
}