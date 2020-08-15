import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmap<K, V> {

    class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    LinkedList<Node>[] buckets = new LinkedList[10];
    int size = 0;

    public Hashmap() {
        for (Integer i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // To be done in Last.
    // agar key is already present then update, warna add key-value and size++.
    public void put(K key, V value) {

        // group mangwao jaha pe ye key belong krta hai.
        LinkedList<Node> group = foundInBucket(key);
        // if node !=null they already present thi, do update only.
        Node node = foundInGroup(group, key);

        if (node == null) { // add key-value

            // if rehashing required when I come (group size + 1)?
            double lambda = ((group.size() + 1) * 1.0) / buckets.length; // *1.0 to convert in double
            if (lambda >= 1.0) {
                // rehash()
            }
            group = foundInBucket(key); // recalculate groupList becoz kya pta rehashing hui ho.
            group.addLast(new Node(key, value));
            size++;
        } else {
            node.value = value;
        }

    }

    public Node get(K key) {
        // check for key hascode in bucket
        LinkedList<Node> group = foundInBucket(key);
        // find the value in group, return null when not found.
        Node node = foundInGroup(group, key);
        return node;
    }

    public Node remove(K key) throws Exception {

        LinkedList<Node> group = foundInBucket(key);
        Node node = foundInGroup(group, key);

        if (node != null) {
            group.remove(node);
            size--;
            return node;
        } else {
            throw new Exception("ElementNotFound: -1");
        }
    }

    public boolean containsKey(K key) {

        LinkedList<Node> group = foundInBucket(key);
        Node node = foundInGroup(group, key);

        return node != null;
    }

    public LinkedList<Node> foundInBucket(K key) {

        Integer hashCode = hasCode(key); // hasCode is alway within buckets size.

        return buckets[hashCode]; // might be empty.
    }

    public Node foundInGroup(LinkedList<Node> group, K key) {
        int i = group.size();

        Node node = null;
        while (i > 0) {
            if (group.getFirst().key == key) {
                node = group.getFirst();
                break;
            } else {
                Node rNode = group.removeFirst();
                group.addLast(rNode);
            }

            i--;
        }

        return node;

    }

    // O(N)
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();

        for (LinkedList<Node> list : buckets) {

            if (list.size() != 0) {

                int size = list.size();

                while (size-- > 0) {
                    Node rn = list.removeFirst();
                    keys.add(rn.key);
                    list.addLast(rn);
                }
            }
        }
        return keys;

    }

    // hasCode returns that bucket, jaha possibly tumhra key ho skta hai.
    public int hasCode(K key) {

        int code = key.hashCode();

        return Math.abs(code) % buckets.length;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("{");

        for (LinkedList<Node> list : buckets) {

            if (list.size() != 0) {

                int size = list.size();

                while (size-- > 0) {
                    Node rn = list.removeFirst();
                    b.append(rn.key + "=" + rn.value + ", ");
                    list.addLast(rn);
                }
            }

        }
        b.delete(b.length() - 2, b.length()); // remove extra comma from end.
        b.append("}");
        return b.toString();
    }

}