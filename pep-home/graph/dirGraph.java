import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * dirGraph
 */
public class dirGraph {

    static class Edge {
        int v = 0;
        int wt = 0;

        public Edge(int v, int w) {
            this.v = v;
            this.wt = w;
        }
    }

    static int graphSize = 7;
    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] graph = new ArrayList[graphSize];

    public static void main(String[] args) {

        populateGraph();
        display(graph);

        // ===================
        // topologicalSort(graph); // only sorting no cycle detection
        // topologicalSort01(graph); // with cycle detection. if "acylic" graph then
        // only print.

        // ========== Khan ALgo : topological Sort algo using Icoming Edges =========
        khanAlgo(graph);
    }

    public static void addEdge(ArrayList<Edge>[] g, int u, int v, int wt) {

        if (u < 0 || u > g.length - 1 || v < 0 || v > g.length - 1)
            return;
        g[u].add(new Edge(v, wt));
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
        // addEdge(graph, 0, 3, 10);
        // addEdge(graph, 3, 0, 10);
        // addEdge(graph, 3, 4, 2);
        // addEdge(graph, 4, 5, 2);
        // addEdge(graph, 5, 6, 3);
        // addEdge(graph, 4, 6, 8);

        // heartShape Graph size 7
        // addEdge(graph, 0, 1, 0);
        // addEdge(graph, 0, 5, 0);
        // addEdge(graph, 1, 2, 0);
        // addEdge(graph, 2, 3, 0);
        // addEdge(graph, 4, 5, 0);
        // addEdge(graph, 4, 6, 0);
        // addEdge(graph, 6, 3, 0);

        // cyclic graph size 7 TPSort01
        addEdge(graph, 0, 1, 0);
        addEdge(graph, 1, 2, 0);
        addEdge(graph, 2, 3, 0);
        addEdge(graph, 3, 4, 0);
        addEdge(graph, 4, 5, 0);
        addEdge(graph, 5, 6, 0);
        addEdge(graph, 6, 0, 0);

        // modified heartGraph Khan algo size 8;
        // o/p: 0, 1, 2, 3, 4, 5, 7, 6,

        // addEdge(graph, 0, 2, 0);
        // addEdge(graph, 0, 3, 0);
        // addEdge(graph, 2, 5, 0);
        // addEdge(graph, 5, 6, 0);
        // addEdge(graph, 1, 3, 0);
        // addEdge(graph, 1, 4, 0);
        // addEdge(graph, 4, 7, 0);
        // addEdge(graph, 7, 6, 0);

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

    // topologicalSort only "Acyclic" graph k liye chlta hai.
    // ALgo: using DFS and filling STACK in post order and Printing the Stack.
    public static void topologicalSort(ArrayList<Edge>[] graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!isVis[i]) {
                topologicalSortUtil(graph, i, isVis, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
        System.out.println();
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int src, boolean[] isVis, Stack<Integer> stack) {

        isVis[src] = true;

        for (Edge e : graph[src]) {
            if (!isVis[e.v])
                topologicalSortUtil(graph, e.v, isVis, stack);
        }
        stack.add(src); // adding only unvisited element.
    }

    // ==============topologicalSort to detect cycle in directedGraph ===========
    // idea is to mantain on more isVisited arr (name it cycle) which reset after
    // each Util call (DFS recursion call). During one recursion if a vtx is marked
    // true in cycle arr that means ye vtx ek recursion mai dobara visit hone
    // ko aaya hai. kyuki cycle arr toh hr recursion reset hota hai, means ye vtx
    // isi recursion time span mai pehle mark hua hoga aur ye fir mark hone ko aaya
    // hai. Hence it's a cycle.

    // Algo: using 2nd isVis(name Cycle) and resetting it after each recursion call.
    // Rest all as privous algo. if found cycle[src] true, return true from
    // recursion and stop.
    public static void topologicalSort01(ArrayList<Edge>[] graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVis = new boolean[graph.length];
        boolean[] cycle = new boolean[graph.length];
        boolean res = false;

        for (int i = 0; i < graph.length && !res; i++) {
            if (!isVis[i]) {
                // calling Tsort and updating res each time.
                res = res || topologicalSortUtil01(graph, i, isVis, stack, cycle);
            }
        }

        // res false hoga tabhi Tsort generate hua hoga.
        if (!res) {

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + ", ");
            }

            System.out.println();

        } else {
            System.out.println("Cylic Graph is found");
        }

    }

    public static boolean topologicalSortUtil01(ArrayList<Edge>[] graph, int src, boolean[] isVis, Stack<Integer> stack,
            boolean[] cycle) {

        isVis[src] = true;
        cycle[src] = true;

        boolean res = false;

        for (Edge e : graph[src]) {
            if (!isVis[e.v])
                res = res || topologicalSortUtil01(graph, e.v, isVis, stack, cycle);
            else if (cycle[e.v]) {
                /**
                 * return true means cycle mil gya, so no need for further call. Since
                 * topological sort is not possible for cyclic graph. "ONE OBSERVATION": yaha se
                 * return hua, toh cycle[src] current src k liye false nai hua. aur
                 * "stack.add(src)" nai chala. which is fine, becoz ab full program terminate hi
                 * krna hai, cycle arr ka use nai hai ab.
                 */

                return true;
            }
        }
        cycle[src] = false; // reset cycle
        stack.add(src); // adding only unvisited element.

        return res;
    }

    // ========= Khan Algo ==============
    /**
     * Here using concept of Incoming Edges. <br>
     * vtx ko ane wale Edges: IC Edges. vtx se jane wale Edges: OG Edges. <br>
     * 
     * "ALGO IDEA" : <br>
     * Maintain an arr "ICEdges" that stores count of IC Edges for each Vtx. <bt>
     * For that use DFS and for each nbr (for both vis and non-vis), IC Edges mai
     * nbr idx pe +1 krdo. <br>
     * 
     * Now Create a que with starting elements having "No IC Edges". (i.e whose
     * value is 0 in ICEdges arr). ***MOST IMP **** <br>
     * 
     * Repeat below steps, till que gets empty.<br>
     * pop => store it in Ans String => traverse its nbr. => Reduce its nbr Icoming
     * Edge by one. => if nbr IC Edge value become 0 that this nbr in the que.
     * 
     */

    public static void khanAlgo(ArrayList<Edge>[] graph) {
        LinkedList<Integer> que = new LinkedList<>();

        boolean[] isVis = new boolean[graph.length];
        int[] ICEdges = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!isVis[i]) {
                incomingEdges(graph, i, isVis, ICEdges);
            }
        }

        for (int i = 0; i < ICEdges.length; i++) {
            if (ICEdges[i] == 0)
                que.addLast(i);
        }

        String ans = "";
        // only purpose of count is to tell if graph is cyclic or not. count is not
        // needed if it is already known that graph has not cycle.
        int count = 0;

        while (!que.isEmpty()) {
            count++;
            int rElement = que.removeFirst(); // Extra: jo remove hua uska IC value zero hi hoga.
            ans += rElement + ", ";

            for (Edge nbr : graph[rElement]) {
                ICEdges[nbr.v]--; // nbr vtx ka IC Edge value ek kam krdo.

                // agr nbr vtx ka IC Edge value == 0 ho jaye, then add this nbr in que.
                if (ICEdges[nbr.v] == 0) {
                    que.add(nbr.v);
                }
            }
        }

        // if count < total vtx in graph => que pehle hi empty ho gyi and "ans" mai
        // saare vtx add nai ho paye. Hence cycle rhi hogi.
        if (count < graph.length)
            System.out.println("Cyclic Graph");
        else
            System.out.println("TPSort KhanAlgo " + ans);

    }

    public static void incomingEdges(ArrayList<Edge>[] graph, int src, boolean[] isVis, int[] ICEdges) {

        isVis[src] = true;

        for (Edge nbr : graph[src]) {
            ICEdges[nbr.v] += 1;
            if (!isVis[nbr.v]) {
                incomingEdges(graph, nbr.v, isVis, ICEdges);
            }
        }
    }

    

}
