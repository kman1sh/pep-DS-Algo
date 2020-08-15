import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class practice {

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // int[] arr = { 100, 2, 50, 1, 3, 75, 4 }; // 1, 2, 3, 4, 50, 75, 100.

        // for (int i : arr) {
        // pq.add(new Student(i));
        // }
        // for (Student s : pq) {
        // System.out.print(s.rank + " ");
        // }
        // System.out.println();

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(pq.poll().rank +" ");
        // }

        // int charValue = (int) '>';
        // System.out.println(charValue);

        // int a = 5;
        // int b = 7;
        // System.out.println();

        String word = "a green apple";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch != ' ') {
                if (map.containsKey(ch))
                    map.put(ch, map.get(ch) + 1);
                else {
                    map.put(ch, 1);
                }
            }
        }
        System.out.println(map);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch != ' ' && map.get(ch) == 1) {
                System.out.println(ch);
                break;
            }
        }

    }

    static class Student implements Comparable<Student> {
        int rank = 0;

        public Student(int r) {
            rank = r;
        }

        @Override
        public int compareTo(Student o) {
            return o.rank - this.rank;
        }

    }

}