/**
 * avl
 */
public class avl {

    static class Node {
        int data = 0;
        Node left = null;
        Node right = null;
        int height = -1;
        int bf = 0;

        Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        Node node = null;

        for (int i = 1; i <= 7; i++) {
            int num = (int) (100 * Math.random());
            node = addData(node, num);
        }

        display(node);

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

    public static Node addData(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (node.data > data) {
            node.left = addData(node.left, data);
        } else {
            node.right = addData(node.right, data);
        }

        // node = updateHeightBalance(node);
        return node;
    }

    public static Node removeData(Node node, int data) {
        if (node == null)
            return;

        if (node.data > data) {
            node.left = addData(node.left, data);
        } else if(node.data < data) {
            node.right = addData(node.right, data);
        } else { //data mil gya
            if(node.left == null || node.right == null)
            return
        }

    }

}
