
public class MyStack {

    private int[] st;
    private int idx = -1;

    public MyStack() {
        this.st = new int[10];
    }

    public MyStack(int size) {
        this.st = new int[size];
    }

    public int size() {
        return idx + 1;
    }


    public int getIdx() {
        return idx;
    }
    public int[] getSt() {
        return st;
    }
    public void setSt(int[] st) {
        this.st = st;
    }

    public void push(int value) {
        // if stack is already full
        if (idx == st.length - 1) {
            System.out.println("StackOverflow");
            return;
        }

        st[++idx] = value;
    }

    public int pop() {
        // stack empty
        if (isEmpty()) {
            System.out.println("StackEmpty");
            return -1;
        }
        int rval = st[idx--];
        return rval;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("StackEmpty");
            return -1;
        }
        return this.st[idx];
    }

    public boolean isEmpty() {
        return this.idx == -1;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = idx;; i--) {
            b.append(st[i]);
            if (i == 0) {
                return b.append("]").toString();
            }
            b.append(", ");
        }
    }

    // public void print() {
    // System.out.print("[");
    // for (int i = idx; i >= 0; i--) {
    // System.out.print(st[i]);
    // if(i == 0) {
    // return;
    // }
    // System.out.print(", ");

    // }
    // System.out.print("]");
    // System.out.println();
    // }

}