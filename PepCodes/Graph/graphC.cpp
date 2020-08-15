#include <iostream>
#include <vector>
#include <queue>
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

vector<vector<Edge *>> graph(7, vector<Edge *>());

void addEdge(int u, int v, int w)
{
    if (u < 0 || v < 0 || u >= graph.size() || v >= graph.size())
        return;

    graph[u].push_back(new Edge(v, w));
    graph[v].push_back(new Edge(u, w));
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

void remove_edge(int vrtx1, int vrtx2)
{
    for (int i = 0; i < graph[vrtx1].size(); i++)
    {
        if ((graph[vrtx1][i]->v) == vrtx2)
            graph[vrtx1].erase(graph[vrtx1].begin() + i);
    }

    for (int i = 0; i < graph[vrtx2].size(); i++)
    {
        if ((graph[vrtx2][i]->v) == vrtx1)
            graph[vrtx2].erase(graph[vrtx2].begin() + i);
    }
}

void removeVertex(int vrtx1)
{
    for (int i = graph[vrtx1].size() - 1; i >= 0; i--)
    {
        remove_edge(graph[vrtx1][i]->v, vrtx1);
    }
}

void hasPath(int src, int des, vector<bool> &visited, string path)
{
    visited[src] = true;

    if (src == des)
    {
        cout << path + to_string(src) << endl;
        return;
    }
    //visited[src] = true;

    for (Edge *e : graph[src]) //graph[src] dega vector of edge aur uspe for loop se milega Edge.
    {
        int nSrc = e->v;
        if (!visited[nSrc])
            hasPath(nSrc, des, visited, path + to_string(src) + "->");
    }
}

void hasPath_allPath(int src, int des, vector<bool> &visited, string path)
{
    if (src == des)
    {
        cout << path + to_string(src) << endl;
        return;
    }

    if (!visited[src])
    {
        visited[src] = true;
        for (Edge *e : graph[src]) //graph[src] dega vector of edge aur uspe for loop se milega Edge.
        {
            int nSrc = e->v;
            hasPath_allPath(nSrc, des, visited, path + to_string(src) + "->");
        }
        visited[src] = false;
    }
}

void PreOrder(int src, vector<bool> &visited, string path)
{
    visited[src] = true;
    cout << to_string(src) << "->" << path + to_string(src) << endl;

    for (Edge *e : graph[src])
    {
        int nSrc = e->v;
        if (!visited[nSrc])
            PreOrder(nSrc, visited, path + to_string(src));
    }
    visited[src] = false;
}

void PostOrder(int src, vector<bool> &visited, string path)
{
    visited[src] = true;

    for (Edge *e : graph[src])
    {
        int nSrc = e->v;
        if (!visited[nSrc])
            PostOrder(nSrc, visited, path + to_string(src));
    }
    visited[src] = false;
    cout << to_string(src) << "->" << path + to_string(src) << endl;
}

string ans = "";
int maxWt;
void heavyPath(int src, int des, vector<bool> &visited, int wt, string path)
{
    if (src == des)
    {
        if (wt > maxWt)
        {
            maxWt = wt;
            ans = path + to_string(des) + " @" + to_string(wt);
        }
        return;
    }
    visited[src] = true;
    for (Edge *e : graph[src])
    {
        int nSrc = e->v;
        int nWt = wt + (e->w);

        if (!visited[nSrc])
            heavyPath(nSrc, des, visited, nWt, path + to_string(src) + "->");
    }
    visited[src] = false;
}

int minWt = 1000000;
void lightestPath(int src, int des, vector<bool> &visited, int wt, string path)
{
    if (src == des)
    {
        if (wt < minWt)
        {
            minWt = wt;
            ans = path + to_string(des) + " @" + to_string(wt);
        }
        return;
    }
    visited[src] = true;
    for (Edge *e : graph[src])
    {
        int nSrc = e->v;
        int nWt = wt + (e->w);

        if (!visited[nSrc])
            lightestPath(nSrc, des, visited, nWt, path + to_string(src) + "->");
    }
    visited[src] = false;
}

class pair_path
{
public:
    int wt = 100000;
    string ansStr = "";
    pair_path(int wt, string str)
    {
        this->wt = wt;
        this->ansStr = str;
    }

    pair_path()
    {
    }
};

class dpair
{
public:
    int v = 0;
    int pvtx = 0;
    int wt = 0;
    int wsf = 0;
    string psf = "";
    dpair(int vtx, int pvtx, int wt, int wsf, string psf)
    {
        this->v = vtx;
        this->pvtx = pvtx;
        this->wt = wt;
        this->wsf = wsf;
        this->psf = psf;
    }

    bool operator<(const dpair &o) const
    {
        return this->wsf > o.wsf;
    }
};


vector<bool> isVisited(7, false);
vector<vector<Edge*>> dGraph(7, vector<Edge*>());

void addEdge_d(int u, int v, int w)
{
    if (u < 0 || v < 0 || u >= dGraph.size() || v >= dGraph.size())
        return;

    // dGraph[u].push_back(new Edge(v, w));
    dGraph[v].push_back(new Edge(u, w));
}

void display_d()
{
    for (int i = 0; i < dGraph.size(); i++)
    {
        cout << i << " => ";
        for (int j = 0; j < dGraph[i].size(); j++)
        {
            cout << "(" << dGraph[i][j]->v << "," << dGraph[i][j]->w << ") ";
        }
        cout << endl;
    }
}

void dijikstra(int src)
{
    priority_queue<dpair> que;
    dpair root(src, -1, 0, 0, to_string(src) + " ");
    que.push(root);
    int dest = 6;

    while (que.size() > 0)
    {
        //remove first ele in queue
        dpair rpair = que.top();
        que.pop();
        addEdge_d(rpair.pvtx, rpair.v,rpair.wt);
        if (isVisited[rpair.v])
            continue;
         
        //mark it
        isVisited[rpair.v] = true;
        //add those nbrs of rpair in the queue which are not visited yet.
        for (Edge *e : graph[rpair.v])
        {
            if (!isVisited[e->v])
            {
                dpair newPair(e->v, rpair.v, e->w, rpair.wsf + e->w, rpair.psf + to_string(e->v) + " ");
                que.push(newPair);
            }
        }

        if (rpair.v == dest)
            cout << rpair.psf << "->" + to_string(rpair.wsf) << endl;
        
    }
}

// pair_path *lightestPath_01(int src, int des, vector<bool> &visited, string path)
// {
//     if (src == des)
//     {
//         pair_path *base = new pair_path(0, "");
//         return base;
//     }

//     pair_path *myAns = new pair_path(0, "");
//     visited[src] = true;
//     for (Edge *e : graph[src])
//     {
//         int nSrc = e->v;
//         int edgeWt = e->w;
//         if (!visited[nSrc])
//             pair_path *recAns = lightestPath_01(nSrc, des, visited, path + to_string(src) + "->");

//         if ((recAns->wt) + (edgeWt) < (myAns->wt))
//         {
//         }
//     }
//     visited[src] = false;
// }

void hamitonianCycle(int src, int startSrc, int count, vector<bool> visited, string ans)
{
    if (count == graph.size() - 1)
    {
        cout << ans + to_string(src);
        for (Edge *e : graph[src])
        {
            int link = e->v;
            if (link == startSrc)
                cout << " -Cycle";
        }
        cout << endl;                          
    }
    visited[src] = true;
    for (Edge *e : graph[src]) //graph[src] dega vector of edge aur uspe for loop se milega Edge.
    {
        int nSrc = e->v;
        if (!visited[nSrc])
            hamitonianCycle(nSrc, startSrc, count + 1, visited, ans + to_string(src) + "->");
    }
    visited[src] = false;
}



void solve()
{
    // addEdge(0, 1, 10);
    // addEdge(0, 3, 10);
    // addEdge(1, 2, 10);
    // addEdge(2, 3, 40);
    // addEdge(2, 5, 5);
    // addEdge(3, 4, 2);
    // addEdge(4, 5, 2);
    // addEdge(4, 6, 8);
    // addEdge(5, 6, 3);

    addEdge(0, 1, 10);
    addEdge(0, 3, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 40);
    addEdge(3, 4, 2);
    addEdge(4, 5, 2);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);

    display();
    cout << endl;
    // remove_edge(3, 4);
    // display();

    vector<bool> visited(graph.size(), false);
    // hasPath(0, 6, visited, "");
    // hasPath_allPath(0, 6, visited, "");
    // hasPath_allPath_PrePost(0, 6, visited, "");
    // PreOrder(0, visited, "");
    // PostOrder(0, visited, "");
    // heavyPath(0, 6, visited, 0, "");
    lightestPath(0, 6, visited, 0, "");
    cout << ans << endl;

    hamitonianCycle(2, 2, 0, visited, "");

    // dijikstra(0);
    // display_d();
}

int main()
{
    solve();
    return 0;
}
