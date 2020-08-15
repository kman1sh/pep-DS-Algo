#include <iostream>
#include <vector>
#include <list>
using namespace std;

class Edge
{
public:
    int v = 0;
    int w = 0;
    Edge(int v, int w)
    {
        this->v = v;
        this->w = w;
    }
};

vector<vector<Edge *>> dirGraph(7, vector<Edge *>());

void addEdge(int u, int v, int w)
{
    if (u < 0 || v < 0 || u >= dirGraph.size() || v >= dirGraph.size())
        return;

    dirGraph[u].push_back(new Edge(v, w));
}

void populateGraph()
{



    //Graph1
    addEdge(0,1,10);
    addEdge(0,3,10);
    addEdge(1,2,10);
    addEdge(2,3,40);
    addEdge(3,0,10);
    addEdge(3,4,2);
    addEdge(4,5,2);
    addEdge(4,6,3);
    addEdge(5,6,8);

    //Topological sort graph
    // addEdge(0, 1, 10);
    // addEdge(0, 5, 10);
    // addEdge(1, 2, 40);
    // addEdge(2, 3, 10);
    // addEdge(4, 5, 2);
    // addEdge(4, 6, 2);
    // addEdge(6, 3, 3);
}

void display()
{
    for (int i = 0; i < dirGraph.size(); i++)
    {
        cout << i << " => ";
        for (int j = 0; j < dirGraph[i].size(); j++)
        {
            cout << "(" << dirGraph[i][j]->v << "," << dirGraph[i][j]->w << ") ";
        }
        cout << endl;
    }
}

// bool topologicalSort(int src, vector<int> &arr, vector<bool> isVisited, vector<bool> cycle)
// {

//     isVisited[src] = true;
//     cycle[src] = true;
//     for (Edge *e : dirGraph[src])
//     {
//         if (!isVisited[e->v])
//         {

//             topologicalSort(e->v, arr, isVisited, cycle);
//             // arr.push_back(e->v);
//         }
//         else
//         {
//             if (cycle[e->v]) {
//                 cout<<"hello"<<endl;
//                 return true; 
//             }
//         }
//     }

//     cycle[src] = false;
//     arr.push_back(src);

//     return false;
// }

// void topologicalSort_()
// {
//     vector<int> arr;
//     vector<bool> isVisited(dirGraph.size(), false);
//     vector<bool> cycle(dirGraph.size(), false);
//     bool res = false;


//     for (int i = 0; i < dirGraph.size() && !res; i++)
//     {
//         if (!isVisited[i])
//         {
//             res = res || topologicalSort(i, arr, isVisited, cycle);
//         }
//     }

//     if (res)
//         cout << "Cycle Detected" << endl;
//     else
//     {
//         for (int i = arr.size() - 1; i >= 0; i--)
//             cout << arr[i] << " ";
//     }
// }

// vector<int> incomingEdge = {0, 0, 1, 2, 1, 1, 2, 1};
// vector<int> ans;
// list<int> que;
// void khanAlgo(int src)
// {
//     que.push_front(src);
//     while (que.size() != 0)
//     {
//         int rvtx = que.front();
//         que.pop_front();
//         ans.push_back(rvtx)
//         for(Edge *e : dirGraph[src])
//     }
// }

int main()
{
    populateGraph();
    display();
    vector<bool> isVisited(7, false);
    topologicalSort_();

    return 0;
}