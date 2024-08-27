package Graph.MediumQuestions;

import java.util.ArrayList;
import java.util.Stack;

/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of 
strongly connected components in the graph.

Input:
0 --> 1 --> 2 --> 0
Output:
1
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC.
*/

public class QStronglyConnectedComponents {

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        // add all the nodes to stack according to finish time
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // reverse the graph and store in adjT
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (Integer neighbor : adj.get(i)) {
                // i -> it
                // it -> i
                adjT.get(neighbor).add(i);
            }
        }
        // perform dfs2 in order of finishing time and count the scc
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs2(node, vis, adjT);
            }
        }
        return scc;
    }

    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (Integer neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, vis, adj, st);
            }
        }
        st.push(node);
    }

    private void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer nieghbor : adjT.get(node)) {
            if (vis[nieghbor] == 0) {
                dfs2(nieghbor, vis, adjT);
            }
        }
    }
}