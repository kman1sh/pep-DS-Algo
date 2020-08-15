import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 25-02-2-2020
 */

public class graph {

    static class Edge {
        int v = 0;
        int wt = 0;

        public Edge(int v, int w) {
            this.v = v;
            this.wt = w;
        }
    }

    static int graphSize = 5;
    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] graph = new ArrayList[graphSize];

    // Kruskal PQ: populating PQ during construction of orginal kruskal graph by
    // calling addEdge.Hence make it global.
    public static PriorityQueue<Kpair> k_pq = new PriorityQueue<>();

    public static void main(String[] args) {

        // ****** baisc functionality of Graph *******
        populateGraph();
        display(graph);

        // removeEdge(0, 3);
        // display();

        // removeVtx(2);
        // display();

        // **************
        // hasPath(0, 6, new boolean[7], "");
        // allPath(0, 6, new boolean[7], "");
        // preOrderPath(0, new boolean[7], "0", 0);

        // **************************

        // lightestPath(0, 6, new boolean[7], 0, "");
        // System.out.println("light path: " + resPath);

        // heaviestPath(0, 6, new boolean[7], 0, "");
        // System.out.println("heaviest path: " + resPath);

        // hemitonianPath_nd_Cycle(2, 2, 0, new boolean[7], "");

        // PriorityQueue<Pair> pq = new PriorityQueue<>();
        // kthLargestPath(0, 5, new boolean[7], "", 0, pq);

        // maxHeap();

        // ************** BFS ******************
        // BFS_shortestPath(0, 6);
        // BFS_shortestPath01(0, 6);

        // gcc(graph);

        // ************JourneyToMoon****************
        // int[][] astronautPairs = { { 0, 1 }, { 2, 3 }, { 0, 4 } }; //n: 5
        // int[][] astronautPairs = {{ 0, 2 }}; //n: 4
        // int[][] astronautPairs = { { 1, 2 }, { 2, 3 } }; // n: 4
        // int[][] astronautPairs = { { 1, 2 }, { 3, 4 } }; // n: 100000
        // int[][] astronautPairs = { { 0, 11 }, { 2, 4 }, { 2, 9 }, { 3, 8 }, { 4, 5 },
        // { 4, 1 }, { 5, 7 }, { 5, 12 } };

        // Scanner scanner = new Scanner(System.in);

        // String[] np = scanner.nextLine().split(" ");

        // int n = Integer.parseInt(np[0]);
        // int p = Integer.parseInt(np[1]);

        // int[][] astronaut = new int[p][2];

        // for (int i = 0; i < p; i++) {
        // String[] astronautRowItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // for (int j = 0; j < 2; j++) {
        // int astronautItem = Integer.parseInt(astronautRowItems[j]);
        // astronaut[i][j] = astronautItem;
        // }
        // }

        // journeyToMoon(100000, astronautPairs);
        // System.out.println("****************");
        // journeyToMoon_DSU(100000, astronautPairs);

        // *************************************

        // System.out.println(bipartite(0));

        // ********************
        // dijkstra(graph, 0);
        // System.out.println("++++++++++++++++++++");
        // primsMST(graph);

        // ******************* Kruskal ************
        // kruskal(graph);

        // ********** Articulation Point ****

        myGreatestAncestor(graph, 0, 0, 0);

        // System.out.println("ances " + Arrays.toString(ancestorsAr));
        // System.out.println("descoveryTime " + Arrays.toString(desc));

    }

    public static void addEdge(ArrayList<Edge>[] g, int u, int v, int wt) {

        if (u < 0 || u > g.length - 1 || v < 0 || v > g.length - 1)
            return;
        g[u].add(new Edge(v, wt));
        g[v].add(new Edge(u, wt));
    }

    public static void kaddEdge(ArrayList<Edge>[] g, int u, int v, int wt) {

        if (u < 0 || u > g.length - 1 || v < 0 || v > g.length - 1)
            return;

        k_pq.add(new Kpair(u, v, wt));
        g[u].add(new Edge(v, wt));
        g[v].add(new Edge(u, wt));
    }

    public static void initializeGraph(ArrayList<Edge>[] g) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
    }

    public static void populateGraph() {

        // initializing AL inside Array for the first time;
        initializeGraph(graph);

        // basic graph : Graph1 size : 7
        // addEdge(graph, 0, 1, 10);
        // addEdge(graph, 1, 2, 10);
        // addEdge(graph, 2, 3, 40);
        // addEdge(graph, 3, 0, 10);
        // addEdge(graph, 3, 4, 2); // comment for GCC count
        // addEdge(graph, 4, 5, 2);
        // addEdge(graph, 5, 6, 3);
        // addEdge(graph, 6, 4, 8);

        // for gcc
        // addEdge(graph, 7, 8, 2);
        // addEdge(graph, 8, 9, 3);
        // addEdge(graph, 9, 10, 4);
        // addEdge(graph, 10, 11, 1);
        // addEdge(graph, 11, 7, 3);

        // hemitonian cycle detection when src is 2;
        // addEdge(graph,2, 6, 5);

        // // prims-Dijkstra Graph difference run both algo together
        // addEdge(graph, 0, 1, 3);
        // addEdge(graph, 1, 2, 4);
        // addEdge(graph, 2, 3, 2);
        // addEdge(graph, 3, 4, 5);
        // addEdge(graph, 4, 5, 1);
        // addEdge(graph, 5, 0, 10);

        // kruskalGraph
        // https://drive.google.com/open?id=1s6_9rGWyASxqpWmEdL6swAcJkEUsF0zR
        // kaddEdge(graph, 0, 1, 4);
        // kaddEdge(graph, 1, 2, 8);
        // kaddEdge(graph, 2, 3, 7);
        // kaddEdge(graph, 2, 5, 4);
        // kaddEdge(graph, 2, 8, 2);
        // kaddEdge(graph, 3, 4, 9);
        // kaddEdge(graph, 4, 5, 10);
        // kaddEdge(graph, 5, 6, 2);
        // kaddEdge(graph, 6, 7, 1);
        // kaddEdge(graph, 7, 8, 7);
        // kaddEdge(graph, 7, 0, 8);
        // kaddEdge(graph, 7, 1, 11);
        // kaddEdge(graph, 8, 6, 6);

        // AP graph size = 6 O/P: 3
        // addEdge(graph, 0, 1, 10);
        // addEdge(graph, 1, 3, 10);
        // addEdge(graph, 1, 4, 10);
        // addEdge(graph, 1, 2, 10);
        // addEdge(graph, 1, 5, 10);
        // addEdge(graph, 4, 5, 10);
        // addEdge(graph, 5, 0, 10);

        // AP graph01 size = 5 o/p: 0, 3
        addEdge(graph, 1, 0, 10);
        addEdge(graph, 0, 2, 10);
        addEdge(graph, 2, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 3, 4, 10);

        // AP Graph02 size = 4 o/p: 1,2
        // addEdge(graph, 0, 1, 10);
        // addEdge(graph, 1, 2, 10);
        // addEdge(graph, 2, 3, 10);

        // AP Graph02 size 7 o/p: 1
        // addEdge(graph, 0, 1, 10);
        // addEdge(graph, 1, 2, 10);
        // addEdge(graph, 2, 0, 10);
        // addEdge(graph, 1, 3, 10);
        // addEdge(graph, 1, 4, 10);
        // addEdge(graph, 1, 6, 10);
        // addEdge(graph, 3, 5, 10);
        // addEdge(graph, 4, 5, 10);
    }

    public static void display(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + "=> ");
            for (Edge e : graph[i]) {
                String nbrEdge = "(" + e.v + ", " + e.wt + ") ";
                System.out.print(nbrEdge);
            }
            System.out.println();
        }

        System.out.println("=============================");
    }

    public static void removeEdge(int vtx1, int vtx2) {
        if (vtx1 < 0 || vtx1 > graph.length - 1 || vtx2 < 0 || vtx2 > graph.length - 1)
            return;

        int idx = 0;
        for (Edge e : graph[vtx1]) {
            if (e.v == vtx2) {
                graph[vtx1].remove(idx);
                break;
            }
            idx++;
        }

        idx = 0;
        for (Edge e : graph[vtx2]) {
            if (e.v == vtx1) {
                graph[vtx2].remove(idx);
                break;
            }
            idx++;
        }

    }

    public static void removeVtx(int vtx) {
        if (vtx < 0 || vtx > graph.length - 1)
            return;

        for (int i = graph[vtx].size() - 1; i >= 0; i--) {
            Edge e = graph[vtx].get(i);
            removeEdge(vtx, e.v);
        }

    }
    // src Vtx to dest Vtx hasPath?
    // print the path in format e.g: 0->1->2
    // path call be more than one print any one.

    public static void hasPath(int src, int dest, boolean[] isVisited, String path) {
        isVisited[src] = true;
        if (src == dest) {
            path += dest + "";
            System.out.println(path);
            return;
        }

        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                hasPath(e.v, dest, isVisited, path + src + " -> ");
                // isVisited[e.v] = false; //uncomment to get all path
            }
        }
    }

    public static void allPath(int src, int dest, boolean[] isVisited, String path) {
        isVisited[src] = true;
        if (src == dest) {
            path += dest + "";
            System.out.println(path);
            return;
        }

        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                allPath(e.v, dest, isVisited, path + src + " -> ");
                isVisited[e.v] = false; // uncomment to get all path
            }
        }

    }

    // src to all vtx in graph print preOrder: (DFS)
    // 0=>0 1=>01 2=>012 3=>0123 4=>01234 5=>012345
    public static void preOrderPath(int src, boolean[] isVisited, String path, int wsf) {
        isVisited[src] = true;

        System.out.println(src + "=> " + path + " @ " + wsf);
        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                preOrderPath(e.v, isVisited, path + e.v + "", wsf + e.wt);
            }
        }

        isVisited[src] = false; // uncomment to get all path

    }

    static int lightestPathWt = Integer.MAX_VALUE;
    static String resPath = "";

    public static void lightestPath(int src, int dest, boolean[] isVisited, int wfs, String path) {
        isVisited[src] = true;

        if (src == dest) {
            // isVisited[src] = false;
            if (wfs < lightestPathWt) {
                lightestPathWt = wfs;
                resPath = path + dest + " @ " + lightestPathWt;
            }
            return;
        }

        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                lightestPath(e.v, dest, isVisited, wfs + e.wt, path + src + "=>");
                isVisited[e.v] = false;
            }
        }

        // isVisited[src] = false;
    }

    static int heaviestPathWt = Integer.MIN_VALUE;

    public static void heaviestPath(int src, int dest, boolean[] isVisited, int wfs, String path) {
        isVisited[src] = true;

        if (src == dest) {
            // isVisited[src] = false;
            if (wfs > heaviestPathWt) {
                heaviestPathWt = wfs;
                resPath = path + dest + " @ " + heaviestPathWt;
            }
            return;
        }

        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                heaviestPath(e.v, dest, isVisited, wfs + e.wt, path + src + "=>");
                isVisited[e.v] = false;
            }
        }
    }

    // heaviest path and lighest path can also be done with a pairclass having wt
    // and path pair instead of creating two global static variable

    public static void hemitonianPath_nd_Cycle(int src, int oSrc, int count, boolean[] isVisited, String path) {

        path += src;
        if (count == graph.length - 1) {
            System.out.print("HemitonianPath: " + path);
            count--;

            for (Edge nbr : graph[src]) {
                if (nbr.v == oSrc)
                    System.out.print(" is cycle");
            }
            System.out.println();
            return;
        }

        isVisited[src] = true;

        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                hemitonianPath_nd_Cycle(e.v, oSrc, count + 1, isVisited, path + "=>");
                isVisited[e.v] = false;
            }
        }

        count--;
    }

    static class Pair implements Comparable<Pair> {
        int wt = 0;
        String path = "";

        Pair(int wsf, String psf) {
            this.wt = wsf;
            this.path = psf;

        }

        @Override
        public int compareTo(Pair o) {
            if (this.wt > o.wt)
                return 1;
            else
                return -1;

            // return this.wt - o.wt;
        }

    }

    // src to any vtx in the graph have a cost.
    // then find kth largest path costing path from src.
    public static void kthLargestPath(int src, int k, boolean[] isVisited, String path, int wsf,
            PriorityQueue<Pair> pq) {
        path += src;

        if (pq.size() < k) {
            Pair pair = new Pair(wsf, path);
            pq.add(pair);
        } else {
            if (pq.peek().wt < wsf) {
                pq.poll();
                pq.add(new Pair(wsf, path));

            }
        }

        // System.out.println(src + "=> " + path);

        isVisited[src] = true;
        for (Edge e : graph[src]) {
            if (!isVisited[e.v]) {
                kthLargestPath(e.v, k, isVisited, path, wsf + e.wt, pq);
                isVisited[e.v] = false;
            }
        }
    }

    // TESTING, EXTRA STUFF
    public static void maxHeap() {
        Integer[] arr = { 46, 13, 11, 38, 25, 12, 24, 42, 10, 32, 53, 48 };
        // PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {

            /**
             * khud ko referance maan k, apne se uper position k liye -ve return karwao apne
             * se nichhe k liye +ve return krwao. valid for both inc. and dec order. e.g for
             * Dec order, i want larger number at top. so for top i want return -ve when o1
             * > o2;
             */

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                }
                return 1;
            }
        });

        maxPQ.addAll(Arrays.asList(arr));

        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.poll());
        }

    }

    /**
     * BFS: iterative , DFS: recursive <br>
     * <br>
     * BFS suitable for -min/shortest path from source to dest. BFS in terms of tree
     * is "@levelOrderTraversal". if probaibility of getting the element is more in
     * somwhere in mid of tree then BFS is most preferable. becoz of its
     * lvlOrderTrav nature.
     * 
     * <br>
     * "DFS bhi chal jayega but faltu ka iteration jyada hoga as DFS is basically
     * preOrderTraversing.
     * 
     * 
     * BFS uses QUEUE DS behind the scene and beocoz of this, space complexity in
     * BFS grow exponentially.
     * 
     * REASON: lvl by lvl searching hogi -> current lvl k ele jo push honge they
     * will be twice the prev lvl ele number (Ideal BTree) -> same next time twice
     * hongye ==> 2^h is growth rate of que where, h is curr height. So queue grow
     * twice than the prev size after each lvl. Hence, Exponential growth of space.
     * 
     * DFS is best suited when probaibility of getting the element is more at leaf
     * side. DFS uses inBuilt stack and stores max to max "h" numbers of element, h:
     * max height of tree.
     * 
     * becoz leaf tk jane pe bhi agr searching element nahi mila toh backtrack
     * karega, to visit next branch of tree, hence stack bhi girega. so stack mai
     * element 'h' number se jyaada nai hoga kisi bhi moment pe. Hence, DFS is space
     * efficient as compared to BFS for large data.
     * 
     * BFS uses QUEUE behind the scene: Queue can be made using any of the following
     * DS: LinkedList(SLL,DLL), ArrayList, Vector, we're using LL here. addFirst,
     * removeFirst, getFirst,size, addLast() and removeLast : when tail is given.
     * 
     * Imp: in term of LL <br>
     * AddFirst and removeFirst : Stack.<br>
     * AddLast and removeFirst : Queue.
     * 
     */

    static class BFSpair {
        int vtx;
        int wsf;
        String psf;

        public BFSpair(int vtx, int wsf, String path) {
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = path;
        }

    }

    // Everything about shortest path + extra
    // print shortest path with path weight and level.
    // detect cycle in graph and print the cycle w.r.t src.
    /**
     * Methods to find lvl ? ******** <br>
     * 1. like below. have a size variable. (self made) <br>
     * 2. double while loop method @BFS_shortestPath01, same concept as point 1.
     * <br>
     * 3. add "null" in que.->if null is head remove it and add it to the last with
     * lvl++. <br>
     * 
     */

    public static void BFS_shortestPath(int src, int dest) {

        LinkedList<BFSpair> que = new LinkedList<>();
        boolean[] isVis = new boolean[graphSize];
        int lvl = 0;
        int size = 0;

        que.addLast(new BFSpair(src, 0, src + ""));
        // que.addLast(null); // null method to find lvl
        boolean desFound = false;

        // while (que.size() > 1){ //null method to find lvl
        while (!que.isEmpty()) {

            BFSpair rPair = que.removeFirst();

            if (isVis[rPair.vtx]) {
                System.out.println("Cycle: " + rPair.psf);
            }

            isVis[rPair.vtx] = true;

            if (rPair.vtx == dest && !desFound) {
                desFound = true;
                System.out.println("sPath:" + rPair.psf + " @" + rPair.wsf + "-lvl: " + lvl);
            }

            for (Edge nbr : graph[rPair.vtx]) {
                if (!isVis[nbr.v]) {
                    BFSpair nbrPair = new BFSpair(nbr.v, rPair.wsf + nbr.wt, rPair.psf + "=>" + nbr.v);
                    que.addLast(nbrPair);
                }
            }

            if (size == 0) {
                size = que.size();
                lvl++;
            }
            size--;

            // if (que.getFirst() == null) {
            // que.removeFirst();
            // que.addLast(null);
            // lvl++;
            // }

        }
    }

    // same objective as above but doing with double while loop.
    // while loop is another way to find LVL**********
    public static void BFS_shortestPath01(int src, int dest) {

        LinkedList<BFSpair> que = new LinkedList<>();
        boolean[] isVis = new boolean[graphSize];
        boolean desFound = false;
        int lvl = 0;

        que.addLast(new BFSpair(src, 0, "0"));

        while (!que.isEmpty()) {

            int size = que.size();
            while (size-- != 0) {
                BFSpair rPair = que.removeFirst();

                if (isVis[rPair.vtx]) {
                    System.out.println("Cycle: " + rPair.psf);
                }

                isVis[rPair.vtx] = true;

                if (rPair.vtx == dest && !desFound) {
                    System.out.println("sPath:" + rPair.psf + " @" + rPair.wsf + "@LVL " + lvl);
                    desFound = true;
                }

                for (Edge nbr : graph[rPair.vtx]) {
                    if (!isVis[nbr.v]) {
                        BFSpair nbrPair = new BFSpair(nbr.v, rPair.wsf + nbr.wt, rPair.psf + "=>" + nbr.v);
                        que.addLast(nbrPair);
                    }
                }
            }
            lvl++;

        }

    }

    // BFS_GCC basically ek tym pe wo sb vtx ko visit krega jo nbr hai ek durse k.
    // jo nbr nai hai unko visited nai kr payega.
    // So ye har BFS_GCC call pe graph ka ek component dega jiske vtx connected
    // hai.

    public static void BFS_GCC(int src, boolean[] isVis) {

        LinkedList<BFSpair> que = new LinkedList<>();

        que.addLast(new BFSpair(src, 0, src + ""));

        while (!que.isEmpty()) {

            BFSpair rPair = que.removeFirst();

            // clycle is not need for JTM problem
            // if (isVis[rPair.vtx]) {
            // System.out.println("Cycle: " + rPair.psf);
            // }

            isVis[rPair.vtx] = true;

            for (Edge nbr : graph[rPair.vtx]) {
                if (!isVis[nbr.v]) {
                    BFSpair nbrPair = new BFSpair(nbr.v, rPair.wsf + nbr.wt, rPair.psf + "=>" + nbr.v);
                    que.addLast(nbrPair);
                }
            }

        }
    }

    // GCC: getConnectedComponent
    public static void gcc(ArrayList<Edge>[] graph) {
        int gccCount = 0;
        boolean[] isVis = new boolean[graphSize];

        for (int i = 0; i < graph.length; i++) {
            if (!isVis[i]) {
                BFS_GCC(i, isVis);
                gccCount++;
            }
        }
        System.out.println("Total disConnected Components: " + gccCount);
    }

    // isConnectedGraph, isTree, isForest concept based on GCC and cycle.
    // https://drive.google.com/open?id=1-BbyOTBAyeKt8E_-4JoYaPdjKe7fGnhR

    public static int BFS_JTM(ArrayList<Edge>[] JTMgraph, int src, boolean[] isVis) {

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        int vtxCount = 0;
        while (!que.isEmpty()) {

            Integer rEle = que.removeFirst();

            if (!isVis[rEle]) {
                vtxCount++;
            }
            isVis[rEle] = true;

            for (Edge nbr : JTMgraph[rEle]) {
                if (!isVis[nbr.v]) {
                    que.addLast(nbr.v);
                }
            }
        }
        return vtxCount;
    }

    // n: no of astronauts == no. of vtx in graph
    // p 2D: astronauts pair == known nbrs pair
    public static void journeyToMoon(int n, int[][] p) {

        // graph creation in next 7 lines
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] JTMgraph = new ArrayList[n];

        boolean[] isVis = new boolean[n];
        initializeGraph(JTMgraph);

        for (int[] pair : p) {
            addEdge(JTMgraph, pair[0], pair[1], 0);
        }
        
        // counting disConnected Components vtx.
        int sum = 0;
        long result = 0;
        for (int i = 0; i < JTMgraph.length; i++) {
            if (!isVis[i]) {
                int ccSize = BFS_JTM(JTMgraph, i, isVis); // ccSize: ConnectedComponentSize
                result = result + (sum * ccSize);
                sum = sum + ccSize;
                // ccCount.add(ccSize);
            }
        }

        // long result = 0;
        // int sum = 0;
        // for (Integer size : ccCount) {
        // result = result + (sum*size);
        // sum = sum +size;
        // }

        System.out.println("Astronaut Pairs: " + result);
    }

    // JourneyToMoon using disjointSetUnion(DSU). As graph creation exceeds time
    // limit.
    public static long journeyToMoon_DSU(int n, int[][] p) {

        DisjointSet dsu = new DisjointSet(n, p);

        int[] setsSize = dsu.makeSet();

        long result = 0;
        int sum = 0;
        for (Integer size : setsSize) {
            result = result + (sum * size);
            sum = sum + size;
        }

        System.out.println("Astronaut Pairs: " + result);
        return result;
    }

    static class Partite_pair {
        int vtx;
        String color;

        public Partite_pair(int vtx, String color) {
            this.vtx = vtx;
            this.color = color;
        }
    }

    /**
     * BIPARTED GRAPH: imagine 2 sets. src ek set mai aur uske nbr durse set mai. do
     * the same for all vtx. In the end if set1 and set2, do not have any common vtx
     * i.e intersection is 0; and set1, set2 union == all vtxS of the graph. then it
     * is BIparted graph. <br>
     * 
     * IMPORTANT: bipartite check krne ki jarurt only cycle wale graph mai padegi.
     * tree/forest structure graph ALWAYS bipartite hota a hai. <br>
     * Graph mai agar cycle EVEN number of vertices se bn rha hai :=>bipartite hai
     * Graph mai agar cycle ODD number of vertices se bn rha hai :=>bipartite nahi.
     * 
     * Algo same as BFS. <br>
     * set1, set2 will be represted by colorSet: "R", "G". <br>
     * instead of boolean[] type isVis, use String[] type. <br>
     * String[] type to store color mark for current vtx. <br>
     * if isVis[x] is null == not marked yet: not isVisited yet. <br>
     * if isVis[x] is NOT null = visited. <br>
     * 
     * 
     * MOST IMP in Algo.<br>
     * agr curr vtx is already Visited hai toh wo usi color k sath visited hua ho
     * jis colr k sath curr vtx abi remove hua hai. otherwise> Not a Bipartite
     * Graph. return false. break loop.
     * 
     */

    public static boolean bipartite(int src) {

        String[] isVis = new String[graphSize];

        LinkedList<Partite_pair> que = new LinkedList<>();
        que.addLast(new Partite_pair(src, "R"));

        while (!que.isEmpty()) {

            Partite_pair rPair = que.removeFirst();

            if (isVis[rPair.vtx] == null) {
                isVis[rPair.vtx] = rPair.color;
            } else { // matlb vtx dursi baar visit horha hai.
                // isVis ke pas jo color hai aur jo rPair k paas color agar wo match nai krta
                // matlb ambiguity aa gyi hai, current vtx k liye "mark red ho ya green pta nai
                // chlra".
                // Hence, not a bipartite graph.
                if (!isVis[rPair.vtx].equals(rPair.color)) {
                    System.out.println("Not a bipartite Graph");
                    return false;
                }
            }

            for (Edge nbr : graph[rPair.vtx]) {
                if (isVis[nbr.v] == null) { // not visited
                    Partite_pair nbrPair = new Partite_pair(nbr.v, (rPair.color.equals("R") ? "G" : "R"));
                    que.addLast(nbrPair);
                }
            }
        }
        System.out.println("It's a Bipartite Graph");
        return true;
    }

    // dijikstra pair class
    static class Dpair implements Comparable<Dpair> {
        int vtx;
        int wsf;
        String psf;

        public Dpair(int vtx, int wsf, String psf) {
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Dpair o) {
            if (this.wsf < o.wsf)
                return -1;
            return 1;
        }

        @Override
        public String toString() {
            return this.psf + " @ " + this.wsf;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {

        PriorityQueue<Dpair> que = new PriorityQueue<>();
        boolean[] isVis = new boolean[graph.length];

        que.add(new Dpair(src, 0, "0"));

        while (!que.isEmpty()) {
            Dpair rPair = que.remove();

            // print path only when visitng for the first time.
            if (!isVis[rPair.vtx])
                System.out.println(rPair);
            else {
                // visting for 2nd time, nbr toh already dal chuke hongy.So nbr check krne ka
                // koi matlb nai. So sidha continue.
                continue;
            }
            isVis[rPair.vtx] = true;

            for (Edge nbr : graph[rPair.vtx]) {
                if (!isVis[nbr.v]) {
                    Dpair nbrEdge = new Dpair(nbr.v, rPair.wsf + nbr.wt, rPair.psf + "->" + nbr.v);
                    que.add(nbrEdge);
                }
            }
        }
    }

    static class PrimsPair implements Comparable<PrimsPair> {
        int vtx;
        int w;
        String psf;

        public PrimsPair(int vtx, int w, String psf) {
            this.vtx = vtx;
            this.w = w;
            this.psf = psf;
        }

        @Override
        public int compareTo(PrimsPair o) {
            if (this.w < o.w) {
                return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return this.psf;
        }

    }

    public static void primsMST(ArrayList<Edge>[] pGraph) {

        PriorityQueue<PrimsPair> que = new PriorityQueue<>();
        boolean[] isVis = new boolean[graph.length];

        que.add(new PrimsPair(0, 0, "0"));

        while (!que.isEmpty()) {

            PrimsPair rPair = que.remove();

            if (!isVis[rPair.vtx])
                System.out.println(rPair);
            else {
                continue;
            }

            isVis[rPair.vtx] = true;

            for (Edge nbr : graph[rPair.vtx]) {
                if (!isVis[nbr.v]) {
                    PrimsPair nbrEdge = new PrimsPair(nbr.v, nbr.wt, rPair.psf + "->" + nbr.v);
                    que.add(nbrEdge);
                }
            }
        }

    }

    /**
     * Dijkstra Vs Prims
     *
     * https://drive.google.com/file/d/16hzIQHhnVf-4WHfZHbvCntHefVaTZyeN/view?usp=sharing
     * Think as metro construction and cost associated with it. <br>
     * First problem : kese "LOW COST" mai source to dest tk. (Here, we are thinking
     * only between any two nodes and not about overall cost of project)<br>
     * 
     * Second Probem : kese "OVERALL PROJECT ki COST MINIMIZE" ho ske. (in 2nd case
     * we are only thinking about overall cost and not between any two specific
     * node. SO here ho skta hai cost between any two nodes optimum na ho. example:
     * screenshot link above) <br>
     * 
     * <br>
     * IMP. POINTS Prims always give Minimum Spanning tree.(MST). whereas, In case
     * of Dijkstra it gives only Spanning tree(more specifically shortest spanning
     * tree in terms of weight from src to dest.).Dijkstra Spanning tree May or may
     * not be a MST.
     * 
     */

    // ********************* Kruskal ******************
    static class Kpair implements Comparable<Kpair> {
        int u;
        int v;
        int w;

        public Kpair(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;

        }

        @Override
        public int compareTo(Kpair o) {
            if (this.w < o.w) {
                return -1;
            }
            return 1;
        }

    }

    public static void kruskal(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // start from here

        // ansGraph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] ansGraph = new ArrayList[n];
        initializeGraph(ansGraph);

        while (!k_pq.isEmpty()) {
            Kpair rPair = k_pq.remove(); // removes an Edge with u,v,w
            int prnt1 = findParent(parent, rPair.u);
            int prnt2 = findParent(parent, rPair.v);

            // dono vrts ek hi edge k part hai means they are known (nbr) to each other. So
            // if they're known each other they should belong to same SET.Same Set ko belong
            // krna means dono k parent same hona. if Parents are not same call union
            // function. parent not being same also show that they are not having any
            // connection till yet. So create an Edge here for kGraph(ansGraph).
            //
            // if they are already in the same set, this means rPair vtxs are either
            // connected directly or indirectly (means traversing from one rPair one vtx
            // will lead you to rPair other vtx, in ansGraph). So no need to create a new
            // Edge here. becoz it will create a cycle. (So need detect cycle too.!!)

            if (prnt1 != prnt2) {
                union(parent, size, prnt1, prnt2);
                addEdge(ansGraph, rPair.u, rPair.v, rPair.w);
            }
        }
        display(ansGraph);
    }

    public static int findParent(int[] parent, int vtx) {

        if (parent[vtx] != vtx) {
            parent[vtx] = findParent(parent, parent[vtx]);
        }
        return parent[vtx];
    }

    public static void union(int[] parent, int[] size, int prnt1, int prnt2) {

        if (parent[prnt1] <= parent[prnt2]) {
            parent[prnt1] = prnt2;
            size[prnt2] += size[prnt1];
        } else {
            parent[prnt2] = prnt1;
            size[prnt1] += size[prnt2];
        }
    }

    static int descoveryTime = 0;

    static int[] ancestorsAr = new int[graphSize]; // ancesotr: jo pehle discover hua
    static int[] desc = new int[graphSize];
    static boolean[] isVis = new boolean[graphSize];

    public static void myGreatestAncestor(ArrayList<Edge>[] graph, int src, int oSrc, int parent) {
        isVis[src] = true;

        desc[src] = descoveryTime++;

        ancestorsAr[src] = desc[parent];
        boolean isAP = false;

        // if root have two child(independent). then root is AP
        // graph[oSrc].size() krke childs nai check krna. becoz childs independent ho ye
        // pta nai chlega. Imagine a triangle graph.
        int child = 0;

        for (Edge nbr : graph[src]) {
            if (!isVis[nbr.v]) {
                child++;
                myGreatestAncestor(graph, nbr.v, oSrc, src);
                ancestorsAr[src] = Math.min(ancestorsAr[src], ancestorsAr[nbr.v]);
            } else {
                // backage found.
                ancestorsAr[src] = Math.min(ancestorsAr[src], desc[nbr.v]);
                // imp case imagination: jab curr src ka nbr, "current src" ka "src" hoga tb bhi
                // else block fasega. becoz graph is bidirectional. if A(src) has nbr B. and
                // now we are at visiting B thru A. now Current Src(B) has nbr A(src), and A is
                // already visited.Hence we'll land into else block.
                // But everything is getting handled automatically, becoz ancestorsAr[src] =>
                // disc time of ansces of B => desc time of A. AND desc[nbr.v] => desc tym of A.
            }

            // when src is not root node.
            if (ancestorsAr[nbr.v] == desc[src] && src != oSrc) {
                isAP = true;
            }

            // when src is root node and have at least two child.
            if (src == oSrc && child > 1) {
                isAP = true;
            }
        }

        if (isAP)
            System.out.println(src + " is AP");
    }

}