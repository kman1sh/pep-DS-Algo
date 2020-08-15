/**
 * disjointSet
 */
public class DisjointSet {
    private int[][] pairs;
    private int n; // total number of elements(astsronaut)

    public DisjointSet(int n, int[][] pairs) {
        this.n = n;
        this.pairs = pairs;
    }

    public int[] makeSet() {
        int[] setArr = new int[n];
        int[] setSize = new int[n];
        for (int i = 0; i < n; i++) {
            setArr[i] = i;
            setSize[i] = 1;
        }
        for (int[] pair : pairs) {
            int set1 = findSet(pair[0], setArr);
            int set2 = findSet(pair[1], setArr);

            if (set1 != set2) {
                union(set1, set2, setArr, setSize);
            }
        }
        // System.out.println(Arrays.toString(setSize));
        // System.out.println(Arrays.toString(setArr));
        return setSize;
    }

    private int findSet(int num, int[] setArr) {
        if (setArr[num] == num)
            return num;

        setArr[num] = findSet(setArr[num], setArr);

        return setArr[num];
    }

    private void union(int set1, int set2, int[] setArr, int[] setSize) {
        // check karo kis set ka size bda hai usme hi union hoga.
        if (setSize[set1] <= setSize[set2]) {
            setArr[set1] = set2;
            setSize[set2] += setSize[set1];
            setSize[set1] = 0;
        } else {
            setArr[set2] = set1;
            setSize[set1] += setSize[set2];
            setSize[set2] = 0;
        }
    }
}