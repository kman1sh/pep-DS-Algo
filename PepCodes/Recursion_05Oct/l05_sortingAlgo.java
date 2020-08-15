import java.util.Arrays;

public class l05_sortingAlgo {
    public static void main(String[] args) {

        // int[] arr1 = {2,8,12,14,18,36};
        // int[] arr2 = {4,6,12,17,29,64,94};
        // int[] unsorted = { 3, 1, 4, 5, 2, 6, 8, 7 };
        // int res[] = mergeSort(arr1, arr2);
        // System.out.println(Arrays.toString(res));
        // int[] splitArrayResult = sort(unsorted, 0, unsorted.length - 1);
        // for (int i : splitArrayResult) {
        // System.out.print(i + " ");
        // }

        int[] zeroOne = { 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0 };
        int[] res = zeroOneSort(zeroOne);
        System.out.println(Arrays.toString(res));
    }

    // arr1: 2,8,12,14,18,36
    // arr2: 4,6,12,17,29,64,94

    public static int[] mergeSort(int[] arr1, int[] arr2) {

        int[] arr = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length || j < arr2.length) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    arr[k] = arr1[i];
                    i++;

                } else {
                    arr[k] = arr2[j];
                    j++;
                }
            } else if (i < arr1.length) {
                arr[k] = arr1[i];
                i++;

            } else if (j < arr2.length) {
                arr[k] = arr2[j];
                j++;
            }

            k++;
        }
        return arr;
    }

    // 1,6,3,2,7,4,5
    public static int[] sort(int[] arr, int li, int ri) {
        if (li == ri) {
            int[] base = new int[1];
            base[0] = arr[li];
            return base;
        }
        int mid = (li + ri) >>> 1;

        int[] left = sort(arr, li, mid);
        int[] right = sort(arr, mid + 1, ri);
        return mergeSort(left, right);
    }

    // 0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,1,0
    // 1,0,1,1,0,0,1,0,1,1,0,1,0,1,1,1,0

    public static int[] zeroOneSort(int[] arr) {
        int temp = -1;
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        return arr;

    }

    public static int[] pivot(int[] arr, int li, int ri, int pivot) {
        int temp = -1;
        int i = li;
        int j = li;
        while (j <= ri) {
            if (arr[j] < pivot) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        return arr;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = -1;
        if (arr[idx1] > arr[idx2]) {
            temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
    }

    public static void sort0_1_2(int[] arr) {
        int pt = 0;
        int pt1 = arr.length - 1;
        int itr = 0;
        while (itr <= pt1) {
            if (arr[itr] == 0) {
                swap(arr, pt, itr);
                pt++;
                itr++;
            } else if (arr[itr] == 2) {
                swap(arr, itr, pt1);
                pt--;
                continue;
            }
            itr++;
        }
    }
}