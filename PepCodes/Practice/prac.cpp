#include <iostream>
#include <vector>

using namespace std;

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

    if (r == 0 && word.length() != crosswordBoard.size()) // row 0 hai aur word crossboard k size se chhota hai. means word k end point pe '+' milna chahiye
    {
        if (crosswordBoard[r + word.length()][c] != '+')
        {
            return false;
        }
    }
    else if (r != 0 && word.length() != crosswordBoard.size() && (r + word.length()) == crosswordBoard.size() && crosswordBoard[r - 1][c] != '+')
    {
        return false;
    }
    else
    {

        if (r != 0 && r + word.length() < crosswordBoard.size())
            if (crosswordBoard[r - 1][c] != '+' || crosswordBoard[r + word.length()][c] != '+')
            {
                return false;
            }
    }

    for (int i = 0; i < word.length(); i++)
    {

        if (!(crosswordBoard[r + i][c] == '-' || crosswordBoard[r + i][c] == word[i]))
            return false;
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

bool canPlaceHorizontal(string word, int r, int c)
{
    if (c == 0 && word.length() != crosswordBoard[0].size()) // row 0 hai aur word crossboard k size se chhota hai. means word k end point pe '+' milna chahiye
    {
        if (crosswordBoard[r][c + word.size()] != '+')
            return false;
    }
    else if (c != 0 && word.length() != crosswordBoard[0].size() && ((c + word.size()) == crosswordBoard[0].size()) && crosswordBoard[r][c - 1] != '+')
    {
        return false;
    }
    else
    {
        if (c != 0 && word.length() != crosswordBoard[0].size() && (crosswordBoard[r][c - 1] != '+' && crosswordBoard[r][c + word.length()] != '+'))
            return false;
    }

    for (int i = 0; i < word.length(); i++)
    {
        if (!(crosswordBoard[r][c + i] == '-' || crosswordBoard[r][c + i] == word[i]))
            return false;
    }
    return true;
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
void unplaceWordHorizontal(int r, int c, vector<bool> position)
{
    for (int i = 0; i < position.size(); i++)
    {
        if (position[i])
            crosswordBoard[r][c + i] = '-';
    }
}

// void crosswordPuzzle(vector<string> &wordsArr, int idx)
// {
//     // if (idx == wordsArr.size())
//     // {
//     //     for (vector<char> v : crosswordBoard)
//     //     {
//     //         for (char ch : v)
//     //         {
//     //             cout << ch << " ";
//     //         }
//     //         cout << endl;
//     //     }
//     //     cout << endl;
//     //     return;
//     // }

//     string word = wordsArr[idx];
//     for (int i = 0; i < crosswordBoard.size(); i++)
//     {
//         for (int j = 0; j < crosswordBoard[0].size(); j++)
//         {
//             if (crosswordBoard[i][j] == '-')
//             {
//                 if (canPlaceVertical(word, i, j))
//                 {
//                     vector<bool> markChar = placeWordVertical(word, i, j);
//                     crosswordPuzzle(wordsArr, idx + 1);
//                     unplaceWordVertical(i, j, markChar);
//                 }

//                 if (canPlaceHorizontal)
//                 {
//                     vector<bool> markChar = placeWordHorizontal(word, i, j);
//                     crosswordPuzzle(wordsArr, idx + 1);
//                     unplaceWordHorizontal(word, i, j, markChar);
//                 }
//             }
//         }
//     }
// }

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

void crosswordPuzzle_01(vector<string> &wordsArr, int idx)
{
    if (idx == wordsArr.size())
    {
        printCrsBoard();
        cout << endl;
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
                    cout << word + " V(x:y) =" << to_string(i) + " " << j << endl;
                    vector<bool> markChar = placeWordVertical(word, i, j);
                    crosswordPuzzle_01(wordsArr, idx + 1);
                    unplaceWordVertical(i, j, markChar);
                }

                cout << word + " O(x:y) =" << to_string(i) + " " << j << endl;
                if (canPlaceHorizontal(word, i, j))
                {
                    cout << word + " H(x:y) =" << to_string(i) + " " << j << endl;
                    vector<bool> markChar = placeWordHorizontal(word, i, j);
                    crosswordPuzzle_01(wordsArr, idx + 1);
                    unplaceWordHorizontal(i, j, markChar);
                }
            }
        }
    }
}



int main()
{
    vector<string> crs_Words = {"AGRA", "NORWAY", "ENGLAND", "GWALIOR"};
    // crosswordPuzzle_01("AGRA");
    crosswordPuzzle_01(crs_Words, 0);

    return 0;
}