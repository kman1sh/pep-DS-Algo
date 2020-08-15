import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] ar = { 7, 8, 6, 5, 12, 13, 11 };
        heapSort(ar, true);
        System.out.println(Arrays.toString(ar));
    }

    public static void heapSort(int[] arr, boolean isMax) {

        // creating a heap from @array
        for (int i = arr.length - 1; i >= 0; i--) {
            downheapify(arr, i, arr.length - 1, isMax);
        }
        System.out.println("heap " +Arrays.toString(arr));

        /**
         * +++SORTING CREATED HEAP+++ It pushes back, the most largest/smallest ele
         * (depending on isMax) from undiscovered region (i to 0 ), (which is always top
         * of heap. In other word, first ele in AL)
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            downheapify(arr, 0, i - 1, isMax);
            System.out.println(Arrays.toString(arr));
            
        }
    }

    public static void downheapify(int[] arr, int pIdx, int endIdx, boolean isMax) {
        int maxIdx = pIdx;
        int lc_idx = 2 * pIdx + 1; // left child idx w.r.t pIdx
        int rc_idx = 2 * pIdx + 2; // right child idx w.r.t pIdx

        if (lc_idx < endIdx && compare(arr[lc_idx], arr[maxIdx], isMax) > 0) {
            maxIdx = lc_idx;
        }

        if (rc_idx < endIdx && compare(arr[rc_idx], arr[maxIdx], isMax) > 0) {
            maxIdx = rc_idx;
        }
        if (maxIdx != pIdx) {
            swap(arr, maxIdx, pIdx);
            downheapify(arr, maxIdx, endIdx, isMax);
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int xVal = arr[x];
        int yVal = arr[y];

        arr[x] = yVal;
        arr[y] = xVal;
    }

    public static int compare(int val1, int val2, boolean isMax) {
        if (isMax) {
            return val1 - val2;
        } else
            return val2 - val1;
    }
}