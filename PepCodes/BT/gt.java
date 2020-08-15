import java.util.ArrayList;
import java.util.Stack;

/**
 * gt
 */
public class gt {

    static class Node {
        int data = 0;
        ArrayList<Node> childs;

        public Node(int data) {
            this.data = data;
            childs = new ArrayList<>();
        }

    }

    public static void main(String[] args) {
        int[] preOrderGT = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1,
                -1, -1 };
        Node rootGT = createGT(preOrderGT);
        // display(rootGT);
        // System.out.println("======");
        // System.out.println("height: " + height(rootGT) + "\nSize: " + size(rootGT));
        // System.out.println("find data: " + findData(rootGT, 80));
        // =============================

        // ArrayList<Node> pathArr = nodeToRootPath(rootGT, 80);
        // for (Node node : pathArr) {
        // System.out.print(node.data + ",");
        // }
        // System.out.println();
        // ===========================
        // LCA(rootGT, 110, 120);
        display(linearizeGT(rootGT));
        
    }

    public static int size(Node node) {
        // note that no base case needed.
        int s = 0;
        for (Node child : node.childs) {
            s += size(child);
        }

        return s + 1;

    }

    public static int height(Node node) {

        int hei = -1;
        for (Node child : node.childs) {
            hei = Math.max(hei, height(child));
        }

        return hei + 1;

    }

    public static boolean findData(Node node, int data) {
        if (node.data == data)
            return true;

        boolean res = false;
        for (Node child : node.childs) {
            res = res || findData(child, data);
        }
        return res;
    }

    public static Node createGT(int[] arr) {

        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == -1) {
                Node rNode = stack.pop();
                stack.peek().childs.add(rNode);
            } else {
                stack.push(new Node(arr[i]));
            }
        }
        return stack.peek();
    }

    public static void display(Node node) {

        String ans = node.data + " -->";
        for (Node child : node.childs) {
            ans += child.data + ", ";
        }

        System.out.println(ans);

        for (Node child : node.childs) {
            display(child);
        }
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<Node> myAns = new ArrayList<>();

        for (Node child : node.childs) {
            ArrayList<Node> recAns = nodeToRootPath(child, data);
            if (recAns.size() > 0) {
                myAns = recAns;
                myAns.add(node);
                break;
            }
        }
        return myAns;
    }

    // public static void kfar(Node node, int k, int data) {

    // ArrayList<Node> path = nodeToRootPath(node, data);
    // Node avoid = null;

    // for (int i = 0; i < path.size(); i++) {

    // }
    // }

    public static void LCA(Node node, int data1, int data2) {

        ArrayList<Node> list1 = nodeToRootPath(node, data1);
        ArrayList<Node> list2 = nodeToRootPath(node, data2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;
        int lca = -1;
        while (i >= 0 || j >= 0) {
            if (list1.get(i).data != list2.get(j).data) {
                break;
            }
            lca = list1.get(i).data;
            i--;
            j--;
        }
        System.out.println(lca);
    }

    // public static void lvlOrderLinewise(Node node) {}

    // public static boolean isSymmetricUtil(Node node) {

    // int i = 0;
    // int j = node.childs.size() - 1;

    // Node n1 = node.childs.get(i);

    // Node n2 = node.childs.get(j);

    // }

    public static Node linearizeGT(Node node) {

        for (Node child : node.childs) {
            linearizeGT(child);
        }

        for (int i = node.childs.size() - 2; i >= 0; i--) {
            Node tail = getTail(node.childs.get(i));
            tail.childs.add(node.childs.get(i + 1));
            node.childs.remove(node.childs.size()-1);
        }
        return node;
    }

    public static Node getTail(Node node) {
        if (node.childs.size() == 0)
            return node;

        return getTail(node.childs.get(node.childs.size()-1));
    }

}
