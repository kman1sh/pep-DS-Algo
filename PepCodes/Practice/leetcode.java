import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class leetcode {

    static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node() {

        }

        Node(int data) {
            this.val = data;
        }

        Node(int data, Node left, Node right) {
            this.val = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1,null,2,3};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(data));

        Node rootNode = createBT(arr);

        // display(rootNode);

        //*****************************************

        // System.out.println(inorderTraversal(rootNode));
        boolean[] isVisited = new boolean[4];
        genTree(3,1,3,isVisited);
        System.out.println(list.size());
        for (Node n : list) {
            display(n);
            System.out.println();
        }
        
    }

    static int idx = 0;

    public static Node createBT(ArrayList<Integer> arr) {
        if (idx >= arr.size() || arr.get(idx) == null) {
            idx++;
            return null;
        }

        Node node = new Node(arr.get(idx));
        idx++;

        node.left = createBT(arr);
        node.right = createBT(arr);

        return node;
    }

    public static void display(Node root) {
        if (root == null)
            return;
        String ans = "";

        ans += (root.left == null) ? "null " : root.left.val;
        ans += "<--- " + root.val + " --->";
        ans += (root.right == null) ? " null " : root.right.val;

        System.out.println(ans);

        display(root.left);
        display(root.right);
    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> inOrderAr = new ArrayList<>();
        if(root == null)
            return inOrderAr;
        
        boolean done = false;
        Stack<Node> stack = new Stack<>();
        
        while(!done) {
            
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else if(root == null && !stack.isEmpty()) {
                Node node = stack.pop();
                inOrderAr.add(node.val);
                root = node.right;
            } else {
                done = true;               
            }
        }
        return inOrderAr;
    }

    static ArrayList<Node> list = new ArrayList<>();

    public static Node genTree(int n, int st, int end, boolean[] isVisited) {
        if(st> end)
            return null;
        if(st==end)
            return new Node(st);

        Node root = null;
        for(int i = st; i <= end; i++) {
            if(!isVisited[i]) {
                root = new Node(i);
                isVisited[i] = true;
                root.left = (i == st)? null : genTree(n, st, i-1, isVisited);
                root.right = (i == end) ? null : genTree(n, i+1, end, isVisited);
                list.add(root);
                isVisited[i]=false;
            } 
        }
        return root;
    }
}