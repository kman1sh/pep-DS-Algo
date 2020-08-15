import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GT {

    public static class Node {
        private int data;
        private ArrayList<Node> childs;

        public Node(int data) {
            this.data = data;
            childs = new ArrayList<>();
        }

    }

    public static void main(String[] args) {
        Integer[] gtPreOrder = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90,
                null, null, 40, 100, null, null, null };

        Integer[] isSymmAr = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, 105, null, null, null };

        Integer[] gtPreOrderMirror = { 10, 40, 100, null, null, 30, 90, null, 80, 120, null, 110, null, null, 70, null,
                null, 20, 60, null, 50, null, null, null };

        // Node root = createGT(gtPreOrder); //recursive
        Node root = createGTItr(gtPreOrder);
        display(root);

        // System.out.println("Tree Height: " + height(root));
        // System.out.println("size: " + size(root));

        // System.out.println(find(root, 100));
        // // =========================
        // ArrayList<Node> nodePathArray = nodeToRootPath(root, 80);

        // for (Node node : nodePathArray) {
        // System.out.print(node.data + " ");
        // }
        // System.out.println();
        // // ============================

        // // LCA(root, 70, 120);

        // // kaway(root, null, 1); // avoid is used for kfar(), no use in away context.
        // System.out.println("-----------------");
        // // kfar(root, 40, 0);

        // levelOrderLineWise(root);

        // // ====================
        // System.out.println(isSymmetric(root));

        // // =====================
        // System.out.println(isMirror(createGT(gtPreOrder),
        // createGTItr(gtPreOrderMirror)));

        // zigzagPath(root);
        // zigzagPath02(root);

        // linearizeTree(root);
        // display(root);

        // linearizeTreeAndReturnTail(root);
        // display(root);

        //=====================================
        // Node removedLeafRoot = removeAllLeaf(root);
        // display(removedLeafRoot);

        removeAllLeaf02(root);
        display(root);


    }

    public static int size(Node root) {
        // no base case required

        int count = 0;

        for (Node child : root.childs) {
            count += size(child);
        }

        count = count + 1; // +1 mere naam ka.

        return count;
    }

    // max Height of the GT.: interms of node, edge k terms k liye, maxHei = -1
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int maxHei = -1;
        for (Node childNode : root.childs) {
            maxHei = Math.max(maxHei, height(childNode));
        }

        maxHei = maxHei + 1; // +1 mere naam ka.

        return maxHei;
    }

    // RecursionMethod
    static int idx = 0;

    public static Node createGT(Integer[] arr) {

        if (arr[idx] == null) {
            return null;
        }

        Node nNode = new Node(arr[idx]);
        idx++;

        while (idx < arr.length && arr[idx] != null) {
            Node child = createGT(arr);
            nNode.childs.add(child);
            idx++;
        }

        return nNode;
    }

    // iterative (using stack)
    public static Node createGTItr(Integer[] arr) {
        Stack<Node> stack = new Stack<>();

        int idx = 0;

        while (idx < arr.length - 1) {

            if (arr[idx] != null) {
                stack.push(new Node(arr[idx]));
            } else {
                Node rn = stack.pop();
                Node pNode = stack.peek(); // parentNode for removedNode.
                pNode.childs.add(rn);
            }

            idx++;
        }

        return stack.pop();
    }

    public static void display(Node root) {

        if (root == null)
            return;

        String childList = "";
        for (Node child : root.childs) {
            childList += child.data + " ";
        }

        System.out.println(root.data + " => " + childList);

        for (Node child : root.childs) {
            display(child);
        }
    }

    public static boolean find(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        boolean res = false;

        for (int i = 0; i < root.childs.size() && !res; i++) {
            Node childNode = root.childs.get(i);
            res = res || find(childNode, data);
        }

        return res;
    }

    // Return list of Node of the path.
    public static ArrayList<Node> nodeToRootPath(Node root, int data) {
        if (root == null || root.data == data) {
            ArrayList<Node> base = new ArrayList<>();

            if (root.data == data) {
                base.add(root);
            }
            return base;
        }

        boolean isFound = false;
        ArrayList<Node> ansPath = new ArrayList<>();

        for (Node childNode : root.childs) {
            ArrayList<Node> recAns = nodeToRootPath(childNode, data);

            if (recAns.size() != 0) {

                isFound = true; // one path found.

                for (Node n : recAns) {
                    ansPath.add(n);
                }
                ansPath.add(root);
            }

            if (isFound) // ek path mil gya, so don't search further, just return
                break;
        }
        return ansPath;
    }

    public static void LCA(Node node, int data1, int data2) {
        if (node == null)
            return;

        ArrayList<Node> list1 = nodeToRootPath(node, data1);
        ArrayList<Node> list2 = nodeToRootPath(node, data2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;
        int lca = 0;
        while (i >= 0 && j >= 0) {

            if (list1.get(i) == list2.get(j)) {
                lca = list1.get(i).data;
            } else {
                break;
            }

            i--;
            j--;
        }

        System.out.println("LCA Node Value: " + lca);

    }

    // given "node" se k distance pe (niche k tarf) milne wale ele print krdo.
    // k basically represents "tree level" **
    // avoid is used for kfar(), no use in away context
    public static void kaway(Node node, Node avoid, int k) {
        if (node == null || node == avoid) {
            return;
        }

        // mai k-away wale node pe khada hu
        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        for (Node child : node.childs) {
            kaway(child, avoid, k - 1);
        }
    }

    public static void kfar(Node root, int data, int k) {

        ArrayList<Node> nodePathArray = nodeToRootPath(root, data);
        Node avoid = null;
        for (Node node : nodePathArray) {
            kaway(node, avoid, k);
            k = k - 1;
            avoid = node;
        }
    }

    public static void levelOrderLineWise(Node node) {
        LinkedList<Node> que = new LinkedList<>();
        int lvl = 0;

        que.addLast(node);

        while (!que.isEmpty()) {
            int size = que.size();

            System.out.print("Level " + lvl + " => ");
            while (size-- > 0) {
                Node rn = que.removeFirst();
                System.out.print(rn.data + " ");

                for (Node childNode : rn.childs) {
                    que.addLast(childNode);
                }
            }
            lvl++;
            System.out.println();
        }
    }

    // TODO: leftView, RightView
    // Note: VerticalView Possible nai hai.kyuki number of child > 2. so konsa child
    // kis vertical order view m ayega kese pta chalega.
    // Similarly BottomView bhi possible nai hai.

    public static boolean isSymmetric_(Node node1, Node node2) {
        // selfMirror ki condition
        // if(node1.childs.size() != node2.childs.size() || node1.data != node2.data)
        // return false;

        // Structure Symmetry call.
        if (node1.childs.size() != node2.childs.size())
            return false;

        // just change terminating condition to traverse whole tree instead of just upto
        // mid (i <=j), this will become isMirror()
        for (int i = 0, j = node2.childs.size() - 1; i <= j; i++, j--) {
            Node child1 = node1.childs.get(i);
            Node child2 = node2.childs.get(j);

            boolean res = isSymmetric_(child1, child2);
            if (!res)
                return false;

            // else continue till you get false or for loop ends.
        }

        return true;
    }

    public static boolean isSymmetric(Node node) {
        return isSymmetric_(node, node);
    }

    // check if two trees are structurelly and datawise mirror or not.
    public static boolean isMirror(Node node1, Node node2) {

        // Structure Symmetry && dataWise same.
        if (node1.childs.size() != node2.childs.size() || node1.data != node2.data) {
            return false;
        }

        // yaha ane ka mtlb dono nodes k childs ka size same hai.
        // traverse whole child of node1 and node2 instead of just checking till mid.
        for (int i = 0, j = node2.childs.size() - 1; j >= 0; i++, j--) {
            Node child1 = node1.childs.get(i);
            Node child2 = node2.childs.get(j);

            boolean res = isMirror(child1, child2);
            if (!res)
                return false;

            // else continue till you get false or for loop ends.
        }

        return true;
    }

    // using proper BFS Time: O(N^2) Space: O(N)
    public static void zigzagPath(Node root) {
        if (root == null) {
            return;
        }

        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> queInt = new LinkedList<>();
        que.addLast(root);

        int lvl = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {

                Node rn = que.removeFirst();
                queInt.addLast(rn.data);

                for (Node child : rn.childs) {
                    que.addLast(child);
                }

            }
            printList(queInt, lvl);

            lvl++;

        }
    }

    public static void printList(LinkedList<Integer> list, int lvl) {
        if (lvl % 2 == 0) {
            // print forward
            while (!list.isEmpty()) {
                System.out.print(list.removeFirst() + " ");
            }
        } else {
            // print backwardx
            while (!list.isEmpty()) {
                System.out.print(list.removeLast() + " ");
            }
        }
        System.out.println();
    }

    // zigzag Path using 2stack approach:
    // Time O(N) space: O(N) - for GT ,O(2^h) - for BT
    // https://drive.google.com/open?id=1GcRZXD7eY011O6j6SOfI8Kx2tXHGnN1y
    public static void zigzagPath02(Node node) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        int lvl = 0;

        s1.push(node);

        while (!s1.isEmpty()) {

            int size = s1.size();

            while (size-- > 0) {

                Node rn = s1.pop();
                System.out.print(rn.data + " ");

                if (lvl % 2 == 0) { // push child direction "--->"
                    for (Node child : rn.childs) {
                        s2.push(child);
                    }
                } else { // push child direction "<---"
                    for (int i = rn.childs.size() - 1; i >= 0; i--) {
                        s2.push(rn.childs.get(i));
                    }
                }
            }

            System.out.println();
            lvl++;
            // swap s1-s2
            Stack<Node> temp = s1;
            s1 = s2;
            s2 = temp;
        }
    }

    static Node tail = null;

    // Linearize tree in PreOrder. result should also be a tree.
    // video: 23Feb, TimeStamp: 00:02:00
    // Time: O(N^2). Space: O(1)
    public static void linearizeTree(Node node) {
        if (node == null)
            return;

        for (Node child : node.childs) {
            linearizeTree(child);
        }

        // 2nd last k piche last wala lgana hai. that's why size-2 se start kra
        for (int i = node.childs.size() - 2; i >= 0; i--) {
            Node tail = getTail(node.childs.get(i));
            tail.childs.add(node.childs.get(i + 1));
            node.childs.remove(i + 1);
        }

    }

    // This is O(N) itself operation that's why above linearize is O(N^2)
    public static Node getTail(Node node) {

        if (node.childs.size() == 0) {
            return node;
        }
        return getTail(node.childs.get(0));
    }

    // TODO: REVISE REVISE REVISE: WATCH VIDEO: 23Feb O(N)
    public static Node linearizeTreeAndReturnTail(Node node) {
        if (node == null)
            return null;

        if (node.childs.size() == 0) {
            return node; // this is leaf and a leaf is a tail.
        }

        int n = node.childs.size();
        // mere last child k subTree ka last ele.
        Node overallTail = linearizeTreeAndReturnTail(node.childs.get(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            Node tail = linearizeTreeAndReturnTail(node.childs.get(i));
            tail.childs.add(node.childs.get(i + 1));
            node.childs.remove(i + 1);
        }

        return overallTail;
    }

    // mySolution.
    public static Node removeAllLeaf(Node node) {
        if (node == null)
            return null;

        // leaf node
        if (node.childs.size() == 0) {
            return null;
        }

        // go from last to first. otherwise if a leaf is there and it get removed childs
        // array idx will get disturbed, so will be the for loop.
        for (int i = node.childs.size() - 1; i >= 0; i--) {
            Node nChild = removeAllLeaf(node.childs.get(i));
            // ith child is a leaf, so remove it.
            if (nChild == null) {
                node.childs.remove(i);
            }
        }
        return node;
    }

    public static void removeAllLeaf02(Node node) {

        // stores only those childs jinke further childs hai. i.e jo leaf na ho
        ArrayList<Node> nChilds = new ArrayList<>();

        for (Node child : node.childs) {

            if (child.childs.size() != 0) {
                nChilds.add(child);
            }
        }

        node.childs = nChilds;

        for (Node child : node.childs) {
            removeAllLeaf02(child);
        }
    }

}
