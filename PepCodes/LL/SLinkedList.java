public class SLinkedList {
    Node head;
    Node tail;
    int size = 0;

    public SLinkedList() {
        head = null;
        tail = null;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        if (head != null) {
            node.next = head;
            head = node;
        } else {
            node = head;
            node = tail;
        }
        size++;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (head != null) {
            tail.next = node;
            tail = node;
        } else {
            node = head;
            node = tail;
        }
        size++;
    }

    public int removeFirst() {
        Node rNode = null;
        if (head != null) {
            if (head == tail) { // only one node in LL
                tail = null;
            }
            rNode = head;
      
            head = head.next;

            size--;
        }
        int data = (rNode == null) ? -1 : rNode.data;
        return data;
    }

    public int removeLast() {
        Node rNode = null;
        if (tail != null) {
            if (size == 1) { // only one node in LL
                head = null;
            }
            rNode = tail;
            tail = getNode(size - 1);
            tail.next = null;

            size--;
        }
        int data = (rNode == null) ? -1 : rNode.data;
        return data;
    }

    public Node getNode(int idx) {
        Node temp = head;
        if (head == null)
            return null;
        if (idx == 0)
            return head;

        while (idx != 0) { // LL size > 1;
            temp = temp.next;
            idx--;
        }
        return temp;
    }

    public void addAt(int idx, int data) {
        Node temp = head;
        Node nNode = new Node(data);

        while (idx != 1) {
            temp = temp.next;
            idx--;
        }

        Node brk = temp.next;
        temp.next = nNode;
        nNode.next = brk;
        size++;
    }

    public Node removeAt(int idx) {
        Node temp = head;

        while (idx != 1) {
            temp = temp.next;
            idx--;
        }

        Node rNode = temp.next;
        Node newNext = rNode.next;
        rNode.next = null;
        temp.next = newNext;
        size--;

        return rNode;
    }

    public int midNode() {
        if (head == null)
            return -1;
        
        Node slow = head;
        Node fast = head;

        while(fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public void display() {
        Node temp = head;
        while(temp !=null) {
            System.out.println("hhhhh");
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public void reversePointer() {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node forw = curr.next;
            curr.next = prev;
            

        }
    }

    public static void main(String[] args) {
        SLinkedList slist = new SLinkedList();
        int[] ar = {1,2,3,4,5,6,7};
        for (int i : ar) {
            slist.addLast(i);
        }
        System.out.println(slist.size);
        slist.display();
        

    }

}
