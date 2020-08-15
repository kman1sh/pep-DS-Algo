
public class Client {
    public static void main(String[] args) {
        SLL root = new SLL();
        root.addLast(20);
        root.addLast(30);
        root.addLast(40);
        root.addLast(50);
        // System.out.println(root);

        root.addFirst(5);
        // System.out.println(root);

        // root.addAt(4, 29);
        System.out.println(root);

        // int mid = root.midNode();
        // System.out.println("mid Element: " + mid);

        // root.reverseDataRec();
        // root.reverseDataItr();

        // root.reversePointerItr();

        // root.reverseDataItr_Optimize();
        // System.out.println(root);

        // ===========isPali========
        // SLL root2 = new SLL();

        // for(int i = 0; i < 5; i++) {
        // root2.addLast(i * 10);
        // }

        // for(int i = 4; i >= 0; i--) {
        // root2.addLast(i * 10);
        // }
        // root2.addAt(5, 55);

        // System.out.println(root2);
        // System.out.println(root2.isPali());
        // =============================

        // root.fold();
        // System.out.println(root);

        // root.unfold();
        // System.out.println(root);

        // =========== reverse in K-size (chunks) of blocks ===============

        // root.reverseInBlocks(3);
        // // root.reverseInBlocks0(3);
        // System.out.println(root);
        // System.out.println(root.size);

        // ============== Segregate in EVEN ODD =================

        SLL root2 = new SLL();
        root2.addLast(2);
        root2.addLast(7);
        root2.addLast(8);
        root2.addLast(6);
        root2.addLast(3);
        root2.addLast(5);

        System.out.println(root2);
        // root2.segregateOddEven();
        root2.segregateOddEven1();

        System.out.println(root2);
        System.out.println(root2.size);

    }

}