public class dpH {

    public static void main(String[] args) {
        int[][] linRecurMat = { { 1, 1 }, { 1, 0 } };
        int[][] ans = pow(linRecurMat, 14);
        System.out.println(ans[0][1]);
        System.out.println(calls);

    }

    public static int[][] matMultiplication(int[][] mat1, int[][] mat2) {

        int a00 = (mat1[0][0] * mat2[0][0]) + (mat1[0][1] * mat2[1][0]);
        int a01 = (mat1[0][0] * mat2[0][1]) + (mat1[0][1] * mat2[1][1]);
        int a10 = (mat1[1][0] * mat2[0][0]) + (mat1[1][1] * mat2[1][0]);
        int a11 = (mat1[1][0] * mat2[0][1]) + (mat1[1][1] * mat2[1][1]);

        int[][] resMat = { { a00, a01 }, { a10, a11 } };
        return resMat;
    }

    public static int power(int a, int b) {
        if (b == 1)
            return a;

        int temp = power(a, b / 2);
        int ans = temp * temp;
        if (b % 2 != 0) {
            ans *= a;
        }

        return ans;
    }

    // fibonacci by linear reocurrance
    public static int[][] pow(int[][] baseMat, int n) {
        if (n == 1)
            return baseMat;
        if (n == 0)
            return new int[2][2];

        int[][] recMat = pow(baseMat, n / 2);
        int[][] ans = matMultiplication(recMat, recMat);

        if (n % 2 != 0)
            return matMultiplication(ans, baseMat);

        return ans;
    }
}