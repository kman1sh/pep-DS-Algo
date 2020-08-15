#include <iostream>
#include <vector>
using namespace std;

//===============================================

void subseq(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << ", ";
        return;
    }
    char ch = ques[0];
    string roq = ques.substr(1);
    subseq(roq, ans + ch);
    subseq(roq, ans);
}

//revise
void removeHi(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return;
    }

    if (ques.length() > 1 && ques[0] == 'h' && ques[1] == 'i')
        removeHi(ques.substr(2), ans);
    else
        removeHi(ques.substr(1), ans + ques[0]);
}

void removeDupli(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return;
    }
    char ch = ques[0];

    //if (ques[0] == ans[ans.length() - 1]) second solution. use it instead of next line
    if (ques.length() > 1 && ques[0] == ques[1])
        removeDupli(ques.substr(1), ans);
    else
        removeDupli(ques.substr(1), ans + ch);
}

//HomeWork removeHi expect Hit

void compression(string ques, string ans, int count)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return;
    }
    char ch = ques[0];
    if (ques.length() > 1 && ques[0] == ques[1])
    {
        compression(ques.substr(1), ans, count + 1);
    }
    else
    {
        string currAns;
        if ((count + 1) < 2)
            currAns = ch;
        else
            currAns = ch + to_string(count + 1);
        compression(ques.substr(1), ans + currAns, 0);
    }
}

//abc
int permutation(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int i = 0; i < ques.length(); i++)
    {
        char ch = ques[i];
        string roq = ques.substr(0, i) + ques.substr(i + 1);
        count += permutation(roq, ans + ch);
    }
    return count;
}

/**
 * REVISE
 * smart permutation to avoid duplicate answer.
 * draw tree diagram to see working.
 * e.g ques = "aaa" should give 1ans which is "aaa" (since only this ans is unique & rests are its duplicate)
 * "aba" should give 3 ans. but "abc" should give 3 answer.
*/

int permutation_Wo_Dupli(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return 1;
    }

    // 0 index as 'a' and 25 as 'z'
    // (your char) - 'a' = its index in map
    // e.g: 'a' - 'a' = 0 idx. and 'c' - 'a' = 2 idx
    vector<bool> mapping(26, false);
    int count = 0;
    for (int i = 0; i < ques.length(); i++)
    {
        char ch = ques[i];
        //if idx of current char is false =>we are using it for first time. give it chance to make ans.
        //mapping har recursion call pe sirre se initialize hori hai jo ye true kaha store hora hai?

        //Reason: ye vector ek level tak same hi rahega koi change isme current level ke liye valid hoga becoz of "FOR LOOP"
        //e.g first time loop 3 bar chalega (if ques = "aba") toh is level 3 call niklegi aur vector mai koi bhi chnge inpe aplicable hoga
        // next level pe(in 3 calls ki further jo branches bnegi) vector reset ho jayega.
        //inshort vector mai changes, "ek level" pe "ek node" se (if there aare many node at that level) nikli branch k liye hi valid hai.

        if (!mapping[ch - 'a'])
        {
            mapping[ch - 'a'] = true;
            string roq = ques.substr(0, i) + ques.substr(i + 1);
            count += permutation_Wo_Dupli(roq, ans + ch);
        }
    }
    return count;
}
//Solving with bits instead of vector of bool. Space efficient
// bool vector will take (26) * one bool size = 26 * 4 (4 or 1 ? not sure) memory usage
// by assuming and using one int variable as array will take only 4byte. As int uses 4 byte or 32bits
// idea is to use one "bit" againts one english alphabet. As total alphabets in english 26. So, each alphabet can be mapped in 32 bits or one int variable.
//see the changes in comparison to above code. Only changes are made to replace vector arr.
int permutation_Wo_Dupli_V2(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return 1;
    }

    // vector<bool> mapping(26, false);
    int mapping = 0; //all 32 bits are 0 right now. Or we can say they all are false now.
    int count = 0;
    for (int i = 0; i < ques.length(); i++)
    {
        char ch = ques[i];
        if ((mapping & (1 << (ch - 'a'))) == 0)
        {
            mapping |= (1 << (ch - 'a'));
            string roq = ques.substr(0, i) + ques.substr(i + 1);
            count += permutation_Wo_Dupli_V2(roq, ans + ch);
        }
    }
    return count;
}

int uniqueIn_K(vector<int> &arr, int k)
{
    for (int i = 0; i < arr.size(); i++)
    {
        int count = 1;
        for (int j = 0; j < arr.size(); j++)
        {
            if (arr[i] == arr[j] && i != j)
            {
                count++;
            }
        }
        if (count == 1)
        {
            return arr[i];
        }
    }
    return -1;
}

int uniqueIn_K2(vector<int> &arr, int k)
{
    int ans = 0;
    for (int i = 0; i < 32; i++)
    {
        int count = 0;
        for (int ele : arr)
        {
            int mask = (1 << i);
            if ((ele & mask) != 0)
            {
                count++;
            }
        }

        if (count % k != 0)
        {
            ans |= (1 << i);
        }
    }
    return ans;
}

//Home Work do keypad question with void type.

//======================================================

void basicQues()
{
    // string str;
    // cin >> str;
    // String str=scn.nextLine();

    // subseq("abc", "");
    // removeHi("hhhhihihihihiiiiihihiihhihih", "");
    // removeDupli(str, "");
    // compression("abbbdd", "",0);
    cout << permutation("abc", "") << endl;
    // cout << permutation_Wo_Dupli("aaa", "") << endl;
    // cout << permutation_Wo_Dupli_V2("abab", "") << endl;

    vector<int> arr = {2, 2, 3, 4, 3, 2, 3};
    // cout << uniqueIn_K(arr, 3);
    // cout << uniqueIn_K2(arr, 3);
}

//======================================================

int mazePathSimple(int sr, int sc, int er, int ec, string ans)
{
    if (sr == er && sc == ec)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    //horizontal move
    if (sc < ec)
        count += mazePathSimple(sr, sc + 1, er, ec, ans + "H");

    //vertical move
    if (sr < er)
        count += mazePathSimple(sr + 1, sc, er, ec, ans + "V");

    return count;
}

//can take more than one or more moves at a time. and can move diagonal as well.
int mazePathMultiMove_Diag(int sr, int sc, int er, int ec, string ans)
{
    if (sr == er && sc == ec)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    //col moves
    for (int i = 1; i <= ec; i++)
    {
        if (sc + i <= ec)
            count += mazePathMultiMove_Diag(sr, sc + i, er, ec, ans + "H" + to_string(i));
    }
    //row moves
    for (int j = 1; j <= er; j++)
    {
        if (sr + j <= er)
            count += mazePathMultiMove_Diag(sr + j, sc, er, ec, ans + "V" + to_string(j));
    }
    //Diagonal moves
    for (int k = 1; k <= er; k++)
    {
        if (sc + k <= ec && sr + k <= er)
            count += mazePathMultiMove_Diag(sr + k, sc + k, er, ec, ans + "D" + to_string(k));
    }

    return count;
}

//dice and bord problem
//can take a jump of 1 to 6 step. board: imagine a 1D array.
//find all the possible path to end of the board.
int boardPath(int start, int end, string ans)
{
    if (start == end)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;

    //a move can be jump of 1 to 6.
    for (int jump = 1; jump <= 6 && start + jump <= end; jump++)
    {
        // if (start + i <= end)
        count += boardPath(start + jump, end, ans + to_string(jump));
    }
    return count;
}

//==========================================================

void pathType()
{
    // cout << mazePathSimple(0, 0, 2, 2, "");
    // cout << mazePathMultiMove_Diag(0, 0, 3, 3, "");
    cout << boardPath(0, 10, "") << endl;
}

//==========================================================

//permutation when each coin can be used infinity times.
int coinChange_permu01(vector<int> &arr, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        int coin = arr[i];
        if (target - coin >= 0)
        {
            count += coinChange_permu01(arr, target - coin, ans + to_string(coin) + " ");
        }
    }
    return count;
}
//Combination when each coin can be used infinity times.
int coinChange_Combi01(vector<int> &arr, int vidx, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = vidx; i < arr.size(); i++)
    {
        int coin = arr[i];
        if (target - coin >= 0)
        {
            count += coinChange_Combi01(arr, i, target - coin, ans + to_string(coin) + " ");
        }
    }
    return count;
}

int coinChange_Combi01_Simplified(vector<int> &arr, int vidx, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    if (target - arr[vidx] >= 0 && vidx < arr.size())
    {
        count += coinChange_Combi01_Simplified(arr, vidx, target - arr[vidx], ans + to_string(arr[vidx]) + " ");
    }
    if (target - arr[vidx + 1] >= 0 && vidx + 1 < arr.size())
    {
        count += coinChange_Combi01_Simplified(arr, vidx + 1, target - arr[vidx + 1], ans + to_string(arr[vidx + 1]) + " ");
    }
    if (target - arr[vidx + 2] >= 0 && vidx + 2 < arr.size())
    {
        count += coinChange_Combi01_Simplified(arr, vidx + 2, target - arr[vidx + 2], ans + to_string(arr[vidx + 2]) + " ");
    }
    if (target - arr[vidx + 3] >= 0 && vidx + 3 < arr.size())
    {
        count += coinChange_Combi01_Simplified(arr, vidx + 3, target - arr[vidx + 3], ans + to_string(arr[vidx + 3]) + " ");
    }

    return count;
}

//Combination when each coin can be used only once.
int coinChange_Combi02(vector<int> &arr, int vidx, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;

    for (int i = vidx; i < arr.size(); i++)
    {
        int newTarget = target - arr[i];
        if (newTarget >= 0)
        {
            count += coinChange_Combi02(arr, i + 1, newTarget, ans + to_string(arr[i]) + " ");
        }
    }
    return count;
}
//permutation when  each coin can be used once.
int coinChange_permu02(vector<int> &arr, int target, vector<bool> isdone, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0 && !isdone[i])
        {
            isdone[i] = true;
            int newTarget = target - arr[i];
            count += coinChange_permu02(arr, newTarget, isdone, ans + to_string(arr[i]) + " ");
            isdone[i] = false;
        }
    }
    return count;
}

//decision on target, whether it wants to accept the coin or not.
//Cobination when coin can be used infinity numbers of time.
int coinChangeCombi03_Subseq(vector<int> &arr, int vidx, int target, string ans)
{
    if (target == 0 || vidx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        else
            return 0;
    }
    int count = 0;
    int newTarget = target - arr[vidx];
    if (newTarget >= 0)
    {
        count += coinChangeCombi03_Subseq(arr, vidx, newTarget, ans + to_string(arr[vidx]) + " ");
    }
    count += coinChangeCombi03_Subseq(arr, vidx + 1, target, ans);

    return count;
}
//coin can be used infinity numbers of time.
int coinChangePermu03_Subseq(vector<int> &arr, int vidx, int target, string ans)
{
    if (target == 0 || vidx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        else
            return 0;
    }
    int count = 0;
    int newTarget = target - arr[vidx];
    if (newTarget >= 0)
    {
        count += coinChangePermu03_Subseq(arr, 0, newTarget, ans + to_string(arr[vidx]) + " ");
    }
    count += coinChangePermu03_Subseq(arr, vidx + 1, target, ans);

    return count;
}

//subsequence method to part an array in two sets(set1, set2) such that set1 = set2.
int equiSet(vector<int> &arr, int vidx, int set1, int set2, string ans1, string ans2)
{
    if (vidx == arr.size())
    {
        if (set1 == set2)
        {
            cout << ans1 << " = " << ans2 << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;

    count += equiSet(arr, vidx + 1, set1 + arr[vidx], set2, ans1 + to_string(arr[vidx]) + " ", ans2);
    count += equiSet(arr, vidx + 1, set1, set2 + arr[vidx], ans1, ans2 + to_string(arr[vidx]) + " ");

    return count;
}
void permuAndCombi()
{

    // vector<int> arr1 = {10, 20, 30, 40, 50, 60, 70};
    // cout << equiSet(arr1, 1, 10, 0, "10 ", "") << endl;

    vector<int> arr = {2, 3, 5, 7};
    cout << coinChange_permu01(arr, 10, "") << endl;
    // vector<bool> isDone(arr.size(), false);
    // cout << coinChange_permu02(arr, 10, isDone, "") << endl;
    // cout << coinChange_Combi01_Simplified(arr, 0, 10, "") << endl;
    cout << coinChange_Combi01(arr, 0, 10, "") << endl;
    // cout << coinChange_Combi02(arr, 0, 10, "") << endl;
    // cout << coinChangeCombi03_Subseq(arr, 0, 10, "") << endl;
    // cout << coinChangePermu03_Subseq(arr, 0, 10, "") << endl;
}

//========================================================================

// int crypto(string str, int idx) {}

vector<string> dict = {"i", "like", "ilike", "man", "go", "mango", "and", "sam", "sung", "samsung"};
//ilikemangoandsamsung

int wordBreak(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    string tempWord;
    for (int i = 0; i < ques.length(); i++)
    {
        tempWord += ques[i];
        for (string s : dict)
        {
            if (tempWord.compare(s) == 0) //IMP: strings are compared with .compare() function.
                count += wordBreak(ques.substr(i + 1), ans + tempWord + " ");
        }
    }
    return count;
}

bool isSafeToPlace(int x, int y, vector<vector<int>> board, int num)
{
    //row
    for (int j = 0; j < board[x].size(); j++)
    {
        if (board[x][j] == num)
            return false;
    }

    //column
    for (int i = 0; i < board.size(); i++)
    {
        if (board[i][y] == num)
            return false;
    }

    //3x3 matrix by compress and decompress from 9x9 to 3x3
    int rowStart = (x / 3) * 3;
    int colStart = (y / 3) * 3;

    for (int k = rowStart; k < (rowStart + 3); k++)
    {
        for (int l = colStart; l < (colStart + 3); l++)
        {
            if (board[k][l] == num)
                return false;
        }
    }

    return true;
}

int sudoku(vector<vector<int>> board, int vidx)
{
    if (vidx == 81)
    {
        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[0].size(); j++)
            {
                cout << board[i][j] << " ";
            }
            cout << endl;
        }
        cout << "==================" << endl;
        return 1;
    }
    //converting vidx to co-ordinates
    int x = vidx / 9;
    int y = vidx % 9;
    int count = 0;

    if (board[x][y] != 0)
        count += sudoku(board, vidx + 1);
    else
    {
        for (int i = 1; i <= 9; i++)
        {
            if (isSafeToPlace(x, y, board, i))
            {
                board[x][y] = i;
                count += sudoku(board, vidx + 1);
                board[x][y] = 0;
            }
        }
    }
    return count;
}

vector<int> row(9, 0);
vector<int> col(9, 0);
vector<vector<int>> mat(3, vector<int>(3, 0));

int sudoku_bitMethod(vector<vector<int>> board, int vidx)
{
    if (vidx == 81)
    {
        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[0].size(); j++)
            {
                cout << board[i][j] << " ";
            }
            cout << endl;
        }
        cout << "==================" << endl;
        return 1;
    }
    //converting vidx to co-ordinates
    int x = vidx / 9;
    int y = vidx % 9;
    int count = 0;

    if (board[x][y] != 0)
        count += sudoku_bitMethod(board, vidx + 1);
    else
    {
        for (int i = 1; i <= 9; i++)
        {
            int mask = (1 << i);
            if (((row[x] & mask) == 0) && ((col[y] & mask) == 0) && ((mat[x / 3][y / 3] & mask) == 0))
            {
                board[x][y] = i;
                row[x] |= mask;
                col[y] |= mask;
                mat[x / 3][y / 3] |= mask;

                count += sudoku_bitMethod(board, vidx + 1);

                //Since I am 100% uper wale bit mene ON kiya tha So OFF krne k liye XOR use krlo.
                //(USE XOR only when you know current state of bit (ON/OFF) jese mujhe yaha pta hai bit ON hai and SO XOR will definately make that bit OFF)
                board[x][y] = 0;
                row[x] ^= mask;
                col[y] ^= mask;
                mat[x / 3][y / 3] ^= mask;
            }
        }
    }
    return count;
}

void ballonGame(vector<int> &arr, int point , string ans)
{
    if(arr.size() == 0) {
        cout<<point<<" "<<endl;
        cout<<ans<<endl;

    }

    for (int i = 0; i < arr.size(); i++)
    {
        int points = 0;
        int Pvalue = 1;
        int Nvalue = 1;
        if (i - 1 >= 0)
            Pvalue = arr[i - 1];

        if (i + 1 < arr.size())
            Nvalue = arr[i + 1];

        points = Pvalue * arr[i] * Nvalue;
        vector<int> newArr;
        for (int j = 0; j < arr.size(); j++)
        {
            if (j != i)
                newArr.push_back(arr[j]);
        }

        ballonGame(newArr, point + points, ans + to_string(arr[i]) +" ");
    }
}
int main(int args, char **argv)
{
    // basicQues();
    // pathType();
    permuAndCombi();
    // cout << wordBreak("ilikemangoandsamsung", "") << endl;

    vector<vector<int>> board{{3, 0, 6, 5, 0, 8, 4, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 8, 7, 0, 0, 0, 0, 3, 1},
                              {0, 0, 3, 0, 1, 0, 0, 8, 0},
                              {9, 0, 0, 8, 6, 3, 0, 0, 5},
                              {0, 5, 0, 0, 9, 0, 6, 0, 0},
                              {1, 3, 0, 0, 0, 0, 2, 5, 0},
                              {0, 0, 0, 0, 0, 0, 0, 7, 4},
                              {0, 0, 5, 2, 0, 6, 3, 0, 0}};

    for (int i = 0; i < board.size(); i++)
    {
        for (int j = 0; j < board[0].size(); j++)
        {
            if (board[i][j] != 0)
            {
                int mask = 1 << board[i][j];
                row[i] |= mask;
                col[j] |= mask;
                mat[i / 3][j / 3] |= mask;
            }
        }
    }

    // cout << sudoku(board, 0) << endl;
    // cout << sudoku_bitMethod(board, 0) << endl;

    // vector<int> arr{2, 5, 7, 8};
    // ballonGame(arr,0, "");
    return 0;
}