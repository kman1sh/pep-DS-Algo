
public class Client {

    public static void main(String[] args) {
        Hashmap<Integer, Integer> map = new Hashmap<>();
        map.put(1, 101);
        map.put(2, 102);
        map.put(3, 103);
        map.put(4, 104);
        map.put(5, 105);
        System.out.println(map);

        map.put(1, 111);
        System.out.println(map);

        Hashmap<String, Integer> map1 = new Hashmap<>();
        map1.put("abc", 3);
        map1.put("bdc", 5);
        map1.put("eew", 22);
        map1.put("ggt", 54);
        map1.put("vfr", 31);

        System.out.println(map1.keySet());
        
        try {
            map1.remove("abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map1.containsKey("abc"));
        System.out.println(map1.size);
        System.out.println(map1);
        

        
    }
}