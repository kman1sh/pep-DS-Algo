import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class l01_graph {

    public static Scanner scn = new Scanner(System.in);
    public static ArrayList<Edge>[] graph = new ArrayList[7];
    // static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        Edge() {

        }
    }

    public static void caseI() {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        addEdge(0, 3, 10);
        addEdge(0, 1, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 40);
        addEdge(3, 4, 2);
        addEdge(4, 5, 2);
        addEdge(4, 6, 3);
        addEdge(5, 6, 8);

    }

    // public static void caseII() {
    // for (int i = 0; i < 7; i++) {
    // graph.add(new ArrayList<Edge>());
    // }

    // }

    public static void addEdge(int u, int v, int w) {
        if (!(u < 0 || v < 0 || u >= graph.length || v >= graph.length)) {
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));

        }
    }

    public static void display() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " => ");

            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print("(" + graph[i].get(j).v + " , " + graph[i].get(j).v + ") ");
            }
            System.out.println();
        }
    }

    public static LinkedList<pathData> que = new LinkedList<>();

    public static void ShortestPath(int src, int des) {
        pathData root = new pathData(src, src + "", 0);
        que.addLast(root);
        boolean isFound = false;
        boolean[] isVis = new boolean[graph.length];

        while (!que.isEmpty()) {

            pathData vrtInfo = que.removeFirst();
            if (!isVis[vrtInfo.v]) {
                isVis[vrtInfo.v] = true;

            } else { // if already visited means cycle
                System.out.println("Cycle--> " + vrtInfo.psf);
            }

            if (vrtInfo.v == des && !isFound) {
                isFound = true;
                System.out.println(vrtInfo.psf);
            }
            for (Edge e : graph[vrtInfo.v]) {
                if (!isVis[e.v]) {
                    que.add(new pathData(e.v, vrtInfo.psf + e.v, vrtInfo.wsf + e.w));
                }
            }

        }

    }

    public static void ShortestPath_null(int src, int des) {
        pathData root = new pathData(src, src + "", 0);
        que.addLast(root);
        que.addLast(null);
        boolean isFound = false;
        boolean[] isVis = new boolean[graph.length];
        int level = 1;

        while (que.size() != 1) {

            pathData vrtInfo = que.removeFirst();
            if (!isVis[vrtInfo.v]) {
                isVis[vrtInfo.v] = true;
                for (Edge e : graph[vrtInfo.v]) {
                    if (!isVis[e.v]) {
                        que.add(new pathData(e.v, vrtInfo.psf + e.v, vrtInfo.wsf + e.w));
                    }
                }

            } else { // if already visited means cycle
                System.out.println("Cycle--> " + vrtInfo.psf);
            }

            if (vrtInfo.v == des && !isFound) {
                isFound = true;
                System.out.println(vrtInfo.psf + "@ length " + level);
            }

            if (que.getFirst() == null) {
                que.removeFirst();
                que.addLast(null);
                level++;
            }
        }
    }

    public static LinkedList<ColoredNode> queue = new LinkedList<>();

    public static void isBiparted(int src) {
        ColoredNode[] isVisited = new ColoredNode[graph.length];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = new ColoredNode();
        }
        ColoredNode root = new ColoredNode(src, 'R');

        queue.addLast(root);

        while (queue.size() != 0) {
            ColoredNode removedPair = queue.removeFirst();

            if (removedPair.v == isVisited[removedPair.v].v) {
                System.out.println("Cyclye @ " + removedPair.v);
                if (removedPair.colorName != isVisited[removedPair.v].colorName) {
                    System.out.println("Non-Biparted Graph");
                } else {
                    System.out.println("Biparted Graph");
                }
                continue;
            } else {
                isVisited[removedPair.v] = new ColoredNode(removedPair.v, removedPair.colorName);

            }
            for (Edge e : graph[removedPair.v]) {
                if (e.v != isVisited[e.v].v) {
                    char color = (removedPair.colorName == 'R') ? 'G' : 'R';
                    queue.add(new ColoredNode(e.v, color));
                }
            }
        }
    }

    public static class pathData {

        int v;
        String psf; // path so far
        int wsf;

        public pathData(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    public static class ColoredNode {
        int v = -1;
        char colorName = 'z';

        public ColoredNode(int v, char colorName) {
            this.v = v;
            this.colorName = colorName;
        }

        public ColoredNode() {
        }
    }

    public static class kpair implements Comparable<kpair> {
        int u = 0;
        int v = 0;
        int w = 0;

        public kpair(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(kpair o) {
            return this.w - o.w;
        }



    }
    public static ArrayList<kpair>[] graph_k = new ArrayList[9];

    public static void case_k() {
        for (int i = 0; i < graph_k.length; i++) {
            graph_k[i] = new ArrayList<>();
        }
    }

    public static void addEdge_k(int u, int v, int w) {
        if (!(u < 0 || v < 0 || u >= graph_k.length || v >= graph_k.length)) {
            graph_k[u].add(new kpair(v, u, w));
            // graph_k[v].add(new kpair(u, w));

        }
    }

    public static int[] parent = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
    public static int[] size = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
    public static PriorityQueue<kpair> kQueue = new PriorityQueue<>();

    
    public static int findParent(int vtx) {

        int par = parent[vtx];
        if (par != vtx) {
            int ans = findParent(par);
            parent[vtx] = ans;
            return ans;
        } else {
            return par;
        }
    }

    public static void union(int pt1, int pt2) {

        if (size[pt1] <= size[pt2]) {
            parent[pt1] = pt2;
            size[pt2] += size[pt1];
        } else {
            parent[pt2] = pt1;
            size[pt1] += size[pt2];
        }
    }



    public static void poplulateKruskalQueue() {
        kQueue.add(new kpair(0, 1, 4));
        kQueue.add(new kpair(1, 2, 8));
        kQueue.add(new kpair(2, 3, 7));
        kQueue.add(new kpair(3, 4, 9));
        kQueue.add(new kpair(4, 5, 10));
        kQueue.add(new kpair(5, 6, 2));
        kQueue.add(new kpair(6, 7, 1));
        kQueue.add(new kpair(7, 8, 7));
        kQueue.add(new kpair(8, 6, 6));
        kQueue.add(new kpair(7, 0, 8));
        kQueue.add(new kpair(2, 8, 2));
        kQueue.add(new kpair(1, 7, 11));
        kQueue.add(new kpair(3, 5, 14));
        kQueue.add(new kpair(2, 5, 4));

    }

    public static void display_k() {
        for (int i = 0; i < graph_k.length; i++) {
            System.out.print(i + " => ");

            for (int j = 0; j < graph_k[i].size(); j++) {
                System.out.print("(" + graph_k[i].get(j).v + " , " + graph_k[i].get(j).v + ") ");
            }
            System.out.println();
        }
    }

    public static void kruskalAlgo() {

        while (kQueue.size() != 0) {

            kpair removedPair = kQueue.remove();
            int pt1 = findParent(removedPair.u);
            int pt2 = findParent(removedPair.v);

            if (pt1 != pt2) {
                union(pt1, pt2);
                addEdge_k(removedPair.u, removedPair.v, removedPair.w);
            }
        }
    }



    public static void main(String[] args) {
        // caseI();
        // display();
        // ShortestPath(0, 6);
        // pathData p = new pathData(5, "fgggg", 55);
        // System.out.println(p.psf);
        // ShortestPath_null(0, 6);
        // isBiparted(0);

        // case_k();
        poplulateKruskalQueue();
        // kruskalAlgo();
        // display_k();


    }

}