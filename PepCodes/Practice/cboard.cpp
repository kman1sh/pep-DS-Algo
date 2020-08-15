#include <iostream>
#include <vector>

using namespace std;

vector<vector<char>> crossWordBoard = {
    {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
    {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
    {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
    {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
    {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
    {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
    {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
    {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
    {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
    {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'},
};
// vector<vector<char>> crossWordBoard = {
//     {'+', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
//     {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
//     {'-', '-', '-', '-', '-', '-', '-', '+', '+', '-'},
//     {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
//     {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
//     {'-', '+', '+', '+', '+', '-', '-', '-', '-', '-'},
//     {'-', '-', '-', '-', '-', '-', '+', '+', '+', '-'},
//     {'-', '+', '+', '+', '+', '+', '+', '+', '+', '-'},
//     {'+', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
//     {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};

bool canPlacedVertical(string word, int r, int c)
{
    //checking Tight bound
    if (r == 0 && word.length() != crossWordBoard.size())
    {
        if (!(r + word.length() < crossWordBoard.size() && crossWordBoard[r + word.length()][c] == '+'))
            return false;
    }
    else if (r + word.length() - 1 == crossWordBoard.size() - 1)
    {
        if (!(crossWordBoard[r - 1][c] == '+'))
            return false;
    }
    else
    {
        if (!(r + word.length() < crossWordBoard.size() && crossWordBoard[r + word.length()][c] == '+' && crossWordBoard[r - 1][c] == '+'))
            return false;
    }

    for (int i = 0; i < word.length(); i++)
    {
        if (!(crossWordBoard[r + i][c] == '-' || crossWordBoard[r + i][c] == word[i]))
        {
            return false;
        }
    }
    return true;
}

vector<bool> placeWordVertical(string word, int r, int c)
{
    vector<bool> pos(word.length(), 0);
    for (int i = 0; i < word.length(); i++)
    {
        if (crossWordBoard[r + i][c] == '-')
        {
            crossWordBoard[r + i][c] = word[i];
            pos[i] = true;
        }
    }
    return pos;
}

void unplaceWordVertical(vector<bool> &pos, int r, int c)
{
    for (int i = 0; i < pos.size(); i++)
    {
        if (pos[i])
        {
            crossWordBoard[r + i][c] = '-';
        }
    }
}
bool canPlacedHorizontal(string word, int r, int c)
{

    if (c == 0 && word.length() != crossWordBoard.size())
    {
        if (!(c + word.length() < crossWordBoard.size() && crossWordBoard[r][c + word.length()] == '+'))
            return false;
    }
    else if (c + word.length() - 1 == crossWordBoard.size() - 1)
    {
        if (!(crossWordBoard[r][c - 1] == '+'))
            return false;
    }
    else
    {
        if (!(c + word.length() < crossWordBoard.size() && crossWordBoard[r][c + word.length()] == '+' && crossWordBoard[r][c - 1] == '+'))
            return false;
    }

    for (int i = 0; i < word.length(); i++)
    {
        if (!(crossWordBoard[r][c + i] == '-' || crossWordBoard[r][c + i] == word[i]))
        {
            return false;
        }
    }
    return true;
}

vector<bool> placeWordHorizontal(string word, int r, int c)
{
    vector<bool> pos(word.length(), 0);
    for (int i = 0; i < word.length(); i++)
    {
        if (crossWordBoard[r][c + i] == '-')
        {
            crossWordBoard[r][c + i] = word[i];
            pos[i] = true;
        }
    }
    return pos;
}

void unplaceWordHorizontal(vector<bool> &pos, int r, int c)
{
    for (int i = 0; i < pos.size(); i++)
    {
        if (pos[i])
        {
            crossWordBoard[r][c + i] = '-';
        }
    }
}

int crossWordProblem(vector<string> &words, int idx)
{
    if (idx == words.size())
    {
        for (int i = 0; i < crossWordBoard.size(); i++)
        {
            for (int j = 0; j < crossWordBoard.size(); j++)
            {
                cout << crossWordBoard[i][j] << " ";
            }
            cout << endl;
        }
        return 1;
    }
    int count = 0;
    for (int i = 0; i < crossWordBoard.size(); i++)
    {
        for (int j = 0; j < crossWordBoard.size(); j++)
        {
            if (canPlacedHorizontal(words[idx], i, j))
            {
                vector<bool> pos = placeWordHorizontal(words[idx], i, j);
                count += crossWordProblem(words, idx + 1);
                unplaceWordHorizontal(pos, i, j);
            }
            if (canPlacedVertical(words[idx], i, j))
            {
                vector<bool> pos = placeWordVertical(words[idx], i, j);
                count += crossWordProblem(words, idx + 1);
                unplaceWordVertical(pos, i, j);
            }
        }
    }
    return count;
}

// vector<string> words = {"maths", "civics", "chemistry", "physics", "history", "geography"};
vector<string> words = {"agra","gwalior","norway","england"};

int main()
{
    crossWordProblem(words, 0);
    return 0;
}