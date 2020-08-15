public class recursionArray {

    public static void main(String[] args) {
        System.out.println(stepCases(5));
    }

//    public static int[] allIndex(int[] arr, int vidx,int data, boolean flag) {
//
//        if(flag) {
//           for(int n: arr) {
//                if(data == n) { 
//                    size++; 
//                }
//            }
//            return new int[size];
//        }
//    }

  //  public static int[] arrLength(int[] arr, data) {
  //      int size =0;
  //      for(int n : arr) {
  //          if(n == data) size++;
  //       }
  //      return new int[size];
  //  }


  public static int stepCases(int n) {
      if(n ==1 || n==0) {
          return 1;
      } 
      if(n == 2) return 2;
      if(n == 3) return 3;

      return stepCases(n-1) + stepCases(n-2) +stepCases(n-3);
  }
} 