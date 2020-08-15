import java.util.ArrayList;
import java.util.Arrays;

/**
 * DP
 */
public class DP {

    public static void main(String[] args) {

        // **************** NOTE BEFORE YOU START ***********
        // DP ka Question ya toh returnType recursion se solve ho jayega mahi toh
        // recursion subseq method se..Aur recursion k question ya toh returnType,
        // voidType ya Subseq Type mese kisi ek se solve ho jate hai.

        // ************** FIBONACCI ALL TYPE ****************
        // int n = 15;
        // // System.out.println(fibonacci(n));

        // int[] DP = new int[n + 1];
        // DP[0] = 0;
        // DP[1] = 1;
        // System.out.println(fibonacciDPM(n, DP));

        // System.out.println(fibonacciDPT(n));
        // System.out.println(fibonacciTwoVariable(n));

        // linearRecurrenceFibonacci(n);
        // System.out.println(powCount);

        // ************** ****************
        // int target = 10;
        // int[] boardPathdp = new int[target + 1];
        // System.out.println(boardPath_rec(0, target));
        // System.out.println(boardPath_memo(0, target, boardPathdp));
        // System.out.println(boardPath_tabu(target));

        // ************ ****************
        // int n = 3;
        // int[][] mazeDP = new int[n][n];
        // System.out.println(mazePath_memo(0, 0, n - 1, n - 1, mazeDP));
        // System.out.println(mazePath_tabu(n - 1, n - 1));

        // System.out.println(mazePathMultiJump(0, 0, n - 1, n - 1));
        // System.out.println(mazePathMultiJump_tabu(n - 1, n - 1));

        // MinCostPath
        // int[][] minCostMat = { { 2, 3, 0, 4 }, { 0, 6, 5, 2 }, { 8, 0, 3, 7 }, { 2,
        // 6, 4, 2 } };
        // int[][] dp = new int[minCostMat.length][minCostMat[0].length];
        // System.out.println(minCostPath_memo(0, 0, minCostMat.length - 1,
        // minCostMat[0].length - 1, minCostMat, dp));
        // System.out.println(minCostPath_tabu(minCostMat));

        // int[] jumps = { 1, 3, 0, 3, 3, 0, 0, 2, 1, 0 }; // { 1, 3, 5, 8, 9, 2, 6, 7,
        // 6, 8, 9 };
        // System.out.println(minJump(0, jumps));
        // System.out.println(minJumpTabu(jumps));

        // System.out.println(singleAndPair(5));
        // System.out.println(singleAndPairTwoVar(5));

        // System.out.println(divideInKGroups(3,2));
        // longestPaliSubstr("forgeeksskeegfor");
        // System.out.println(isPali(""));
        // String str = "babad"; //"forgeeksskeegfor";
        // longestPaliSubstrDP(str);

        // for (String s : subseqRec("pcbcmp")) {
        // System.out.println(s);
        // }

        // lpSubseqDP("pcbcmp"); // GEEKSFORGEEKS: 5, pcbcmp
        // countPSubseq("abcd"); // aaaa:15 , babad:9

        // CSubstr IP/OP ABCDGH:ACDGHR/4, GeeksforGeeks:GeeksQuiz/5, abcdxyz:xyzabcd/4
        // CSubseq ABCDGH:AEDFHR/3-ADH, AGGTAB:GXTXAYB/4-GTAB

        // String s1 = "GeeksforGeeks";
        // String s2 = "GeeksQuiz";

        // recursion
        // longestCommonSubstr(s1, s2, 0);
        // System.out.println(maxleng);

        // System.out.println(longestCommonSubstrDP(s1, s2));

        // longestCommonSubseqDP(s1, s2);

        // System.out.println(countStrAsSubseq("GeeksforGeeks", "Gks"));
        // countStrAsSubseqDp("Gks", "GeeksforGeeks");

        //// s1 < s2 : "sunday"/"saturday":3, "cat"/"cut":1, "geek"/"gesek":1
        // System.out.println(matchStrings("saturday", "sunday"));
        // System.out.println(matchStringsDP("cat", "cut"));

        // countDistinctSubseqDP("ababc");

        // countSubsequences("abc", "abbc");

        // int[] LISarr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        // LIS(LISarr);
        // displaydp1(LDS(LISarr));
        // displaydp1(LIS_frmFront(LISarr));
        // LongestBitonicSubseq(LISarr);

        // int[][] goldMatrix = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0,
        // 6, 1, 2 } };
        // System.out.println(goldMine(goldMatrix));

        // int[][] sqMatrix = { { 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1 }, { 1, 1, 1,
        // 1, 1, 1 }, { 1, 1, 1, 1, 0, 0 },
        // { 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 0 } };
        // biggestSquare(sqMatrix);

        // ************
        // int[][] keypad = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, {
        // '*', '0', '#' } };
        // // System.out.println(numberKeypadUtil(keypad, 5));
        // numberKeypadDP(keypad, 5);

        // int[] coins = { 2, 3, 5, 7 };
        // System.out.println(coinChangePermuRec(coins, 10));
        // coinChangePermDP(coins, 10);

        // System.out.println(coinChangeCombiRec(coins, 0, 10, ""));
        // int[] combiDPCoins = { 2, 3, 5, 7 };
        // coinChangeCombiDP(combiDPCoins, 10);

        // ------------------------------------------------
        // int[] wt = { 1, 3, 4, 5 };
        // int[] profit = { 10, 40, 50, 70 };

        // knapsack_rec(wt, profit, 0, 0, 8);
        // System.out.println(maxProfit);

        // knapsackDP(wt, profit, 8);
        // knapsackDP_spaceOp(wt, profit, 8);

        // ------------------------------------------
        // System.out.println(encoding("110023")); // 110000410
        // encodingDP("110023");

        // -------------------------------------------

        // Samples: { 40, 20, 30, 10, 30 }; = 26000
        // {10, 20, 30, 40, 30}; = 30000, {10, 20, 30}; = 6000

        // int[] ar = { 40, 20, 30, 10, 30 };
        // System.out.println(mcmRec(ar, 1, ar.length - 1));
        // mcmDP(ar);
        // mcmDP2(ar);

        // -----------------------------------------------
        // String str = "abccbc";
        // System.out.println(palindromicCut(str, 0, str.length() - 1));
        // palindromicCutDP(str);

        // ----------------------------
        // { 5, 10 }; :60 // { 1, 2, 3, 4, 5 }; :110 // { 2, 4, 5, 8, 9, 2, 1, 6 }; :978
        // int[] arr = { 1, 2, 3, 4, 5 };
        // System.out.println(BurstBalloonRec(arr, 0, arr.length - 1, 1, 1));
        // BurstBalloonsDP(arr);
        // --------------------------------------------------------
        // int[] lengths = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };

        // System.out.println(rodCutting(lengths, price, 0, 8));
        // rodCuttingDP(lengths, price, 8);

        // ----------------------------------------------------------

        // key[] = {10, 12}, freq[] = {34, 50} : O/P = 118
        // key[] = { 10, 12, 20 }, freq[] = { 34, 8, 50 } : O/P = 142

        // int[] key = { 10, 12, 20 };
        // int[] freq = { 34, 8, 50 };
        // recursion 1: 3 varrying variable , Hence 3D DP bnega agr use kiya
        // System.out.println(OBST(key, freq, 0, key.length - 1, 1));

        // recursion 2: 2 varrying variable , Hence 2D DP bnega agr use kiya
        // int[] costs = new int[freq.length];
        // for (int i = 0; i < costs.length; i++) {
        // costs[i] = freq[i] + ((i == 0) ? 0 : costs[i - 1]);
        // }
        // System.out.println(OBST_rec2(key, freq, 0, key.length - 1, costs));

        // OBST_DP(key, freq);
        // -----------------------------------------------
        // Boolean Parenthesization Problem
        // "TTFT" : "|&^" , "TFT" : "^&"
        char[] symbols = "TTFT".toCharArray();
        char[] operators = "|&^".toCharArray();
        // int countTrue = countParenthe(symbols, operators, 0, symbols.length - 1,
        // true);
        // System.out.println(countTrue);
        countParenthe(symbols, operators);

    }

    static int totalCalls = 0;

    // display 2d 1d dp
    public static void displaydp1(int[] dp) {
        System.out.println(Arrays.toString(dp));
    }

    public static void displaydp2(int[][] dp) {
        for (int[] ar : dp) {
            System.out.println(Arrays.toString(ar));
        }
    }

    // recursion
    public static int fibonacci(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;

        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    // please match side by side with recursion Code.
    public static int fibonacciDPT(int num) {

        int[] fiboDPArray = new int[num + 1]; // +1 becoz 5th idx ki value chahiye (if num = 5).

        for (int i = 0; i < fiboDPArray.length; i++) {
            // baseCase
            if (i == 0 || i == 1) {
                fiboDPArray[i] = i; // idx 0 pe 0, idx 1 pe 1.
            } else {

                fiboDPArray[i] = fiboDPArray[i - 1] + fiboDPArray[i - 2];
            }
        }

        return fiboDPArray[num];
    }

    public static int fibonacciDPM(int num, int[] DP) {
        if (num == 0)
            return DP[0];
        if (num == 1)
            return DP[1];

        if (DP[num] != 0) {
            return DP[num];
        }

        int result = fibonacciDPM(num - 1, DP) + fibonacciDPM(num - 2, DP);
        DP[num] = result;

        return result;
    }

    // by tabulation one thing is observed that ek time pe array se just pichhle 2
    // values hi
    // chahiye. So we calculate fib of any number by maintaining two
    // values/variable only. Hence, No need to create array ==> reducing the space.

    public static int fibonacciTwoVariable(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;

        int l = 0; // fib(0)
        int m = 1; // fib(1)

        for (int i = 2; i <= num; i++) {
            int res = l + m;
            l = m;
            m = res;
        }

        return m;
    }

    public static void linearRecurrenceFibonacci(int num) {
        int[][] magicMatrix = { { 1, 1 }, { 1, 0 } };
        int[][] baseCondition = { { 1 }, { 0 } };

        int[][] powMagicMatrix = pow(magicMatrix, num - 1);

        int[][] ansMatrix = matrixMultiplication(powMagicMatrix, baseCondition);

        for (int[] is : ansMatrix) {
            System.out.println(Arrays.toString(is));
        }
    }

    static int powCount = 0;

    public static int[][] pow(int[][] magicMatrix, int n) {
        powCount++;
        if (n == 1) {
            return magicMatrix;
        }

        if (n % 2 == 0) {
            // mat * mat
            int[][] mat = pow(magicMatrix, n / 2);
            return matrixMultiplication(mat, mat);
        } else {
            // mat * mat * maigcMatrix
            int[][] mat = pow(magicMatrix, n / 2);
            return matrixMultiplication(matrixMultiplication(mat, mat), magicMatrix);
        }
    }

    public static int[][] matrixMultiplication(int[][] mat1, int[][] mat2) {
        // row w.r.t mat1 col w.r.t mat2
        int row = mat1.length;
        int col = mat2[0].length;
        // n x m * m x p. resultant mat = n x p. So m = mat1 col count or mat2 row count
        int m = mat2.length; // m = mat1 col count or mat2 row count

        int[][] resMat = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < m; k++) {
                    resMat[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return resMat;
    }

    // Todo: write linear recurrence matrix expression and algo steps. snap upload
    // and paste link here.

    /**
     * BoardPathQues: ek 2D board hai(imaging it like an array) of length 10. and
     * you have a dice. Tell all the possible way to reach the target (10th cell on
     * the board)
     */
    public static int boardPath_rec(int st, int target) {
        if (st == target) {
            return 1;
        }

        int count = 0;

        for (int jump = 1; jump <= 6; jump++) {
            if (st + jump <= target) {
                count += boardPath_rec(st + jump, target);
            }
        }
        return count;
    }

    public static int boardPath_memo(int st, int target, int[] dp) {
        if (st == target) {
            dp[st] = 1; // when you are already on target, only one way . kahi mat jao.
            return 1;
        }

        int count = 0;

        if (dp[st] != 0) {
            return dp[st];
        }

        for (int jump = 1; jump <= 6; jump++) {
            if (st + jump <= target) {
                count += boardPath_memo(st + jump, target, dp);
            }
        }
        dp[st] = count;
        return count;
    }

    // Tabulation
    public static int boardPath_tabu(int target) {
        int[] dp = new int[target + 1];

        for (int idx = dp.length - 1; idx >= 0; idx--) {

            if (idx == target) { // baseCase
                dp[target] = 1;
                continue;
            }
            for (int jump = 1; jump <= 6 && jump + idx <= target; jump++) {
                dp[idx] += dp[idx + jump];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] DP) {
        // base
        if (sr == er && sc == ec) {
            DP[sr][sc] = 1;
            return 1;
        }

        if (DP[sr][sc] != 0) {
            return DP[sr][sc];
        }

        int count = 0;

        // Horizontal Move (sr, sc+1)
        if (sc + 1 <= ec) {
            count += mazePath_memo(sr, sc + 1, er, ec, DP);
        }

        // Vertical Move (sr+1, sc)
        if (sr + 1 <= er) {
            count += mazePath_memo(sr + 1, sc, er, ec, DP);
        }

        // Diagonal Move (sr+1, sc +1)
        if (sr + 1 <= er && sc + 1 <= ec) {
            count += mazePath_memo(sr + 1, sc + 1, er, ec, DP);
        }

        DP[sr][sc] = count;
        return count;
    }

    public static int mazePath_tabu(int er, int ec) {
        int[][] dp = new int[er + 1][ec + 1];

        for (int sr = dp.length - 1; sr >= 0; sr--) {
            for (int sc = dp[0].length - 1; sc >= 0; sc--) {
                // base
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                // Horizontal Move (sr, sc+1)
                if (sc + 1 <= ec) {
                    dp[sr][sc] += dp[sr][sc + 1];
                }

                // Vertical Move (sr+1, sc)
                if (sr + 1 <= er) {
                    dp[sr][sc] += dp[sr + 1][sc];

                }

                // Diagonal Move (sr+1, sc +1)
                if (sr + 1 <= er && sc + 1 <= ec) {
                    dp[sr][sc] += dp[sr + 1][sc + 1];
                }
            }
        }
        // Display DP
        return dp[0][0];
    }

    public static int mazePathMultiJump(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            return 1;
        }

        int count = 0;

        // Horizontal Move
        for (int jump = 1; sc + jump <= ec; jump++) {
            count += mazePathMultiJump(sr, sc + jump, er, ec);
        }

        // Vetical Move
        for (int jump = 1; sr + jump <= er; jump++) {
            count += mazePathMultiJump(sr + jump, sc, er, ec);
        }

        // Diagonal Move
        for (int jump = 1; sc + jump <= ec && sr + jump <= er; jump++) {
            count += mazePathMultiJump(sr + jump, sc + jump, er, ec);
        }

        return count;
    }

    public static int mazePathMultiJump_tabu(int er, int ec) {
        int[][] dp = new int[er + 1][ec + 1];

        for (int sr = dp.length - 1; sr >= 0; sr--) {
            for (int sc = dp[0].length - 1; sc >= 0; sc--) {
                // baseCase
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }
                // Horizontal Move
                for (int jump = 1; sc + jump <= ec; jump++) {
                    dp[sr][sc] += dp[sr][sc + jump];
                }
                // Vetical Move
                for (int jump = 1; sr + jump <= er; jump++) {
                    dp[sr][sc] += dp[sr + jump][sc];
                }
                // Diagonal Move
                for (int jump = 1; sc + jump <= ec && sr + jump <= er; jump++) {
                    dp[sr][sc] += dp[sr + jump][sc + jump];
                }

            }
        }
        // Displaydp2(dp);
        return dp[0][0];
    }

    static int[][] dirArray = { { 0, 1 }, { 1, 0 } };

    public static int minCostPath_memo(int sr, int sc, int er, int ec, int[][] costMat, int[][] dp) {
        if (sr == er && sc == ec) {
            return costMat[sr][sc];
        }

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        int minCost = Integer.MAX_VALUE;
        // using direction Array to make Horizontal Vertical and even diagonal move.
        for (int[] dir : dirArray) {
            int y = dir[0];
            int x = dir[1];

            if (sc + x <= ec && sr + y <= er) {
                minCost = Math.min(minCost, minCostPath_memo(sr + y, sc + x, er, ec, costMat, dp));
            }
        }

        minCost += costMat[sr][sc];
        dp[sr][sc] = minCost;
        return minCost;
    }

    public static int minCostPath_tabu(int[][] costMat) {
        int er = costMat.length - 1;
        int ec = costMat[0].length - 1;
        int[][] dp = new int[er + 1][ec + 1];

        for (int sr = dp.length - 1; sr >= 0; sr--) {
            for (int sc = dp[0].length - 1; sc >= 0; sc--) {
                // baseCase
                if (sr == er && sc == ec) {
                    dp[sr][sc] = costMat[sr][sc];
                    continue;
                }

                int minCost = Integer.MAX_VALUE;

                // HorizontalMove
                if (sc + 1 <= ec) {
                    minCost = Math.min(minCost, dp[sr][sc + 1]);
                }

                // VerticalMove
                if (sr + 1 <= er) {
                    minCost = Math.min(minCost, dp[sr + 1][sc]);
                }

                minCost += costMat[sr][sc];
                dp[sr][sc] = minCost;
            }
        }
        displaydp2(dp);
        return dp[0][0];
    }

    // Minimum number of jumps to reach end of an array. where each element
    // represents the max number of steps that can be made forward from that
    // element.

    public static int minJump(int idx, int[] jumps) {
        if (idx == jumps.length - 1) {
            return 0; // no jump required if you are already at end.
        }
        // at dead point.
        if (jumps[idx] == 0) {
            return 100000000; // matlb yaha se kabi minimum aa hi nai skta.
        }

        int minRes = Integer.MAX_VALUE;
        for (int step = 1; step <= jumps[idx]; step++) {
            if (idx + step < jumps.length) {
                int res = minJump(idx + step, jumps) + 1;
                minRes = Math.min(minRes, res);
            }
        }
        return minRes;
    }

    public static int minJumpTabu(int[] jumps) {
        int[] dp = new int[jumps.length];

        for (int idx = dp.length - 1; idx >= 0; idx--) {
            // baseCase:
            if (idx == jumps.length - 1) {
                dp[idx] = 0;
                continue;
            }
            // at dead point
            if (jumps[idx] == 0) {
                dp[idx] = 100000000;
                continue;
            }

            int minJump = Integer.MAX_VALUE;
            for (int step = 1; step <= jumps[idx]; step++) {
                if (idx + step < jumps.length) {
                    int potentialMin = dp[idx + step] + 1;
                    minJump = Math.min(minJump, potentialMin);
                }
            }
            dp[idx] = minJump;
        }
        displaydp1(dp);
        return dp[0];
    }

    // jab mai single rehna chahta hu: ROQ: f(n-1). roq ka ans is my ans.
    // jab mai pair mai rehna chahta hu ROQ: f(n-2). roq * (n-1) is my ans.
    // So final answer: f(n)=f(n-1) + f(n-2) * (n-1).

    public static int singleAndPair(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        int totalWays = 0;

        // WHEN SINGLE: jitane ans "n-1" (r.o.q) k honge utni baar mai single ja skta hu
        // uske saath.
        totalWays += singleAndPair(n - 1);

        // WHEN PAIR UP: roq= n-2. And mere pair krne k ways: (n-1). Hence total
        // combination = (n-1)*(roq_Ans)
        totalWays += (n - 1) * singleAndPair(n - 2);

        return totalWays;
    }

    public static int singleAndPair_tabu(int n) {
        int[] dp = new int[n + 1];

        for (int idx = 0; idx < dp.length; idx++) {
            if (idx == 0 || idx == 1) {
                dp[idx] = 1;
                continue;
            }
            dp[idx] = dp[idx - 1] + ((idx - 1) * dp[idx - 2]);
        }
        // displaydp1(dp);
        return dp[dp.length - 1];
    }

    public static int singleAndPairTwoVar(int n) {

        int p = 1; // f(0)
        int q = 1; // f(1)

        for (int idx = 2; idx <= n; idx++) {
            int r = q + ((idx - 1) * p);
            p = q;
            q = r;
        }
        return q;
    }

    // N: No's ko, K: set mai divide krna hai, such that koi bhi set khali na rhe.
    // know there can be many possible ways to do that, count all the ways.
    // Note: ek number ek time pe ek hi set mai exist kr skta.
    // public static int divideInKGroups(int n, int k) {

    // // BaseCase0
    // if (n < k) {
    // return 0;
    // }

    // // BaseCase1
    // if (n == k) {
    // int res = 1;
    // for (int i = 2; i <= n; i++) {
    // res *= i;
    // }
    // return res;
    // }

    // // N > K
    // int ans = k * divideInKGroups(n - 1, k);

    // return ans;
    // }

    public static boolean isPali(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            lcount++;
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static int lcount = 0;

    public static void longestPaliSubstr(String str) {
        int lpLen = 0;
        for (int st = 0; st < str.length(); st++) {
            for (int end = st + 1; end <= str.length(); end++) {
                lcount++;
                String substring = str.substring(st, end);
                if (isPali(substring)) {
                    lpLen = Math.max(lpLen, substring.length());
                }
            }
        }
        System.out.println(lpLen);
    }

    // ques: how dp aprroach of LPSStr is better than forloop(BruteFoce apporach).
    // Real data proof

    // https://leetcode.com/articles/longest-palindromic-substring/
    // no need to create truth table: But truth table se approach ka idea lg jayega.
    // substring S(i,j) is palindrome if S(i+1, j-1) is palindrome && i == j
    // how to check if S(i+1, j-1) palindrome? if this position in DP is anything
    // otherthan 0.

    public static int longestPaliSubstrDP(String str) {
        int[][] dp = new int[str.length()][str.length()];
        int lpLen = 0;
        String lpString = "";
        int start = 0;
        int end = 0;

        // Traversing Diagonally over 2d dp
        for (int diag = 0; diag < dp[0].length; diag++) {
            // i : row har bar 0 se star. j : col w.t.t diag pos.
            for (int i = 0, j = diag; j < dp[0].length; i++, j++) {
                // baseCase
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j)) {
                    // No gap b/w i,j chars. So i,j k bich mai chck krna bnta bhi nai.
                    if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }

                if (dp[i][j] > lpLen) {
                    lpLen = dp[i][j];
                    start = i;
                    end = j + 1;
                    // lpString = str.substring(i, j+1);
                }

            }
        }
        lpString = str.substring(start, end);
        System.out.println(lpLen);
        System.out.println(lpString);
        displaydp2(dp);
        return 0;
    }

    // generating subseq
    public static ArrayList<String> subseqRec(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = subseqRec(str.substring(1));
        int size = recAns.size();
        for (int i = 0; i < size; i++) {
            recAns.add(ch + recAns.get(i));
        }

        return recAns;
    }

    public static int lpSubseqDP(String str) {
        int[][] dp = new int[str.length()][str.length()];

        for (int diag = 0; diag < dp[0].length; diag++) {
            for (int i = 0, j = diag; j < dp[0].length; i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j)) {
                    // no char b/w i, j
                    if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        // Max of {(i, j-1) , (i + 1, j) + 2 ( +2 beocz my start == end )
                        // dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]) + 2;
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }

                } else {
                    // st != end. then, max length of pSubseq for me = max length of pSubseq my
                    // "SubStrings" can make.
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        displaydp2(dp);
        return dp[0][dp[0].length - 1];
    }

    // Counting numbers of Palindromic subseq in a string.
    // https://media.geeksforgeeks.org/wp-content/uploads/20190804162927/00011.jpg
    // 1. In str(i,j), regardless of if first and last char are equal or not, count
    // all palSubseq in str(i, j -1) and (i+1, j).(ek bar starting char ko chorke,
    // ek bar end char ko chorke).

    // ##SOME OBSERVATION: Jab hum do call lgate hai, ek bar left char ko aur ek bar
    // right char ko drop krke. Then we will find that dono chars ko chorke jo str
    // bcha S(i+1, j-1) (lets call it "TRIMMED STR") wo upr wale dono calls mai
    // common hai. So, agr ye TRIMMED STR kuch answers lata hai toh wo answers dono
    // calls mai dikhegye. Aur since hum number of Palindromic Subseq count kr rahe
    // hai, toh ye TRIMMED STR ka answer do baar count ho jayega. <br/>

    // For this, Solution is: TRIMMED STR ke jitne answers hongey(count)
    // wo TRIMMED STR k dp location (i+1, j-1) pe save hoga. So iss count ko
    // generate answer mese substract krlo kyuki ye do bar count ho gya tha, ek bar
    // left char ko aur ek bar right char ko drop krke jab calls lga tha.

    // 2. Only when first and last char are equal: <br/>
    // (a). ch(i) + ch(j) is also a subseq so, count = count + 1;
    // (b). if we have substr inbetween. S(i+1, j-1). then S ke jinte pali count
    // hongey unsbke sath start and end lg k same number of new subseq bna dengye.
    // so now count = count + dp[i+1][j-1]

    public static int countPSubseq(String str) {
        int[][] dp = new int[str.length()][str.length()];

        for (int diag = 0; diag < dp[0].length; diag++) {
            for (int i = 0, j = diag; j < dp[0].length; i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                int count = (dp[i + 1][j] + dp[i][j - 1]) - (dp[i + 1][j - 1]);

                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i == 1) { // no char b/w i, j OR NO GAP.
                        count += 1; // no gap. no inner substr. +1 becoz chi + chj is also a subseq
                    } else {

                        // becoz char(i) + char(j) is also a subseq
                        count += 1;
                        // becoz jitana inner substr (i + 1,j - 1) palindrome bneyga, un sabko char(i),
                        // char(j) mai sandwich krke utne hi new palindrom bn jayega.
                        count += dp[i + 1][j - 1];

                    }
                }
                dp[i][j] = count;
            }
        }
        displaydp2(dp);
        return dp[0][dp[0].length - 1];
    }

    // Recursion
    static int maxleng = 0;

    public static void longestCommonSubstr(String s1, String s2, int count) {

        if (s1.length() == 0 || s2.length() == 0) {
            maxleng = Math.max(maxleng, count);
            return;
        }

        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);
        if (ch1 == ch2) {
            longestCommonSubstr(s1.substring(1), s2.substring(1), count + 1);

        } else {
            maxleng = Math.max(maxleng, count);
            longestCommonSubstr(s1, s2.substring(1), 0);
            longestCommonSubstr(s1.substring(1), s2, 0);

        }
    }

    public static int longestCommonSubstrDP(String s1, String s2) {

        // dp size is +1 becoz last row and col will represent empty string.
        int[][] dp = new int[s1.length()][s2.length()];

        // col pe hai s2 AND row pe hai s1.
        // note that loop hum strings k last idx se chla rhe hai and not from dp k last
        // idx se. DP k last idx ko empty string ko represent krne ko rkha hai.
        int result = 0;
        for (int rowIdx = dp.length - 1; rowIdx >= 0; rowIdx--) {
            for (int colIdx = dp[0].length - 1; colIdx >= 0; colIdx--) {

                if (s1.charAt(rowIdx) == s2.charAt(colIdx)) {

                    int res = 0;
                    if (rowIdx + 1 < dp.length && colIdx + 1 < dp[0].length) {
                        res = dp[rowIdx + 1][colIdx + 1];
                    }
                    dp[rowIdx][colIdx] = res + 1;
                    result = Math.max(dp[rowIdx][colIdx], result);
                }
            }
        }

        displaydp2(dp);
        return result;
    }

    public static int longestCommonSubseqDP(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];

        for (int rowIdx = dp.length - 1; rowIdx >= 0; rowIdx--) {
            for (int colIdx = dp[0].length - 1; colIdx >= 0; colIdx--) {

                if (s1.charAt(rowIdx) == s2.charAt(colIdx)) {
                    int res = 0;
                    if (rowIdx + 1 < dp.length && colIdx + 1 < dp[0].length) {
                        res = dp[rowIdx + 1][colIdx + 1];
                    }
                    dp[rowIdx][colIdx] = res + 1;

                } else {
                    // mere se start hone wale common subseq toh nahi ho skte. But kya pta mujhe
                    // chhorke jo
                    // substr bna wo shayd common subseq bna de. ye possibility dono str mai krna
                    // hoga.
                    int res1 = (rowIdx + 1 < dp.length) ? dp[rowIdx + 1][colIdx] : 0;
                    int res2 = (colIdx + 1 < dp[0].length) ? dp[rowIdx][colIdx + 1] : 0;

                    dp[rowIdx][colIdx] = Math.max(res1, res2);
                }
            }
        }
        displaydp2(dp);
        return dp[0][0];

    }

    // Find number of times a string occurs as a subsequence in given string
    // Find 's' String in "ques" string
    public static int countStrAsSubseq(String ques, String s) {
        // empty str is subseq of every string. return 1
        if (s.length() == 0 || (ques.length() == 0 && s.length() == 0)) {
            return 1;
        }

        // empty ques mai "s" str (whose length > 0) kabhi nai mil skta.
        if (ques.length() == 0) {
            return 0;
        }

        char ch1 = ques.charAt(0);
        char ch2 = s.charAt(0);
        int count = 0;
        if (ch1 == ch2) {
            int ans1 = countStrAsSubseq(ques.substring(1), s.substring(1));
            int ans2 = countStrAsSubseq(ques.substring(1), s);
            count = ans1 + ans2;
        } else {
            count = countStrAsSubseq(ques.substring(1), s);
        }

        return count;

    }

    public static int countStrAsSubseqDp(String s1, String s2) {
        // find s1 in s2 question. : s1 = row & s2 = column
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int rowIdx = dp.length - 1; rowIdx >= 0; rowIdx--) {
            for (int colIdx = dp[0].length - 1; colIdx >= 0; colIdx--) {

                // baseCase1
                if (rowIdx == dp.length - 1) {
                    dp[rowIdx][colIdx] = 1;
                    continue;
                }

                // baseCase2
                if (colIdx == dp[0].length - 1 && rowIdx != dp.length - 1) {
                    dp[rowIdx][colIdx] = 0;
                    continue;

                }

                if (s1.charAt(rowIdx) == s2.charAt(colIdx)) {
                    int res1 = 0;
                    int res2 = 0;
                    if (rowIdx + 1 < dp.length && colIdx + 1 < dp[0].length) {
                        // find "new" s1(RowIdx+1) in "new" s2(colIdx +1)
                        res1 = dp[rowIdx + 1][colIdx + 1];
                    }

                    if (colIdx + 1 < dp[0].length) {
                        // "new" s2(Currentidx+1) mai s1(old) ke subseq firse count/search kro.
                        // kyki ho skta hai s1 se start hone subseq agey fir se mil jaye.
                        res2 = dp[rowIdx][colIdx + 1];
                    }

                    dp[rowIdx][colIdx] = res1 + res2;

                } else {
                    dp[rowIdx][colIdx] = (colIdx + 1 < dp[0].length) ? dp[rowIdx][colIdx + 1] : 0;
                }
            }
        }
        displaydp2(dp);
        return dp[0][0];
    }

    // s1 =< s2. sara kaam s1 pe hoga w.r.t to s2(bigger string)
    public static int matchStrings(String s1, String s2) {
        totalCalls++;

        if (s1.length() == 0 && s2.length() == 0) {
            return 0;
        }

        if ((s1.length() == 0 && s2.length() != 0)) {
            // return (int) 1e8;
            return s2.length();
        }

        if ((s1.length() != 0 && s2.length() == 0)) {
            return s1.length();
        }

        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);

        int opCount = 1000000;

        if (ch1 == ch2) {
            int recAns = matchStrings(s1.substring(1), s2.substring(1));
            opCount = Math.min(opCount, recAns);
        } else {
            // delete
            if (s1.length() > s2.length()) {
                int recAns = 1 + matchStrings(s1.substring(1), s2);
                opCount = Math.min(opCount, recAns);
            }
            // Insert
            int recAns1 = 1 + matchStrings(ch2 + s1, s2);
            opCount = Math.min(opCount, recAns1);
            // replace
            int recAns2 = 1 + matchStrings(ch2 + s1.substring(1), s2);
            opCount = Math.min(opCount, recAns2);
        }
        return opCount;
    }

    // s1 < s2. And s1 is on column side. S2: row side
    public static int matchStringsDP(String s1, String s2) {
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];

        for (int rowIdx = dp.length - 1; rowIdx >= 0; rowIdx--) {
            for (int colIdx = dp[0].length - 1; colIdx >= 0; colIdx--) {

                int lengS1 = (dp[0].length - 2) - colIdx + 1;
                int lengS2 = (dp.length - 2) - rowIdx + 1;

                // BaseCase1
                if (rowIdx == dp.length - 1 && colIdx == dp[0].length - 1) {
                    dp[rowIdx][colIdx] = 0;
                    continue;
                }

                // BaseCase3
                if (rowIdx == dp.length - 1) {
                    dp[rowIdx][colIdx] = lengS1;
                    continue;
                }

                // BaseCase2
                if (colIdx == dp[0].length - 1) {
                    dp[rowIdx][colIdx] = lengS2;
                    continue;
                }

                if (s1.charAt(colIdx) == s2.charAt(rowIdx)) {
                    dp[rowIdx][colIdx] = dp[rowIdx + 1][colIdx + 1];
                } else {
                    int opCount = 100000;
                    // Delete
                    if (lengS1 > lengS2) {
                        int ans = 1 + dp[rowIdx][colIdx + 1];
                        opCount = Math.min(opCount, ans);
                    }

                    // insert
                    int ans1 = 1 + dp[rowIdx + 1][colIdx];
                    opCount = Math.min(opCount, ans1);
                    // replace
                    int ans2 = 1 + dp[rowIdx + 1][colIdx + 1];
                    opCount = Math.min(opCount, ans2);

                    dp[rowIdx][colIdx] = opCount;
                }
            }
        }
        displaydp2(dp);
        return dp[0][0];

    }

    public static int countDistinctSubseqDP(String str) {
        // +1 to store empty string subseq.
        int[] dp = new int[str.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            // baseCase
            if (i == dp.length - 1) {
                dp[i] = 1;
                continue;
            }

            // i to str end length = (strLastIdx - currentIdx + 1) == (strLastIdx - i) + 1
            int count = 2 * dp[i + 1];

            int prIdx = str.indexOf(str.charAt(i), i + 1);
            if (prIdx != -1) {
                // dublicate = current idx(prIdx) k char "se" bnne wale saare subseq na ki
                // curr idx "tak" k sare subseq. hme bs wo chaiye jiska starting PrIdx char ho.
                int duplicateCount = dp[prIdx] - dp[prIdx + 1];
                count = count - duplicateCount;
            }
            dp[i] = count;

        }
        displaydp1(dp);
        return dp[0];
    }

    /**
     * Given a string, count number of subsequences of the form a^i b^j c^k, i.e.,
     * it consists of i ’a’ characters, followed by j ’b’ characters, followed by k
     * ’c’ characters where i >= 1, j >=1 and k >= 1.
     * 
     * @param s1 = jisko find krna hai compressed subseq form e.g abc
     * @param s2 = jispe find krna hai, i.e question str e.g: abcabc o/p = 7
     * 
     *           below code is exactly same as find in "geeksforgeeks" count of
     *           subseq of "gks"
     */
    public static int countSubsequences(String s1, String s2) {
        // find s1 in s2 question. : s1 = row & s2 = column
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int rowIdx = dp.length - 1; rowIdx >= 0; rowIdx--) {
            for (int colIdx = dp[0].length - 1; colIdx >= 0; colIdx--) {

                // baseCase1
                if (rowIdx == dp.length - 1) {
                    dp[rowIdx][colIdx] = 1;
                    continue;
                }

                // baseCase2
                if (colIdx == dp[0].length - 1 && rowIdx != dp.length - 1) {
                    dp[rowIdx][colIdx] = 0;
                    continue;

                }

                if (s1.charAt(rowIdx) == s2.charAt(colIdx)) {
                    int res1 = 0;
                    int res2 = 0;
                    if (rowIdx + 1 < dp.length && colIdx + 1 < dp[0].length) {
                        // find "new" s1(RowIdx+1) in "new" s2(colIdx +1)
                        res1 = dp[rowIdx + 1][colIdx + 1];
                    }

                    if (colIdx + 1 < dp[0].length) {
                        // "new" s2(Currentidx+1) mai s1(old) ke subseq firse count/search kro.
                        // kyki ho skta hai s1 se start hone subseq agey fir se mil jaye.
                        // jitane count aaya utana ans toh hai hi pr iske agey mai lg k naye answer bna
                        // skta hu. e.g In a(--s--) if S mai 4 "abc" format k subseq hai toh inke aagey
                        // mera "a" bhi toh lg skta hai example (a + aaabcc) or (a + abbc) jo ki valid
                        // hai. matlb ans hoga double.
                        // but in question find "gks" subseq in "geeksforgeeks" wale mai hum double nai
                        // krte the becz gggks is not valid answer for that quesstn. only "gks"
                        res2 = 2 * dp[rowIdx][colIdx + 1];
                    }

                    dp[rowIdx][colIdx] = res1 + res2;

                } else {
                    dp[rowIdx][colIdx] = (colIdx + 1 < dp[0].length) ? dp[rowIdx][colIdx + 1] : 0;
                }
            }
        }
        displaydp2(dp);
        return dp[0][0];
    }

    // Given a gold mine of n*m dimensions. Each field in this mine contains a
    // positive integer which is the amount of gold in tons. Initially the miner is
    // at first column but can be at any row. He can move only (right->,right up
    // /,right down\) that is from a given cell, the miner can move to the cell
    // diagonally up towards the right or right or diagonally down towards the
    // right. Find out maximum amount of gold he can collect.
    public static int goldMine(int[][] goldMatix) {
        int[][] dp = new int[goldMatix.length][goldMatix[0].length];
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } }; // backward direction: front, right front, left front
        int max = -1;

        for (int col = dp[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < dp.length; row++) {

                if (col == dp[0].length - 1) {
                    dp[row][col] = goldMatix[row][col];
                    continue;
                }
                int maxGold = -1;

                for (int i = 0; i < dir.length; i++) {
                    int r = row + dir[i][0];
                    int c = col + dir[i][1];
                    if (r < dp.length && r > 0 && c < dp[0].length) {
                        maxGold = Math.max(maxGold, dp[r][c]);
                    }
                }
                dp[row][col] = goldMatix[row][col] + maxGold;
                max = Math.max(max, dp[row][col]);
            }
        }
        displaydp2(dp);
        return max;
    }

    public static int biggestSquare(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };

        for (int rowIdx = dp.length - 1; rowIdx >= 0; rowIdx--) {
            for (int colIdx = dp[0].length - 1; colIdx >= 0; colIdx--) {

                if (rowIdx == dp.length - 1 || colIdx == dp[0].length - 1) {
                    dp[rowIdx][colIdx] = matrix[rowIdx][colIdx];
                    continue;
                }

                if (matrix[rowIdx][colIdx] == 0) {
                    continue;
                }

                int maximumEdgeLen = Integer.MAX_VALUE; // min of all possibility
                for (int i = 0; i < dir.length; i++) {
                    int r = rowIdx + dir[i][0];
                    int c = colIdx + dir[i][1];
                    if (r < dp.length && c < dp[0].length) {
                        maximumEdgeLen = Math.min(maximumEdgeLen, dp[r][c]);
                    }
                }

                if (maximumEdgeLen != 0) {
                    dp[rowIdx][colIdx] = maximumEdgeLen + 1;
                } else {
                    dp[rowIdx][colIdx] = matrix[rowIdx][colIdx]; // OR simple put 1;
                }
            }
        }
        displaydp2(dp);
        return dp[0][0];
    }

    // n^2 solution: TODO: N(LOG(n)) SOLUTION
    // Longest Increasing Subseq
    public static void LIS(int[] arr) {
        int[] dp = new int[arr.length];
        int max = 0;

        // baseCase
        dp[dp.length - 1] = 1;

        for (int i = dp.length - 2; i >= 0; i--) {
            int subseqLen = 0;
            for (int j = i + 1; j < dp.length; j++) {
                // if true means mai j ele ka starting bn skta hu.
                if (arr[j] > arr[i]) {
                    subseqLen = Math.max(subseqLen, dp[j]);
                }
            }
            dp[i] = 1 + subseqLen;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        displaydp1(dp);
    }

    public static int[] LDS(int[] arr) {
        int[] dp = new int[arr.length];
        int max = 0;

        // baseCase
        dp[dp.length - 1] = 1;

        for (int i = dp.length - 2; i >= 0; i--) {
            int subseqLen = 0;
            for (int j = i + 1; j < dp.length; j++) {
                // if true means mai j ele ka starting bn skta hu.
                if (arr[j] < arr[i]) {
                    subseqLen = Math.max(subseqLen, dp[j]);
                }
            }
            dp[i] = 1 + subseqLen;
            max = Math.max(max, dp[i]);
        }
        // System.out.println(max);

        // instead of max, dp return isliye kra rhe hai becoz longest bitonic subseq m
        // use hai.
        return dp;
    }

    // Longest Bitonic Subseq
    // https://drive.google.com/open?id=1pExN25q6dL61ArF31AekU4ToLSJzqh77
    // uper LIS AND LDS dono ko array ke pichhe se calculate kiya hai.
    // So kisi bhi idx ka ans == uss idx se array k last idx tk k ele ka answer hai.
    // but for bitonic subseq, LIS and LDS mese kisi bhi ek ka dp "front" se build
    // krege aur durse ka "pichhe" se.
    public static int[] LIS_frmFront(int[] arr) {
        int[] dp = new int[arr.length];
        int max = 0;

        // baseCase
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int subseqLen = 0;
            for (int j = i - 1; j >= 0; j--) {
                // if true means mai j ele ke abhi tk ke subseq ka mai end bn skta hu.
                if (arr[i] > arr[j]) {
                    subseqLen = Math.max(subseqLen, dp[j]);
                }
            }
            dp[i] = 1 + subseqLen;
            max = Math.max(max, dp[i]);
        }
        // System.out.println(max);

        // instead of max, dp return isliye kra rhe hai becoz longest bitonic subseq m
        // use hai.
        return dp;
    }

    public static void LongestBitonicSubseq(int[] arr) {
        int[] LIS = LIS_frmFront(arr);
        int[] LDS = LDS(arr);

        // EXTRAAAA: just to display bitonic length each idx.
        int[] bitonicDP = new int[arr.length];

        int maxBitonicLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int b = LIS[i] + LDS[i] - 1;
            bitonicDP[i] = b;
            maxBitonicLen = Math.max(maxBitonicLen, b);
        }

        System.out.println("Longest Bitonic Subseq: " + maxBitonicLen);
        displaydp1(bitonicDP);
    }

    // https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
    // Recursive Method
    public static int numberKeypadUtil(int[][] keypad, int moves) {

        int count = 0;
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[0].length; j++) {
                if (keypad[i][j] != '*' && keypad[i][j] != '#')
                    count += numberKeypad(keypad, i, j, moves);
            }
        }

        return count;
    }

    static int[][] keypadDir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    // recursive Method
    // faith: it there are n moves allowed from my location, toh mai har wo location
    // jaha pe mai visit kr skta hu from from location, unko bolunga tum apne tk k
    // saare answer le aao jo tum (n-1) moves mai bna skte ho. jo tumhra answer
    // ayega usme 1 move ka effort lga k wo answers mere se (n) moves mai milne wale
    // answer ho jayege.
    public static int numberKeypad(int[][] keypad, int row, int col, int moves) {

        if (moves == 1) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < keypadDir.length; i++) {
            int r = row + keypadDir[i][0];
            int c = col + keypadDir[i][1];
            // calls should be inside keypad boundary limit.
            if (r >= 0 && r < keypad.length && c >= 0 && c < keypad[0].length) {
                if (keypad[r][c] != '*' && keypad[r][c] != '#') {
                    count += numberKeypad(keypad, r, c, moves - 1);
                }
            }
        }
        return count;
    }

    public static void numberKeypadDP(int[][] keypad, int moves) {
        int[][] dp = new int[moves + 1][10];

        int[][] keypadDir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int move = 1; move < dp.length; move++) {
            // keyword row - col
            for (int i = 0; i < keypad.length; i++) {
                for (int j = 0; j < keypad[0].length; j++) {

                    // key at which we are currently == dp jiski abhi fill krne aaye hai
                    if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                        int num = keypad[i][j] - '0';

                        // baseCondition
                        if (move == 1) {
                            dp[move][num] = 1;
                            continue;
                        }

                        // possible direction
                        for (int d = 0; d < keypadDir.length; d++) {
                            int r = i + keypadDir[d][0];
                            int c = j + keypadDir[d][1];

                            // check for valid move
                            if (r >= 0 && r < keypad.length && c >= 0 && c < keypad[0].length) {
                                if (keypad[r][c] != '*' && keypad[r][c] != '#') {
                                    int nbrNum = keypad[r][c] - '0';
                                    dp[move][num] += dp[move - 1][nbrNum];
                                }
                            }
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int n : dp[dp.length - 1]) { // last row values
            count += n;
        }

        displaydp2(dp);
        System.out.println(count);
    }

    // ************************** TODO ***********************
    // look notes for hint how n(logN)?
    // * Leetcode 354. Russian Doll Envelopes n(lonN)
    // * Activity Selection Problem n(logN)
    // https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
    // * Building Bridges
    // https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
    // * target Sum problem
    // * unbounded knapsack
    // * fractional knapsack

    // one coin can be used for infinity number of times
    public static int coinChangePermuRec(int[] coins, int target) {

        if (target == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int ntarget = target - coins[i];
            if (ntarget >= 0) {
                count += coinChangePermuRec(coins, ntarget);
            }
        }
        return count;
    }

    public static void coinChangePermDP(int[] coins, int target) {
        // +1 becoz baseCase hi hai ki 0 target 1 ans. and target is represented by idx.
        int[] dp = new int[target + 1];

        for (int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i] = 1;
                continue;
            }
            for (int j = 0; j < coins.length; j++) {
                int ntarget = i - coins[j];
                if (ntarget >= 0) {
                    dp[i] += dp[ntarget];
                }
            }

        }
        // Exactly same code will work for coinChangeCombi, jsut exchange for loop
        // position. ALWAYS REMEMBER.
        displaydp1(dp);
        System.out.println(dp[target]);
    }

    // one coin can be used for infinity number of times
    public static int coinChangeCombiRec(int[] coins, int idx, int target, String ans) {
        if (target == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            int ntarget = target - coins[i];
            if (ntarget >= 0) {

                // note: TWO VARIABLES 'i' and 'ntarget'. hence 2d DP.
                // faith: ntarget ko i idx aggey wale saare coins ka use krke answer le aa.
                // means mere aur mere se aagey wale coin use krke hi ntarget acheive kr skta
                // hai.
                count += coinChangeCombiRec(coins, i, ntarget, ans + " " + coins[i]);
            }
        }
        return count;
    }

    // Time: "almost" O(n * m) Space: n * m : n = target, m = coins
    // by me. Complex. look next code, simple and optimize
    public static void coinChangeCombiDP(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];

        // tar idx === dp's col. represent targets 0 to target
        for (int tar = 0; tar < dp[0].length; tar++) {
            // i represent coins arr, row
            for (int i = 0; i < dp.length; i++) {

                int ntar = tar - coins[i];
                if (ntar == 0) {
                    dp[i][tar] = 1;
                    continue;
                }

                if (ntar > 0) {
                    // looking ways to achieve ntar with curr coin to last coin (i to dp.length - 1)
                    // unsbka sum == total ways to achieve curr target with coins (i to dp.length-1)
                    for (int coinIdx = i; coinIdx < dp.length; coinIdx++) {
                        dp[i][tar] += dp[coinIdx][ntar];
                    }
                }
                // when coin > target: dp = 0. No need to do anything, automatically handled.
            }
        }
        displaydp2(dp);

        int count = 0;
        // last column k saare elements ka sum
        for (int i = 0; i < dp.length; i++) {
            count += dp[i][dp[0].length - 1];
        }
        System.out.println("total combinations: " + count);
    }

    // space optimized coinChange Combination.
    // time: "perfect" O(n * m). Space: O(n)
    // video: 11Jan, 02:45:00
    public static void coinChangeCombiDP_Optimized(int[] coins, int target) {
        int[] dp = new int[target + 1];

        // below code is EXACTLY SAME as coinChangePermuDP. Bs for loop ki position
        // exchanged hai. Always remember
        for (int i = 0; i < coins.length; i++) {
            for (int tar = 0; i < dp.length; tar++) {
                if (tar == 0) {
                    dp[0] = 1; // baseCase. 0 target bnane ka ek tarika, coin use hi na karo.
                    continue;
                }

                int ntarget = tar - coins[i];

                if (ntarget >= 0) {
                    dp[tar] += dp[ntarget];
                }
            }
        }
    }

    static int maxProfit = Integer.MIN_VALUE;

    public static void knapsack_rec(int[] wt, int[] val, int idx, int profit, int target) {
        if (target == 0) {
            // System.out.println(profit);
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        for (int i = idx; i < wt.length; i++) {
            int ntarget = target - wt[i];

            if (ntarget >= 0) {
                knapsack_rec(wt, val, i, profit + val[i], ntarget);
            }
        }
    }

    /**
     * SUBSEQUENCE METHOD: ya toh weight aayega ya toh nai aayega. Time: O(m *n)
     * Space: O(m * n) where n: target, m: wt/val array size.
     * 
     * faith: current wt(i) k pass 2 option hai. <br>
     * 1) agar wt(i) nahi aata hai toh maxProfit = i se pehle wale wts ka use krke
     * curr target k liye jo MaxProfit generate hua tha wahi target ka maxProfit
     * hoga. which is stored at (i-1)th row of curr target column. <br>
     * 
     * 2) agar i wt anna chahta hai max Profit can also be the profit generated
     * after including i wt.
     * 
     * so maxProfit = max Profits amongs these two possibilities.
     */

    public static void knapsackDP(int[] wt, int[] val, int target) {
        int[][] dp = new int[val.length][target + 1];

        // row = allowed weight
        for (int i = 0; i < dp.length; i++) {
            // col: targets
            for (int j = 0; j < dp[0].length; j++) {
                int ntarget = j - wt[i];

                // when wt is not considered
                dp[i][j] = ((i - 1) >= 0) ? dp[i - 1][j] : 0;

                if (ntarget >= 0) {

                    // when wt is considered.
                    int profit = dp[i][ntarget] + val[i];
                    dp[i][j] = Math.max(dp[i][j], profit);

                }
            }
        }
        displaydp2(dp);

    }

    // Space Optimized Solution.
    // Time: O(m*n), Space: O(n). n = target. m = wt/val arr length
    public static void knapsackDP_spaceOp(int[] wt, int[] val, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 0; // 0 profit for 0 target for given wts.

        // target array DP
        for (int i = 1; i < dp.length; i++) {
            // considering each wt(j) to achieve target i.
            for (int j = 0; j < wt.length; j++) {
                int ntarget = i - wt[j];

                if (ntarget >= 0) {
                    int myProfit = dp[ntarget] + val[j];
                    dp[i] = Math.max(dp[i], myProfit);
                }
            }
        }
        System.out.println(dp[target]);
        displaydp1(dp);
    }

    // str: 1142
    public static ArrayList<String> encoding(String str) {

        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        // handling edge case like: 1351000001
        if (str.charAt(0) == '0') {
            // jab ch is '0' tab, it will not contribute in ans. jo ans agey se ayega wahi
            // yaha tk ka answer ho. Moreover, '0X' ki call ki bhi jarurt nai hai.

            return encoding(str.substring(1));
        } else {

            char ch0 = (char) ('a' + (str.charAt(0) - '1'));
            ArrayList<String> recAns0 = encoding(str.substring(1));
            for (String s : recAns0) {
                ans.add(ch0 + s);
            }
        }

        if (str.length() > 1 && Integer.parseInt(str.substring(0, 2)) < 27) {
            char ch1 = (char) ('a' + (Integer.parseInt(str.substring(0, 2)) - 1));
            ArrayList<String> recAns1 = encoding(str.substring(2));
            for (String s : recAns1) {
                ans.add(ch1 + s);
            }
        }

        return ans;
    }

    // same as above recursion calls : O(N) T and Space solution
    // O(1) space solution is also possible, Since at one time, only two pr. DP
    // value is needed
    // Note a valid Leetcode encoding is when (110) -> 1answer only (1,10): (A,J)
    // Sir ans: (110) -> (1,10) , (11,0) : (A,J), (K) -> 2 ans.
    // Since Alone 0 is not a valid english Char. hence (K) is invalid answer Acc.
    // to leetcode. So leetcode k hisab bhi krna. only small change needed,think
    // recursion first.
    public static int encodingDP(String str) {
        int[] dp = new int[str.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {

            // baseCase: str.len == 0
            if (i == dp.length - 1) {
                dp[i] = 1;
                continue;
            }

            int count = 0;

            if (str.charAt(i) == '0') {
                dp[i] = dp[i + 1];
                continue;
            } else {
                // bs yha return ni kra bocoz 2 char wale possibility bhi check krna hai agey.
                count += dp[i + 1];
            }

            // e.g 2521'4' => 5 - 4 = 1 length. e.g 25'2'14 => 5 - 2 = 3 leng.
            int len = str.length() - i;
            if (len > 1 && Integer.parseInt(str.substring(i, i + 2)) < 27) {
                count += dp[i + 2];
            }

            dp[i] = count;
        }

        displaydp1(dp);
        return dp[0];
    }

    // TODO new Encoding Leetcode Question with small variation
    // questn str can also have "*" char whose value it can varray from (1-9)
    // Question: 16JanVideo Time: 02:29:08

    // ================= MCM / Cut Type Questions ==========================
    // ******** Jaha Cut lga k Question Solve ho, Waha MCM lgega ************

    // si: start idx (first matrix), ei: end index (last matrix)
    // si initially starts with 1, when called from main method.
    // ar idx represent matrix name. and ith Matrix = ar[i-1] x [i].

    // To this with memorization too.
    public static int mcmRec(int[] ar, int si, int ei) {

        if (si == ei) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        // for array 0 to 4 ===> si = 1,ei = 4 ===> cuts = 3;
        for (int cut = si; cut < ei; cut++) {
            // si se i tk cut ka left, i + 1 se ei tk cut ka right
            int recAns = (mcmRec(ar, si, cut) + mcmRec(ar, cut + 1, ei));
            // total multiplicaton = recAns + mere khud ka multiplication cost.
            int total = recAns + (ar[si - 1] * ar[cut] * ar[ei]);
            minCost = Math.min(minCost, total);
        }

        return minCost;
    }

    // same as recursion faith.
    // T: O(N^3). one N extra becoz for N matrices hum (N-1) cut lga rhe hai.
    // S: O(N^2)
    public static void mcmDP(int[] arr) {

        int[][] dp = new int[arr.length][arr.length];

        // IMP: look how row 1 col 1 se diagonal start hai.
        for (int diag = 1; diag < dp[0].length; diag++) {
            for (int si = 1, ei = diag; ei < dp[0].length; si++, ei++) {

                // base Condition
                if (si == ei) {
                    // ek hi matrix, multiplication Cost = 0;
                    dp[si][ei] = 0;
                    continue;
                }

                int minCost = Integer.MAX_VALUE;
                for (int cut = si; cut < ei; cut++) {

                    int cutAns = dp[si][cut] + dp[cut + 1][ei];
                    int total = cutAns + (arr[si - 1] * arr[cut] * arr[ei]);
                    minCost = Math.min(minCost, total);
                }

                dp[si][ei] = minCost;
            }
        }

        displaydp2(dp);
        System.out.println(dp[1][dp[0].length - 1]);
        // return dp[1][dp[0].length-1];
    }

    // mcmDP min cost along with order of multiplication for that min Cost.
    public static void mcmDP2(int[] arr) {

        int[][] dp = new int[arr.length][arr.length];
        String[][] ans = new String[arr.length][arr.length];

        // IMP: look how row 1 col 1 se diagonal start hai.
        for (int diag = 1; diag < dp[0].length; diag++) {
            for (int si = 1, ei = diag; ei < dp[0].length; si++, ei++) {

                // base Condition
                if (si == ei) {
                    // ek hi matrix, multiplication Cost = 0;
                    dp[si][ei] = 0;
                    ans[si][ei] = (char) ('A' + si - 1) + "";
                    continue;
                }

                int minCost = Integer.MAX_VALUE;
                for (int cut = si; cut < ei; cut++) {

                    int cutAns = dp[si][cut] + dp[cut + 1][ei];
                    int total = cutAns + (arr[si - 1] * arr[cut] * arr[ei]);
                    // minCost update karo aur ans[][] ka string update karo.
                    if (total < minCost) {
                        minCost = total;
                        ans[si][ei] = "(" + ans[si][cut] + ans[cut + 1][ei] + ")";
                    }
                }

                dp[si][ei] = minCost;
            }
        }

        for (String[] s : ans) {
            System.out.println(Arrays.toString(s));
        }

        // displaydp2(dp);
        System.out.println(dp[1][dp[0].length - 1]);
    }

    // palindromic cut:
    // Count minimum cut to make string -> substrings of palindrome
    // E.g: abccbc => a|bccb|c => 2 cuts.

    public static int palindromicCut(String str, int st, int end) {

        // becoz 0 cut is need make 1 len str into palindrome
        if (st == end) {
            return 0;
        }

        if (isPali(str.substring(st, end + 1))) {
            return 0;
        }
        int minCut = Integer.MAX_VALUE;

        for (int cut = st; cut < end; cut++) {
            int left = palindromicCut(str, st, cut);
            int right = palindromicCut(str, cut + 1, end);
            int totalCuts = left + right + 1;

            minCut = Math.min(minCut, totalCuts);

        }
        return minCut;
    }

    public static void palindromicCutDP(String str) {

        int[][] dp = new int[str.length()][str.length()];

        for (int gap = 0; gap < dp[0].length; gap++) {
            for (int st = 0, end = gap; end < dp[0].length; st++, end++) {

                // baseCase: or st == end
                if (gap == 0) {
                    dp[st][end] = 0;
                    continue;
                }

                // we can also use isPaliDP first to create paliDP for str, usse isPali check
                // o(1) ka ho jayega
                if (isPali(str.substring(st, end + 1))) {
                    dp[st][end] = 0;
                    continue;
                }

                int minCut = Integer.MAX_VALUE;

                for (int cut = st; cut < end; cut++) {
                    int left = dp[st][cut];
                    int right = dp[cut + 1][end];
                    int totalCuts = left + right + 1;
                    minCut = Math.min(minCut, totalCuts);
                }

                dp[st][end] = minCut;

            }
        }

        System.out.println(dp[0][dp.length - 1]);
        displaydp2(dp);
    }

    // BurstBalloons to Maximize Profit: gfg Nice Question
    // left: left most "ele" (not Idx) available for "virtually available array" at
    // that time. right: right most "ele" (not Idx) available for "available array"
    // at that time.
    // a cut divides the problem into two smaller problem, leftPart and rightPart.
    // what to set extreme end ele for these two Parts?
    // leftPart: extreme left = ParentQuestn ka extreme left. Extreme right: cut val
    // rightPart: extreme left = cut val. Extreme right: P.Questn ka extreme right.
    public static int BurstBalloonRec(int[] arr, int st, int end, int left, int right) {

        // ek hi balloon bacha hai
        if (st == end) {
            return left * arr[st] * right;
        }

        int maxProfit = -1;
        for (int cut = st; cut <= end; cut++) {

            // if cut lga array ke first ele pe toh iska koi left nai hoga that is why 0.
            // if cut lga array ke last ele pe toh iska koi right nai hoga that is why 0.
            int leftPart = (cut == st) ? 0 : BurstBalloonRec(arr, st, cut - 1, left, arr[cut]);
            int rightPart = (cut == end) ? 0 : BurstBalloonRec(arr, cut + 1, end, arr[cut], right);
            int profit = leftPart + rightPart + (left * arr[cut] * right);

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void BurstBalloonsDP(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int diag = 0; diag < dp[0].length; diag++) {
            for (int st = 0, end = diag; end < dp[0].length; st++, end++) {

                // koi bhi calc se pehle setting exact left right for st to end array.
                int left = (st == 0) ? 1 : arr[st - 1];
                int right = (end == arr.length - 1) ? 1 : arr[end + 1];

                if (st == end) {
                    dp[st][end] = left * arr[st] * right;
                    continue;
                }

                int maxProfit = -1;
                for (int cut = st; cut <= end; cut++) {

                    int leftPart = (cut == st) ? 0 : dp[st][cut - 1];
                    int rightPart = (cut == end) ? 0 : dp[cut + 1][end];
                    int total = leftPart + rightPart + (left * arr[cut] * right);
                    maxProfit = Math.max(maxProfit, total);
                }

                dp[st][end] = maxProfit;
            }
        }

        displaydp2(dp);
        System.out.println(dp[0][dp.length - 1]);
    }

    // Given a rod of length n inches and an array of prices that contains prices of
    // all pieces of size smaller than n. Determine the maximum value obtainable by
    // cutting up the rod and selling the pieces. For example, if length of the rod
    // is 8 and the values of different pieces are given as following, then the
    // maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
    // length | 1 2 3 4 5, 6, 7, 8
    // price | 1, 5 8 9 10 17 17 20
    public static int rodCutting(int[] lengthAr, int[] price, int idx, int target) {
        if (target == 0) {
            return 0;
        }

        int maxPrice = -1;
        for (int i = idx; i < lengthAr.length; i++) {
            int ntarget = target - lengthAr[i];
            if (ntarget >= 0) {
                int recAns = rodCutting(lengthAr, price, i, ntarget);
                int totalPrice = recAns + price[i];

                maxPrice = Math.max(maxPrice, totalPrice);
            }
        }
        return maxPrice;
    }

    // Time: n^2, Space: N
    public static void rodCuttingDP(int[] lengthAr, int[] price, int target) {
        int[] dp = new int[target + 1];

        for (int tar = 0; tar < dp.length; tar++) {
            if (tar == 0) {
                dp[tar] = 0;
                continue;
            }

            int maxPrice = -1;

            for (int l = 0; l < lengthAr.length; l++) {
                int ntar = tar - lengthAr[l];
                if (ntar >= 0) {
                    int totalPrice = dp[ntar] + price[l];

                    maxPrice = Math.max(maxPrice, totalPrice);
                }
            }

            dp[tar] = maxPrice;
        }
        displaydp1(dp);
        System.out.println(dp[target]);
    }

    // Optimal Binary Search Tree
    // keys ka BTS bnao, Since there can be many ways to form BST from give keys
    // array.And To search an element which is at root of BST requires 1 comparison.
    // To search an element which is at ith lvl in BST, requires "i" comparisons
    // Kuch key durse keys k comparitive m jyada ya km frequently search ki jati hai
    // and ye freq of search ki info is stored in freq[] array.
    // so element at ith lvl ko uski freq times search krne ki cost = freq[i] * lvl;
    // Optimal BST: BST whose sum of Cost of searching each element in BST is
    // Minimum alomg all other Possible BSTs.
    public static int OBST(int[] keys, int[] freq, int st, int end, int lvl) {
        if (st == end) {
            return lvl * freq[st];
        }

        int minCost = Integer.MAX_VALUE;

        for (int cut = st; cut <= end; cut++) {
            int leftTreeCost = (cut == st) ? 0 : OBST(keys, freq, st, cut - 1, lvl + 1);
            int rightTreeCost = (cut == end) ? 0 : OBST(keys, freq, cut + 1, end, lvl + 1);

            int totalCost = leftTreeCost + rightTreeCost + (lvl * freq[cut]);
            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }

    // without passing level argument becoz then we will have 3 variable in our
    // faith call, st, end, and level. Hence 3d DP
    // We are using costs array to eliminate use of lvl variable.
    // In costs array each index stores sum of freq from 0 to that idx.
    public static int OBST_rec2(int[] keys, int[] freq, int st, int end, int[] costs) {
        if (st == end) {
            return freq[st];
        }

        int minCost = Integer.MAX_VALUE;

        // IMPORTANT: st to end tk jitana array hai ukne freq ka sum.
        int makeUpCost = costs[end] - ((st == 0) ? 0 : costs[st - 1]);

        for (int cut = st; cut <= end; cut++) {
            int leftTreeCost = (cut == st) ? 0 : OBST_rec2(keys, freq, st, cut - 1, costs);
            int rightTreeCost = (cut == end) ? 0 : OBST_rec2(keys, freq, cut + 1, end, costs);

            // makeUpCost add se, st to end tk array ke tree ka, lvl k hisab se cost calc ho
            // jayega.
            int totalCost = leftTreeCost + rightTreeCost + makeUpCost;
            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }

    // Time: O(N^2 + N) Space: N^2 Good Concept on how to handle BST lvl calc.
    public static void OBST_DP(int[] keys, int[] freq) {

        int[][] dp = new int[keys.length][keys.length];
        int[] costs = new int[freq.length];

        for (int i = 0; i < freq.length; i++) {
            if (i == 0) {
                costs[i] = freq[i];
                continue;
            }
            costs[i] = costs[i - 1] + freq[i];
        }

        for (int diag = 0; diag < dp[0].length; diag++) {
            for (int st = 0, end = diag; end < dp[0].length; st++, end++) {

                if (st == end) {
                    dp[st][end] = freq[st];
                    continue;
                }

                int minCost = Integer.MAX_VALUE;

                // IMPORTANT: st to end tk jitana array hai ukne freq ka sum.
                int makeUpCost = costs[end] - ((st == 0) ? 0 : costs[st - 1]);
                for (int cut = st; cut <= end; cut++) {

                    int left = (cut == st) ? 0 : dp[st][cut - 1];
                    int right = (cut == end) ? 0 : dp[cut + 1][end];
                    // makeUpCost add se, st to end tk ke tree ka, lvl k hisab se cost calc ho
                    // jayega.
                    int totalCost = left + right + makeUpCost;

                    minCost = Math.min(minCost, totalCost);
                }

                dp[st][end] = minCost;
            }
        }

        displaydp2(dp);
    }

    // https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/

    public static int countParenthe(char[] symbol, char[] operator, int st, int end, boolean isTrue) {

        // BaseCase:
        // T(i, i) = 1 if symbol[i] = 'T'
        // T(i, i) = 0 if symbol[i] = 'F'

        // F(i, i) = 1 if symbol[i] = 'F'
        // F(i, i) = 0 if symbol[i] = 'T'
        if (st == end) {
            if (isTrue) {
                return (symbol[st] == 'T') ? 1 : 0;
            } else {
                return (symbol[st] == 'F') ? 1 : 0;
            }

        }

        int count = 0;
        // cut st se end - 1 tk becoz operators ele ek km hai symbol ele se.
        // aur cut operator elements k position pe lgre hai.
        for (int cut = st; cut < end; cut++) {

            int leftT = countParenthe(symbol, operator, st, cut, true);
            int leftF = countParenthe(symbol, operator, st, cut, false);
            int rightT = countParenthe(symbol, operator, cut + 1, end, true);
            int rightF = countParenthe(symbol, operator, cut + 1, end, false);

            if (operator[cut] == '|') {
                if (isTrue)
                    count += (leftT * rightF) + (leftF * rightT) + (leftT * rightT);
                else
                    count += (leftF * rightF);
            }

            if (operator[cut] == '&') {
                if (isTrue)
                    count += (leftT * rightT);
                else
                    count += (leftT * rightF) + (leftF * rightT) + (leftF * rightF);
            }

            if (operator[cut] == '^') {
                if (isTrue)
                    count += (leftF * rightT) + (leftT * rightF);
                else
                    count += (leftF * rightF) + (leftT * rightT);
            }

        }

        return count;
    }

    // Time : O(N^3) Space: (2N^2) becoz 2 dp bna hai.
    public static void countParenthe(char[] symbol, char[] operator) {
        int n = symbol.length;
        int[][] trueDP = new int[n][n];
        int[][] falseDP = new int[n][n];

        for (int diag = 0; diag < n; diag++) {
            for (int st = 0, end = diag; end < n; st++, end++) {

                if (st == end) {
                    trueDP[st][end] = (symbol[st] == 'T') ? 1 : 0;
                    falseDP[st][end] = (symbol[st] == 'F') ? 1 : 0;
                    continue;
                }

                int trueCount = 0;
                int falseCount = 0;
                for (int cut = st; cut < end; cut++) {

                    int leftT = trueDP[st][cut];
                    int leftF = falseDP[st][cut];

                    int rightT = trueDP[cut + 1][end];
                    int rightF = falseDP[cut + 1][end];

                    if (operator[cut] == '|') {
                        trueCount += (leftT * rightF) + (leftF * rightT) + (leftT * rightT);
                        falseCount += (leftF * rightF);
                    }

                    if (operator[cut] == '&') {
                        trueCount += (leftT * rightT);
                        falseCount += (leftT * rightF) + (leftF * rightT) + (leftF * rightF);
                    }

                    if (operator[cut] == '^') {
                        trueCount += (leftF * rightT) + (leftT * rightF);
                        falseCount += (leftF * rightF) + (leftT * rightT);
                    }
                }

                trueDP[st][end] = trueCount;
                falseDP[st][end] = falseCount;

            }
        }

        displaydp2(trueDP);
    }

}