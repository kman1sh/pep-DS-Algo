import java.util.Arrays;
import java.util.PriorityQueue;

public class Huffman {

    public static void main(String[] args) {
        int[] ar =freqMap("abbssaass");
        System.out.println(Arrays.toString(ar));


        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.
    }

    public static int[] freqMap(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            freq[idx] += 1;
        }
        return freq;
    }

    class Node implements Comparable<Node> {
        String data;
        Node left = null;
        Node right = null;
        int freq = 0;

        public Node(int data, int left, int right, int freq) {
          this.data = data;
          this.left = left;
          this.right = right;
          this.freq = freq;  
        }

        @Override
        public int compareTo(Node o) {
            
            return o.freq - this.freq;
        }
    }



}