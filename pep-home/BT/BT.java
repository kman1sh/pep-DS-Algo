import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BT {

    static class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;

        }
    }

    public static void main(String[] args) {

        Integer[] btPreOrdered = { 10, 20, 40, 60, null, null, 70, null, null, 50, 80, null, null, null, 30, 90, null,
                110, 150, null, null, null, 100, 120, null, null, null };

        Integer[] bt01 = { 4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null,
                9, null, null, -1, -4, null, null, null, -2, null, null };

        Integer[] bt02 = { -13, 5, -8, 2, null, null, 6, null, null, 1, null, null, 6, 3, null, null, 9, null, 0, 4,
                null, null, -1, 10, null, null, null };

        // Leetcode: PathSum II
        Integer[] bt03 = { 5, 4, 11, 7, null, null, 2, null, null, null, 8, 13, null, null, 4, 5, null, null, 1, null,
                null };

        Node rootNode = createTree(btPreOrdered);
        // display(rootNode);
        System.out.println(size(rootNode));
        // System.out.println(rootToNodePath(rootNode, 150));

        // System.out.println(LCA(rootNode, 60,40));

        // ===================================
        // diameter_01(rootNode);
        // System.out.println(maxDia);
        // maxDia = 0;
        // diameter_02(rootNode);
        // System.out.println(maxDia);

        // ================================

        leafToLeafMaxSum(rootNode);
        System.out.println("Sum" + maxSum);

        // NodeToNodeMaxSum(rootNode);
        // System.out.println(maxSumN2N);

        // System.out.println(anyNodeToAnyNodeDiameter(rootNode, 80, 110));
        // for (List<Integer> list : ans) {
        // System.out.println(list);
        // }

        // Leetcode 113
        // pathSumII(rootNode, 22, 0, new ArrayList<Integer>());
        // for (List<Integer> list : ans) {
        // System.out.println(list);
        // }

        // System.out.println(pathSumIII(rootNode, 13));
        // System.out.println(temp);
        // System.out.println(count);

        // =========================================

        // ceilFloor(rootNode, 150);
        // String floor = (pair.floor == Integer.MIN_VALUE) ? "NA" : pair.floor + "";
        // String ceil = (pair.ceil == Integer.MAX_VALUE) ? "NA" : pair.ceil + "";
        // System.out.println(floor + " : " + ceil);

        // ========== ALL SOLUTION =============
        // Pair p = new Pair();
        // allSolution(rootNode, 0, 80, 0, p);
        // System.out.println(p);

        // ======== Predecessor - Successor ===========
        // predSucc(rootNode, 80, new predSuccPair());

        // ==============View Set ===============

        // viewSet(rootNode);

        // Traversal Set =============
        // ItrInOrder(rootNode);
    }

    static int i = 0;

    // @param: preOrder array of tree;
    public static Node createTree(Integer[] arr) {
        if (i >= arr.length || arr[i] == null) {
            i++;
            return null;
        }

        Node node = new Node(arr[i]);
        i++;
        node.left = createTree(arr);
        node.right = createTree(arr);

        return node;
    }

    // O(N)
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String left = (node.left == null) ? "." : node.left.data + "";

        String right = (node.right == null) ? "." : node.right.data + "";

        String ans = left + " -> " + node.data + " <- " + right;

        System.out.println(ans);

        // faith that left and right child will also do the same;
        display(node.left);
        display(node.right);
    }

    // O(N)
    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int leftTreeSize = size(node.left);
        int rightTreeSize = size(node.right);

        return leftTreeSize + rightTreeSize + 1;
    }

    static int temp = 0;

    // Maximum height of the tree.
    public static int findMaxHei(Node node) {
        temp++;
        if (node == null) {
            return 0;
        }

        int maxHei = 0;
        int leftHei = findMaxHei(node.left);
        int rightHei = findMaxHei(node.right);

        maxHei = Math.max(leftHei, rightHei) + 1;

        return maxHei;
    }

    // Tells if data is found or not. boolean type.
    public static boolean findData(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        boolean res = false;

        res = res || findData(node.left, data);
        res = res || findData(node.right, data);

        return res;
    }

    // root to data's Node Path. ArrayList reverse bni hai(so it is nodeToRootPath).
    // myAns AL bna k issue solve ho skta hai or linkedList with addFirst()?
    public static ArrayList<Integer> rootToNodePath(Node rootNode, int data) {

        if (rootNode == null) {
            ArrayList<Integer> base = new ArrayList<>();
            return base;
        }

        if (rootNode.data == data) {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(data);
            return base;
        }

        ArrayList<Integer> leftAns = rootToNodePath(rootNode.left, data);
        ArrayList<Integer> rightAns = (leftAns.size() == 0) ? rootToNodePath(rootNode.right, data) : leftAns;

        // now rightAns alway have an answer either becoz recursion call or from leftAns
        if (rightAns.size() != 0) {
            // data mil gya hai, path build karo.
            rightAns.add(rootNode.data);
        }

        return rightAns;
    }

    // Time: O(N), Space: O(N) or O(hei)
    public static int LCA(Node root, int data1, int data2) {

        ArrayList<Integer> path1 = rootToNodePath(root, data1); // node to root path
        ArrayList<Integer> path2 = rootToNodePath(root, data2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        int currCommonNode = -1;

        while (i >= 0 && j >= 0) {

            if (path1.get(i) == path2.get(j)) {
                currCommonNode = path1.get(i);
                i--;
                j--;
            } else {
                break;
            }
        }

        return currCommonNode;
    }

    // TODO: LCA: Time O(N), Space: O(1)

    // The Diameter of a tree(sometimes called the width) is the "number of nodes on
    // the longest path" between TWO ENDS NODES/LEAF.

    /**
     * **NOTE**: When we are COUNTING max numbers of nodes b/w any two leaves it is
     * Diameter/width Problem. <br>
     * 
     * When we are doing sum instead of Counting node, it is leafToLeaf Maxmium sum
     * problem. (next Question). Hence, code is almost same.
     */

    static int maxDia = 0;

    // O(N^2)
    public static void diameter_01(Node root) {
        if (root == null)
            return;

        // left aur right ki height le aao, issme mere tk dia nikle jayega.
        int leftHei = findMaxHei(root.left);
        int rightHei = findMaxHei(root.right);

        int myDia = leftHei + rightHei + 1; // +1 interms of Node. +2 in terms of Edges.
        maxDia = Math.max(maxDia, myDia);

        // now do same for for my childs. becoz jaruri toh nai root se pass hoke milne
        // wala dia hi max length ka ho.
        diameter_01(root.left);
        diameter_01(root.right);

    }

    // exactly findHeight wala kaam hora hai, sirf ek chhoti si calculation bich mai
    // kr rhe hai yaha.
    // O(N)
    public static int diameter_02(Node root) {
        temp++;
        if (root == null) {
            return 0; // 0: interms of Nodes, -1 in terms of Edges
        }

        int leftTreeHei = diameter_02(root.left);
        int rightTreeHei = diameter_02(root.right);

        int myDia = leftTreeHei + rightTreeHei + 1; // +1 interms of Node. +2 in terms of Edges.

        maxDia = Math.max(maxDia, myDia);

        // return maxHei/EdgeLength for this node.
        return Math.max(leftTreeHei, rightTreeHei) + 1;
    }

    // same as Diameter problem instead of counting nodes/edges, now do sum.
    static int maxSum = Integer.MIN_VALUE;

    // TODO: REVISE
    public static int leafToLeafMaxSum(Node node) {
        if (node == null)
            return 0; // -ve infinity return karo if nodes have -ve values.

        int leafToLeftChild_MaxSum = leafToLeafMaxSum(node.left); // left leaf Path whose sum is max
        int leafToRightChild_MaxSum = leafToLeafMaxSum(node.right); // right leaf Path whose sum is max

        int sum = leafToLeftChild_MaxSum + leafToRightChild_MaxSum + node.data;

        // this ensures that dono child present the i.e dono subtrees mai sum leaf to
        // node hai, hence overall sum is leaf to leaf and not leaf to node.
        if (node.left != null && node.right != null) {
            maxSum = Math.max(maxSum, sum); // maxSum tabhi update hoga tab @Sum is leafToLeaf.
        }



        if (node.left == null && node.right == null) {
            return node.data;
        }
        return Math.max(leafToLeftChild_MaxSum, leafToRightChild_MaxSum) + node.data;

        /*
        // mere se (node) pass hone wala max leaf path sum. (yahi to faith mangra hai.)
        // if both sides se answer aaya hai hai (both childs are not null) toh jo max
        // hoga uske sath lg jao. else jo child null hai uske answer k sath lg jao.
        // if (node.left != null && node.right != null)
        // return Math.max(leafToLeftChild_MaxSum, leafToRightChild_MaxSum) + node.data;
        // else if (node.left != null)
        // return leafToLeftChild_MaxSum + node.data;
        // else // if (node.right != null)
        // return leafToRightChild_MaxSum + node.data;
        */
    }

    // AnyNode to AnyNode Max Sum.
    /**
     * Imgine 3 Node: root, leftChild, rightChild. (both of them have subTree (draw
     * subTree as bollon)). <br>
     * CASES TO BE HANDLED: <br>
     * 
     * 1) One ChildAns could be -ve. 2) both Childs Ans could be +ve. 3) I could be
     * -ve. (*this is not neccessary but anyway.) 4) related to pointed (1) : both
     * child could be -ve.
     * 
     * return: mere se start hote hue kitna max sum generate ho skta hai? CASES:
     * <br>
     * 1) I could join any one of my child's answer, ONLY IF at least one of them is
     * +ve: return max(lcAns, rcAns) + me. == max Sum upto ME. <br>
     * 
     * 2) if none of my child answer is +ve. no point of joining them. return: ME
     * only == max Sum upto ME.
     */
    static int maxSumN2N = Integer.MIN_VALUE;

    // O(N)
    public static int NodeToNodeMaxSum(Node node) {
        if (node == null)
            return 0;

        int leftAns = NodeToNodeMaxSum(node.left);
        int rightAns = NodeToNodeMaxSum(node.right);

        // Case (1)
        int tempMaxSum = Math.max(leftAns, rightAns) + node.data;
        // fight with case (2)
        tempMaxSum = Math.max(tempMaxSum, leftAns + rightAns + node.data);
        // fight with case (3). Not required
        // tempMaxSum = Math.max(tempMaxSum, Math.max(leftAns, rightAns));

        // fight with case (4)
        tempMaxSum = Math.max(tempMaxSum, node.data);

        maxSumN2N = Math.max(maxSumN2N, tempMaxSum);

        // mere se start hote hue kitna max sum generate ho skta hai yahi toh faith hai.
        // if both child's Answer is -ve then mere tk ka sum = node.data. isilye return
        // esa kra hai.
        return Math.max((Math.max(leftAns, rightAns) + node.data), node.data);
    }

    // number of nodes in path for node1 to node2. or count edges. Draw a tree you
    // find that this can solved using LCA approach or more specifically
    // rootToNodePath.
    public static int anyNodeToAnyNodeDiameter(Node root, int val1, int val2) {
        if (root == null)
            return 0;

        ArrayList<Integer> list1 = rootToNodePath(root, val1); // list is from val to root.
        ArrayList<Integer> list2 = rootToNodePath(root, val2); // list is from val to root.

        int i = list1.size() - 1;
        int j = list2.size() - 1;
        int commonLenCount = 0; // in terms of nodes start from 0. in terms of edge: -1

        while (i >= 0 && j >= 0) {

            if (list1.get(i) == list2.get(j))
                commonLenCount++;
            else
                break;

            i--;
            j--;
        }

        // +1 : diameter in terms of node count. -2: instead of +1: diameter in tems of
        // Edges
        return (list1.size() + list2.size() - 2 * commonLenCount) + 1;
    }

    // TODO: Graph Diameter (2BFS)

    /**
     * print all the path from root to leaf whose sum is equal to target sum <br>
     * 
     * 1st method (voidType) faith: start with sum zero, and keep adding the node
     * value where you traverse, jis din leaf pe pahucho, check if sum so far is
     * equal to the target or not. if yes, then add this path to your list, else
     * return back look for other path.
     * 
     * NOT SURE* 2nd method (return Type) faith: khud ko target mese subtract krke,
     * faith rkho newTarget ko mere childs achieve krke le ayege.
     *
     * 
     */

    static List<List<Integer>> ans = new ArrayList<>();

    public static void pathSumII(Node root, int target, int sum, ArrayList<Integer> ansList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {

            if (sum + root.data == target) { // leaf + sum == target

                ansList.add(root.data);
                ans.add(new ArrayList<>(ansList));
                ansList.remove(ansList.size() - 1);
            }
            // return even when (leaf + sum != target) you can't go down further in tree.
            return;

        }

        ansList.add(root.data);
        pathSumII(root.left, target, sum + root.data, ansList);
        pathSumII(root.right, target, sum + root.data, ansList);
        ansList.remove(ansList.size() - 1);
    }

    static int count = 0;

    // root ko bolo apne se start ho k har node tk ka sum le aaye. fir leftChild and
    // rightChild ko root maan k same faith lga do.
    // T: O(N) S: O(N)
    // TODO: REVISE
    // my Solution
    public static ArrayList<Integer> pathSumIII(Node node, int target) {
        if (node == null) {
            ArrayList<Integer> base = new ArrayList<>();
            return base;
        }
        temp++; // call counts

        ArrayList<Integer> myAns = new ArrayList<>();

        ArrayList<Integer> leftSumArr = pathSumIII(node.left, target);
        ArrayList<Integer> rightSumArr = pathSumIII(node.right, target);

        for (Integer n : leftSumArr) {
            if (node.data + n == target)
                count++;

            myAns.add(node.data + n);
        }

        for (Integer n : rightSumArr) {
            if (node.data + n == target)
                count++;

            myAns.add(node.data + n);
        }

        if (node.data == target)
            count++;

        myAns.add(node.data);

        return myAns;
    }

    // Optimized
    // public static ArrayList<Integer> pathSumIIII(Node node, int target) {

    // }

    // public static int minCameraCover(Node root) { }

    /**
     * This pair Class can be used to solve multi things at one time. Becoz just to
     * find Ceil FLoor we are going to traverse whole Tree in PreOrder. So all the
     * problems that required Traversal of whole BT just one time, un sabko ek saath
     * hi solve kr skte hai. E.g BT Size, Height, findData //boolean type. etc.
     *
     */
    public static class Pair {
        int size = 0;
        int height = 0;
        boolean find = false;
        Node pred = null;
        Node succ = null;
        Node prev = null;

        int ceil;
        int floor;

        public Pair() {
            this.ceil = Integer.MAX_VALUE;
            this.floor = Integer.MIN_VALUE;
        }

        @Override
        public String toString() {
            return "size: " + this.size + "\n" + "height: " + this.height + "\n" + "findData: " + this.find + "\n"
                    + "ceil: " + ((this.ceil == Integer.MAX_VALUE) ? "NA" : this.ceil) + "\n" + "floor: "
                    + ((this.floor == Integer.MIN_VALUE) ? "NA" : this.floor) + "\n" + "pred: "
                    + ((this.pred == null) ? "null" : this.pred.data) + "\n" + "succ: "
                    + ((this.succ == null) ? "null" : this.succ.data);

        }
    }

    // Since this is BT and not BST ceil-floor value kahi bhi so skta, Hence
    // using Recursion or can use iterative preOrder traversing.

    static Pair pair = new Pair();

    public static void ceilFloor(Node root, int data) {
        if (root == null) {
            return;
        }

        // might be a floor
        if (root.data < data) {
            pair.floor = Math.max(pair.floor, root.data);
        } else if (root.data > data) { // might be a ceil
            pair.ceil = Math.min(pair.ceil, root.data);
        }

        ceilFloor(root.left, data);
        ceilFloor(root.right, data);
    }

    // check if data exist, find ceil floor for data, Tree Size, MaxHeight of BT,
    // PredSucc (PredSucc: T O(N), Space : O(1) )
    public static void allSolution(Node root, int level, int data, int size, Pair pair) {
        if (root == null)
            return;

        // PreOrderWork
        pair.size++; // har node ek baar visit krne wale so har bar size++;
        pair.height = Math.max(pair.height, level);
        pair.find = pair.find || (root.data == data);

        if (root.data < data) {
            pair.floor = Math.max(pair.floor, root.data);
        } else if (root.data > data) { // might be a ceil
            pair.ceil = Math.min(pair.ceil, root.data);
        }

        // PredSucc: in PreOrder,
        // TODO: *REMEMBER* Agar InOrder puchhe toh ye code left, right call k bich m
        // daal do. Agar PostOrder Puchhe toh left, right call k baad daldo.
        if (root.data == data && pair.pred == null) {
            pair.pred = pair.prev;
        } else if (pair.pred != null && pair.succ == null) { // or jab prev "data" pe hoga. current mera succ pe hoga.
            pair.succ = root;
        }
        pair.prev = root;

        allSolution(root.left, level + 1, data, size, pair);
        allSolution(root.right, level + 1, data, size, pair);
    }

    static class predSuccPair {
        Node prev = null;
        Node pred = null;
        Node succ = null;

        @Override
        public String toString() {
            return "pred: " + ((this.pred == null) ? "null" : this.pred.data) + "\n" + "succ: "
                    + ((this.succ == null) ? "null" : this.succ.data);
        }
    }

    // PredSucc using iterative way.(using stack)
    // O(N): Time, O(Height): space (stack can max out upto Tree height);
    public static void predSucc(Node root, int data, predSuccPair pair) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null) {

            // we are standing at successor and pred is already set.
            if (pair.pred != null) {
                pair.succ = curr;
                break;
            } else if (curr.data == data) {
                pair.pred = pair.prev; // pred is no more null.
            } else {
                pair.prev = curr;
            }

            if (curr.left != null) {

                stack.push(curr);
                curr = curr.left;

            } else if (curr.right != null) {
                curr = curr.right;
            } else {

                while (!stack.isEmpty() && stack.peek().right == null) {
                    stack.pop();
                }

                if (!stack.isEmpty())
                    curr = stack.pop().right;
                else
                    curr = null;
            }

        }
        System.out.println(pair);
    }

    // view Set

    public static void viewSet(Node root) {

        lineWiseLvlOrder(root);
        leftView(root);
        rightView(root);
        topView(root);
        verticalOrderPrint(root);
        verticalOrderPrint_02(root);
        verticalSum(root);
        bottomView(root);
        boundaryTraversal(root);

    }

    public static void lineWiseLvlOrder(Node root) {
        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn.
        LinkedList<Node> que = new LinkedList<>();
        int level = 0;

        que.addLast(root);

        while (!que.isEmpty()) {
            int size = que.size();
            System.out.print("Level " + level + " => ");
            while (size-- > 0) {
                Node rNode = que.removeFirst();

                System.out.print(rNode.data + " ");

                if (rNode.left != null) {
                    que.addLast(rNode.left);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                }
            }

            System.out.println();
            level++;
        }

        System.out.println();
        System.out.println();
    }

    public static void leftView(Node root) {
        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);

        System.out.print("LeftView: ");

        while (!que.isEmpty()) {

            // agr yha aya toh que empty to nai hai.2ndly yha ana matlb new lvl ka start.
            // 3rd, yha sirf que ka first element left view m dikhega & sirf last ele in
            // que, right view se dikhega. (but for rightView we'll do something else)

            System.out.print(que.getFirst().data + " ");

            int size = que.size();
            while (size-- > 0) {
                Node rNode = que.removeFirst();

                if (rNode.left != null) {
                    que.addLast(rNode.left);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                }
            }
        }

        System.out.println();
        System.out.println();
    }

    // for a lvl, jo sabse pehle "ADD" hoga wo left view mai ayega, jo sabse last m
    // "REMOVE" hoga wo rightView mai ayega.
    public static void rightView(Node root) {
        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn.
        LinkedList<Node> que = new LinkedList<>();

        que.addLast(root);

        System.out.print("rightView: ");
        while (!que.isEmpty()) {

            // System.out.print(que.getLast().data + " "); //this is one way

            int size = que.size();
            Node rightViewEle = null;

            while (size-- > 0) {

                Node rNode = que.removeFirst();
                rightViewEle = rNode; // jab curr lvl ka last ele remove hoga, rightViewEle sahi set hojayega
                if (rNode.left != null) {
                    que.addLast(rNode.left);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                }
            }
            // rightViewEle can't be null here. 100% sure.
            System.out.print(rightViewEle.data + " "); // this is 2nd way to print rightView.
        }
        System.out.println();
        System.out.println();
    }

    // leftView + rightView = topView but Node that, jis lvl pe sirf ek hi element
    // hai wo element left and right dono view mai ayega. e.g: root node or imagine
    // a leaf node (jo apne lvl pe iklauta hai). So avoid this duplicacy of ele.

    public static void topView(Node root) {
        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn.
        LinkedList<Node> que = new LinkedList<>();

        que.addLast(root);

        System.out.print("TopView: ");
        while (!que.isEmpty()) {

            System.out.print(que.getFirst().data + " ");

            int count = 0; // jis lvl pe element count is > 1, usi ka rightView ele Consider karege.
            Node rightViewNode = null;

            int size = que.size();
            while (size-- > 0) {
                count++;

                Node rNode = que.removeFirst();
                rightViewNode = rNode;

                if (rNode.left != null) {
                    que.addLast(rNode.left);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                }
            }

            if (count > 1)
                System.out.print(rightViewNode.data + " ");
        }

        System.out.println();
        System.out.println();
    }

    // que(node) and queInt(id) ka pair LL lena aur single-single 2 LL, same thing.
    /**
     * Imagine dono que ek hi hai, aur hum root-0 (i.e root at 0 id vertical order)
     * ka pair que m daalre hai. Now imagine vertical order, mai jis vertical
     * jaunga, mera left child mere se -1 aur right child +1 vertical order mai
     * jayega.
     */

    public static void verticalOrderPrint(Node root) {
        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn.
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> queInt = new LinkedList<>();

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        // min max to get min amd max id. so that pta chal ske itane veritcal view hai.
        int min = 0;
        int max = 0;
        que.addLast(root);
        queInt.addLast(0);

        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                Node rNode = que.removeFirst();
                int verticalId = queInt.removeFirst();

                min = Math.min(min, verticalId);
                max = Math.max(max, verticalId);

                if (!hm.containsKey(verticalId)) { // first tym key aaya hai, instantiate corresponding AL first
                    hm.put(verticalId, new ArrayList<>());
                }

                // add the node val to corresponding verticalId(key).
                hm.get(verticalId).add(rNode.data);

                if (rNode.left != null) {
                    que.addLast(rNode.left);
                    queInt.addLast(verticalId - 1);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                    queInt.addLast(verticalId + 1);
                }
            }
        }

        System.out.println("VerticalView: ");
        for (int i = min; i <= max; i++) {
            System.out.println(hm.get(i));
        }
        System.out.println();
    }

    // without hashmap => more optimized
    public static void verticalOrderPrint_02(Node root) {

        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn.
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> queInt = new LinkedList<>();

        // finding width of my Tree in [min, max] when 0 being my root.
        int[] widthAr = new int[2];
        width(root, 0, widthAr);
        int widthLen = widthAr[1] - widthAr[0] + 1;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] map = new ArrayList[widthLen];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        // zeroId : where my root with Lie in map. (-ve of min Width => widthAr[0])
        int zerothId = -widthAr[0]; // maping idx for root node.

        que.addLast(root);
        queInt.addLast(zerothId);

        while (!que.isEmpty()) {

            int size = que.size();

            while (size-- > 0) {
                Node rNode = que.removeFirst();
                int verticalId = queInt.removeFirst();

                map[verticalId].add(rNode.data);

                if (rNode.left != null) {
                    que.addLast(rNode.left);
                    queInt.addLast(verticalId - 1);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                    queInt.addLast(verticalId + 1);
                }
            }
        }

        System.out.println("VerticalView_02: ");
        for (ArrayList<Integer> arrayList : map) {
            System.out.println(arrayList);
        }
        System.out.println();
    }

    // arr[] = [min, max] : leftMost length, rightMost length, when root being at 0.
    public static void width(Node root, int length, int[] arr) {
        if (root == null)
            return;

        arr[0] = Math.min(arr[0], length);
        arr[1] = Math.max(arr[1], length);

        width(root.left, length - 1, arr);
        width(root.right, length + 1, arr);

    }

    // same as above, but instead of maintaining each vertical ele(we were using
    // ArrayList of Array (2D)), we do sum on the spot, so 1D array is sufficient.
    public static void verticalSum(Node root) {
        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn.
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> queInt = new LinkedList<>();

        // finding width of my Tree in [min, max] when 0 being my root.
        int[] widthAr = new int[2];
        width(root, 0, widthAr);
        int widthLen = widthAr[1] - widthAr[0] + 1;

        int[] map = new int[widthLen]; // storing sum of each vertical view this time

        // zeroId : where my root with Lie in map. (-ve of min Width => widthAr[0])
        int zerothId = -widthAr[0]; // maping idx for root node.

        que.addLast(root);
        queInt.addLast(zerothId);

        while (!que.isEmpty()) {

            int size = que.size();

            while (size-- > 0) {
                Node rNode = que.removeFirst();
                int verticalId = queInt.removeFirst();

                map[verticalId] += rNode.data;

                if (rNode.left != null) {
                    que.addLast(rNode.left);
                    queInt.addLast(verticalId - 1);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                    queInt.addLast(verticalId + 1);
                }
            }
        }

        System.out.println("VerticalViewSum: " + Arrays.toString(map));
        System.out.println();
    }

    // 1st solution: har ek verticalOrderView ka last node == bottomView
    // 2nd Sol: verticalOrderView mujhe har vertical order k liye list deta hai,
    // but hume list ki jarurt thodi hai, we just want last element from each list.
    // So instead of list, har vertical order k liye, corresponding verticalId pe
    // har bar value update krte rho. and in the end, har verticalId apni last
    // value(bottom) ko store krke baitha hoga.

    public static void bottomView(Node root) {
        if (root == null)
            return;

        // use LL as Que. becoz it has removeFirst(), addLast(), getFirst() fn.
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> queInt = new LinkedList<>();

        // finding width of my Tree in [min, max] when 0 being my root.
        int[] widthAr = new int[2];
        width(root, 0, widthAr);
        int widthLen = widthAr[1] - widthAr[0] + 1;

        int[] map = new int[widthLen];

        // zeroId : where my root with Lie in map. (-ve of min Width => widthAr[0])
        int zerothId = -widthAr[0]; // maping idx for root node.

        que.addLast(root);
        queInt.addLast(zerothId);

        while (!que.isEmpty()) {

            int size = que.size();

            while (size-- > 0) {
                Node rNode = que.removeFirst();
                int verticalId = queInt.removeFirst();

                map[verticalId] = rNode.data; // updating map[i] each time instead of having a full Al here.

                if (rNode.left != null) {
                    que.addLast(rNode.left);
                    queInt.addLast(verticalId - 1);
                }

                if (rNode.right != null) {
                    que.addLast(rNode.right);
                    queInt.addLast(verticalId + 1);
                }
            }
        }

        System.out.println("bottomView: " + Arrays.toString(map));
        System.out.println();
    }

    public static void boundaryTraversal(Node root) {
        if (root == null)
            return;

        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> queInt = new LinkedList<>();

        ArrayList<Integer> leftViewEleList = new ArrayList<>();
        ArrayList<Integer> rightViewEleList = new ArrayList<>();

        int[] widthArray = new int[2]; // interms of [min, max]. farest left & right node can go when root being at 0.
        width(root, 0, widthArray);
        int widthLen = widthArray[1] - widthArray[0] + 1; // actual length on +ve scale.

        int[] bottomViewEleList = new int[widthLen]; // this much will be the verticalOrders.

        int rootId = -widthArray[0]; // mapping rootId on +ve scale Since, we don't have -ve idx in Array.

        que.addLast(root);
        queInt.add(rootId);

        while (!que.isEmpty()) {

            leftViewEleList.add(que.getFirst().data);

            Node rightViewEle = null;
            int count = 0; // avoid duplicacy from right & left view when there is only 1 ele at that level
            int size = que.size();
            while (size-- > 0) {
                count++;
                Node rNode = que.removeFirst();
                rightViewEle = rNode;

                Integer verticalId = queInt.removeFirst();
                bottomViewEleList[verticalId] = rNode.data;

                if (rNode.left != null) {
                    que.add(rNode.left);
                    queInt.add(verticalId - 1);
                }

                if (rNode.right != null) {
                    que.add(rNode.right);
                    queInt.add(verticalId + 1);
                }
            }

            if (count > 1) {
                // no chance of rightViewEle being a null. so (.data) will not give error.
                rightViewEleList.add(rightViewEle.data);
            }

        }

        // Printing Rule.
        // 1. leftView[0 to lastIdx -1] becoz lastIdx ele bottom m bhi hoga & bottomView
        // start from here.
        // 2. bottomView[0 to lastIdx - 1] becoz lastIdx ele rightView m bhi hoga &
        // rightView start from here.
        // 3. rightView[lastIdx to 1] becoz 0th idx ele leftView m bhi hoga, jisko humne
        // already print kr liya hai. (Note: rightView printed in reverse order)

        System.out.println(leftViewEleList);
        System.out.println(rightViewEleList);
        System.out.println(Arrays.toString(bottomViewEleList));

        System.out.print("Boundary Traversal: ");

        for (int i = 0; i < leftViewEleList.size() - 1; i++) {
            System.out.print(leftViewEleList.get(i) + " ");
        }

        for (int i = 0; i < bottomViewEleList.length - 1; i++) {
            System.out.print(bottomViewEleList[i] + " ");
        }

        for (int i = rightViewEleList.size() - 1; i >= 1; i--) {
            System.out.println(rightViewEleList.get(i) + " ");
        }

        System.out.println();
    }

    public static Node removeAllLeaf(Node node) {

        if (node == null)
            return null;

        // leaf node
        if (node.left == null && node.right == null)
            return null;

        node.left = removeAllLeaf(node.left);
        node.right = removeAllLeaf(node.right);

        return node;
    }

    // Traverssal Set Morris(Pre, In). itera(pre,in,post)

    /**
     * Morris Traversal: In-Order <br>
     * Create a Stack, <br>
     * Push root in the Stack <br>
     * 1) if my left != null, keep going left and keep pushing ele in stack. <br>
     * 2) OR if my left == null,now we go for right SUBTREE of me. but before that,
     * Since left & right k bich, inOrder m, main milunga and i m at the top of
     * stack. So pop and print me, since you just got an inOrder element. and then
     * go my right. <br>
     * 
     * GOING FOR RIGHT, when right !=null <br>
     * if left == null, go for right child and then most left of it, till a leaf
     * found and keep pushing in stack becoz that will we the next ele found in
     * InOrder.
     * 
     * When right == null <br>
     * pop the top and print. and look for newTop element's right subtree.
     * 
     * Note: Main (on the top of stack) aur mere se niche element stack m isiliye
     * hai kyuki unka abhi right visit/check nai hua hai. Now right ho bhi stkta hai
     * aur nai bhi.<br>
     * agr right nai hai toh sidha wo pop and print honge otherwise currPointer ko
     * right pe bhej k left chalte jayege and is path k ele ko stack mai dalte
     * jayege.
     * 
     * 
     */

    public static void ItrInOrder(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Node curr = node;
        while (!stack.isEmpty()) {

            if (curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            } else { // time to go right if possible and print ME(inOrder).
                Node top = stack.pop();
                System.out.print(top.data + " ");

                if (top.right == null) {

                    while (!stack.isEmpty() && top.right == null) {
                        top = stack.pop();
                        System.out.print(top.data + " ");
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
    }

}