import java.util.ArrayList;
import java.util.Arrays;

public class dp {

    public static void main(String[] args) {
        // int[][] baseMat = {{1,1}, {1,0}};
        // int[][] myAns =power(baseMat, baseMat, 6);
        // System.out.println(myAns[0][1]);

        // System.out.println(boardPath(10));
        // int[] arr = new int[11];
        // boardPath_Tabulation(10, arr);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(boardPathV2(0, 10));
        // System.out.println(Arrays.toString(board));
        int[][] dp = new int[3][3];
        // System.out.println(mazePath(0, 0, 2, 2, dp));
        // System.out.println(mazePathMulti(0, 0, 2, 2, dp));

        // int[][] mazePath_dpAns = mazePath_Tabulation(0, 0, 2, 2, dp);
        // for (int[] is : mazePath_dpAns) {
        // System.out.println(Arrays.toString(is));
        // }

        // int[][] mazePathMulti_dpAns = mazePathMulti_Tabulation(0, 0, 2, 2, dp);

        // for (int[] is : mazePathMulti_dpAns) {
        // System.out.println(Arrays.toString(is));
        // }
        // int[][] maze = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2, 0, 4, 2
        // } };
        // minCostMazePath(0, 0, 3, 3, 0, " ", maze);
        // System.out.println(minCost);
        // System.out.println(minPath);

        // int[] arr = { 1, 3, 0, 4, 0, 0, 2, 1, 1, 0 };
        // minJumpGame(arr);
        // System.out.println(Arrays.toString(arr));
        // picnicPair(5);
        // subseqPaliDP("babad");

        // System.out.println(isPalindrome("babad"));
        // System.out.println(longestPaliSubstr("babad"));

        // palindrome("babad");
        // distinctSubseqCnt("dcabab");
        // countSubsequence("abcabc");
        // int[] wt = { 1, 3, 4, 5 };
        // int[] profit = { 10, 40, 50, 70 };
        // knapsack(wt, profit, 8);

        int[] LIS_arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7 };
        // System.out.println("LIS Length: " + LIS(LIS_arr));

        // System.out.println("LDS Length: " + LDS(LIS_arr));
        System.out.println("Bitonic Length: " + bitonic(LIS_arr));

        // int[] row = { 2, 3, 6, 4 };
        // int[] col = { 3, 6, 4, 5 };

        // System.out.println(mcm(0, row.length - 1, row, col));

        int[] priceList = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int[] lenArr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        rodCut(priceList, lenArr, 8, 0, 0);
        System.out.println(maxProfit);

    }

    public static int[][] multiplication(int[][] mat1, int[][] mat2) {
        int a00 = (mat1[0][0]) * (mat2[0][0]) + (mat1[0][1]) * (mat2[1][0]);
        int a01 = (mat1[0][0]) * (mat2[0][1]) + (mat1[0][1]) * (mat2[1][1]);
        int a10 = (mat1[1][0]) * (mat2[0][0]) + (mat1[1][1]) * (mat2[1][0]);
        int a11 = (mat1[1][0]) * (mat2[0][1]) + (mat1[1][1]) * (mat2[1][1]);
        int[][] ans = { { a00, a01 }, { a10, a11 } };

        return ans;
    }

    public static int[][] power(int[][] a, int[][] baseMat, int pow) {
        if (pow == 0)
            return new int[2][2];
        if (pow == 1) {
            return baseMat;
        }

        int[][] arr = power(a, baseMat, pow / 2);
        int[][] ans = multiplication(arr, arr);

        if (pow % 2 != 0) {
            return multiplication(ans, baseMat);
        }

        return ans;
    }

    static int[] board = new int[11];

    public static int boardPathV2(int start, int target) {
        if (start == target) {
            board[start] = 1;
            return 1;
        }
        if (board[start] != 0)
            return board[start];
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            if (i + start <= target) {
                count += boardPathV2(i + start, target);
            }
        }

        board[start] = count;
        return count;
    }

    public static void boardPath_Tabulation(int target, int[] arr) {
        arr[10] = 1;
        for (int j = arr.length - 1; j < 0; j++) {
            for (int i = 1; i <= 6; i++) {
                if (j + i <= target)
                    arr[j] += arr[j + i];
            }
        }
    }

    public static int mazePath(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            dp[sr][sc] = 1;
            return 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        if (sr + 1 <= er) {
            count += mazePath(sr + 1, sc, er, ec, dp);
        }
        if (sc + 1 <= ec) {
            count += mazePath(sr, sc + 1, er, ec, dp);
        }
        if (sr + 1 <= er && sc + 1 <= ec) {
            count += mazePath(sr + 1, sc + 1, er, ec, dp);
        }

        dp[sr][sc] = count;
        return count;

    }

    public static int mazePathMulti(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            dp[sr][sc] = 1;
            return 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int jump = 1; jump + sr <= er; jump++) {
            count += mazePathMulti(sr + jump, sc, er, ec, dp);

        }

        for (int jump = 1; jump + sc <= ec; jump++) {
            count += mazePathMulti(sr, sc + jump, er, ec, dp);

        }

        for (int jump = 1; jump + sr <= er && jump + sc <= ec; jump++) {
            count += mazePathMulti(sr + jump, sc + jump, er, ec, dp);

        }

        dp[sr][sc] = count;
        return count;

    }

    public static int[][] mazePath_Tabulation(int sr, int sc, int er, int ec, int[][] dp) {
        dp[er][ec] = 1;

        for (int i = er; i >= 0; i--) { // row
            for (int j = ec; j >= 0; j--) { // col
                if (i + 1 <= er) {
                    dp[i][j] += dp[i + 1][j];
                }
                if (j + 1 <= ec) {
                    dp[i][j] += dp[i][j + 1];
                }
                if (i + 1 <= er && j + 1 <= ec) {
                    dp[i][j] += dp[i + 1][j + 1];
                }

            }
        }

        return dp;
    }

    public static int[][] mazePathMulti_Tabulation(int sr, int sc, int er, int ec, int[][] dp) {
        dp[er][ec] = 1;

        for (int i = er; i >= 0; i--) { // row
            for (int j = ec; j >= 0; j--) { // col

                for (int jump = 1; jump + i <= er; jump++) {
                    dp[i][j] += dp[i + jump][j];
                }

                for (int jump = 1; jump + j <= ec; jump++) {
                    dp[i][j] += dp[i][j + jump];
                }

                for (int jump = 1; jump + i <= er && jump + j <= ec; jump++) {
                    dp[i][j] += dp[i + jump][j + jump];
                }
            }
        }

        return dp;
    }

    static int minCost = Integer.MAX_VALUE;
    static String minPath = "";

    public static void minCostMazePath(int sr, int sc, int er, int ec, int csf, String path, int[][] maze) {
        if (sr == er && sc == ec) {
            csf += maze[sr][sc];
            if (csf < minCost) {
                minCost = csf;
                minPath = path;
            }
            return;
        }
        if (sr + 1 <= er) {
            minCostMazePath(sr + 1, sc, er, ec, csf + maze[sr][sc], path + "V", maze);
        }
        if (sc + 1 <= ec) {
            minCostMazePath(sr, sc + 1, er, ec, csf + maze[sr][sc], path + "H", maze);
        }
    }

    public static void minJumpGame(int[] arr) {

        for (int i = arr.length - 2; i >= 0; i--) {
            int min = (int) Math.pow(10, 6);
            for (int j = i + 1; j <= arr[i] + i; j++) {
                min = Math.min(arr[j], min);
            }
            arr[i] = min + 1;
        }
    }

    public static void picnicPair(int n) {

        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == 1)
                arr[i] = 1;
            else {
                arr[i] = arr[i - 1] + arr[i - 2] * (i - 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void subseqPaliDP(String str) {
        int[][] dp = new int[str.length()][str.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if ((i == 0 && j == 0)) {
                    dp[0][0] = 1;
                } else {
                    if (i <= j && i < str.length() - 1 && j < dp.length - 1) {
                        if (str.charAt(i) == str.charAt(j)) {
                            dp[i][j] = dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + dp[i + 1][j - 1];
                        }
                    }
                }
            }
        }
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));

        }
    }

    public static boolean isPalindrome(String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--))
                return false;
        }
        return true;
    }

    public static int longestPaliSubstr(String str) {
        if (str.length() == 1) {
            return 1;
        }

        if (isPalindrome(str)) {
            return str.length();
        } else {
            int ans1 = longestPaliSubstr(str.substring(0, str.length() - 2));
            int ans2 = longestPaliSubstr(str.substring(1, str.length() - 1));
            return Math.max(ans1, ans2);
        }
    }

    // creating 2d boolean dp to store all palindrome location
    public static boolean[][] palindrome(String str) {
        boolean[][] isPali_DP = new boolean[str.length()][str.length()];

        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < str.length(); i++, j++) {
                if (gap == 0) {
                    isPali_DP[i][j] = true;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        if (gap == 1)
                            isPali_DP[i][j] = true;
                        else if (isPali_DP[i + 1][j - 1]) {
                            isPali_DP[i][j] = true;
                        }
                    }
                }
            }
        }
        return isPali_DP;
        // for (boolean[] bs : isPali_DP) {
        // System.out.println(Arrays.toString(bs));
        // }
    }

    // =============================================
    // =============================================

    public static void distinctSubseqCnt(String word) {

        int[] ssCountArr = new int[word.length() + 1];
        int[] lastEnctrof = new int[26];

        for (int i = 0; i < ssCountArr.length; i++) {
            if (i == 0)
                ssCountArr[0] = 1;
            else {
                int wordCharIdx = word.charAt(i - 1) - 'a';
                ssCountArr[i] = (ssCountArr[i - 1] * 2) - lastEnctrof[wordCharIdx];
                lastEnctrof[wordCharIdx] = ssCountArr[i];
            }

        }
        System.out.println(Arrays.toString(ssCountArr));
    }

    // public static int goldMine(int[][] goldBoard) {

    // for (int i = goldBoard[0].length - 2; i >= 0; i--) {
    // for (int j = 0; j < goldBoard.length; j++) { // row
    // // i+1,j+1 i+1, j i+1 j-1

    // int w1, w2, w3 = 0;
    // if (i + 1 < goldBoard[0].length && j + 1 < goldBoard.length) {

    // }
    // if (i + 1 < goldBoard[0].length && j < goldBoard.length) {

    // }
    // if (i + 1 < goldBoard[0].length && j - 1 < goldBoard.length) {

    // }
    // }
    // }

    // }

    public static void countSubsequence(String s) { // a^i b^j c^k
        int[] dp = new int[27];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a' + 1;
            dp[idx] = dp[idx - 1] + 2 * dp[idx];
        }

        System.out.println(Arrays.toString(dp));
    }

    // public static void knapsack(int[] wt, int[] profit, int maxWtCap) {

    // int[][] dp = new int[wt.length + 1][maxWtCap + 1];

    // for (int i = 0; i < wt.length; i++) {
    // for (int j = 0; j < dp[0].length; j++) { //0 to 8
    // if (i == 0 || j == 0) {
    // dp[i][j] = 0;
    // } else if (j > i) {
    // dp[i][j] = dp[i - 1][j];
    // } else {
    // int temp = dp[i][j - 1] + dp[j - 1][i - j];
    // dp[i][j] = Math.max(temp, dp[i - 1][j]) ;
    // }

    // }
    // }

    // for (int[] is : dp) {
    // System.out.println(Arrays.toString(is));
    // }
    // }

    // longest Increasing subsequence length : In n square.
    public static int LIS(int[] arr) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max_len = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[j] < arr[i]) && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                    max_len = Math.max(max_len, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max_len;
    }

    public static int LDS(int[] arr) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max_len = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] < arr[i]) && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                    max_len = Math.max(max_len, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return max_len;
    }

    public static int bitonic(int[] arr) {

        // LIS
        int[] lis_dp = new int[arr.length];
        Arrays.fill(lis_dp, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[j] < arr[i]) && (lis_dp[i] < lis_dp[j] + 1)) {
                    lis_dp[i] = lis_dp[j] + 1;
                }
            }
        }

        // LDS
        int[] lds_dp = new int[arr.length];
        Arrays.fill(lds_dp, 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] < arr[i]) && (lds_dp[i] < lds_dp[j] + 1)) {
                    lds_dp[i] = lds_dp[j] + 1;
                }
            }
        }

        // Biotonic
        int maxBiotonicLen = -10000;
        for (int i = 0; i < arr.length; i++) {
            if ((lis_dp[i] + lds_dp[i] - 1) > maxBiotonicLen) {
                maxBiotonicLen = lis_dp[i] + lds_dp[i] - 1;
            }
        }
        return maxBiotonicLen;
    }

    public static int mcm(int st, int end, int[] row, int[] col) {
        if (st == end) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int cut = st; cut < end; cut++) {
            int left = mcm(st, cut, row, col);
            int right = mcm(cut + 1, end, row, col);

            int cost = left + (row[st] * col[end] * col[cut]) + right;
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    // public static int MinPalindromicCut(String str, int st, int end, boolean[][]
    // isPali) {

    // if (st == end || isPali[st][end]) {
    // return 0;
    // }

    // for (int cut = st; cut < end; cut++) {
    // int left = 1 + MinPalindromicCut(str, st, cut, isPali);
    // int right = 1 + MinPalindromicCut(str, cut + 1, end, isPali);
    // }

    // }

    // public static int mcm_dp(int[] row, int[] col) {

    // }

    static int maxProfit = Integer.MIN_VALUE;

    public static void rodCut(int[] Pricelst, int[] lenArr, int length, int idx, int profit) {
        if (length == 0 || idx == Pricelst.length) {
            // if (length == 0)
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        for (int i = idx; i < Pricelst.length; i++) {
            if (length - lenArr[i] >= 0) {
                rodCut(Pricelst, lenArr, length - lenArr[i], 0, profit + Pricelst[i]);
            }
            rodCut(Pricelst, lenArr, length, i + 1, profit);
        }
    }

    // public static void rodCut_dp(int[] Pricelst, int[] lenArr) {

    //     int[] dp = new int[Pricelst.length + 1];

        
    //     for (int i = 0; i < Pricelst.length; i++) {
    //         int len = lenArr[i];
    //         if (i == 0)
    //             dp[0] = 0;

    //     for (int j = 0; j < i-1; j++) {
    //         while(len != 0 && len > lenArr[j] ) {

    //         }
    //     }

    //     }
    // }

    public static int _mcm(int st, int end, int[] row, int[] col) {
        if (st == end) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int cut = st; cut < end; cut++) {
            int left = mcm(st, cut, row, col);
            int right = mcm(cut + 1, end, row, col);

            int cost = left + (row[st] * col[end] * col[cut]) + right;
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

}