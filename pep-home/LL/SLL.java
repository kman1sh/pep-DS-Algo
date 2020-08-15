
public class SLL {

    private Node head;
    private Node tail;
    int size = 0;

    public SLL() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        size++;
    }

    public void addFirst(Node listHead, Node listTail, Node node) {
        if (listHead == null) {
            listHead = node;
            listTail = node;
        } else {
            node.next = listHead;
            listHead = node;
        }
    }

    public void addFirst(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null) { // no ele in LL yet.
            this.head = node;
            this.tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void addLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public int removeFirst() {
        if (head == null) {
            return -1;
        }

        if (head == tail) {
            tail = null;
        }

        Node temp = head.next;
        int headVal = head.data;
        head.next = null;
        // Node rHead = head; // remove Head
        this.head = temp;
        size--;

        return headVal;
    }

    public Node removeFirstNode() {
        if (head == null)
            return null;

        if (head == tail) {
            tail = null;
        }

        Node rNode = head;
        Node nhead = head.next;
        head.next = null;
        this.head = nhead;
        size--;

        return rNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public int getFirst() {
        if (isEmpty()) {
            return -1;
        }

        return head.data;

    }

    public int getLast() {
        if (isEmpty()) {
            return -1;
        }
        return tail.data;
    }

    // Time: O(N)
    public int removeLast() {
        if (head == null) {
            return -1;
        }
        Node rNode = null;
        if (head == tail) {
            rNode = tail;
            head = null;
            tail = null;
        } else {
            Node newTail = getNode(size - 2);
            newTail.next = null;
            rNode = tail;
            tail = newTail;
        }
        size--;
        return (rNode == null) ? -1 : rNode.data;
    }

    public Node removeLastNode() {
        if (head == null)
            return null;

        Node lastNode = null;
        if (head == tail) {

            lastNode = tail;
            head = null;
            tail = null;
        } else {

            Node newTail = getNode(size - 2);
            lastNode = tail;
            newTail.next = null;
            tail = newTail;
        }
        size--;
        return lastNode;
    }

    public Node getNode(int idx) {
        if (idx >= size || idx < 0) {
            return null;
        }

        Node root = head;
        int i = 0;
        while (i < idx) {

            root = root.next;
            i++;
        }

        return root;
    }

    public Node getNode(Node head, int idx) {
        if (idx >= size || idx < 0) {
            return null;
        }

        Node root = head;
        int i = 0;
        while (i < idx) {

            root = root.next;
            i++;
        }

        return root;
    }

    public void addAt(int idx, int data) {

        if (idx > size || idx < 0) {
            System.out.println("IndexOutOfBound");
            return;
        }

        Node node = null;
        Node newNode = new Node(data);

        if (idx == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            // node at one less than "idx".
            node = getNode(idx - 1);
            Node temp = node.next;
            node.next = newNode;
            newNode.next = temp;
        }

        size++;
    }

    public Node removeAt(int idx) {
        if (idx >= size || idx < 0) {
            System.out.println("IndexOutOfBound");
            return null;
        }

        Node prNode = getNode(idx - 1);
        Node idxNode = prNode.next;
        Node newNext = idxNode.next;

        prNode.next = newNext;

        idxNode.next = null; // break Link.

        size--;
        return idxNode;
    }

    // Optized Algo: rabbit turtle move. O(N/2)
    public Node midNode() {
        if (head == null) { // empty LL
            return null;
        }

        if (head == tail) { // Only 1 ele in LL
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 1 SOLUTION: purey LL ko array mai copy kro, array ko reverse krke LL mai
    // wapis daal do. but this way you need O(N) extra space (array k liye).
    // 2 SOLUTION: No extra Space Required. LL ko array jese maanke, ek point i = 0
    // pe dursa j = last Idx pe rkhlo. Now swap the data and make i++, j-- .
    // How to go to j-- Node ? use getNode() method. Yes! it is costly but only
    // option we have.
    // 3 SOLUTION: using reversePointer() half way to reverse Data Iteratively. Best
    // in Complexity but difficult to manage pointer/reference.

    // 2nd Solution: Time O(N^2) becoz of getNode() fn. Space O(1)
    public void reverseDataItr() {

        Node leftNode = head;
        Node rightNode = getNode(size - 1);

        int i = 0, j = size - 1;
        while (i < j) {

            int temp = leftNode.data;
            leftNode.data = rightNode.data;
            rightNode.data = temp;

            i++;
            j--;

            leftNode = leftNode.next; // i++ Node
            rightNode = getNode(j); // j-- Node
        }
    }

    // Avoid using recursion with LinkedList. No preferable. Go for Iterative way.
    // Reason: Stack get OverFlow when LinkedList is very big: 10^6. During online
    // code submission you will see big LL edge case. So avoid recursion.
    // Time: O(N). Space: O(N) becoz memory stack built hoga of N size.

    Node sNode = null; // swapping node.

    public void reverseDataRec() {
        // this is imp to define sNode here. becoz sNode is just like other properties
        // of class and if i do sNode = head at start then sNode will be null becz head
        // was null at start. Hence, we will get nullpointer exception.
        sNode = head; // swapping node.

        System.out.println(sNode.data); // error

        reverseDataRec(head, 0);
    }

    private void reverseDataRec(Node n, int i) {
        if (n == null)
            return;

        reverseDataRec(n.next, i + 1);
        if (i > ((size - 1) / 2)) {
            int temp = n.data;
            n.data = sNode.data;
            sNode.data = temp;
            sNode = sNode.next;
        }
    }

    // TODO: Revise. Imp Question.
    public void reverseDataItr_Optimize() {
        if (head == null)
            return;

        Node leftHead = head;
        Node midNode = midNode();

        // range: mid + 1 to size.
        Node rightHead = reversePointerItr(midNode.next);

        midNode.next = null; // break the LL after midNode.

        Node lHead = leftHead;
        Node rHead = rightHead;
        while (lHead != null && rHead != null) {
            int temp = lHead.data;
            lHead.data = rHead.data;
            rHead.data = temp;

            lHead = lHead.next;
            rHead = rHead.next;
        }

        rightHead = reversePointerItr(rightHead);
        midNode.next = rightHead;
    }

    public void reversePointerItr() {
        // automatically handle ho gya jab mene future = null initially set kra.
        // if(head == null)
        // return;

        Node past = null;
        Node present = head;
        Node future = null;

        while (present != null) {

            future = present.next; // when present != null, store its future in advance.

            // point prev Node by curNode.next. This will not only start pointing prevNode
            // but also abhi tk k next se link tut jayega. That's why if stored its currNext
            // in futureNode, jispe aagey humko jana hai.
            present.next = past;

            // move all pointer forward
            past = present;
            present = future;
        }

        // present is at null and past is at last ele of orginial LL. So set new head.
        head = past;
    }

    // reverse Pointer from given node to till end.
    public Node reversePointerItr(Node node) {

        Node past = null;
        Node present = node;
        Node future = null;

        while (present != null) {

            future = present.next;
            present.next = past;

            past = present;
            present = future;
        }
        Node newHead = past;
        return newHead;
    }

    // check if LL is palindrome and make the ll as it was orginally, after check.
    public boolean isPali() {
        if (head == null)
            return true; // empty LL is Pali in itself.

        Node leftHead = head;
        Node midNode = midNode();

        // range: mid + 1 to size.
        Node rightHead = reversePointerItr(midNode.next);

        midNode.next = null; // break the LL after midNode.

        Node lHead = leftHead;
        Node rHead = rightHead;
        boolean flag = true;
        while (lHead != null && rHead != null) {

            if (lHead.data != rHead.data) {
                flag = false;
                break;
            }

            lHead = lHead.next;
            rHead = rHead.next;
        }

        rightHead = reversePointerItr(rightHead);
        midNode.next = rightHead;
        return flag;
    }

    /**
     * Reverse Pointer for a rang of LL
     * 
     * @param startIdx is Inclusive
     * @param lastIdx  is exclusive.
     */

    public Node reversePointerItr(Node head, int startIdx, int lastIdx) {
        // automatically handle ho gya jab mene future = null initially set kra.
        if (startIdx < 0 || lastIdx > size || startIdx > lastIdx || startIdx == lastIdx)
            return null;

        Node past = null;
        Node present = getNode(head, startIdx); // startIdx
        Node future = null; // startIdx + 1

        while (startIdx < lastIdx) {

            future = present.next; // store its future in advance.
            present.next = past;

            // move all pointer forward
            past = present;
            present = future;
            startIdx++;
        }
        // present is at future now and past is at lastIdx ele of orginial LL. So set
        // new head to past.
        Node newHead = past;
        return newHead;
        // head = past;
    }

    /**
     * TODO: <br>
     * REVERSION POINTER 2nd METHOD: using removeFirst() and addFirst() methods only
     * Space: O(1). each node at a time either be in original List or new List.
     * Time: O(N) <br>
     * Problem: addFirst() creates new node at "new" memory location. but new memory
     * loc toh create hi nai krna h. node wahi rhega bs pointers reverse krna hai.
     * so modify addFirst() to receive removed Node as it is and add it to first
     * without making new node with "new" keyword, ese node ka memory loc aj bhi
     * purana wala hi rahega. INSHORT: modify addFirst() -> addFirstNode and
     * removeFirst() -> removeFirstNode()
     * 
     */

    // fold and also manage the tail of fold.
    public void fold() {
        Node leftHead = head;
        Node midNode = midNode();
        Node rightHead = midNode.next;

        midNode.next = null;

        // reversing pointer for next half of the List and setting new head.
        rightHead = reversePointerItr(rightHead);

        Node curr1 = leftHead;
        Node curr2 = rightHead;

        Node tempTail = null;

        while (curr1 != null && curr2 != null) {
            Node currNext1 = curr1.next;
            Node currNext2 = curr2.next;

            curr1.next = curr2;
            curr2.next = currNext1;

            tempTail = curr2;

            curr1 = currNext1;
            curr2 = currNext2;
        }

        if (curr1 == null && curr2 == null) {
            this.tail = tempTail;
        } else {
            this.tail = curr1;
        }
    }

    // TODO: Fold using removeFirst()->addLast()-> removeLast()->addLast()

    // unfold and set tail to correct position.
    public void unfold() {
        if (head == null) {
            return;
        }

        // this is tail. storing in advance so that lost na ho jaye
        Node head2 = head.next;

        Node h1 = head;
        Node h2 = head.next;
        Node mid = h1;

        while (h1 != null && h2 != null) {

            h1.next = h2.next;
            h1 = h1.next;

            if (h1 != null) {
                mid = h1;
            }

            h2.next = (h1 != null) ? h1.next : null;
            h2 = h2.next;
        }

        tail = head2;
        head2 = reversePointerItr(head2);
        mid.next = head2;

    }

    /**
     * TODO: unfold using removeFirst() , addFirst() , addLast() fns <br>
     * ALGO Steps: (easy than above unfolding and have same complexity) <br>
     * 1) Imagine breaking folded list into two List. (L1, L2) <br>
     * 2) Call removeFirst on each ele of folded list and add removeNode to L1 , L2
     * alternatively. <br>
     * Note: Use addLast() if you are adding removeNode in L1 and use addFirst() if
     * you are adding removeNode in L2. <br>
     * 3) At last join L1 and L2 and set tail to correct position.
     */

    // public void reversePointerRec() {}

    // TODO: floyd Cylce

    // ============================================================

    // Reverse LL in k-size blocks/chunks
    // using Node only to create List (no SLL list) and doing smiliar to addFirst
    // operation on Nodes.
    public void reverseInBlocks(int blockSize) {
        if (head == null)
            return;

        Node ansListHead = null; // head for resultant list.
        Node ansListTail = null; // head for resultant list.
        int listSize = size;

        while (head != null) {
            int k = blockSize;
            Node nhead = null; // head for block/chunked list.
            Node ntail = null; // head for block/chunked list

            while (k > 0 && head != null) {
                Node rNode = removeFirstNode(); // removes the head of original head and set new head.

                // add the rNode and set the head position correctly.
                if (nhead == null) {
                    nhead = rNode;
                    ntail = rNode;
                } else {
                    rNode.next = nhead;
                    nhead = rNode;
                }
                k--;
            }
            // yaha aana matlb either head == null or k is 0;

            // join this new "k-size reversed" list to ansList.
            if (ansListHead == null) {
                ansListHead = nhead;
                ansListTail = ntail;
            } else {
                ansListTail.next = nhead;
                ansListTail = ntail;
            }
        }
        head = ansListHead;
        tail = ansListTail;
        size = listSize;
    }

    // creating a temp SLL list for k size chunk list and calling addFirst() method.
    public void reverseInBlocks0(int blockSize) {
        if (head == null)
            return;

        Node ansListHead = null; // head for resultant list.
        Node ansListTail = null; // head for resultant list.
        int listSize = size; // store the size as size dec. during removing node.

        while (head != null) {
            int k = blockSize;
            SLL tempList = new SLL();

            while (k > 0 && head != null) {
                Node rNode = removeFirstNode(); // removes the head of original head and set new head.

                // add the rNode and set the head position correctly.
                tempList.addFirst(rNode);
                k--;
            }
            // yaha aana matlb either head == null or k is 0;

            // join this new "k-size reversed" list to ansList.
            if (ansListHead == null) { // ans list is yet empty
                ansListHead = tempList.head;
                ansListTail = tempList.tail;
            } else {
                ansListTail.next = tempList.head;
                ansListTail = tempList.tail;
            }
        }
        head = ansListHead;
        tail = ansListTail;
        size = listSize;
    }

    // =====================================================

    // Segregate odd and even Nodes, return list in the form evens then odds nodes

    // METHOD1: creating two list evenList, oddList and joining them later.
    public void segregateOddEven() {
        if (head == null)
            return;
        SLL evenList = new SLL();
        SLL oddList = new SLL();
        int listSize = this.size;

        while (head != null) {

            Node rNode = removeFirstNode();

            if (rNode.data % 2 == 0)
                evenList.addLast(rNode);
            else
                oddList.addLast(rNode);
        }
        head = evenList.head;
        evenList.tail.next = oddList.head;
        tail = oddList.tail;
        size = listSize;
    }

    // Method2: using 4 node pointer instead of creating two list (evenList,
    // oddList). each pair of pointers will represent head and tail of
    // evenList/oddList. eh, et : evenListHead, evenListTail. Similarly oh, ot.
    public void segregateOddEven1() {
        if (head == null)
            return;

        Node eh = null, et = null, oh = null, ot = null;
        int listSize = this.size;

        // why we are using removeFirst instead of getNode(idx) ?
        // Reason: remveFirst() se node ek tym pe ek hi list m hoga whereas, getNode()
        // se orginal list alive rehegi, hence space complexity will become O(N).
        while (head != null) {

            Node rNode = removeFirstNode();

            if(rNode.data % 2 == 0) {
                // Add rNode to Last of even List. Basically writting addLast() fn.
                if(eh == null) {
                    eh = rNode;
                    et = rNode;
                } else {
                    et.next = rNode;
                    et = et.next;
                }
                
            } else {
                // Add rNode to Last of even List. Basically writting addLast() fn.
                if(oh == null) {
                    oh = rNode;
                    ot = rNode;
                } else {
                    ot.next = rNode;
                    ot = ot.next;
                }
            }
        }

        // Join two lists
        et.next = oh;
        et = ot;

        this.head = eh;
        this.tail = et;
        this.size = listSize;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        Node temp = head;
        while (temp != null) {
            b.append(temp.data);
            temp = temp.next;

            if (temp != null)
                b.append(", ");
        }

        return b.append("]").toString();
    }

}