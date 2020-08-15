import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return ((this == null) ? "null" : this.val + "");
        }
    }

    public static void main(String[] args) {

        int[] arr = { 2, 6, 10, 25, 36, 37, 39, 40, 52, 68, 72 };

        Node root = createBST(arr, 0, arr.length - 1);
        // display(root);

        // System.out.println(findData(root, 25));

        // PredSucc(root, 10);
        // PredSucc(root, 25);
        // PredSucc(root, 36);
        // PredSucc(root, 37);
        // PredSucc(root, 41);

        // int[] arr1 = new int[2];
        // width(root, 0, arr1);
        // System.out.println(arr1[0] + " " + arr1[1]);

        swapElementBST(root);
        swapElementBST02(root);

        System.out.println("swapValues: " + val1 + " " + val2);
    }

    // sorted Array or in other word, in-ordered BST array
    // si: stating index, ei: End index.
    public static Node createBST(int[] arr, int si, int ei) {

        if (si > ei) {
            return null;
        }

        int mid = si + ((ei - si) / 2);

        Node root = new Node(arr[mid]);

        root.left = createBST(arr, si, mid - 1); // si se 'mid-1' tk k array se BST bna k le ao
        root.right = createBST(arr, mid + 1, ei); // ei se 'mid+1' tk k array se BST bna k le ao

        return root;
    }

    public static void display(Node root) {
        if (root == null)
            return;

        String left = ((root.left != null) ? root.left.val : ".") + " <-- ";
        String right = " --> " + ((root.right != null) ? root.right.val : ".");

        System.out.println(left + root.val + right);

        // same thing mere childs, apne children k liye krde.
        display(root.left);
        display(root.right);
    }

    // TODO: find size(), maxHeight() same as BT method. Since we have to travell
    // whole Tree for that, as we did this using recusion in BT, do the same here.

    // BTS : Time log(N) = Height of tree . BT: Time O(N)
    public static boolean findData(Node root, int data) {
        if (root == null)
            return false;

        while (root != null) {

            if (root.val == data)
                return true;
            else if (data < root.val)
                root = root.left;
            else if (data > root.val)
                root = root.right;
        }
        return false;
    }

    // Perfect code.
    public static void PredSucc(Node root, int data) {
        if (root == null)
            return;

        // 4 variable chahiye hi. Actual pred-Succ tabhi set karege jab data tree m mil
        // jayega. otherwise temp variable mai hi pred succ carry karege. agar data not
        // found then pre-Succ null dege
        Node prev = null;
        Node pred = null;
        Node succ = null;
        Node tempSucc = null;

        while (root != null) {

            if (root.val == data) {

                // finding Pred.

                // when (left != null): pred mere left subtree mai hai.
                if (root.left != null) {

                    // go left then go for "right most child" in the subtree.
                    Node curr = root.left;
                    while (curr.right != null) {
                        curr = curr.right;
                    }
                    // curr is at perfect pred.
                    pred = curr;

                } else { // pred mere se uper tha jo mai prev se maintain krra hu.
                    pred = prev; // prev might be pointing null also, agar koi pred possible hi na hua.
                }

                // find successor:

                // (right !=null) : Successor mere right subtree mai hai.
                if (root.right != null) {

                    Node curr = root.right;
                    while (curr.left != null) {
                        curr = curr.left;
                    }

                    // curr is at perfect Successor.
                    succ = curr;

                } else { // succ mere se uper hoga, (undiscovered InOrder Node). maintained in tempSucc.
                    succ = tempSucc;
                }

                break;

            } else if (data < root.val) {
                tempSucc = root; // it might be our succ.
                root = root.left;
            } else if (data > root.val) {
                prev = root; // it might be our pred
                root = root.right;
            }
        }

        System.out.println("Pred=" + pred + " succ= " + succ);
    }

    public static void width(Node root, int length, int[] arr) {
        if (root == null)
            return;

        arr[0] = Math.min(arr[0], length);
        arr[1] = Math.max(arr[1], length);

        width(root.left, length - 1, arr);
        width(root.right, length + 1, arr);

    }

    // TODO: BST k do nodes swap ho gaye hai, hence it is no more BST, find those to
    // swapped node

    public static void swapElementBST(Node node) {
        if (node == null) {
            return;
        }

        int currPtr = -1;
        int prevPtr = Integer.MIN_VALUE;
        int s1 = 0;
        int s2 = 0;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Node curr = node;
        while (!stack.isEmpty()) {

            if (curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            } else { // time to go right if possible and print ME(inOrder).
                Node top = stack.pop();
                System.out.print(top.val + " ");
                prevPtr = currPtr;
                currPtr = top.val;

                if (prevPtr > currPtr) {
                    if (s1 == 0 && s2 == 0) { // 1st encount, prev is more culprit than curr.
                        s1 = prevPtr;
                        s2 = currPtr;
                    } else { // 2nd encounter so curr is culprit
                        s2 = currPtr;
                        break;
                    }
                }

                if (top.right == null) {

                    while (!stack.isEmpty() && top.right == null) {
                        top = stack.pop();
                        System.out.print(top.val + " ");
                        prevPtr = currPtr;
                        currPtr = top.val;

                        if (prevPtr > currPtr) {
                            if (s1 == 0 && s2 == 0) { // 1st encount, prev is more culprit than curr.
                                s1 = prevPtr;
                                s2 = currPtr;
                            } else { // 2nd encounter so curr is culprit
                                s2 = currPtr;
                                break;
                            }
                        }
                    }
                }

                if (stack.isEmpty() && top.right == null) {
                    break;
                }

                // this region means top.right is no more null.
                stack.push(top.right);
                curr = top.right;
            }
        }

        System.out.println();
        System.out.println("swapped element " + s1 + " " + s2);
    }

    static int prev = -1;
    static int val1 = -1;
    static int val2 = -1;

    // recursive
    public static void swapElementBST02(Node node) {

        if (node == null) {
            return;
        }

        swapElementBST02(node.left);

        if (node.val < prev) {
            if (val1 == -1 && val2 == -1) {
                val1 = prev;
                val2 = node.val;
            } else {
                val2 = node.val;
            }
        }

        prev = node.val;

        swapElementBST02(node.right);
    }

    // TODO: isBST
}