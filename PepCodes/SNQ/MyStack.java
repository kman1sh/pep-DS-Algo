import java.util.ArrayList;

public class MyStack {

    private int[] st;
    private int idx = -1;

    public MyStack() {
        this.st = new int[10];
    }

    public MyStack(int size) {
        this.st = new int[size];
    }

    public void print() {
        if (idx != -1) {
            System.out.print("[");
            for (int i = idx; i >= 0; i--) {
                System.out.print(st[i] + ", ");
            }
            System.out.println("]");
        }
    }

    public int size() {
        return idx + 1;
    }

    public int top() {
        if (idx == -1) {
            System.err.println("StackIsEmpty");
            return -1;
        }
        return st[idx];
    }

    public boolean isEmpty() {
        return idx == -1;
    }

    public void push(int input) {
        if(idx == st.length) {
            System.err.println("StackOverflow");
            return;
        }
        idx++;
        st[idx] = input;
    }

    public int pop() {
        if(idx == -1) {
            System.out.println("StackIsEmpty");
            return -1;
        }
        int value = st[idx];
        st[idx] = 0;
        idx--;
        return value;
    }
}