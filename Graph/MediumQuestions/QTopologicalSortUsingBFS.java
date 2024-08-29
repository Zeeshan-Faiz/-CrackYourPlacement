package Graph.MediumQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains a list of 
all vertices j such that there is a directed edge from vertex i to vertex j, with  V  vertices and 
E  edges, your task is to find any valid topological sorting of the graph.
In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.

Example 1:
Input:
Output:
1
Explanation:
The output 1 denotes that the order is valid. So, if you have, implemented your function correctly, then output
would be 1 for all test cases. One possible Topological order for the graph is 3, 2, 1, 0.

Example 2:
Input:
Output:
1
Explanation:
The output 1 denotes that the order is valid. So, if you have, implemented your function correctly, then output
would be 1 for all test cases. One possible Topological order for the graph is 5, 4, 2, 1, 3, 0.
*/

public class QTopologicalSortUsingBFS {

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int indegree[] = new int[V];
        // find indegree for each node
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        //add all nodes with indegree=0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int ans[] = new int[V];
        int i = 0;
        while (!queue.isEmpty()) 
        {
            int node = queue.remove();
            ans[i] = node;
            i++;
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return ans;
    }
}