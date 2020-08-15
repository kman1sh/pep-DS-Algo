import java.util.ArrayList;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        ArrayList<String> base = floodfill(0, 0, 3, 3, new boolean[4][4]);
        System.out.println(base);
        System.out.println(base.size());
    }


    public static ArrayList<String> floodfill(int row_st, int col_st, int row_end, int col_end, boolean[][] isVis) {
        if(row_st == row_end && col_st == col_end) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        // System.out.println(row_st +":" +col_st);
        //H
        if(col_st + 1 <= col_end && row_st <= row_end && !isVis[row_st][col_st +1]) {
            isVis[row_st][col_st +1] = true;
            ArrayList<String> recAns = floodfill(row_st, col_st+1, row_end, col_end, isVis);
            for (String s : recAns) {
                myAns.add('H' +s);
            }
            isVis[row_st][col_st +1] = false;

        }
        //V
        if(row_st +1 <= row_end && col_st <= col_end && !isVis[row_st+1][col_st]) {
            isVis[row_st+1][col_st] = true;
            ArrayList<String> recAns = floodfill(row_st+1, col_st, row_end, col_end, isVis);
            for (String s : recAns) {
                myAns.add('V' +s);
            }
            isVis[row_st+1][col_st] = false;
        }
        //D
        if(row_st +1 <= row_end  && col_st + 1 <= col_end  && !isVis[row_st+1][col_st +1]) {
            isVis[row_st+1][col_st +1] = true;
            ArrayList<String> recAns = floodfill(row_st+1, col_st+1, row_end, col_end, isVis);
            for (String s : recAns) {
                myAns.add('D' +s);
            }
            isVis[row_st+1][col_st +1] = false;
        }
        return myAns;
    }


}




