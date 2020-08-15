import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0}; // {1,-1,-1,0}; {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}; // { -1, 0, 1, 2, -1, -4 }; 
        // System.out.println(nums.length);
        // threeSum(nums);
        // for (List<Integer> i : sets) {
        //     System.out.println(i);
        // }
        // Arrays.sort(nums);
        // String s = Arrays.toString(nums);
        // System.out.println(s);

        String s = "2393";
        char ch = (char) ('a' + s.charAt(0) - '0');
        System.out.println(ch);

    }

    static List<List<Integer>> sets = new ArrayList<List<Integer>>();
    static HashMap<String,Integer> hmap = new HashMap<>();

    public static List<List<Integer>> threeSum(int[] nums) {
        _threesum(nums, 0, 0, 0, "");
        return sets;
    }

    public static void _threesum(int[] nums, int idx, int sum, int count, String ans) {
        if (count == 3 || idx == nums.length) {
            if (count == 3 && sum == 0) {
                int[] set = stringToSet(ans);
                ArrayList<Integer> setAr = new ArrayList<>();
                Arrays.sort(set);
                String key  = "";
                for (int n : set) {
                    key +=n+",";
                    setAr.add(n);
                }

                if(!hmap.containsKey(key)) {
                    sets.add(setAr);
                    hmap.put(key, 1);
                } 
            }
            return;
        }

        _threesum(nums, idx + 1, sum + nums[idx], count + 1, ans + nums[idx] + ",");
        _threesum(nums, idx + 1, sum, count, ans);
        // System.out.println("Set building " +Arrays.toString(set));

    }

    public static int[] stringToSet(String str) {
        String[] ar = str.split(",");
        int[] set = new int[3];
        for (int i = 0; i < ar.length; i++) {
            set[i] = Integer.parseInt(ar[i]);
        }

        return set;
    }

}