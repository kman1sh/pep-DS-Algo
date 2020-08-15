#include <iostream>
#include <vector>
using namespace std;

// int bitPractice(int y)
// {
//     int x = 32;

//     if ((x & (1 << 5)) != 0)
//     {
//         cout << "occupied";
//     }
//     else
//     {
//         cout << "Nope";
//     }
//     return x;
// }

int indexOfNumber(vector<int> arr, int vidx, int num)
{
    if (vidx == arr.size())
        return -1;
    if (arr[vidx] == num)
        return vidx;
    return indexOfNumber(arr, vidx + 1, num);
}

vector<string> display(string str)
{

    vector<string> arr;
    for (int i = 0; i < str.length(); i++)
    {
        arr.push_back(str[i] + "z");
    }
    return arr;
}

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

bool canPlaceVertical(string word, int r, int c)
{
    if (r == 0 && word.length() != crosswordBoard.size())
    {
        if (crosswordBoard[r + word.length()][c] != '+')
            return false;
    }
    else if ((r + word.length() - 1) == crosswordBoard.size() - 1 && crosswordBoard[r - 1][c] != '+')
    {
        return false;
    }
    else
    {
        if (r + word.length() < crosswordBoard.size())
        {
            if (!(crosswordBoard[r - 1][c] == '+' && crosswordBoard[r + word.length()][c] == '+'))
            {
                return false;
            }
        }
    }
    for (int i = 0; i < word.length(); i++)
    {
        if (!(crosswordBoard[r + i][c] == '-' || crosswordBoard[r + i][c] == word[i]))
        {
            return false;
        }
    }
    return true;
}

bool canPlaceHorizontal(string word, int r, int c)
{
    if (c == 0 && word.length() != crosswordBoard.size())
    {
        if (crosswordBoard[r][c + word.length()] != '+')
            return false;
    }
    else if ((c + word.length() - 1) == crosswordBoard.size() - 1 && crosswordBoard[r][c - 1] != '+')
    {
        return false;
    }
    else
    {
        if ((c + word.length() < crosswordBoard.size()))
        {
            if (!(crosswordBoard[r][c - 1] == '+' && crosswordBoard[r][c + word.length()] == '+'))
                return false;
        }
    }
    for (int i = 0; i < word.length(); i++)
    {
        if (!(crosswordBoard[r][c + i] == '-' || crosswordBoard[r][c + i] == word[i]))
        {
            return false;
        }
    }
    return true;
}

vector<bool> placeWordVertical(string word, int r, int c)
{
    vector<bool> pos(word.length(), false);
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

vector<bool> placeWordHorizontal(string word, int r, int c)
{
    vector<bool> pos(word.length(), false);
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
void unplaceWordHorizontal(string word, int r, int c, vector<bool> position)
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
    cout << idx << "- Start" << endl;
    if (idx == wordsArr.size())
    {
        printCrsBoard();
        cout << endl;
        cout << idx << "-  In Base" << endl;
        return;
    }

    string word = wordsArr[idx];
    for (int i = 0; i < crosswordBoard.size(); i++)
    {
        for (int j = 0; j < crosswordBoard[0].size(); j++)
        {
            // if (crosswordBoard[i][j] == '-')
            // {

            cout << idx << "-  In for loop" << endl;
            if (canPlaceVertical(word, i, j))
            {
                vector<bool> markChar = placeWordVertical(word, i, j); // word ke characters mark kr liye jo place hue hai.
                crosswordPuzzle(wordsArr, idx + 1);
                unplaceWordVertical(i, j, markChar);
            }

            if (canPlaceHorizontal)
            {
                vector<bool> markChar = placeWordHorizontal(word, i, j); // place kiya aur word mark kr liye jo place hue hai.
                crosswordPuzzle(wordsArr, idx + 1);
                unplaceWordHorizontal(word, i, j, markChar);
            }
            // }
        }
    }
}

int main(int args, char **argv)
{
    // cout << bitPractice(99);
    // int x = 6;
    // int y = 4;
    // int z = pointer_to_binary_function(6);
    // cout<<z<<endl;

    // vector<string> dis = (display("abcd"));
    // cout<<dis.size();
    // int x = 8;

    vector<string> crs_Words = {"ARGRA", "NORWAY", "ENGLAND", "GWALIOR"};
    crosswordPuzzle(crs_Words, 0);

    return 0;
}
