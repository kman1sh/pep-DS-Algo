/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        SLL list = new SLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.display();        
        list.fold();
        System.out.println();
        list.display();        
        
    }
}