import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * BT
 */
public class BT {

    public static void main(String[] args) {

        int[] bt = { 10, 20, 40, 60, -1, -1, 70, -1, -1, 50, 80, -1, -1, -1, 30, 90, -1, 110, 150, -1, -1, -1, 100, 120,
                -1, -1, -1 };

        // int[] bt1 = { -15, 5, -8, 2, -1, -1, 6, -1, -1, 1, -1, -1, 6, 3, -1, -1, 9,
        // -1, 0, 4, -1, -1, 1, 10, -1 };

        Node rootNode = creatTree(bt);
        // Node rootNode1 = creatTree(bt1);
        display(rootNode);
        // System.out.println(size(rootNode));

        // System.out.println(height(rootNode));

        System.out.println(findPath(rootNode, 150));

        // System.out.println(findData(rootNode, 80));

        // System.out.println(leafToleafSum(rootNode));
        // System.out.println(maxSum);

        // int[] bt437 = { 10, 5, -3, 3, 2, -1, 11, 3, -2, -1, 1 };
        // Node root473 = creatTree(bt437);
        // HashMap<Integer,Integer> map = new HashMap<>();
        // pathSum(root473, 8, 0, map);
        // System.out.println(ans);

        int[] sortedAr = { 2, 6, 10, 25, 36, 37, 39, 40, 52, 68, 72 };

        Node rootBST = consBTS(sortedAr, 0, sortedAr.length - 1);
        // display(rootBST);
        // System.out.println(findBST(rootBST, 2));

        // =======All SOL ========

        // pair p = new pair();
        // findCF(rootNode, 70, 0, p);
        // System.out.println("Ceil:Floor " + p.ceil + ":" + p.floor);
        // System.out.println("Height:ifContain " + p.height + ":" + p.find);
        // System.out.println("Pred:Succ " + p.predNode.data + ":" + p.succNode.data);
        // System.out.println(p.size);

        BSTpredSucc(rootBST, 37);

        // View set
        // int[] arr = { 10, 20, 40, 60, -1, -1, 70, -1, -1, 50, 80, -1, -1, -1, 30, 90, -1, 110, 150, -1, -1, -1, 100,
        //         120, -1, -1, -1 };
        // Node rootVS = creatTree(bt);
        // viewSet(rootVS);

        
    }

    static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int idx = 0;

    public static Node creatTree(int[] arr) {
        if (idx == arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }

        Node node = new Node(arr[idx]);
        idx++;

        node.left = creatTree(arr);
        node.right = creatTree(arr);

        return node;
    }

    public static void display(Node node) {
        if (node == null)
            return;

        String ans = "";
        ans += (node.left == null) ? "." : node.left.data;
        ans += "-> " + node.data + " <-";
        ans += (node.right == null) ? "." : node.right.data;

        System.out.println(ans);

        display(node.left);
        display(node.right);
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        count += size(root.left) + size(root.right) + 1;

        return count;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int li_hei = height(root.left);
        int ri_hei = height(root.right);

        return Math.max(li_hei, ri_hei) + 1;

    }

    public static ArrayList<Integer> findPath(Node root, int data) {
        if (root == null || root.data == data) {

            ArrayList<Integer> base = new ArrayList<>();
            if (root != null)
                base.add(data);
            return base;
        }

        ArrayList<Integer> myAns = new ArrayList<>();

        ArrayList<Integer> recAnsLe = findPath(root.left, data);
        ArrayList<Integer> recAnsRi = (recAnsLe.size() > 0) ? new ArrayList<>() : findPath(root.right, data);

        if (recAnsLe.size() > 0) {
            for (Integer i : recAnsLe) {
                myAns.add(i);
            }
            myAns.add(root.data);
        }

        if (recAnsRi.size() > 0) {
            for (Integer i : recAnsRi) {
                myAns.add(i);
            }
            myAns.add(root.data);
        }

        return myAns;
    }

    public static boolean findData(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data)
            return true;

        boolean res = false;

        res = res || findData(root.left, data);
        res = res || findData(root.right, data);

        return res;
    }

    // lowest common Ancestor LCA leetcode 236

    static int maxSum = Integer.MIN_VALUE;

    public static int leafToleafSum(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        if (root.left == null && root.right == null) {
            return root.data;
        }

        int leftSum = leafToleafSum(root.left);
        int rightSum = leafToleafSum(root.right);
        int recAns = leftSum + rightSum + root.data;

        if (root.left != null && root.right != null) {
            maxSum = Math.max(maxSum, recAns);
        }

        return (root.left == null) ? (rightSum)
                : ((root.right == null) ? leftSum : Math.max(leftSum, rightSum)) + root.data;

    }

    // static int maxSum = Integer.MIN_VALUE;

    // public static int maxPathSum(Node root) {
    // if (root == null) {
    // return Integer.MIN_VALUE;
    // }

    // if (root.left == null && root.right == null) {
    // return root.data;
    // }

    // int leftAns = maxPathSum(root.left);
    // int rightAns = maxPathSum(root.right);

    // int recAns = Math.max(leftAns, rightAns) + root.data;
    // maxSum = Math.max(maxSum, leftAns + rightAns + root.data);
    // }

    int[] bt437 = { 10, 5, -3, 3, 2, -1, 11, 3, -2, -1, 1 };
    Node root473 = creatTree(bt437);

    static int ans = 0;

    public static void pathSum(Node root, int tar, int prefixSum, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        prefixSum += root.data;
        ans += map.getOrDefault(prefixSum - tar, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        pathSum(root.left, tar, prefixSum, map);
        pathSum(root.right, tar, prefixSum, map);

        map.put(prefixSum, map.getOrDefault(prefixSum, 1) - 1);

    }

    public static Node consBTS(int[] arr, int si, int ei) {
        if (si >= ei) {
            if (si > ei)
                return null;
            return new Node(arr[si]);
        }

        int mid = (si + ei) / 2;

        Node node = new Node(arr[mid]);

        node.left = consBTS(arr, si, mid - 1);
        node.right = consBTS(arr, mid + 1, ei);

        return node;
    }

    public static boolean findBST(Node node, int data) {

        while (node != null) {
            if (node.data == data)
                return true;

            else if (data > node.data)
                node = node.right;

            else if (data < node.data)
                node = node.left;
        }

        return false;
    }

    static class pair {
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        boolean find = false;
        int height = 0; // max height of tree.
        int size = 0;

        Node predNode = null;
        Node succNode = null;
        Node justPrev = null;
    }

    public static void findCF(Node node, int value, int level, pair p) {
        if (node == null) {
            return;
        }
        p.size++;
        // ceil-floor
        if (node.data > value && node.data < p.ceil) {
            p.ceil = node.data;
        }
        if (node.data < value && node.data > p.floor) {
            p.floor = node.data;
        }

        // height and find data
        p.height = Math.max(p.height, level);
        if (!p.find)
            p.find = (node.data == value);

        // pred - succ in PREORDER for input data/value

        if (node.data == value && p.predNode == null) { // p.succNode == null means first time data mila hai.
            p.predNode = p.justPrev;
        }

        if (p.justPrev != null && p.justPrev.data == value) {// p.justPrev == node: pntr "value" wale node k agle node
                                                             // pe h
            // System.out.println();
            p.succNode = node;
        }

        p.justPrev = node;

        findCF(node.left, value, level + 1, p);
        findCF(node.right, value, level + 1, p);
    }

    public static void BSTpredSucc(Node node, int data) {
        if (node == null)
            return;
        Node predNode = null;
        Node succNode = null;
        Node justPreNode = null;

        while (node != null) {

            if (node.data > data) {
                // justPreNode = node;
                succNode = node; // have potential to become succNode
                node = node.left;

            } else if (node.data < data) {
                justPreNode = node;
                node = node.right;

            } else { // node.data == data
                Node temp = node;
                // predNode
                if (node.left != null) {
                    // *have temp
                    node = node.left;
                    while (node.right != null) {
                        node = node.right;
                    }
                    // after loop node is at predNode. even if there wasnt any right child;
                    predNode = node;
                } else { // data node has no left
                    predNode = justPreNode;
                }

                node = temp;
                // succNode
                if (node.right != null) {
                    node = node.right;
                    while (node.left != null) {
                        node = node.left;
                    }
                    // after loop node is at succNode. even if there wasnt any right child;
                    succNode = node;
                } else {
                    // succNode is already set while traversal
                }

                break;
            }
        }

        System.out.println("PredNode " +predNode.data + ", succNode " +succNode.data);

    }

    // view Set.==================================

    // public static void lineWiseLevelOrder(Node node) {
    // LinkedList<Node> que = new LinkedList<>();
    // que.addLast(node);

    // int level = 0;
    // while (que.size() != 0) {
    // int size = que.size();
    // System.out.print("Level: " + level + " -> ");

    // while (size-- > 0) {
    // Node rnode = que.removeFirst();
    // System.out.print(rnode.data + ", ");

    // if (rnode.left != null) {
    // que.addLast(rnode.left);
    // }

    // if (rnode.right != null) {
    // que.addLast(rnode.right);
    // }
    // }

    // level++;
    // System.out.println();
    // }
    // System.out.println();
    // }

    // public static void leftView(Node node) {
    // LinkedList<Node> que = new LinkedList<>();
    // que.addLast(node);

    // while (que.size() != 0) {
    // int size = que.size();
    // System.out.print(que.getFirst().data + " ");
    // while (size-- > 0) {
    // Node rnode = que.removeFirst();

    // if (rnode.left != null) {
    // que.addLast(rnode.left);
    // }

    // if (rnode.right != null) {
    // que.addLast(rnode.right);
    // }
    // }

    // }
    // System.out.println();
    // }

    // public static void rightView(Node node) {
    // LinkedList<Node> que = new LinkedList<>();
    // que.addLast(node);

    // while (que.size() != 0) {
    // int size = que.size();
    // Node prev = null;
    // while (size-- > 0) {
    // Node rnode = que.removeFirst();
    // prev = rnode;
    // if (rnode.left != null) {
    // que.addLast(rnode.left);
    // }

    // if (rnode.right != null) {
    // que.addLast(rnode.right);
    // }
    // }

    // System.out.print(prev.data + " ");

    // }
    // System.out.println();
    // }

    // public static void topView(Node node) {
    // LinkedList<Node> que = new LinkedList<>();
    // que.addLast(node);

    // while (que.size() != 0) {
    // int size = que.size();
    // System.out.print(que.getFirst().data + " ");
    // Node prev = null;
    // int count = 0;
    // while (size-- > 0) {
    // Node rnode = que.removeFirst();
    // prev = rnode;
    // count++;
    // if (rnode.left != null) {
    // que.addLast(rnode.left);
    // }

    // if (rnode.right != null) {
    // que.addLast(rnode.right);
    // }
    // }
    // if (count > 1)
    // System.out.print(prev.data + " ");
    // System.out.println();

    // }
    // System.out.println();
    // }

    // public static void viewSet(Node node) {
    // lineWiseLevelOrder(node);
    // // leftView(node);
    // // rightView(node);
    // // topView(node);
    // }

}