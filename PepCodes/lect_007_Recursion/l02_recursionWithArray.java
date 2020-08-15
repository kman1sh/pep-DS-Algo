
public class l02_recursionWithArray {

    public static void main(String[] args) {

        int[] arr = { 10, 8, 9, 10, 11, 13, 10, 11, 18, 10, 10 };
        int[] ans = allIndex(arr, 0, 10, 0);
        for (int n : ans) {
            System.out.print(n + " ");
        }

    }

    public static int[] allIndex(int[] arr, int vidx, int data, int size) {

        if (vidx == arr.length) {
            int[] base = new int[size];
            return base;
        }

        if (arr[vidx] == data) {
            size++;
        }

        int[] recAns = allIndex(arr, vidx + 1, data, size);
        if (arr[vidx] == data) {
            recAns[size - 1] = vidx;
        }
        return recAns;
    }
}