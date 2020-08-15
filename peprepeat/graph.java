import java.util.ArrayList;

/**
 * graph
 */
public class graph {

    public static void main(String[] args) {

        populate();
        display(graph);

        // removeEdge(0, 3);
        // display(graph);

        // removeVtx(2);
        // display(graph);

        // ********************

        // System.out.println(hasPath(0, 6, new boolean[n]));
        // allPath(0, 6, new boolean[n], "");
        DataPair allsol = new DataPair();
        allSolution(0, 6, 55, new boolean[n], allsol, 0, "");

        System.out.println("heaviest Path" + allsol.hpath);
        System.out.println("lighest Path" + allsol.lpath);
        System.out.println("ceil" + allsol.ceil);
        System.out.println("Floor" + allsol.floor);
    }

    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int n = 9;
    static ArrayList<Edge>[] graph = new ArrayList[n];

    public static void populate() {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        AddEdge(graph, 0, 1, 10);
        AddEdge(graph, 1, 2, 10);
        AddEdge(graph, 0, 3, 10);
        AddEdge(graph, 3, 2, 40);
        AddEdge(graph, 3, 4, 2);
        AddEdge(graph, 4, 5, 2);
        AddEdge(graph, 4, 6, 3);
        AddEdge(graph, 5, 6, 8);

        AddEdge(graph, 2, 7, 5);
        AddEdge(graph, 2, 8, 5);
        AddEdge(graph, 7, 8, 6);

    }

    public static void AddEdge(ArrayList<Edge>[] g, int u, int v, int w) {

        g[u].add(new Edge(v, w));
        g[v].add(new Edge(u, w));
    }

    public static void display(ArrayList<Edge>[] g) {

        for (int i = 0; i < g.length; i++) {
            System.out.print(i + " =>");
            for (Edge e : g[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }

        System.out.println("================================");
    }

    public static void removeEdge(int u, int v) {

        if (u < 0 || u > n - 1 || v < 0 || v > n - 1)
            return;

        for (int i = 0; i < n; i++) {
            Edge e = graph[u].get(i);
            if (e.v == v) {
                graph[u].remove(i);
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            Edge e = graph[v].get(i);
            if (e.v == u) {
                graph[v].remove(i);
                break;
            }
        }

    }

    public static void removeVtx(int vtx) {
        if (vtx < 0 || vtx > n - 1)
            return;

        for (int i = graph[vtx].size() - 1; i >= 0; i--) {
            Edge e = graph[vtx].get(i);
            removeEdge(vtx, e.v);
        }
    }

    public static boolean hasPath(int src, int dest, boolean[] isVisited) {
        if (src == dest) {
            return true;
        }
        isVisited[src] = true;
        boolean res = false;
        for (Edge nbr : graph[src]) {
            if (!isVisited[nbr.v]) {
                res = res || hasPath(nbr.v, dest, isVisited);
            }
        }

        return res;
    }

    public static void allPath(int src, int dest, boolean[] isVisited, String path) {
        path += src + "";
        if (src == dest) {
            System.out.println(path);
            return;
        }
        isVisited[src] = true;
        for (Edge nbr : graph[src]) {
            if (!isVisited[nbr.v]) {
                allPath(nbr.v, dest, isVisited, path + "=>");
                isVisited[nbr.v] = false;
            }
        }
    }

    static class DataPair {
        int heaviestPath = Integer.MIN_VALUE;
        int lighestPath = Integer.MAX_VALUE;
        String lpath = "";
        String hpath = "";

        int ceil = 100000;
        int floor = -100000;

    }

    public static void allSolution(int src, int dest, int data, boolean[] isVisited, DataPair pair, int wsf,
            String path) {

        path += src;

        if (src == dest) {
            if (wsf < pair.lighestPath) {
                pair.lighestPath = wsf;
                pair.lpath = path + "@" + pair.lighestPath;
            }
            if (wsf > pair.heaviestPath) {
                pair.heaviestPath = wsf;
                pair.hpath = path + "@" + pair.heaviestPath;
            }

            if (wsf > data) {
                pair.ceil = Math.min(pair.ceil, wsf);
            }
            if (wsf < data) {
                pair.floor = Math.max(pair.floor, wsf);
            }

            // System.out.println(path + "@" +wsf);
            return;
        }

        isVisited[src] = true;
        for (Edge nbr : graph[src]) {
            if (!isVisited[nbr.v]) {
                allSolution(nbr.v, dest, data, isVisited, pair, wsf + nbr.w, path + "=>");
                isVisited[nbr.v] = false;
            } 
        }
    }
    
}
