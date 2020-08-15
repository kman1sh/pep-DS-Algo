import java.util.Arrays;

public class dp2 {

    public static void main(String[] args) {

        // ****** Minimum Cut to Make String -> substrs of Palindromes ************
        String ques = "ababbbabbababa";
        // int minCut = minPaliParitionV2(ques, 0, ques.length() - 1, isPaliDP(ques));
        // System.out.println("By Recursion Minimum cut: " + minCut);

        // int[][] minPaliCutDP = minPaliParitionDP(ques, isPaliDP(ques));
        // printDP(minPaliCutDP);

        // ********************* MCM *************
        int[] mcmArr = { 40, 20, 30, 10, 30 };
        // // st, end are first and last matrix name. total matrix one less that arr
        // size
        // System.out.println("mcm Recursion " + mcm(mcmArr, 1, mcmArr.length - 1));
        // System.out.println("mcm_DP " + mcm_DP(mcmArr));

        // ****************Burst Ballon And Maximize Profit ***************
        int[] balloons = { 1, 2, 3, 4, 5 };
        // System.out.println(burstBallons_GetMax(balloons, 0, balloons.length - 1, -1,
        // balloons.length));
        burstBallons_GetMaxDP(balloons);

        // ****************Cut Rod And Maximize Profit ***************
        int[] lenPrice = { 1, 5, 8, 9, 10, 17, 17, 20 };
        // cutRodMaxProfit(lenPrice, lenPrice.length, 0, 0, "");
        // System.out.println("max profit: " + bestPath + " calls " + calls);

        int ans = cutRodMaxProfit_DP(lenPrice);
        System.out.println(ans);
    }

    // extra
    public static void printDP(int[][] DP) {
        System.out.println("By DP");
        for (int[] is : DP) {
            System.out.println(Arrays.toString(is));
        }
    }

    // Matrix chain multiplication
    public static int mcm(int[] arr, int st, int end) { // recursion
        if (st == end)
            return 0;
        int minMultiplyCost = Integer.MAX_VALUE;
        for (int cut = st; cut < end; cut++) {

            int left = mcm(arr, st, cut);
            int right = mcm(arr, cut + 1, end);
            int recAns = left + right + arr[st - 1] * arr[end] * arr[cut];

            minMultiplyCost = Math.min(minMultiplyCost, recAns);
        }
        return minMultiplyCost;
    }

    public static int mcm_DP(int[] arr) {
        // not dealing with 0th row and 0th col. actual dp starts from (st,st) to (end,
        // end)
        // below dp has 0th row and 0th col extra. becoz my matrices name starts with
        // "1"
        // and dp idx represent my matrix name; i dont have matrix with name 0.
        int[][] dp = new int[arr.length][arr.length];

        for (int gap = 0; gap < dp[0].length; gap++) {
            for (int st = 1, end = gap + 1; end < dp[0].length; st++, end++) { // i: row always start at 1
                if (gap == 0) {
                    dp[st][end] = 0;
                } else {
                    int minMultiplyCost = Integer.MAX_VALUE;
                    for (int cut = st; cut < end; cut++) {

                        int left = dp[st][cut];
                        int right = dp[cut + 1][end];
                        // for Mat A(mxn) X B(nxp) : AB(mxp) n: cut point, differentiate Mat A and B.
                        // cost of Multiplication for AxB = m * p * n;
                        // Cost = A's row * B's col * cut pe value == arr[st - 1] * arr[end] * arr[cut]
                        int thisCost = left + right + arr[st - 1] * arr[end] * arr[cut];

                        minMultiplyCost = Math.min(thisCost, minMultiplyCost);
                    }
                    dp[st][end] = minMultiplyCost;
                }
            }
        }
        return dp[1][dp.length - 1];
    }

    // public static int minPaliParition(String word) {
    // if (isPali(word))
    // return 0;
    // int cc = Integer.MAX_VALUE;
    // for (int cut = 1; cut < word.length(); cut++) {
    // String left = word.substring(0, cut);
    // String right = word.substring(cut);

    // int recCut = 1 + minPaliParition(left) + minPaliParition(right);
    // cc = Math.min(recCut, cc);
    // }
    // return cc;
    // }
    // public static boolean isPali(String word) {

    // int left = 0;
    // int right = word.length() - 1;

    // while (left < right) {
    // if (word.charAt(left++) != word.charAt(right--))
    // return false;
    // }

    // return true;
    // }

    public static int minPaliParitionV2(String word, int stIdx, int endIdx, boolean[][] isPaliDP) {
        if (isPaliDP[stIdx][endIdx])
            return 0;

        int cc = Integer.MAX_VALUE;
        for (int cut = stIdx; cut < endIdx; cut++) {

            int left = minPaliParitionV2(word, stIdx, cut, isPaliDP);
            int right = minPaliParitionV2(word, cut + 1, endIdx, isPaliDP);

            int recCut = left + 1 + right;
            cc = Math.min(recCut, cc);
        }
        return cc;
    }

    public static boolean[][] isPaliDP(String word) {
        // row-th idx se col-th idx tk ki string.
        boolean[][] dp = new boolean[word.length()][word.length()];

        /**
         * The best way to fill dp is, fill all the base cases first "jese hi loop start
         * ho" or "loop start hone se pehle".
         */

        // ***example case for below doc, filling baseCase before starting dp
        // traversal***
        // for (int i = 0; i < dp.length; i++) { // row
        // for (int j = 0; j < dp[0].length; j++) {
        // if (i == j)
        // dp[i][j] = true;
        // }
        // }

        /**
         * To do this,the best approach here is use" gap loop" : fast and it always fill
         * base values first. DP mai kai baar hme apne se niche wale cell ki value
         * chahiye aur agar hum dp k each cell ko one by one visit kr rhe hai in
         * tradtional way. then apne se niche wale ki "SAHI VALUE" dena possible nai
         * hoga since we haven't visit that cell. and it is even a bigger problem if
         * that cell (niche wala) is a base case cell. kyuki base case ko toh sabse
         * pehle fill hona chahiye tha. that's why if you're traversing dp by traditon
         * forloop way then fill your base case in dp "before" traversing the dp or stop
         * and think if gap/diagonal loop approach can help you or not.
         */

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) { // i:row j:col
                if (gap == 0) // baseCase got filled at the first ever start of the loop
                    dp[i][j] = true;
                else if (gap == 1) {
                    if (word.charAt(i) == word.charAt(j))
                        dp[i][j] = true;
                } else {
                    if (word.charAt(i) == word.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }
            }
        }
        return dp;
    }

    // https://drive.google.com/file/d/16brjSPM3gufRhyvI-RJk7mNkcpCDnGa5/view?usp=sharing
    public static int[][] minPaliParitionDP(String input, boolean[][] isPali) {
        int[][] dp = new int[input.length()][input.length()];

        for (int gap = 0; gap < dp[0].length; gap++) {
            for (int st = 0, end = gap; end < dp[0].length; st++, end++) {
                if (gap == 0) // st == end
                    dp[st][end] = 0;
                else {
                    if (!isPali[st][end]) {
                        int minCut = Integer.MAX_VALUE;
                        for (int cut = st; cut < end; cut++) {
                            // see image above for calls+-
                            int thisCut = 1 + dp[st][cut] + dp[cut + 1][end]; // leftMinCut + 1 + rightMinCut
                            minCut = Math.min(minCut, thisCut);
                        }
                        dp[st][end] = minCut;
                    }
                }
            }
        }
        return dp;
    }

    // public static int burstBallons_GetMax(int[] ar, int st, int end, int cutPt) {
    // if (st == end) { // only one ele in ar.
    // return 1 * ar[st] * 1;
    // }
    // int maxPoints = Integer.MIN_VALUE;
    // for (int cut = st; cut <= end; cut++) {
    // // left : (st, cut-1) right: (cut+1, end) //cut point cut
    // int left = (cut - 1 < st) ? 0 : burstBallons_GetMax(ar, st, cut - 1, cut);
    // int right = (cut + 1 > end) ? 0 : burstBallons_GetMax(ar, cut + 1, end, cut);
    // // int atCut = ((cut - 1 < st) ? 1 : ar[cut - 1]) * ar[cut] * ((cut + 1 >
    // end) ?
    // // 1 : ar[cut + 1]);
    // int atCut = ((cut - 1 < 0) ? 1 : ar[cut - 1]) * ar[cut] * ((cut + 1 >
    // ar.length - 1) ? 1 : ar[cut + 1]);
    // int points = left + atCut + right;
    // maxPoints = Math.max(maxPoints, points);
    // System.out.println(
    // "Max:" + maxPoints + ", points: " + points + ", st:end:cut: " + st + ":" +
    // end + ":" + cut);
    // }
    // return maxPoints;
    // }

    public static int burstBallons_GetMax(int[] ar, int st, int end, int le, int ri) {
        if (st == end) {
            return ((le == -1) ? 1 : ar[le]) * ar[st] * ((ri == ar.length) ? 1 : ar[ri]);
        }
        int maxPts = Integer.MIN_VALUE;
        for (int cut = st; cut <= end; cut++) {

            int left = (cut - 1 < st) ? 0 : burstBallons_GetMax(ar, st, cut - 1, st - 1, cut);
            int right = (cut + 1 > end) ? 0 : burstBallons_GetMax(ar, cut + 1, end, cut, end + 1);

            int atCut = ((le == -1) ? 1 : ar[le]) * ar[cut] * ((ri == ar.length) ? 1 : ar[ri]);

            int points = left + atCut + right;

            maxPts = Math.max(points, maxPts);
        }

        return maxPts;
    }

    public static void burstBallons_GetMaxDP(int[] ar) {
        int[][] dp = new int[ar.length][ar.length];

        for (int gap = 0; gap < dp.length; gap++) {
            for (int st = 0, end = gap; end < dp.length; st++, end++) {
                if (gap == 0) { // st == end
                    dp[st][end] = ((st - 1 == -1) ? 1 : ar[st - 1]) * ar[st]
                            * ((end + 1 == dp.length) ? 1 : ar[st + 1]);
                } else { // means ques length > 1. So all possible cuts mese max point kon dega dekho
                    int maxPoints = Integer.MIN_VALUE;
                    for (int cut = st; cut <= end; cut++) {

                        int left = (cut - 1 < st) ? 0 : dp[st][cut - 1];
                        int right = (cut + 1 > end) ? 0 : dp[cut + 1][end];
                        int atCut = ((st == 0) ? 1 : ar[st - 1]) * ar[cut] * ((end == ar.length - 1) ? 1 : ar[end + 1]);
                        int points = left + atCut + right;

                        maxPoints = Math.max(maxPoints, points);
                    }
                    dp[st][end] = maxPoints;
                }
            }
        }

        System.out.println("MaxPoints: dp[0][ar.length-1]: " + dp[0][ar.length - 1]);
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
    }

    // *********************************
    static int maxProfit = Integer.MIN_VALUE;
    static String bestPath = "";
    static int calls = 0;

    public static void cutRodMaxProfit(int[] profit, int length, int vidx, int prof, String path) {
        calls++;
        if (length == 0 || vidx == profit.length) {
            if (maxProfit < prof) {
                maxProfit = prof;
                bestPath = path + "@" + maxProfit;
            }
            return;
        }

        for (int i = vidx; i < profit.length; i++) {
            if (length - (i + 1) >= 0) {
                int nLength = length - (i + 1);
                cutRodMaxProfit(profit, nLength, 0, prof + profit[i], path + "->" + (i + 1));
            }
            cutRodMaxProfit(profit, length, i + 1, prof, path);
        }
    }

    public static int cutRodMaxProfit_(int[] profit, int length) {
        if (length == 0) {
            return 0;
        }
        int myAns = Integer.MIN_VALUE;
        for (int i = 0; i < profit.length; i++) {

            if (length - (i + 1) >= 0) {
                int remaingLen = length - (i + 1);
                int recAns = cutRodMaxProfit_(profit, remaingLen);
                myAns = Math.max(recAns + profit[i], myAns);
            }
        }
        return myAns;
    }

    // 1,3,8,9,10,17
    // 0,1,2,3,4, 5
    public static int cutRodMaxProfit_DP(int[] profit) {
    int[] dp = new int[profit.length + 1];
    dp[0] = 0;
    for (int length = 1; length < dp.length; length++) {
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < profit.length; i++) { //i = cutting length 
            if(length - (i+1) >= 0) {
                int remaingLen = length - (i+1); //0
                maxProfit = Math.max(maxProfit, dp[remaingLen] + profit[i]);
            }
        }
        dp[length] = maxProfit;
    }
    return dp[dp.length-1];
    }
}