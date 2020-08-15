import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
            return;
        }

        if (val > min) {
            stack.push(val);
        } else { // new minimum is found.
            int oldMin = min;
            int encodedVal = 2 * val - oldMin; // y = 2*X - min && Y < X
            stack.push(encodedVal);
            min = val;
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            System.out.println("StackIsEmpty");
            return -1;
        }
        int rEle = stack.pop();
        // encoded ele is popped Out;
        if (rEle < min) {
            int orginalVal = min;

            // update min before returning.
            int prMin = 2 * min - rEle;
            min = prMin;
            return orginalVal;
        } else { // normal ele is popped out.
            return rEle;
        }
    }
    
    public int peek() {
        if(stack.isEmpty()) {
            System.out.println("StackIsEmpty");
            return -1;
        }
        if()
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty())
            return -1;
        return min;
    }

}