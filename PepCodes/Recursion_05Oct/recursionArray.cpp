#include <iostream>
#include <vector>
using namespace std;

void displayArray(vector<int> &arr, int vidx) {

    if(vidx+1 == arr.size()) return ;

    cout<<arr[vidx] << " ";
    displayArray(arr, vidx+1);

}

bool find(vector<int> &arr, int vidx, int data)  {
    
    if(arr[vidx] == data) {
        return true;
    }
    if (vidx==arr.size())
    {
     return false;
    }
    
    return find(arr, vidx+1, data);

}

//int maximum(vector<int> &arr, int vidx) { }
//int minimum(vector<int> &arr, int vidx) {}
//int lastIndex(vector<int> &arr, int vidx, int data) {}

//vector<int> allIndex(vector<int> &arr, int vidx, int data, ) {} //do in java





int main(int args, char ** argv) {

    vector<int> arr = {10, 6, 8, 10, 4, 5, 5, 6, 8, -3, 2, 12, 8, 3};
    // displayArray(arr,0);

    cout<<find(arr,0, -31)<<endl;

    return 0;
}
