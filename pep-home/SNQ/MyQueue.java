
public class MyQueue {
    int[] que;

    int start = 0;
    int end = 0;
    int size = 0;

    public MyQueue() {
        this.que = new int[10];
    }

    public MyQueue(int size) {
        this.que = new int[size];
    }

    public void add(int data) {
        // full
        if (size == que.length) {
            System.out.println("QueueIsFull");
            return;
        }

        this.que[end] = data;

        this.end = (end + 1) % que.length;
        this.size++;
    }

    // remove and retrieve head element
    public int poll() {
        // Empty
        if (isEmpty()) {
            System.out.println("QueueIsEmpty");
            return -1;
        }

        int rEle = this.que[start];

        this.start = (start + 1) % que.length;
        this.size--;

        return rEle;
    }

    public int peek() {
        // Empty
        if (isEmpty()) {
            System.out.println("QueueIsEmpty");
            return -1;
        }
        return this.que[start];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        // Empty
        if (this.size == 0) {
            return "[ ]";
        }
        StringBuilder b = new StringBuilder();
        b.append("[");

        for (int i = start;; i++) {
            int idx = i % que.length;
            b.append(que[idx]);
            // if it is last element
            if (i == start + size - 1) {
                return b.append("]").toString();
            }
            b.append(", ");
        }

    }

}