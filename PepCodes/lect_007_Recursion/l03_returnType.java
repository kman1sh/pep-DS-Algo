import java.util.ArrayList;

public class l03_returnType {

    public static void main(String[] args) {
        // System.out.println(subseq("ABCD").size());
        // String hiString = "HiiiHiiHiiHHiiiiHHiHiiHHiii";
        // System.out.println(removeHi(hiString));
        // System.out.println(removeHiExceptHit("HiHitHiHiiiHitHiiH"));
        // System.out.println(removeDuplicates("aaaabbcdefaaa"));
        // System.out.println(compression("aaaabbcdeeff", 1));
        // System.out.println(compression_v2("a", 1, 1));
        // System.out.println(mazePath(0, 0, 2, 2));
        // System.out.println(mazePath_diag(0, 0, 2, 2));
        // System.out.println(mazePath_diag_hei(0, 0, 4, 6));
        // System.out.println(mazePath_diag_Minhei(0, 0, 5, 5));
        // System.out.println(mazePath_diag_multiJump(0, 0, 3, 3).size());
        // System.out.println(floodFill(0, 0, 2, 2, new boolean[3][3]));

        /**
         * using isDone to create matix path with a few locations blocked (by marking it
         * true manually) Since we mark location true when we visit that location and
         * mark it false when we leave it. Since niche wale isdone mai already kuch
         * location true mark hai. So hum unko visit we nahi kr payege. Aur jab visit
         * nahi kr payege toh inn locations ko false bhi mark nahi kr payege.
         */

        // boolean[][] isdone = { { false, false, false }, { false, false, true }, {
        // true, false, false } };
        // System.out.println(floodFill_eightCalls(0, 0, 2, 2, isdone));
        // System.out.println(floodFill_eightCalls(0, 0, 2, 2, new
        // boolean[3][3]).size());
        // System.out.println(knightPath(0, 0, 4, 4, new boolean[5][5]).size());
        // System.out.println(knightPath_V2(0, 0, 4, 4, new boolean[5][5], "(0,0) "));
        // System.out.println(knightPathTour(0, 0, 0, 64, new boolean[8][8], new
        // int[8][8]));
        // String[] keys = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu",
        // "vwx", "yz" };
        // System.out.println(keyPad_01("245", keys));
        // System.out.println(permuatation("abc"));
        // System.out.println(encoding_v1("1123"));
        // System.out.println(encoding("110023"));

        int[][] board = {   { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
                            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
                            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
                            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
                            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
                            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
                            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
                            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
                            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
                        };

        System.out.println(sudoku(board, 0));

    }

    // abc output: [ , c , b , bc , a , ac , ab , abc ]. **For 3 length string we
    // have 2^3 output**
    // postion of a character w.r.t neigbouring character is fixed.
    // means agar "a", "c" se pehle place hai toh output mai bhi hmesha pehle hi
    // place hoga.

    public static ArrayList<String> subseq(String str) { // abc

        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        char ch = str.charAt(0);

        ArrayList<String> recResult = subseq(str.substring(1));

        int size = recResult.size();
        for (int i = 0; i < size; i++) {
            recResult.add(ch + recResult.get(i));
        }

        return recResult;
    }

    //
    public static String removeHi(String ques) {

        if (ques.length() == 0)
            return "";

        char ch = ques.charAt(0);
        String recAns = removeHi(ques.substring(1));
        if (ch == 'H' && recAns.charAt(0) == 'i') {
            return recAns.substring(1);
        }

        return ch + recAns;

    }

    // Rajneesh Sir Version
    public static String removeHi_v2(String ques) {
        if (ques.length() == 0) {
            return "";
        }
        // if(ques.length()>1 && ques.charAt(0)=='h' && ques.charAt(1)=='i')

        // making sure that ques string is >1. otherwise ques.substring will give
        // exception
        if (ques.length() > 1 && ques.substring(0, 2).equals("Hi"))
            return removeHi_v2(ques.substring(2));
        else {
            char ch = ques.charAt(0);
            return ch + removeHi_v2(ques.substring(1));
        }
    }

    // Ques: aaaabbcdefaaa O/P: abcdefa
    public static String removeDuplicates(String ques) {

        if (ques.length() == 1)
            return ques;

        char ch = ques.charAt(0);
        String recAns = removeDuplicates(ques.substring(1));

        if (ch == recAns.charAt(0)) {
            return recAns;
        } else {
            return ch + recAns;
        }
    }

    // ques: "HiHitHiHiiiHitHiiH"
    // O/P: "HitiiHitiH"
    public static String removeHiExceptHit(String ques) {

        if (ques.length() == 0)
            return " ";

        if (ques.length() > 2 && ques.substring(0, 2).equals("Hi") && ques.charAt(2) != 't') {

            return removeHiExceptHit(ques.substring(2));

        } else if (ques.length() > 2 && ques.substring(0, 3).equals("Hit")) {

            return ques.substring(0, 3) + removeHiExceptHit(ques.substring(3));

        } else {

            return ques.charAt(0) + removeHiExceptHit(ques.substring(1));
        }
    }

    // ques: aaaabbcdeeff O/P: a4b2cde2f2
    public static String compression(String ques, int count) {
        if (ques.length() == 1) {
            return (count == 1) ? ques : ques + "" + count;
        }

        char ch = ques.charAt(0);
        if (ques.charAt(1) == ch) {
            count++;
            String recAns = compression(ques.substring(1), count);
            return recAns;
        } else {
            String recAns = compression(ques.substring(1), 1);
            return (count == 1) ? ch + recAns : ch + "" + count + recAns;
        }
    }

    // compression sir's version
    public static String compression_v2(String ques, int idx, int count) {
        if (idx == ques.length()) {
            String ans = ques.charAt(idx - 1) + ((count == 1) ? "" : "" + count);
            return ans;
        }

        if (ques.charAt(idx - 1) == ques.charAt(idx)) {
            return compression_v2(ques, idx + 1, count + 1);
        } else {
            String ans = ques.charAt(idx - 1) + ((count == 1) ? "" : "" + count);
            return ans + compression_v2(ques, idx + 1, 1);
        }
    }

    // Horizontal And Vertical moves Only. And find possible path from (0,0)  corner to opposite corner(x,x) e.g (2,2) : 3x3 maze
    public static ArrayList<String> mazePath(int sr, int sc, int er, int ec) {

        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (sc < ec) {
            ArrayList<String> HorizontalRecAns = mazePath(sr, sc + 1, er, ec);
            for (String s : HorizontalRecAns) {
                ans.add("H" + s);
            }
        }
        if (sr < er) {
            ArrayList<String> VerticalRecAns = mazePath(sr + 1, sc, er, ec);
            for (String s : VerticalRecAns) {
                ans.add("V" + s);
            }
        }
        return ans;
    }

    // Horizontal, Veritcal and Diagonal moves.
    // Tree Diagram:
    // https://drive.google.com/file/d/13-UFBSXGToehU6j-G3TAl2hvzfAl32R6/view?usp=sharing
    public static ArrayList<String> mazePath_diag(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (sc < ec) {
            ArrayList<String> HorizontalRecAns = mazePath_diag(sr, sc + 1, er, ec);
            for (String s : HorizontalRecAns) {
                ans.add("H" + s);
            }
        }
        if (sr < er) {
            ArrayList<String> VerticalRecAns = mazePath_diag(sr + 1, sc, er, ec);
            for (String s : VerticalRecAns) {
                ans.add("V" + s);
            }
        }
        if (sr < er && sc < ec) {
            ArrayList<String> DiagRecAns = mazePath_diag(sr + 1, sc + 1, er, ec);
            for (String s : DiagRecAns) {
                ans.add("D" + s);
            }
        }
        return ans;
    }

    // Maximum height of mazePath tree.
    // Tree Diagram:
    // https://drive.google.com/file/d/13-UFBSXGToehU6j-G3TAl2hvzfAl32R6/view?usp=sharing
    public static int mazePath_diag_hei(int sr, int sc, int er, int ec) {

        if (sr == er && sc == ec) {
            return 0;
        }

        int maxHeight = 0;
        if (sc < ec) {
            int recAns = mazePath_diag_hei(sr, sc + 1, er, ec);
            maxHeight = Math.max(maxHeight, recAns);
        }

        if (sr < er) {
            int recAns = mazePath_diag_hei(sr + 1, sc, er, ec);
            maxHeight = Math.max(maxHeight, recAns);
        }

        if (sr < er && sc < ec) {
            int recAns = mazePath_diag_hei(sr + 1, sc + 1, er, ec);
            maxHeight = Math.max(maxHeight, recAns);
        }

        return maxHeight + 1;
    }

    // will it not return 2 even for one height tree?
    public static int mazePath_diag_Minhei(int sr, int sc, int er, int ec) {

        if (sr == er && sc == ec) {
            return 0;
        }

        // Since we to compare return values of below three tree branches. So we need a
        // global local variable.
        // Purpose of this variable is to store value of first recusion call and compare
        // it with other two recursion calls.
        // So we want 1st recAns value to get stored in it.Hence, it can't be initialize
        // with 0 or 1.
        // So its initial value must need to something that get replaced when Math.min()
        // get called.
        // Hence make it the largest int can hold. Or something very big which recAns
        // can't return;
        int minHei = Integer.MAX_VALUE;
        if (sc < ec) {
            int recAns = mazePath_diag_Minhei(sr, sc + 1, er, ec);
            minHei = Math.min(minHei, recAns);
        }

        if (sr < er) {
            int recAns = mazePath_diag_Minhei(sr + 1, sc, er, ec);
            minHei = Math.min(minHei, recAns);
        }

        if (sr < er && sc < ec) {
            int recAns = mazePath_diag_Minhei(sr + 1, sc + 1, er, ec);
            minHei = Math.min(minHei, recAns);
        }

        return minHei + 1;
    }

    // using for loop for multiJump otherwise 9 calls lgani pad jati. see img below.
    // img:
    // https://drive.google.com/file/d/1TdZ_KVghi19bvQw64DWfCDAqudIfJAhl/view?usp=sharing
    public static ArrayList<String> mazePath_diag_multiJump(int sr, int sc, int er, int ec) {

        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        if (sc < ec) {
            for (int i = 1; sc + i <= ec; i++) {
                ArrayList<String> HorizontalRecAns = mazePath_diag_multiJump(sr, sc + i, er, ec);
                for (String s : HorizontalRecAns) {
                    ans.add("H" + i + s);
                }
            }
        }
        if (sr < er) {
            for (int i = 1; sr + i <= er; i++) {

                ArrayList<String> VerticalRecAns = mazePath_diag_multiJump(sr + i, sc, er, ec);
                for (String s : VerticalRecAns) {
                    ans.add("V" + i + s);
                }
            }
        }
        if (sr < er && sc < ec) {
            for (int i = 1; sr + i <= er && sc + i <= ec; i++) {
                ArrayList<String> DiagRecAns = mazePath_diag_multiJump(sr + i, sc + i, er, ec);
                for (String s : DiagRecAns) {
                    ans.add("D" + i + s);
                }
            }
        }
        return ans;

    }

    // public static ArrayList<String> mazePathDiag_MultiJump_MaxHeight(int sr, int
    // sc, int er, int ec) {}

    public static ArrayList<String> floodFill(int sr, int sc, int er, int ec, boolean[][] isdone) {

        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        isdone[sr][sc] = true;

        if (sr - 1 >= 0 && !isdone[sr - 1][sc]) {
            ArrayList<String> upAns = floodFill(sr - 1, sc, er, ec, isdone);
            for (String s : upAns) {
                myAns.add("U" + s);
            }
        }

        if (sr + 1 <= er && !isdone[sr + 1][sc]) {
            ArrayList<String> downAns = floodFill(sr + 1, sc, er, ec, isdone);
            for (String s : downAns) {
                myAns.add("D" + s);
            }
        }

        if (sc + 1 <= ec && !isdone[sr][sc + 1]) {
            ArrayList<String> rightAns = floodFill(sr, sc + 1, er, ec, isdone);
            for (String s : rightAns) {
                myAns.add("R" + s);
            }
        }

        if (sc - 1 >= 0 && !isdone[sr][sc - 1]) {
            ArrayList<String> leftAns = floodFill(sr, sc - 1, er, ec, isdone);
            for (String s : leftAns) {
                myAns.add("L" + s);
            }
        }
        isdone[sr][sc] = false;
        return myAns;
    }

    public static ArrayList<String> floodFill_eightCalls(int sr, int sc, int er, int ec, boolean[][] isDone) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        int[][] locCodinates = { { -1, 0 }, // UP
                { 1, 0 }, // DOWN
                { 0, -1 }, // LEFT
                { 0, 1 }, // RIGHT
                { -1, 1 }, // UR-1
                { 1, 1 }, // DR-2
                { 1, -1 }, // DL-3
                { -1, -1 } // UL-4
        };
        String[] locName = { "U", "D", "L", "R", "1", "2", "3", "4" };

        ArrayList<String> myAns = new ArrayList<>();
        isDone[sr][sc] = true;

        for (int i = 0; i < locCodinates.length; i++) {
            int x = sr + locCodinates[i][0];
            int y = sc + locCodinates[i][1];
            if (isValid(x, y, er, ec, isDone)) {
                ArrayList<String> recAns = floodFill_eightCalls(x, y, er, ec, isDone);
                for (String s : recAns) {
                    myAns.add(locName[i] + s);
                }
            }
        }
        isDone[sr][sc] = false;
        return myAns;
    }

    public static boolean isValid(int sr, int sc, int er, int ec, boolean isDone[][]) {
        if (sr >= 0 && sr <= er && sc >= 0 && sc <= ec && !isDone[sr][sc])
            return true;
        return false;
    }

    // My version with ArrayList to store unique paths and using size() to get total
    // number of paths.
    public static ArrayList<String> knightPath(int sr, int sc, int er, int ec, boolean[][] isDone) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        int[][] locCodinates = { { -2, 1 }, // U2R
                { -1, 2 }, // R2U
                { 1, 2 }, // R2D
                { 2, 1 }, // D2R
                { 2, -1 }, // D2L
                { 1, -2 }, // L2D
                { -1, -2 }, // L2U
                { -2, -1 } // U2L
        };
        String[] locName = { "U2R", "R2U", "R2D", "D2R", "D2L", "L2D", "L2U", "U2L" };

        ArrayList<String> myAns = new ArrayList<>();
        isDone[sr][sc] = true;

        for (int i = 0; i < locCodinates.length; i++) {
            int x = sr + locCodinates[i][0];
            int y = sc + locCodinates[i][1];
            if (isValid(x, y, er, ec, isDone)) {
                ArrayList<String> recAns = knightPath(x, y, er, ec, isDone);
                for (String s : recAns) {
                    myAns.add(locName[i] + s);
                }
            }
        }
        isDone[sr][sc] = false;
        return myAns;
    }

    // Sir version of int return type to print total paths and "String ans" as
    // argument to store two paths.
    public static int knightPath_V2(int sr, int sc, int er, int ec, boolean[][] isDone, String ans) {

        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }
        int[][] locCodinates = { { -2, 1 }, // U2R
                { -1, 2 }, // R2U
                { 1, 2 }, // R2D
                { 2, 1 }, // D2R
                { 2, -1 }, // D2L
                { 1, -2 }, // L2D
                { -1, -2 }, // L2U
                { -2, -1 } // U2L
        };
        isDone[sr][sc] = true;
        int count = 0;

        for (int i = 0; i < locCodinates.length; i++) {
            int x = sr + locCodinates[i][0];
            int y = sc + locCodinates[i][1];
            if (isValid(x, y, er, ec, isDone)) {
                count += knightPath_V2(x, y, er, ec, isDone, ans + "(" + x + "," + y + ") ");
            }
        }
        isDone[sr][sc] = false;
        return count;
    }

    // function mai enter hote hi uss location pe current count rkh do.
    // fir starting point se har possibility ko traverse kro.
    // wo path do chalte chalte count 63 pe tk chla jaye usko base case mai print
    // krwa lo
    public static boolean knightPathTour(int sr, int sc, int count, int boxSize, boolean[][] isDone, int[][] ans) {

        ans[sr][sc] = count;

        if (count + 1 == boxSize) {
            for (int[] row : ans) {
                for (int n : row) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
            return true;
        }
        boolean result = false;
        isDone[sr][sc] = true;

        int[][] locCodinates = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 },
                { -2, -1 } };

        for (int i = 0; i < locCodinates.length; i++) {
            int x = sr + locCodinates[i][0];
            int y = sc + locCodinates[i][1];
            if (isValidTour(x, y, isDone)) {
                result = result || knightPathTour(x, y, count + 1, boxSize, isDone, ans);
            }
        }
        ans[sr][sc] = 0;
        isDone[sr][sc] = false;
        return result;
    }

    public static boolean isValidTour(int sr, int sc, boolean[][] isDone) {
        if (sr >= 0 && sc >= 0 && sr < isDone.length && sc < isDone[0].length && !isDone[sr][sc])
            return true;
        return false;
    }

    // String[] keys={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    /**
     * For a given "string array" of keypad map (index representing the keyNumber of
     * KeyPad) and a string ques, example: 245. For each key in 245 hold some
     * letters on keypad. Find all the possible 3letter words that can be made by
     * pressing 2-4-5
     */

    public static ArrayList<String> keyPad_01(String ques, String[] keys) {

        if (ques.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = ques.charAt(0);
        String keyNum = keys[ch - '0'];
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> recAns = keyPad_01(ques.substring(1), keys);
        for (int i = 0; i < keyNum.length(); i++) {
            for (String s : recAns) {
                ans.add(keyNum.charAt(i) + s);
            }
        }
        return ans;
    }

    public static ArrayList<String> permuatation(String str) {
        /**
         * My Base Case
         */
        // if (str.length() == 0) {
        // ArrayList<String> base = new ArrayList<>();
        // base.add("");
        // return base;
        // }

        if (str.length() == 0)
            return new ArrayList<>();

        if (str.length() == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add(str);
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> recAns = permuatation(str.substring(1));
        for (String st : recAns) {
            for (int i = 0; i <= st.length(); i++) {
                // tricky***
                myAns.add(st.substring(0, i) + ch + st.substring(i));
            }
        }
        return myAns;
    }

    // My version. Not working for case like "10001"
    // Revise
    public static ArrayList<String> encoding_v1(String ques) {
        if (ques.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = ques.charAt(0);
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> recAns = encoding_v1(ques.substring(1));

        for (String string : recAns) {
            char letter = (char) ('a' + (ch - '1'));
            myAns.add(letter + string);
        }
        if (ques.length() > 1) {
            int inLetter = Integer.parseInt(ques.substring(0, 2));
            if (inLetter <= 26) {
                ArrayList<String> recAns1 = encoding_v1(ques.substring(2));
                for (String string : recAns1) {
                    char letter = (char) ('a' + inLetter - 1);
                    myAns.add(letter + string);
                }
            }
        }
        return myAns;
    }

    public static ArrayList<String> encoding(String ques) {
        if (ques.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = ques.charAt(0);
        if (ch == '0') {
            return encoding(ques.substring(1));
        }
        char alphabet = (char) ('a' + (ch - '1'));
        String ros = ques.substring(1);
        ArrayList<String> myAns = new ArrayList<>();

        ArrayList<String> recAns = encoding(ros);
        for (String str : recAns) {
            myAns.add(alphabet + str);
        }

        if (ques.length() > 1) {
            // int x = Integer.parseInt(ques.substring(0, 2));
            // trickty
            int x = (ch - '0') * 10 + (ques.charAt(1) - '0');
            if (x < 27) {
                char alpha = (char) ('a' + (x - 1));
                ArrayList<String> recAns1 = encoding(ques.substring(2));
                for (String str : recAns1) {
                    myAns.add(alpha + str);
                }
            }
        }
        return myAns;
    }

    // do keypad problem v2 20ct 01h:29m with * and #
    public static boolean isValidSudokuMove(int[][] sudoku, int xloc, int yloc, int num) {

        // column check
        for (int i = 0; i < sudoku[xloc].length; i++) {
            if (sudoku[xloc][i] == num) {
                return false;
            }
        }

        // row check
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][yloc] == num) {
                return false;
            }
        }
        // 3x3 Matrix check
        int x = (xloc / 3) * 3;
        int y = (yloc / 3) * 3;

        for (int i = x; i < (x + 3); i++) {
            for (int j = y; j < (y + 3); j++) {

                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // use int return type to count number of solutions.
    public static boolean sudoku(int[][] board, int vidx) {

        if (vidx == board.length * board[0].length) {
            for (int[] row : board) {
                for (int ele : row) {
                    System.out.print(ele + " ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }

        // getting row(r),column(c) location on board from vidx.
        // divide: gives row number and mod: Give column location.
        int r = vidx / 9;
        int c = vidx % 9;
        // int count = 0;
        boolean recAns = false;
        if (board[r][c] != 0) {
            recAns = recAns || sudoku(board, vidx + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (isValidSudokuMove(board, r, c, num)) {
                    board[r][c] = num;
                    // How OR || orperator is giving only one solution when multiple ans are
                    // possible.
                    /**
                     * jab ek bar base case hit hoga toh true return krte hue recursion wapis agyega
                     * so recAns is true at this point. So jab "if block" se nikl ke "for loop"
                     * chalega to check for other possibilties and enters in if block again tab, OR
                     * operator se ye check hoga agr recAns true hai (jo ki hai) toh sudoku ko call
                     * nai lagegi and that's how it will exit the if block without doing any
                     * recursion call. and at last each at bottom of recurison tree (vidx =0) and
                     * exit the recursion with true.
                     */
                    recAns = recAns || sudoku(board, vidx + 1);
                    board[r][c] = 0;
                }
            }
        }
        return recAns;
    }

}