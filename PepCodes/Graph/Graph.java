import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Graph {

    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return "(" + v + "," + w + ") ";
        }
    }

    public static ArrayList<Edge>[] graph = new ArrayList[6];

    public static void populateGraph() {
        // intializing ArrayLists pressent on all the 7 location of Array, before adding
        // any Edge value in ArrayList.
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0th vertex k saare edge add kare

        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 40);
        addEdge(3, 4, 2);
        addEdge(4, 5, 2);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);

        // addEdge(5, 2, 7); // only to check hemitonian cycle. Not part of real graph.

        // graph for gcc

        // addEdge(0, 1, 2);
        // addEdge(0, 3, 2);
        // addEdge(1, 2, 2);
        // addEdge(2, 3, 2);

        // addEdge(4, 5, 2);
        // addEdge(4, 6, 2);
        // addEdge(5, 6, 2);

        // addEdge(7, 8, 2);
        // addEdge(8, 9, 2);
        // addEdge(9, 10, 2);
        // addEdge(10, 11, 2);
        // addEdge(11, 7, 2);

        //dijkstra/prims Graph
        // addEdge(0, 1, 5);
        // addEdge(0, 2, 2);
        // addEdge(1, 3, 4);
        // addEdge(1, 2, 8);
        // addEdge(1, 4, 2);
        // addEdge(2, 4, 7);
        // addEdge(3, 4, 6);
        // addEdge(3, 5, 3);
        // addEdge(4, 5, 1);
        // addEdge(0, 1, 5);

    }

    public static void addEdge(int u_Vertex, int v_Vertex, int wt) { // dono vertices k bich ek hi wt hoga.
        // if(!(u_Vertex < 0 || v_Vertex < 0 || u_Vertex > graph.length || v_Vertex
        // >graph.length)) //agar sab false ho tab call lge.
        if (u_Vertex >= 0 && v_Vertex >= 0 && u_Vertex < graph.length && v_Vertex < graph.length) {
            graph[u_Vertex].add(new Edge(v_Vertex, wt));
            graph[v_Vertex].add(new Edge(u_Vertex, wt));
        }
    }

    public static void displayGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + "=>");
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.v + "," + edge.w + ") ");
            }
            System.out.println();
        }
    }

    public static void removeEdge(int vertex1, int vertex2) {
        // checks for valid input
        if (vertex1 >= 0 && vertex1 < graph.length && vertex2 >= 0 && vertex2 < graph.length) {

            for (int i = 0; i < graph[vertex1].size(); i++) {
                Edge e = graph[vertex1].get(i);
                if (e.v == vertex2)
                    graph[vertex1].remove(i);
            }

            for (int i = 0; i < graph[vertex2].size(); i++) {
                Edge e = graph[vertex2].get(i);
                if (e.v == vertex1)
                    graph[vertex2].remove(i);
            }
        } else {
            System.out.println("Wrong vertices: Not in graph");
        }
    }

    public static void removeVertex(int vertex) {
        for (int i = graph[vertex].size() - 1; i >= 0; i--) {
            Edge e = graph[vertex].get(i);
            removeEdge(vertex, e.v);
        }
    }

    public static void hasPath(int src, int des, boolean[] isVisited, String path) {
        isVisited[src] = true;
        if (src == des) {
            path += src;
            System.out.println(path);
            return;
        }
        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                hasPath(e.v, des, isVisited, path + src + "->");
            }
        }

    }

    public static void allPath(int src, int des, boolean[] isVisited, String path) {
        if (src == des) {
            path += src;
            System.out.println(path);
            return;
        }
        isVisited[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                allPath(e.v, des, isVisited, path + src + "->");
            }
        }
        isVisited[src] = false;
    }

    public static void preOrderPath(int src, int wsf, boolean[] isVisited, String path) {
        path += src + ""; // updating path
        System.out.println(src + "=> " + path + " @ " + wsf); // printing path so far with wsf.
        isVisited[src] = true;

        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                preOrderPath(e.v, wsf + e.w, isVisited, path);
            }
        }
        isVisited[src] = false;
    }

    // global variables to stores lightest Weight from source to destination
    public static String lighestPath = " ";
    public static int lpw = Integer.MAX_VALUE; // lightest path weight

    public static void lightestPath(int src, int dest, int wsf, boolean[] isVisited, String path) {

        path += src + ""; // path update
        if (src == dest) {
            if (wsf < lpw) {
                lpw = wsf;
                lighestPath = path;
            }
            return;
        }

        isVisited[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                lightestPath(e.v, dest, wsf + e.w, isVisited, path + "=>"); // wsf update (upto src + edge wt)
            }
        }
        isVisited[src] = false;
    }

    public static String heaviestPath = "";
    public static int hpw = Integer.MIN_VALUE; // hpw: heaviest path weight

    public static void heaviestPath(int src, int dest, int wsf, boolean[] isVisited, String path) {

        path += src + ""; // path update
        if (src == dest) {
            if (wsf > hpw) {
                hpw = wsf;
                heaviestPath = path;
            }
            return;
        }

        isVisited[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                heaviestPath(e.v, dest, wsf + e.w, isVisited, path + "=>"); // wsf update (upto src + edge wt)
            }
        }
        isVisited[src] = false;
    }

    static class pairPath {
        int wt = 1000;
        String path;

        public pairPath(int wt, String path) {
            this.wt = wt;
            this.path = path;
        }

        pairPath() {

        }
    }

    public static pairPath lighestPath_objMethod(int src, int des, boolean[] isVisited) {

        if (src == des) {
            pairPath base = new pairPath(0, src + "");
            return base;
        }

        isVisited[src] = true;

        pairPath myAns = new pairPath();

        for (Edge nbr : graph[src]) {
            if (!isVisited[nbr.v]) {
                pairPath recAns = lighestPath_objMethod(nbr.v, des, isVisited);
                if (recAns.wt + nbr.w < myAns.wt) {
                    myAns.wt = recAns.wt + nbr.w;
                    myAns.path = src + recAns.path;
                }
            }
        }
        isVisited[src] = false;
        return myAns;
    }

    public static void hemitonianPath_nd_Cycle(int src, int startSrc, int cnt, boolean[] isVisited, String path) {
        path += src + "";
        if (cnt == graph.length - 1) {
            System.out.print(path);
            for (Edge e : graph[src]) {
                if (e.v == startSrc) {
                    System.out.print(": Cycle");
                }
            }
            System.out.println();
            return;
        }

        isVisited[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                hemitonianPath_nd_Cycle(e.v, startSrc, cnt + 1, isVisited, path + "->");
            }
        }
        isVisited[src] = false;
    }

    public static void main(String[] args) {
        populateGraph();
        // System.out.println(Arrays.toString(graph));
        // displayGraph();
        // System.out.println();
        // removeVertex(3);
        // displayGraph();
        boolean[] isVisited = new boolean[graph.length];
        // hasPath(0, 6, isVisited, "");
        // allPath(0, 6, isVisited, "");
        // preOrderPath(0, 0, isVisited, "");
        // lightestPath(0, 6, 0, isVisited, "");
        // System.out.println(lighestPath +" @ " + lpw);
        // heaviestPath(0, 6, 0, isVisited, "");
        // System.out.println(heaviestPath +" @ " + hpw);
        // hemitonianPath_nd_Cycle(2,2,0,isVisited,"");
        // pairPath ans = lighestPath_objMethod(0, 6, isVisited);
        // System.out.println(ans.path + " @ " + ans.wt);

        BFS(0, 6);
        // BFS_doubleLoop(0, 6);
        // System.out.println("Total Disconnected Component: " +GCC(isVisited));

        // GCC direct with bfs function.
        // int compCount = 0;
        // for (int i = 0; i < graph.length; i++) {
        //     if (!isVisited[i]) {
        //         BFS_trimmed_for_GCC(i, isVisited);
        //         compCount++;
        //     }
        // }
        // System.out.println("Total Disconnected Components: " + compCount);

        /**
         * Dijkstra Algo
         */
        //initialize Dgraph before adding anything
        // for (int i = 0; i < dgraph.length; i++) {
        //     dgraph[i] = new ArrayList<>();
        // }
        // dijkstra(0, graph);

        //primsAlgo
        // MSTprims(graph);d
         
        
    }

    /**
     * BFS also gives all the cycle in a graph. first use of BFS algo(with Queue
     * property). 1) find shortest path in graph. "Mind it SHORTEST PATH and not
     * LIGHTEST PATH" 2) Shortest path weight. 3)detecting cycle, if any.
     */
    static class BFSpair {
        int vtx;
        String psf;
        int wsf;

        public BFSpair(int v, String psf, int wsf) {
            this.vtx = v;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    public static void BFS(int src, int des) { // also printing level using null method.

        LinkedList<BFSpair> que = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];

        // jab des first tym milega wahi shortest path hoga.this flag will stop next
        // path from getting print.
        boolean isFound = false;

        que.addLast(new BFSpair(src, src + "", 0));
        que.add(null); // for level calulation.
        int level = 0; // for level count. Start with 1 to get total vtx.

        while (que.size() != 1) {
            BFSpair rpair = que.removeFirst();

            if (rpair.vtx == des && !isFound) {
                isFound = true;
                System.out.println("Shortest path to des: " + rpair.psf + " @ " + rpair.wsf + " lvl: " + level);
            }

            if (isVisited[rpair.vtx]) {
                System.out.println("Cycle @" + rpair.psf);
            } else {
                isVisited[rpair.vtx] = true;
                for (Edge e : graph[rpair.vtx]) {
                    if (!isVisited[e.v])
                        que.addLast(new BFSpair(e.v, rpair.psf + e.v, rpair.wsf + e.w));
                }
            }

            if (que.getFirst() == null) {
                que.removeFirst();
                que.addLast(null);
                level++;
            }
        }
    }

    public static void BFS_doubleLoop(int src, int des) { // double loop approach to find level

        LinkedList<BFSpair> que = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];
        boolean isFound = false;

        que.addLast(new BFSpair(src, src + "", 0));
        int level = 0; // for level count. Start with 1 to get total vtx.

        while (que.size() != 0) {
            int currentQsize = que.size();

            while (currentQsize != 0) {
                BFSpair rpair = que.removeFirst();

                if (rpair.vtx == des && !isFound) {
                    isFound = true;
                    System.out.println(rpair.psf + " @ " + rpair.wsf + " lvl: " + level);
                }
                if (isVisited[rpair.vtx]) {
                    System.out.println("Cycle @" + rpair.psf);
                } else {
                    isVisited[rpair.vtx] = true;

                    for (Edge e : graph[rpair.vtx]) {
                        if (!isVisited[e.v])
                            que.addLast(new BFSpair(e.v, rpair.psf + e.v, rpair.wsf + e.w));
                    }
                }

                currentQsize--;
            }
            level++;
        }
    }

    // We are using BFS here.
    public static int GCC(boolean[] isVisited) {

        int vtxCount = graph.length;
        int gcc = 0;
        LinkedList<Integer> que = new LinkedList<>();

        for (int i = 0; i < vtxCount; i++) {

            int src = i;
            if (!isVisited[src]) {
                que.addLast(src);
                gcc++;
                while (que.size() != 0) {
                    int rVtx = que.removeFirst();
                    if (isVisited[rVtx])
                        System.out.println("Cycle @ " + rVtx);
                    else {
                        isVisited[rVtx] = true;
                        for (Edge e : graph[rVtx]) {
                            if (!isVisited[e.v])
                                que.addLast(e.v);
                        }
                    }
                }
            }
        }
        return gcc;
    }

    public static void BFS_trimmed_for_GCC(int src, boolean[] isVisited) { // also printing level using null method.

        LinkedList<BFSpair> que = new LinkedList<>();

        que.addLast(new BFSpair(src, src + "", 0));

        while (que.size() != 0) {
            BFSpair rpair = que.removeFirst();

            if (isVisited[rpair.vtx]) {
                System.out.println("Cycle @" + rpair.psf);
            } else {
                isVisited[rpair.vtx] = true;
                for (Edge e : graph[rpair.vtx]) {
                    if (!isVisited[e.v])
                        que.addLast(new BFSpair(e.v, rpair.psf + e.v, rpair.wsf + e.w));
                }
            }
        }
    }

    static class Dpair implements Comparable<Dpair> {
        int vtx;
        int pvtx;
        int w;
        int wsf;
        String psf;

        public Dpair(int vtx, int pvtx, int w, int wsf) {
            this.vtx = vtx;
            this.pvtx = pvtx;
            this.w = w;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Dpair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void addEdge_Generic(int u, int v, int w, ArrayList<Edge>[] graph) {
        if (u >= 0 && v >= 0 && u < graph.length && v < graph.length) {
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
    }

    public static void displayGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + "=>");
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.v + "," + edge.w + ") ");
            }
            System.out.println();
        }
    }

    static ArrayList<Edge>[] dgraph = new ArrayList[graph.length];

    public static void dijkstra(int src, ArrayList<Edge>[] graph) {

        PriorityQueue<Dpair> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[graph.length];
        Dpair root = new Dpair(src, -1, 0, 0);
        pq.add(root);

        while (!pq.isEmpty()) {
            Dpair rDpair = pq.remove();
            int u = rDpair.vtx;
            if (!isVisited[u]) {
                isVisited[u] = true;
                addEdge_Generic(u, rDpair.pvtx, rDpair.w, dgraph);

                for (Edge e : graph[u]) {
                    if (!isVisited[e.v]) {
                        Dpair pair = new Dpair(e.v, u, e.w, rDpair.wsf + e.w);
                        pq.add(pair);
                    }
                }
            }
        }
        displayGraph(dgraph);
    }

    static class PrimsPair implements Comparable<PrimsPair> {
        int vtx;
        int pvtx;
        int w;
        // int wsf;
        public PrimsPair(int vtx, int pvtx, int w) {
            this.vtx = vtx;
            this.pvtx = pvtx;
            this.w = w;
        }

        @Override
        public int compareTo(PrimsPair o) {
            return this.w - o.w;
        } 
    }

    public static void MSTprims(ArrayList<Edge>[] graph) {
        boolean[] isVisited = new boolean[graph.length];
        PriorityQueue<PrimsPair> pque = new PriorityQueue<>();
        PrimsPair root = new PrimsPair(4, -1, 0);
        pque.add(root);       

        //intializing graph where ans will be stored
        ArrayList<Edge>[] primsGraph = new ArrayList[graph.length];
        for (int i = 0; i < primsGraph.length; i++) {
            primsGraph[i] = new ArrayList<>();
        }

        while(!pque.isEmpty()) {
            PrimsPair rPair = pque.remove();
            int u = rPair.vtx;

            if(!isVisited[u]) {
                isVisited[u] = true;
                addEdge_Generic(u, rPair.pvtx, rPair.w, primsGraph);

                for (Edge e : graph[u]) {
                    if(!isVisited[e.v]) {
                        PrimsPair npair = new PrimsPair(e.v, u, e.w);
                        pque.add(npair);
                    }
                }
            }
        }
        displayGraph(primsGraph);
    }

} 