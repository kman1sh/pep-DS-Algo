import java.util.ArrayList;

public class MyHeap {

    public static void main(String[] args) {
        int[] ar = { 7, 8, 6, 5, 12, 13, 11 };
        PriorityQue pq = new PriorityQue(ar, true);
        System.out.println(pq.arList);
        pq.add(10);
        System.out.println(pq.arList);

    }

    public static class PriorityQue {

        ArrayList<Integer> arList = new ArrayList<>();
        boolean isMax = true;

        public PriorityQue() {
        }

        public PriorityQue(int[] arr, boolean isMax) {
            this.isMax = isMax;
            for (int i = 0; i < arr.length; i++) {
                arList.add(arr[i]);
            }

            for (int i = arList.size() - 1; i >= 0; i--) {
                downheapify(i);
            }

        }

        /**
         * downheapify m basically hum parent idx val to child idx values se compare
         * krate hai, to find most eligible cadidate for parent position. and during
         * this we, sometimes swap parent val to child position, i.e downgrading the
         * current parent value.Sometimes parent val may get shifted more than 1 level
         * down, till leaf position. Hence the name downHeapify. "***This is PARENT
         * CENTRIC.**"
         * 
         */

        public void downheapify(int pIdx) {
            int maxIdx = pIdx;
            int lc_idx = 2 * pIdx + 1; // left child idx w.r.t pIdx
            int rc_idx = 2 * pIdx + 2; // right child idx w.r.t pIdx

            if (lc_idx < arList.size() && compare(arList.get(lc_idx), arList.get(maxIdx)) > 0) {
                maxIdx = lc_idx;
            }

            if (rc_idx < arList.size() && compare(arList.get(rc_idx), arList.get(maxIdx)) > 0) {
                maxIdx = rc_idx;
            }

            // at this point maxIdx may or may not be changed. if changed do swap.
            // If not changed means elements are already at correct places.
            if (maxIdx != pIdx) {
                // swap pIdx val to maxIdx val becoz there is new eligible val for Parent
                // position.
                swap(maxIdx, pIdx);

                /**
                 * after swap pIdx val, maxIdx pe chla gya. Now this position for pIdx "VALUE"
                 * may the the disturb the tree structure below it. i.e not being accordance to
                 * "isMax". That's why call recursive for from this point.
                 * 
                 */

                downheapify(maxIdx);
            }

        }

        public void upheapify(int cIdx) {
            // find parent for @cIdx
            int pIdx = (cIdx - 1) / 2;
            if (compare(arList.get(cIdx), arList.get(pIdx)) > 0) { // => child deserve parent position
                swap(cIdx, pIdx);
                // at this line of code, new "Parent" is cIdx Value
                // So do recursive call to make it go to its correct Position
                upheapify(pIdx);
            }
        }

        public void swap(int x, int y) { // remember ArList ka set function returns oldValue of that idx.
            arList.set(x, arList.set(y, arList.get(x)));
        }

        public int compare(int val1, int val2) {
            if (isMax) {
                return val1 - val2;
            } else
                return val2 - val1;
        }

        public void add(int num) {
            if (arList.size() == 0) {
                arList.add(num);
                return;
            }
            int lastIdx = arList.size() - 1;
            arList.add(num);
            upheapify(lastIdx + 1);
        }

        public int remove(int num) {
            int idx = -1;
            for (int i = 0; i < arList.size(); i++) {
                if (arList.get(i) == num) {
                    idx = i;
                    break;
                }
            }

            swap(idx, arList.size() - 1);
            int removedEle = arList.remove(arList.size() - 1);
            downheapify(idx);
            return removedEle;
        }

        public void update(int newVal, int oldVal) {
            int idx = -1;
            for (int i = 0; i < arList.size(); i++) {
                if (arList.get(i) == oldVal) {
                    idx = i;
                    break;
                }
            }

            arList.set(idx, newVal);
            // only one heapfiy will run;
            upheapify(idx);
            downheapify(idx);
        }

        
    }

}