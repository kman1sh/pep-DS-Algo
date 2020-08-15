//AVL is all about BST management so that tree balanced rhe and search operation log(n) 
// ka hi bna rhe otherwise what's the point of BST.

public class avl {

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        private int ht = 0; // height starting -1 se, if 0 toh scene kuch aur hoga.

        private int bal = 0; // Balance Factor should be in range (-1,1) both inclusive.

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {

        Node node = null;
        for (int i = 1; i <= 15; i++) {
            int num = i * 10;
            node = addData(node, num);
        }

        node = removeData(node, 30);
        node = removeData(node, 130);
        node = removeData(node, 60);
        node = removeData(node, 110);
        node = removeData(node, 20);
        display(node);
        // node = addData(node, 102);

    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String left = (node.left == null) ? "." : node.left.data + "";

        String right = (node.right == null) ? "." : node.right.data + "";

        String ans = left + " -> " + node.data + ":(" + node.ht + ":" + node.bal + ")" + " <- " + right;

        System.out.println(ans);

        // faith that left and right child will also do the same;
        display(node.left);
        display(node.right);
    }

    // return new root after adding the data.
    public static Node addData(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = addData(node.left, data);
        } else if (data > node.data) {
            node.right = addData(node.right, data);
        }

        // har node k liye (only root to leaf path, jisme data add hua hai) post-order m
        // uska height update kro and rotate if possible.
        node = rotation(node);
        return node;
    }

    // removeData mai data milega is baat ki 100% gurantee hoti hai.

    /**
     * if the node which need to be removed, has 2 childs: then who will take this
     * node postion in the tree? <br>
     * 
     * two node are eligible for it: <br>
     * 1) removeNode k leftSubTree ka maximum val element.<br>
     * 2) removeNode k rightSubTee ka minimum val element.
     * 
     * choosing either of them will be fine. I m choosing (1) <br>
     * Now swap removing Node.data with leftSubTree ka max(lets call it maxNode) and
     * delete maxNode from it original position.
     */

    public static Node removeData(Node node, int data) {

        if (data < node.data) {

            node.left = removeData(node.left, data);

        } else if (data > node.data) {

            node.right = removeData(node.right, data);

        } else { // data mil gya. but there are 3 cases.
            // 1) data's Node is leaf Node 2) have one child 3) have 2 childs.

            // case 1, case 2
            if (node.left == null || node.right == null) {
                return (node.left != null) ? node.left : node.right;
            }

            // agr if m nai fasa: definately node has two childs: case3
            Node maxNode = maxNode(node.left);

            node.data = maxNode.data; // swap with my val. so data is gone, now remove maxNode
            node.left = removeData(node.left, maxNode.data);
        }

        // har node k liye (only root to leaf path, jisme data add hua hai) post-order m
        // uska height update kro and rotate if possible.
        node = rotation(node);
        return node;
    }

    public static Node maxNode(Node node) {

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // =========== AVL ====================

    public static void updateHeightBalance(Node node) {
        // in terms of edges heights hai.
        int lh = (node.left != null) ? node.left.ht : -1;
        int rh = (node.right != null) ? node.right.ht : -1;

        node.ht = Math.max(lh, rh) + 1;

        if (node.data == 150) {
            System.out.println(lh + " : " + rh);
            System.out.println(node.right.data);
        }

        node.bal = lh - rh;
    }

    public static Node ll(Node x) {
        Node y = x.left;
        Node yKaRight = y.right; // store kra lo otherwise kho jaega.

        y.right = x;
        x.left = yKaRight;

        updateHeightBalance(x);
        updateHeightBalance(y);

        return y;
    }

    public static Node rr(Node x) {
        Node y = x.right;
        Node yKaLeft = y.left;

        y.left = x;
        x.right = yKaLeft;

        updateHeightBalance(x);
        updateHeightBalance(y);

        return y;
    }

    // return Node, jaruri toh nai jo pehle root tha, rotation k baad bhi wahi root
    // rhe. So it returns new root
    public static Node rotation(Node node) {

        updateHeightBalance(node);

        if (node.bal == 2) { // ll, lr: 100% leftChild is present.

            if (node.left.bal == 1) { // ll
                return ll(node);
            } else { // lr
                Node nodeleft = rr(node.left); // left subTree ko rotate krke le ao. aur mere left m firse lga do
                node.left = nodeleft;
                return ll(node);

            }

        } else if (node.bal == -2) { // rr, rl

            if (node.right.bal == -1) { // rr
                return rr(node);
            } else { // rl
                Node nodeRight = ll(node.right);
                node.right = nodeRight;
                return rr(node);
            }
        }
        return node;
    }
}