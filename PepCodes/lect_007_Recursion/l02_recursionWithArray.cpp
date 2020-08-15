#include <iostream>
#include <vector>
using namespace std;

//display array elements on console
void display(vector<int> &arr, int vidx)
{
    if (vidx == arr.size())
        return;

    cout << arr[vidx] << " ";
    display(arr, vidx + 1);
}

bool find(vector<int> &arr, int vidx, int data)
{
    if (vidx == arr.size())
    {
        return false;
    }

    if (arr[vidx] == data)
    {
        return true;
    }

    return find(arr, vidx + 1, data);
}

int maximum(vector<int> &arr, int vidx)
{
    if (vidx == arr.size() - 1)
    {
        return arr[vidx];
    }

    int result = maximum(arr, vidx + 1);
    return max(arr[vidx], result);
}

int minimum(vector<int> &arr, int vidx)
{
    if (vidx == arr.size() - 1)
    {
        return arr[vidx];
    }

    int result = minimum(arr, vidx + 1);
    return min(arr[vidx], result);
}

int lastIndex(vector<int> &arr, int vidx, int data)
{
    if (vidx == arr.size())
    {
        return -1;
    }

    int result = lastIndex(arr, vidx + 1, data);
    if (arr[vidx] == data && result == -1)
    {
        return vidx;
    }
    return result;
}

//tree diagram from n to 0 (up to bottom). Hit base case when reached at bottom of stairs.
int stairCase(int n)
{
    if (n == 0)
        return 1;

    int count = 0;
    if ((n - 1) >= 0)
        count += stairCase(n - 1);

    if ((n - 2) >= 0)
        count += stairCase(n - 2);

    if ((n - 3) >= 0)
        count += stairCase(n - 3);

    // for (int i = 1; i <= 3; i++)
    // {
    //     if (n - i >= 0)
    //         count += stairCase(n - i);
    // }

    return count;
}

//V2 tree diagram from 0 to n. Hit base case when reached at the top of stairs.(retun 1)
// return 0 if invalid path (when jump exceeds n).
// https://drive.google.com/file/d/1Qbc9KRHW8xlZNKRdpx-oatzsqpSarsqR/view?usp=sharing
int stairCase_v2(int st, int lastStep) {

    if(st == lastStep) return 1;

    if(st>lastStep) return 0;
    
    int count = 0;

    count+= stairCase_v2(st+1, lastStep);
    count+= stairCase_v2(st+2, lastStep);
    count+= stairCase_v2(st+3, lastStep);

    return count;
}

void solve()
{
    vector<int> arr = {1, 0, 6, 8, 10, 4, 5, 5, 6, 8, -3, 2, 12, 8, 3};
    // display(arr, 0);
    // cout<<find(arr,0,120)<<endl;
    // cout << maximum(arr, 0) << endl;
    // cout << minimum(arr, 0) << endl;
    // cout << lastIndex(arr,0, 8) << endl;
    // cout << stairCase(4) << endl;
    cout << stairCase_v2(0, 4) << endl;
}

int main(int args, char **argv)
{
    solve();
    return 0;
}
