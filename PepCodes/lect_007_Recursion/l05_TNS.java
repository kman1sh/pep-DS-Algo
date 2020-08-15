public class l05_TNS {

    public static void main(String[] args) {

        // int[] arr2 = { 2, 4, 7, 9, 17, 19 };
        // int[] arr1 = { 3, 6, 7, 11, 13, 15, 20, 23, 24 };
        // displayArray(mergeSortedArray(arr1, arr2));

        // int[] unsortedArray = { 1, 4, 9, 3, 2, 8, 7 };
        // int[] sortedAns = mergeSortAlgo(unsortedArray, 0, unsortedArray.length - 1);

        // int[] arr0_1 = { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0 };
        // int[] oneZeroSortedArray = sort0_1(arr0_1);
        // int[] oneZeroSortedArray = sort0_1_V2(arr0_1);
        // displayArray(oneZeroSortedArray);

        // int[] qArray = { 3, 6, 7, 11, 13, 15, 20, 23, 24, 2, 4, 7, 9, 17, 19 };
        // displayArray(quickSortAlgo(qArray, 11));

        int[] arr0_1_2 = { 0, 1, 2, 0, 1, 2, 1, 0, 1, 2, 0, 1, 0, 0 };
        displayArray(sort0_1_2(arr0_1_2));
    }

    public static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {

        int ptr1 = 0; // pointer
        int ptr2 = 0;
        int vidx = 0; // for new array
        int[] mergedArray = new int[arr1.length + arr2.length];

        while (ptr1 < arr1.length || ptr2 < arr2.length) { // if either of the array has elements in it that yet to be
                                                           // traverse, while loop will continue.
            if (ptr1 < arr1.length && ptr2 < arr2.length) { // if dono pointers, arr length se pichhe hi hai means dono
                                                            // arr k elements compare karo
                if (arr1[ptr1] < arr2[ptr2]) {
                    mergedArray[vidx] = arr1[ptr1];
                    ptr1++;
                    vidx++;
                } else {
                    mergedArray[vidx] = arr2[ptr2];
                    ptr2++;
                    vidx++;
                }
            } else { // else block fasega jab either of the arr get exhausted i.e its points == arr
                     // length. So yaha jo arr exhausted nai hua hai wo direct copy krdo.
                if (ptr1 < arr1.length) {
                    mergedArray[vidx] = arr1[ptr1];
                    ptr1++;
                    vidx++;
                } else {
                    mergedArray[vidx] = arr2[ptr2];
                    ptr2++;
                    vidx++;
                }
            }
        }
        return mergedArray;
    }

    public static int[] mergeSortAlgo(int[] arr, int leftIdx, int rightIdx) {

        if (leftIdx == rightIdx) {
            int[] baseArr = { arr[leftIdx] };
            return baseArr;
        }

        int mid = (leftIdx + rightIdx) / 2; // or (leftIdx+rightIdx)>>1 : right shift 1 in binary = divide by 2.
        int[] ans1 = mergeSortAlgo(arr, leftIdx, mid);
        int[] ans2 = mergeSortAlgo(arr, mid + 1, rightIdx);

        return mergeSortedArray(ans1, ans2);
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    // with two pointers, one at 0 idx, other at last idx, at intial state.
    public static int[] sort0_1(int[] arr) {
        int ptr1 = 0;
        int ptr2 = arr.length - 1;

        while (ptr1 != ptr2 && ptr1 < ptr2) {
            if (arr[ptr1] == 0) {
                ptr1++;
            } else {
                if (arr[ptr2] == 0) {
                    swap(arr, ptr1, ptr2);
                    ptr1++;
                    ptr2--;
                } else {
                    ptr2--;
                }
            }
        }
        return arr;
    }

    // with one pointer and one iterator. both at 0 idx at inital state.
    /**
     * Imp points: iterator ko hum arr pe move krwayege. Jab bhi iterator ko zero
     * milega, usko pointers k sath swap krgye. aur ab dono ko agey move kr degye.
     * pointer move krega only jab swapping hogi** Imp observation** : At any stage
     * of operation, -pointer se pehle wala area 0 ka hoga. -pointer se, iterator se
     * pehle wala area 1 ka hoga. -iterator se baad wala area unexplored hoga.
     */

    public static int[] sort0_1_V2(int[] arr) {

        int itr = 0, ptr = 0;

        while (itr != arr.length) {
            if (arr[itr] == 0) {
                swap(arr, ptr, itr);
                itr++;
                ptr++;
            } else {
                itr++;
            }
        }
        return arr;
    }

    public static int[] quickSortAlgo(int[] arr, int pivot) {

        int pt = 0;
        int itr = 0;

        while (itr < arr.length) {
            if (arr[itr] <= pivot) { // jab pivot se chhota ya equal value mile -> usko piche ptr ke pass bhejdo.
                swap(arr, pt, itr);
                pt++;
                itr++;
            } else {
                itr++;
            }
        }
        System.out.println("pt:" + pt + " itr:" + itr);
        return arr;
    }

    public static int[] sort0_1_2(int[] arr) {

        int pt1 = 0, itr = 0, pt2 = arr.length - 1;

        while (itr <= pt2) {
            if (arr[itr] == 0) {
                swap(arr, pt1, itr);
                pt1++;
            } else if (arr[itr] == 2) {
                swap(arr, itr, pt2);
                pt2--;
                continue;
                // continue se itr++ is case mai nahi hoga. aur jab 0 mile ya 1 tab itr++ chal
                // jayega. else block bhi bna skte hai jese uper walo mai kiya hai. tab if block
                // mai, pt1++ k sath itr++ bhi likhte.
            }
            itr++;
        }
        return arr;
    }
}