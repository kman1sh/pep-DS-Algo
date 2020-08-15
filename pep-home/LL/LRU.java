import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
    LinkedList<Integer> list = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int defaultSize = 4;

    public void set(int key, int value) {

        if (map.containsKey(key)) {

            list.addFirst(list.remove(key)); // bring key in front of list. NOT O(1)!!!
            map.put(key, value);

        } else {
            
            // updating list
            if (list.size() < defaultSize) {
                list.addFirst(key);
            } else { // cache is full
                int lastKey = list.removeLast();
                map.remove(lastKey);
                list.addFirst(key);
            }
            
            map.put(key, value);
        }

    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        list.addFirst(list.remove(key)); // bring key in front of list. NOT O(1)!!!
        return map.get(key);

    }

}