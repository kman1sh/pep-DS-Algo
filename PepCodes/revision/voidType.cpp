#include <iostream>
#include <vector>
using namespace std;

void subseq(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return;
    }

    char ch = ques[0];
    subseq(ques.substr(1), ans + ch);
    subseq(ques.substr(1), ans);
}

void subseqV2(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return;
    }
    char ch = ques[0];
    int ch1 = ques[0];
    subseqV2(ques.substr(1), ans + ch);
    subseqV2(ques.substr(1), ans);
    subseqV2(ques.substr(1), ans + to_string(ch1));
}

void permu(string ques, string ans)
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return;
    }

    for (int i = 0; i < ques.length(); i++)
    {
        char ch = ques[i];
        string roq = ques.substr(0, i) + ques.substr(i + 1);
        permu(roq, ans + ch);
    }
}

void permu_NoDubli(string ques, string ans) //aba
{
    if (ques.length() == 0)
    {
        cout << ans << endl;
        return;
    }
    vector<bool> arr(26, false);
    for (int i = 0; i < ques.length(); i++)
    {
        char ch = ques[i];
        int idx = ch - 'a';
        if (arr[idx] == false)
        {
            arr[idx] = true;
            string roq = ques.substr(0, i) + ques.substr(i + 1);
            permu_NoDubli(roq, ans + ch);
        }
    }
}

int permu_infCoins_01(vector<int> &arr, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0)
            count += permu_infCoins_01(arr, target - arr[i], ans + to_string(arr[i]) + " ");
    }
    return count;
}

int combi_infCoins_01(vector<int> &arr, int idx, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = idx; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0)
            count += combi_infCoins_01(arr, i, target - arr[i], ans + to_string(arr[i]) + " ");
    }
    return count;
}

int combi_finiCoins_02(vector<int> &arr, int idx, int target, string ans)
{
    if (target == 0)
    {
        cout << ans << endl;
        return 1;
    }
    int count = 0;
    for (int i = idx; i < arr.size(); i++)
    {
        if (target - arr[i] >= 0)
            count += combi_finiCoins_02(arr, i + 1, target - arr[i], ans + to_string(arr[i]) + " ");
    }
    return count;
}

int permu_infCoins_subSeq_02(vector<int> &arr, int target, int idx, string ans)
{
    if (target == 0 || idx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (target - arr[idx] >= 0)
    {
        count += permu_infCoins_subSeq_02(arr, target - arr[idx], 0, ans + to_string(arr[idx]) + " ");
        count += permu_infCoins_subSeq_02(arr, target, idx + 1, ans);
    }
    return count;
}

int permu_finiCoins_subSeq_03(vector<int> &arr, int target, int idx, vector<bool> isValid, string ans)
{
    if (target == 0 || idx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (target - arr[idx] >= 0 && isValid[idx] == false)
    {
        isValid[idx] = true;
        count += permu_finiCoins_subSeq_03(arr, target - arr[idx], 0, isValid, ans + to_string(arr[idx]) + " ");
        isValid[idx] = false;
    }
    count += permu_finiCoins_subSeq_03(arr, target, idx + 1, isValid, ans);
    return count;
}
// int permu_finiCoins_04(vector<int> &arr, int target, int idx, vector<bool> isValid, string ans) {}

int combi_infCoins_subSeq_03(vector<int> &arr, int target, int idx, string ans)
{
    if (target == 0 || idx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (target - arr[idx] >= 0)
    {
        count += combi_infCoins_subSeq_03(arr, target - arr[idx], idx, ans + to_string(arr[idx]) + " ");
        count += combi_infCoins_subSeq_03(arr, target, idx + 1, ans);
    }
    return count;
}

int combi_finiCoins_subSeq_04(vector<int> &arr, int target, int idx, string ans)
{
    if (target == 0 || idx == arr.size())
    {
        if (target == 0)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count = 0;
    if (target - arr[idx] >= 0)
    {
        count += combi_finiCoins_subSeq_04(arr, target - arr[idx], idx + 1, ans + to_string(arr[idx]) + " ");
    }
    count += combi_finiCoins_subSeq_04(arr, target, idx + 1, ans);
    return count;
}

void coinChange()
{
    vector<int> coins = {2, 3, 5, 7};
    // cout << permu_infCoins_01(coins, 10, "") << endl;
    // cout << combi_infCoins_01(coins, 0, 10, "") << endl;
    // cout << combi_finiCoins_02(coins, 0, 10, "") << endl;
    // cout << permu_infCoins_subSeq_02(coins, 10, 0, "") << endl;
    // cout << combi_infCoins_subSeq_03(coins, 10, 0, "") << endl;
    cout << combi_finiCoins_subSeq_04(coins, 10, 0, "") << endl;

    // vector<bool> isVisited(coins.size(), false);
    // cout << permu_finiCoins_subSeq_03(coins, 10, 0, isVisited, "") << endl;
}
//=============================================

void nqueen_permu01(int box, int numQueen, int QueensUsed, vector<bool> isVisited, string ans)
{
    if (QueensUsed == numQueen)
    {
        cout << ans << endl;
    }

    for (int i = 0; i < box; i++)
    {
        if (!isVisited[i])
        {
            isVisited[i] = true;
            nqueen_permu01(box, numQueen, QueensUsed + 1, isVisited, ans + "b" + to_string(i + 1) + "q" + to_string(QueensUsed + 1));
            isVisited[i] = false;
        }
    }
}

void nqueen_combi01(int box, int numQueen, int QueensUsed, int idx, string ans)
{
    if (QueensUsed == numQueen)
    {
        cout << ans << endl;
    }

    for (int i = idx; i < box; i++)
        nqueen_combi01(box, numQueen, QueensUsed + 1, i + 1, ans + "b" + to_string(i + 1) + "q" + to_string(QueensUsed + 1));
}

void nqueen_Matcombi(int box, int numQueen, int QueensUsed, int idx, string ans)
{

    if (QueensUsed == numQueen)
    {
        cout << ans << endl;
    }

    for (int i = idx; i <= box; i++)
    {
        int x = i / 4;
        int y = i % 4;
        string cordinate = "(" + to_string(x) + "," + to_string(y) + ")";
        nqueen_Matcombi(box, numQueen, QueensUsed + 1, i + 1, ans + cordinate + "q" + to_string(QueensUsed + 1) + " ");
    }
}

void nqueen_MatPermu(int box, int numQueen, int QueensUsed, vector<bool> isVisited, string ans)
{
    if (QueensUsed == numQueen)
    {
        cout << ans << endl;
        return;
    }

    for (int i = 0; i < box; i++)
    {
        if (!isVisited[i])
        {
            isVisited[i] = true;
            int x = i / 4;
            int y = i % 4;
            string cordinate = "(" + to_string(x) + "," + to_string(y) + ")";
            nqueen_MatPermu(box, numQueen, QueensUsed + 1, isVisited, ans + cordinate + "q" + to_string(QueensUsed + 1) + " ");
            isVisited[i] = false;
        }
    }
}

vector<vector<int>> magnitude = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

bool isSafeToPlace_q(int x, int y, vector<vector<bool>> isVis)
{
    for (int i = 0; i < magnitude.size(); i++)
    {
        for (int j = 1; j < 4; j++)
        {
            int xloc = x + (j * magnitude[i][0]);
            int yloc = y + (j * magnitude[i][1]);
            if (xloc >= 0 && yloc >= 0 && (xloc < magnitude.size()) && (yloc < magnitude.size()) && (isVis[xloc][yloc]))
            {
                return false;
            }
        }
    }

    return true;
}

void nqueen_act(int box, int numQueen, int QueensUsed, int idx, vector<vector<bool>> isVis, string ans)
{

    if (QueensUsed == numQueen)
    {
        cout << ans << endl;
        return;
    }

    for (int i = idx; i <= box; i++)
    {
        int x = i / 4;
        int y = i % 4;
        if (isSafeToPlace_q(x, y, isVis))
        {
            isVis[x][y] = true;
            string cordinate = "(" + to_string(x) + "," + to_string(y) + ")";

            nqueen_act(box, numQueen, (QueensUsed + 1), (i + 1), isVis, ans + cordinate + "q" + to_string(QueensUsed + 1) + " ");
            isVis[x][y] = false;
        }
    }
}

int nqueen_actCombi_subseq(int box, int idx, int numQueen, int queensUsed, vector<vector<bool>> isValid, string ans)
{
    if (numQueen == queensUsed || idx == box + 1)
    {
        if (numQueen == queensUsed)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }

    int count = 0;
    int x = idx / 4;
    int y = idx % 4;
    if (isSafeToPlace_q(x, y, isValid))
    {
        isValid[x][y] = true;
        string cordinate = "(" + to_string(x) + "," + to_string(y) + ")";

        count += nqueen_actCombi_subseq(box, (idx + 1), numQueen, queensUsed + 1, isValid, ans + cordinate + "q" + to_string(queensUsed + 1) + " ");
        isValid[x][y] = false;
    }
    count += nqueen_actCombi_subseq(box, (idx + 1), numQueen, queensUsed, isValid, ans);
    return count;
}
//==============================================

void nqueen()
{

    vector<bool> isVisited(5, false);
    // nqueen_permu01(5, 3, 0, isVisited, "");
    // nqueen_combi01(5, 3, 0, 0, "");
    // nqueen_Matcombi(15, 4, 0, 0, "");
    // vector<bool> isVisited2D(16, false);
    // nqueen_MatPermu(16, 4, 0, isVisited2D, "");
    vector<vector<bool>> isValid(4, vector<bool>(4, false));
    // nqueen_act(15, 4, 0, 0, isValid, "");

    nqueen_actCombi_subseq(15, 0, 4, 0, isValid, "");
}

//==================================================

// void subseq_binary(int hei, string ans) {
//     if(ans.length() == 3){
//         cout<<
//     }

//     subseq_binary(hei-1, ans + "1");
//     subseq_binary(hei-1, ans + "0");

// }

//==================================================

string strJointer()
{
    string str = "sendmoremoney";
    vector<int> arr(26, 0);
    for (int i = 0; i < str.length(); i++)
    {
        int idx = str[0] - 'a';
        arr[idx] += 1;
    }
    string ans = "";
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] > 0)
            ans += (char)(i + 'a');
    }
    return ans;
}

string send = "send";
string more = "more";
string money = "money";

int decrypt(string str, vector<int> arr)
{
    // string num;
    int number = 0;
    for (int i = 0; i < str.length(); i++)
    {
        int idx = str[i] - 'a';
        // num = num + to_string(arr[idx]);
        number = (number * 10) + arr[idx];
    }
    // return stoi(num);
    return number;
}
//9567 1085 10652
void crypto(string jStr, vector<int> arr, vector<bool> isAssinged, string ans)
{
    if (jStr.length() == 0)
    {
        if (arr['s' - 'a'] != 0 && arr['m' - 'a'] != 0)
        {

            int send = decrypt("send", arr);
            int more = decrypt("more", arr);
            int money = decrypt("money", arr);
            if ((send + more) == money)
            {
                cout << send << " + " << more << " = " << money << endl;
            }
        }
        return;
    }
    char ch = jStr[0];
    for (int i = 0; i < 10; i++)
    {
        if (!isAssinged[i])
        {
            isAssinged[i] = true;
            int idx = ch - 'a';
            arr[idx] = i;
            crypto(jStr.substr(1), arr, isAssinged, ans + ch + "=" + to_string(i) + " ");
            isAssinged[i] = false;
        }
    }
}

void cryptoSubseq(string str, int nummber, vector<bool> isAssinged, vector<int> mapcharToNumber)
{
    if (nummber > 9 || str == "")
    {

        if (str.length() == 0 && (mapcharToNumber['s' - 'a'] != 0) && (mapcharToNumber['m' - 'a'] != 0))
        {
            int send = decrypt("send", mapcharToNumber);
            int more = decrypt("more", mapcharToNumber);
            int money = decrypt("money", mapcharToNumber);
            if ((send + more) == money)
            {
                cout << send << " + " << more << " = " << money << endl;
            }
        }
        return;
    }

    char ch = str[0];
    if (!isAssinged[nummber])
    {
        isAssinged[nummber] = true;
        mapcharToNumber[ch - 'a'] = nummber;
        cryptoSubseq(str.substr(1), 0, isAssinged, mapcharToNumber);
        isAssinged[nummber] = false;
    }
    cryptoSubseq(str, nummber + 1, isAssinged, mapcharToNumber);
}

bool isSafeToPlace_s(vector<vector<int>> board, int num, int x, int y)
{
    //uss row  mai check
    for (int i = 0; i < board.size(); i++)
    {
        if (board[x][i] == num)
            return false;
    }

    //uss col mai check
    for (int i = 0; i < board.size(); i++)
    {
        if (board[i][y] == num)
            return false;
    }

    //3x3 mat
    int xStart = (x / 3) * 3;
    int yStart = (y / 3) * 3;

    for (int i = xStart; i < xStart + 3; i++)
    {
        for (int j = yStart; j < yStart + 3; j++)
        {
            if (board[i][j] == num)
                return false;
        }
    }
    return true;
}

void printSudoku(vector<vector<int>> board)
{
    for (int i = 0; i < board.size(); i++)
    {
        for (int j = 0; j < board[0].size(); j++)
        {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}

void sudoku(vector<vector<int>> board, int idx, string ans)
{
    if (idx == board[0].size() * board.size())
    {
        printSudoku(board);
        return;
    }

    int x = idx / 9;
    int y = idx % 9;

    if (board[x][y] != 0)
        sudoku(board, idx + 1, ans);
    else
    {
        for (int i = 1; i <= 9; i++)
        {
            if (isSafeToPlace_s(board, i, x, y))
            {
                board[x][y] = i;
                sudoku(board, idx + 1, ans);
                board[x][y] = 0;
            }
        }
    }
}

void sudoku_02(vector<vector<int>> board, int idx, vector<int> boardWoNums)
{
    if (idx == boardWoNums.size())
    {
        printSudoku(board);
        return;
    }

    int x = boardWoNums[idx] / 9;
    int y = boardWoNums[idx] % 9;

    for (int i = 1; i <= 9; i++)
    {
        if (isSafeToPlace_s(board, i, x, y))
        {
            board[x][y] = i;
            sudoku_02(board, idx + 1, boardWoNums);
            board[x][y] = 0;
        }
    }
}
void sudokuSubseq_03(vector<vector<int>> board, int idx, int number, vector<int> boardWoNums)
{
    if (idx == boardWoNums.size() || number > 9)
    {
        if (idx == boardWoNums.size())
            printSudoku(board);

        return;
    }

    int x = boardWoNums[idx] / 9;
    int y = boardWoNums[idx] % 9;

    if (isSafeToPlace_s(board, number, x, y))
    {
        board[x][y] = number;
        sudokuSubseq_03(board, idx + 1, 1, boardWoNums);
        board[x][y] = 0;
    }
    sudokuSubseq_03(board, idx, number + 1, boardWoNums);
}

int rows[9] = {0};
int cols[9] = {0};
int matrix[3][3] = {0};

void sudokuSubseq_BitMask_Optimized(vector<vector<int>> board, int idx, int number, vector<int> boardWoNums)
{
    if (idx == boardWoNums.size() || number > 9)
    {
        if (idx == boardWoNums.size())
            printSudoku(board);

        return;
    }

    int x = boardWoNums[idx] / 9;
    int y = boardWoNums[idx] % 9;
    int mask = (1 << number);
    if ((rows[x] & mask) == 0 && (cols[y] & mask) == 0 && (matrix[x / 3][y / 3] & mask) == 0)
    {
        board[x][y] = number;
        rows[x] ^= mask;
        cols[y] ^= mask;
        matrix[x / 3][y / 3] ^= mask;
        sudokuSubseq_BitMask_Optimized(board, idx + 1, 1, boardWoNums);
        rows[x] ^= mask;
        cols[y] ^= mask;
        matrix[x / 3][y / 3] ^= mask;
        board[x][y] = 0;
    }
    sudokuSubseq_BitMask_Optimized(board, idx, number + 1, boardWoNums);
}

//======================================================================

vector<vector<char>> crosswordBoard =
    {{'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
     {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
     {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
     {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
     {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
     {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
     {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
     {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
     {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
     {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};

// vector<string> crs_Words = {"AGRA", "NORWAY", "ENGLAND", "GWALIOR"};

bool canPlaceVertical(string word, int r, int c)
{
    //row 0 and row last ko alag se handle krna hai becoz 0 se pehle and last row k baad '+' nahi hai.
    //jab r = 0 se start ho
    if (r == 0 && word.length() != crosswordBoard.size()) // row 0 hai aur word crossboard k size se chhota hai. means word k end point pe '+' milna chahiye
    {
        if (crosswordBoard[r + word.length()][c] != '+')
        {
            return false;
        }
    }
    // jab r bich mai kahi ho and word rkhne pe crossword k last row tk chla jaye. ye valid loc tab tk nai hoga jab tk word k just uper '+' na ho.
    if (r != 0 && word.length() != crosswordBoard.size() && (r + word.length()) == crosswordBoard.size() && crosswordBoard[r - 1][c] != '+')
    {
        return false;
    }

    //jab row bich mai ho... aur word rkhne pe crossword k last row se chhota reh jaye
    if (r != 0 && word.length() != crosswordBoard.size() && (crosswordBoard[r - 1][c] != '+' || crosswordBoard[r + word.length()][c] != '+'))
    {
        return false;
    }

    // checks tight bound and when word.length() == crosswordBoard.size()
    for (int i = 0; i < word.length(); i++)
    {

        // if(crosswordBoard[r + i][c] == "+") return false;
        if (!(crosswordBoard[r + i][c] == '-' || crosswordBoard[r + i][c] == word[i]))
        {
            return false;
        }
    }
    return true;
}

vector<bool> placeWordVertical(string word, int r, int c)
{
    vector<bool> pos(word.size(), false); //to track konsa word "Currently" humne place kiya aur konsa pehle se tha.
    for (int i = 0; i < word.length(); i++)
    {
        if (crosswordBoard[r + i][c] == '-')
        {
            crosswordBoard[r + i][c] = word[i];
            pos[i] = true;
        }
    }
    return pos;
}
void unplaceWordVertical(int r, int c, vector<bool> position)
{
    for (int i = 0; i < position.size(); i++)
    {
        if (position[i])
            crosswordBoard[r + i][c] = '-';
    }
}

bool canPlaceHorizontal(string word, int r, int c)
{
    if (c == 0 && word.length() != crosswordBoard[0].size()) // row 0 hai aur word crossboard k size se chhota hai. means word k end point pe '+' milna chahiye
    {
        if (crosswordBoard[r][c + word.size()] != '+')
            return false;
    }

    if (c != 0 && word.length() != crosswordBoard[0].size() && ((c + word.size()) == crosswordBoard[0].size()) && crosswordBoard[r][c - 1] != '+')
        return false;

    if (c != 0 && word.length() != crosswordBoard[0].size() && (crosswordBoard[r][c - 1] != '+' || crosswordBoard[r][c + word.length()] != '+'))
        return false;

    // checks tight bound and when word.length() == crosswordBoard.size()
    for (int i = 0; i < word.length(); i++)
    {
        if (!(crosswordBoard[r][c + i] == '-' || crosswordBoard[r][c + i] == word[i]))
            return false;
    }
    return true;
}

vector<bool> placeWordHorizontal(string word, int r, int c)
{
    vector<bool> pos(word.length(), false); //to track krha hai konsa word "Currently" humne place kiya aur konsa pehle se tha.
    for (int i = 0; i < word.length(); i++)
    {
        if (crosswordBoard[r][c + i] == '-')
        {
            crosswordBoard[r][c + i] = word[i];
            pos[i] = true;
        }
    }
    return pos;
}
void unplaceWordHorizontal(int r, int c, vector<bool> position)
{
    for (int i = 0; i < position.size(); i++)
    {
        if (position[i])
            crosswordBoard[r][c + i] = '-';
    }
}

void printCrsBoard()
{
    for (vector<char> v : crosswordBoard)
    {
        for (char ch : v)
        {
            cout << ch << " ";
        }
        cout << endl;
    }
}

void crosswordPuzzle(vector<string> &wordsArr, int idx)
{
    if (idx == wordsArr.size())
    {
        printCrsBoard();
        return;
    }

    string word = wordsArr[idx];
    for (int i = 0; i < crosswordBoard.size(); i++)
    {
        for (int j = 0; j < crosswordBoard[0].size(); j++)
        {
            if (crosswordBoard[i][j] == '-' || crosswordBoard[i][j] == word[0])
            {
                if (canPlaceVertical(word, i, j))
                {
                    vector<bool> markChar = placeWordVertical(word, i, j); // word ke characters mark kr liye jo place hue hai.
                    crosswordPuzzle(wordsArr, idx + 1);
                    unplaceWordVertical(i, j, markChar);
                }

                if (canPlaceHorizontal(word, i, j))
                {
                    vector<bool> markChar = placeWordHorizontal(word, i, j); // place kiya aur word mark kr liye jo place hue hai.
                    crosswordPuzzle(wordsArr, idx + 1);
                    unplaceWordHorizontal(i, j, markChar);
                }
            }
        }
    }
}

//=============================================================
int main(int args, char **argv)
{
    // subseqV2("abc", "");
    // permu("abc", "");
    // permu_NoDubli("aba", "");
    // coinChange();
    // nqueen();
    // vector<int> arr(26, -1);
    // vector<bool> arrBool(10, false);

    // crypto("demnorsy", arr, arrBool, "");
    // cryptoSubseq("demnorsy", 0, arrBool, arr);

    // {
    //                             { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
    //                             { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
    //                             { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
    //                             { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
    //                             { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
    //                             { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
    //                             { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
    //                             { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
    //                             { 0, 0, 0, 0, 8, 0, 0, 7, 9 }};

    // {
    // { 0, 0, 0, 8, 0, 0, 0, 0, 0 },
    // { 7, 8, 9, 0, 1, 0, 0, 0, 6 },
    // { 0, 0, 0, 0, 0, 6, 1, 0, 0 },
    // { 0, 0, 7, 0, 0, 0, 0, 5, 0 },
    // { 5, 0, 8, 7, 0, 9, 3, 0, 4 },
    // { 0, 4, 0, 0, 0, 0, 2, 0, 0 },
    // { 0, 0, 3, 2, 0, 0, 0, 0, 0 },
    // { 8, 0, 0, 0, 7, 0, 4, 3, 9 },
    // { 0, 0, 0, 0, 0, 1, 0, 0, 0 }};

    // vector<vector<int>> board = {
    //     {0, 0, 0, 0, 8, 0, 0, 3, 0},
    //     {0, 7, 0, 0, 2, 0, 8, 0, 4},
    //     {0, 0, 0, 0, 4, 3, 0, 1, 0},
    //     {8, 9, 0, 0, 0, 0, 0, 6, 2},
    //     {5, 0, 0, 0, 0, 0, 0, 0, 8},
    //     {2, 4, 0, 0, 0, 0, 0, 9, 7},
    //     {0, 8, 0, 0, 0, 0, 0, 0, 0},
    //     {6, 0, 9, 0, 3, 0, 0, 0, 0},
    //     {0, 3, 0, 0, 5, 0, 0, 0, 0}};

    // sudoku(board, 0, "");

    // vector<int> boardWoNums;
    // for (int i = 0; i < board.size(); i++)
    // {
    //     for (int j = 0; j < board[0].size(); j++)
    //     {
    //         if (board[i][j] == 0)
    //         {
    //             int B_idx = (i * 9) + j;
    //             boardWoNums.push_back(B_idx);
    //         }
    //         else
    //         {
    //             int mask = (1 << board[i][j]); // mask = number in the board at that perticular position
    //             rows[i] |= mask;
    //             cols[j] |= mask;
    //             matrix[i / 3][j / 3] |= mask;
    //         }
    //     }
    // }

    // sudoku_02(board,0,boardWoNums);
    // sudokuSubseq_03(board, 0, 1, boardWoNums);

    vector<string> crs_Words = {"AGRA", "NORWAY", "ENGLAND", "GWALIOR"};

    crosswordPuzzle(crs_Words, 0);

    cout << "====================================" << endl;

    // cout << (canPlaceVertical("ENGLAND", 0, 1));

    return 0;
}