import java.util.ArrayList;
import java.util.Scanner;

public class returnType{

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // String str = "ABCD";
        // ArrayList<String> result = subSeq(str);
        // System.out.println(result);
        
        System.out.println(removeHi("hihiiiihihihiihiiihi"));
        // System.out.println(removeHiSkipHit("hihithiiiihihihiihiiihi"));
        // System.out.println(compression("aaaaabbbccddef", 1, 1));
        // System.out.println(mazePath(0,0,2,2));
        // System.out.println(mazePath_Diag(0,0,2,2));
        // // System.out.println(mazeHei(0,0,2,2));
        // boolean isDone[][] = new boolean[3][3];
        // boolean blockedLoc[][] = new boolean[3][3];
        // System.out.println(floodFill(0,0,2,2, isDone));

        // boolean[][] path={{false,false,false},
        //                   {false,false,true},
        //                   {false,false,false},
        //                  };

        // System.out.println(floodFill_eightCalls(0,0,2,2,path,new boolean[3][3]));
        // System.out.println(knightPath(0,0,3,3,new boolean[4][4]));

        // String[] keypad = {".","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // System.out.println(keyPad_01("245", keypad));

        // System.out.println(wordsPerm("abcdef").size());
        


    }
    public static ArrayList<String> subSeq(String str) {

        if(str.length() == 0) { //base Condtion
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        char ch = str.charAt(0);
        String restOfString = str.substring(1);

        //faith
        ArrayList<String> recAns = subSeq(restOfString);

        ArrayList<String> myAns = new ArrayList<>();
        myAns.addAll(recAns);

        for(String s: recAns) {
            myAns.add(ch+s);
        }

        return myAns;
    }

    public static String removeHi(String ques) {

        if(ques.length() == 0) {
            return " ";
        }


        if(ques.length()>=1 && ques.substring(0,2).equals("hi")) {
            return removeHi(ques.substring(2));
        } else {
            char ch = ques.charAt(0);
            return ch + removeHi(ques.substring(1));
        }
    }

    public static String removeDuplicates(String ques) {
        if (ques.length() == 1) {
            return ques;
        }

        char ch = ques.charAt(0);
        String recAns = removeDuplicates(ques.substring(1));
        if (ch == recAns.charAt(0))
            return recAns;
        else
            return ch + recAns;
    }

    public static String removeHiSkipHit(String ques) {

        if(ques.length() == 0) {
            return " ";
        }
        
        if(ques.length()>=1 && ques.substring(0,2).equals("hi")) {

            if(ques.length()> 2 && ques.substring(0,3).equals("hit")) {
                String str =  ques.substring(0,3);
                return str + removeHiSkipHit(ques.substring(3));
            } else {
                return removeHiSkipHit(ques.substring(2));
            }
        } else {
            char ch = ques.charAt(0);
            return ch + removeHiSkipHit(ques.substring(1));
        }
    }

    public static String compression(String str, int idx, int count) {

        if(str.length() == idx) {
            return str.charAt(idx-1) + ((count > 1)? count+"" : "");
        }

        if(str.charAt(idx-1) == str.charAt(idx)) {
            return compression(str, idx+1, count+1);
        } else { 
            String st = str.charAt(idx-1) + ((count > 1)? count+"" : "");
            return st + compression(str,idx+1, 1);
        }
    }

    public static ArrayList<String> mazePath(int sr, int sc, int er, int ec) {
        if(sc == ec && sr==er) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
       
        if(sc+1 <=ec) {
            ArrayList<String> horizontal = mazePath(sr, sc+1, er, ec );
            for(String s : horizontal) {
                ans.add("H" + s);
            }
        }
        if(sr+1 <= er) {
            ArrayList<String> vertical = mazePath(sr+1, sc, er, ec );
            for(String s: vertical) {
                ans.add("V" +s);
            }
        }
        return ans;
    }

    public static ArrayList<String> mazePath_Diag(int sr, int sc, int er, int ec) {
        if(sc == ec && sr==er) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
       
        if(sc+1 <=ec) {
            ArrayList<String> horizontal = mazePath_Diag(sr, sc+1, er, ec );
            for(String s : horizontal) {
                ans.add("H" + s);
            }
        }
        if(sr+1 <= er) {
            ArrayList<String> vertical = mazePath_Diag(sr+1, sc, er, ec );
            for(String s: vertical) {
                ans.add("V" +s);
            }
        }

        if(sr+1 <= er && sc+1 <= ec) {
            ArrayList<String> diagonal = mazePath_Diag(sr+1, sc+1, er, ec );
            for(String s: diagonal) {
                ans.add("D" +s);
            }
        }
        return ans;
    }

    public static int mazeHei(int sr, int sc, int er, int ec) {
        if(sc == ec && sr==er) {
            return 0;
        }

       int maxHei = 0;
        if(sc+1 <=ec) {
            maxHei = Math.max(maxHei, mazeHei(sr, sc+1, er, ec ) );
        }
        if(sr+1 <= er) {
            maxHei = Math.max(maxHei,mazeHei(sr+1, sc, er, ec ));
        }

        if(sr+1 <= er && sc+1 <= ec) {
            maxHei = Math.max(maxHei,mazeHei(sr+1, sc+1, er, ec ));
        }
        return maxHei+1;
    }

    public static ArrayList<String> floodFill(int sr, int sc, int er, int ec, boolean[][] isDone) {

        if(sc == ec && sr==er) {
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        isDone[sr][sc] = true;
        if(sc+1<= ec && !isDone[sr][sc+1]) {
            ArrayList<String> right = floodFill(sr, sc+1, er, ec,isDone );
            for(String s: right) {
                ans.add("R" + s);
            }
        }

        if(sr+1 <= er && !isDone[sr+1][sc]) {
            ArrayList<String> down = floodFill(sr+1, sc, er, ec,isDone );
            for(String s: down) {
                ans.add("D" +s);
            }
        }

        if(sr-1 >= 0 && !isDone[sr-1][sc]) {
            ArrayList<String> up = floodFill(sr-1, sc, er, ec,isDone );
            for(String s: up) {
                ans.add("U" +s);
            }
        }

        if(sc-1>= 0 && !isDone[sr][sc-1]) {
            ArrayList<String> right = floodFill(sr, sc-1, er, ec,isDone );
            for(String s: right) {
                ans.add("R" + s);
            }
        }
        isDone[sr][sc] = false;
        return ans;
    }

    public static boolean isValid(int x,int y,boolean[][] path,boolean[][] isdone){
      if(x>=0 && y>=0 && x<isdone.length && y<isdone[0].length && !isdone[x][y] && !path[x][y]) return true;
      return false;
    }

    public static ArrayList<String> floodFill_eightCalls(int sr,int sc,int er,int ec,boolean[][] path,boolean[][] isdone){
        if(sr==er && sc==ec){
         ArrayList<String> base=new ArrayList<>();
         base.add("");
         return base;
        }

        int[][] dir={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        String[] dirName={"D","R","U","L","1","3","4","2"};
    
        ArrayList<String> myAns=new ArrayList<>();
        
        isdone[sr][sc]=true;
        for(int d=0;d<dir.length;d++){
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
             
        if(isValid(x,y,path,isdone)){
            ArrayList<String> calls=floodFill_eightCalls(x,y,er,ec,path,isdone);
            for(String s:calls){
              myAns.add(dirName[d] + s);
            }  
          }
        }

        isdone[sr][sc]=false;

        return myAns;

    }

    public static boolean isValid(int x,int y,boolean[][] isdone){
      if(x>=0 && y>=0 && x<isdone.length && y<isdone[0].length && !isdone[x][y]) return true;
      return false;
    }

    public static int knightPath(int sr,int sc,int er,int ec,boolean[][] isdone){
        if(sr==er && sc==ec){
         return 1;
        }

        int[][] dir={{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        // String[] dirName={"D","R","U","L","1","3","4","2"}
        
        isdone[sr][sc]=true;
        int count = 0;
        for(int d=0;d<dir.length;d++){
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
             
        if(isValid(x,y,isdone)){
            count+=knightPath(x,y,er,ec,isdone); 
          }
        }
        isdone[sr][sc]=false;

        return count;

    }

    // public static ArrayList<Stmring> knightMove_fillMatrix(int sr,int sc,int count, int boxSize, boolean[][] isdone, ans ){
    //     isdone[sr][sc] = true;
    //     ans[sr][sc] = count;
        
    //     if(count == boxSize) {


    //     }
    //     isdone[sr][sc]=true;
    //     int count = 0;

    //     for(int d=0;d<dir.length;d++){
    //         int x=sr+dir[d][0];
    //         int y=sc+dir[d][1];

    //         if(isValid(x,y,isdone)){
    //              ArrayList<String> calls=knightMove_fillMatrix(x,y,er,ec,isdone);
    //              for(String s:calls){

    //               }  
    //          }
    //     }
    //     isdone[sr][sc]=false;

    //     return myAns;

    // }


    public static  ArrayList<String> keyPad_01(String ques, String[] keys) {

        if(ques.length() == 0) {
                    ArrayList<String> base = new ArrayList<>();
                    base.add("");
                    return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = ques.charAt(0); //237
        String keyAlpha = keys[ch-'0']; //abc

        ArrayList<String> temp = keyPad_01(ques.substring(1), keys);
        
        for(String s: temp) {
            for (int i = 0; i < keyAlpha.length(); i++) {
                ans.add(keyAlpha.charAt(i) + s);
            }
        }
        
        return ans;

    }

    public static ArrayList<String> wordsPerm(String str) {
        if(str.length() == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add(str);
            return base;
        }
        char ch = str.charAt(0);
        ArrayList<String> res = new ArrayList<>();
        
        
        ArrayList<String> temp = wordsPerm(str.substring(1));

        for(String s : temp) {
            for (int i = 0; i < s.length()+1; i++) {
                String ans = s.substring(0,i) + ch + s.substring(i);
                res.add(ans);
            }
        }
        return res;
    }

    // public static ArrayList<String> numToWordPermutation(String ques) {

    //     if(ques.length() == 0) {
    //                 ArrayList<String> base = new ArrayList<>();
    //                 base.add("");
    //                 return base;
    //     }
        
    //     char ch = ques.charAt(0);
    //     ArrayList<String> ans = new ArrayList<>();
    //     if(ch =='0') {
    //         return numToWordPermutation(ques.substring(1));
    //     } else {
    //         ArrayList<String> temp = numToWordPermutation(ques.substring(1));
    //         for(String s: temp) {
    //             char ch1 = (char) ('a' + ch -1);
    //             ans.add(ch+s);
    //         }
    //     }

    //     if(ques.length()>1) {
    //         char ch1 = ques.charAt(1);
    //         int num = (ch-'0')*10 + (ch1-'0');
    //         if(num <27) {
    //             ArrayList<String> temp = numToWordPermutation(ques.substring(2));
    //             for(String s: temp) {
    //                 char ch2 = (char) ('a' + num -1);
    //                 ans.add(ch2 +s);
    //             }
    //         }
    //     }

    // }
    

    public static boolean isValidSudoko(int[][] board, int i, int j, int num) {

        //row
        for(int idx =0; idx < board.length; idx++) {
            if(board[idx][j] == num) return false;
        }

        for(int idx =0; idx < board.length; idx++) {
            if(board[i][idx] == num) return false;
        }

        //matix 3x3
        int r = (i/3)*3;
        int c = (j/3)*3;
        for(int row=0; row<r; row++) {
            for(int col =0; col< c; col++) {
                if(board[r+row][c+col] ==num) return false;
            }

        }
        return true;
    }

    // public static int sudoku(int[][] board) {
         
    // }











    

    // public static String balanceBrackets(String str, ) { }
    

}