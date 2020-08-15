public class Client {
    public static void main(String[] args) {
        // MyStack stack = new MyStack();

        // stack.push(10);
        // stack.push(15);
        // stack.push(25);
        // stack.print();

        MyQueue queue = new MyQueue();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.print();
    }
}