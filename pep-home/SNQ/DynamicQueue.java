
public class DynamicQueue extends MyQueue {

    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public void add(int data) {
        // full
        if (size == que.length) {
            int[] newQue = new int[que.length * 2];

            //copying carefully
            for(int i = 0; i < que.length; i++) {
                int idx = (i + start) % que.length;
                newQue[i] = que[idx];
            }
            //setting start end w.r.t to newQue
            start = 0;
            end = que.length; //ek new khali place pe.

            //this.que and super.que means same becoz "que" is only one in our obj.
            this.que = newQue;
        }

        super.add(data);
    }
}