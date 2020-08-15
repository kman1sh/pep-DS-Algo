/**
 * heap
 */
public class heap {

    public static void main(String[] args) {
    }
    
    static int[] arr = {2,12,4,9,10,7,6};
    
    public static void downheapify(int pIdx) {
        int lcIdx = (2*pIdx) + 1;
        int rcIdx = (2*pIdx) + 2;
        int maxValIdx = pIdx;

        //check to find maxValue wala idx
        if(arr[lcIdx] > arr[maxValIdx] ) {
            maxValIdx = lcIdx;
        }
        if(arr[rcIdx] > arr[maxValIdx]) {
            maxValIdx = rcIdx;
        }

        //maxIdx change ho gya, swap
        if(maxValIdx != pIdx) {
            swap(maxValIdx, pIdx);
        }
        
        //after swap maxValIdx pe current parent chala gya. So again find correct pos for parent (jo maxIdx pe hai).
        downheapify(maxValIdx);
    }

    public static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        
        
    }
}