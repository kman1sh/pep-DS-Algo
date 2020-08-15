#include <iostream>
using namespace std;

void printIncr(int st, int end)
{
    if (st == end + 1)
        return;

    cout << st << " ";
    printIncr(st + 1, end);
}

void printDecr(int st, int end)
{
    if (st == end + 1)
        return;

    printDecr(st + 1, end);
    cout << st << " ";
}

int printDecre_returnType(int st, int end)
{

    if (st == end)
    {
        cout << st << " ";
        return st - 1;
    }

    int res = printDecre_returnType(st + 1, end);
    cout << res << " ";

    return res - 1;
}

int factorial(int n) {
    if(n<=1) return 1;

    int result = factorial(n-1);
    return n * result;
}

int main(int args, char **agrv)
{
    // printIncr(1, 10);
    // printDecr(1, 10);
    // printDecre_returnType(1, 10);
    cout<<factorial(5)<<" ";
    return 0;
}