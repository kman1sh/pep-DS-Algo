public class MyQueue {

    private int[] que;
    private int start = 0;
    private int end = 0;
    private int size = 0;

    public MyQueue() {
        this.que = new int[10];
    }

    public MyQueue(int size) {
        this.que = new int[size];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("QueueIsEmpty");
            return -1;
        }

        int value = que[start];
        size--;
        start = (start + 1) % que.length;
        return value;
    }

    public void push(int input) {
        if (size == que.length) {
            System.err.println("QueueOverflow");
            return;
        }

        que[end] = input;
        size++;
        end = (end + 1) % que.length;
    }

    public void print() {
        System.out.print("[");

        for (int i = 0; i < size; i++) {
            int idx = (start + i) % que.length;
            System.out.print(que[idx] + ", ");
        }
        System.out.println("]");
    }

    public int front() {
        return que[start];
    }

}