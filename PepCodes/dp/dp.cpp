#include<iostream>
#include<vector>

using namespace std;

void isPalindrom(string str) {


vector<vector<bool>> mat(str.length(), vector<bool>(str.length(), false));

for (int gap = 0; gap < str.length(); gap++)
{
    for (int i=0, j = gap; j < str.length(); j++, i++)
    {
        if(gap == 0) {
            mat[i][j] = true;
        } else if(gap == 1 && str[i] == str[j]) {
            mat[i][j] = true;
        } else if(str[i] == str[j]) {
            
        }
    }
    
}



}


int main() {

    return 0;
}