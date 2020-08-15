
public class SLL {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null) { // if head or tail = null, LL is empty
            head = node;
            tail = node;
        } else {
            // LL has some elements
            // last m add hone aaya hai upate tail, Head aaj bhi wahi rhega
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        if (head == null) { // if head or tail = null, LL is empty
            head = node;
            tail = node;
        } else {

            // LL has some elements
            // head update hoga, tail aaj bhi wahi rhega.
            node.next = head;
            head = node;
        }

        size++;

    }

    public int removeLast() {
        if (head == null) // no element in List
            return -1;

        // if you reach here -> atleast one ele is there in list.
        int rData = tail.data;
        if (head == tail) { // only one ele in list
            head = null;
            tail = null;
        } else {
            Node newTail = getNode(size - 2); // tail se pehle wala node, ab bnega tail.
            newTail.next = null;
            tail = newTail;
        }
        size--;
        return rData;
    }

    private Node getNode(int idx) {
        if (idx >= size || idx < 0) {
            return null;
        }
        Node tempHead = head;
        while (idx > 0) { // idx =0, loop break.
            tempHead = tempHead.next;
            idx--;
        }
        return tempHead;
    }

    public int removeFirst() {
        if (head == null) // no ele in list
            return -1;

        // if you reach here -> atleast one ele is there in list.
        int rData = head.data;

        if (head == tail) { // only one ele in list
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return rData;

    }

    public void addAt(int idx, int data) {
        if (idx > size || idx < 0) {
            return;
        }

        if (idx == 0)
            addFirst(data);
        else if (idx == size)
            addLast(data);
        else { // kahi bich m node add hone ko aaya

            Node newNode = new Node(data);
            Node prevNode = getNode(idx - 1);

            Node nodeAtIdx = prevNode.next;
            prevNode.next = newNode;
            newNode.next = nodeAtIdx;
            size++;
        }
    }

    public void removeAt(int idx) {
        if (idx < 0 || idx >= size) { // idx is at outOfBound
            return;
        }

        if (idx == 0)
            removeFirst();
        else if (idx == size - 1)
            removeLast();
        else { // kahi bich se node remove hona hai

            Node prevNode = getNode(idx - 1);
            Node nodeAtIdx = prevNode.next;
            prevNode.next = nodeAtIdx.next;

        }
    }

    public int midNode() {
        if (head == null)
            return -1;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    public Node midNode1() {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // reverseDataRec()
    // reverseDateitr()
    // isPalindrome()

    public void fold() {
    
        Node midNode = midNode1();
        Node head2 = midNode.next;
        midNode.next = null;
        Node head1 = head;

        head2 = reverseList(head2);

        while(head1 != null && head2 !=null) {

            Node CN1 = head1.next;
            Node CN2 = head2.next;

            head1.next = head2;
            thead2.next = CN1;
            CN1.next = CN2;

            head2 = CN2;            
            head1 = CN1;
        }


        
    }

    public Node reverseList(Node node) {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }
    

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
    }

    @Override
    public String toString() {
        if (head == null)
            return "[]";

        Node tempHead = head;
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (;;) {
            sb.append(tempHead.data);
            if (tempHead == tail) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',').append(' ');

            tempHead = tempHead.next;
        }
    }

    private class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }

    }
}
