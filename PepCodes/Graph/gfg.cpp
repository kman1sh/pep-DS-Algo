#include<iostream>
#include<vector>
#include<list>

using namespace std;

// vector<vector<int>> arr = { {2, 1, 0, 2, 1}, //3x5
//                             {1, 0, 1, 2, 1},
//                             {1, 0, 0, 2, 1}};

// list<int> que;

// int rotOranges(int src, vector<bool> isVis) {
//     isVis[src] = true;
//     que.push_back(arr[src/3][src%4])
// }

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

vector<vector<Edge *>> graph(3, vector<Edge *>());

void addEdge(int u, int v, int w)
{
    if (u < 0 || v < 0 || u >= graph.size() || v >= graph.size())
        return;

    graph[u].push_back(new Edge(v, w));
    graph[v].push_back(new Edge(u, w));
}

void populateGraph() {
    addEdge(1, 2, 10);
    addEdge(2, 3, 20);
    addEdge(3, 1,30);

}

void display()
{
    for (int i = 0; i < graph.size(); i++)
    {
        cout << i << " => ";
        for (int j = 0; j < graph[i].size(); j++)
        {
            cout << "(" << graph[i][j]->v << "," << graph[i][j]->w << ") ";
        }
        cout << endl;
    }
}

int main() {

    return 0;
}