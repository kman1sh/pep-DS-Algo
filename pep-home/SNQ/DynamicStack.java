
public class DynamicStack extends MyStack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    // using getter and setter becoz i want my stack and idx member to be private.
    @Override
    public void push(int data) {
        int oLength = getSt().length;
        if (getIdx() == oLength - 1) {
            int[] newSt = new int[oLength * 2];
            for (int i = 0; i < oLength; i++) {
                newSt[i] = getSt()[i];
            }
            setSt(newSt);
        }
        super.push(data);
    }

}