package Graph.MediumQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional 
edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that 
already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] 
indicates that there is an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are 
multiple answers, return the answer that occurs last in the input.

Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:
Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
*/

public class Q684RedundantConnections {
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int m = edges.length;
        //we'll use hashmap to store our adjacency matrix
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, new HashSet<>());
        }

        //traverse all edges and check whether adding current edge will create a cycle
        for (int[] edge : edges) {
            if (dfs(new HashSet<>(), map, edge[0], edge[1]))
                return edge;//cycle can be found by adding this current edge, return it

            //otherwise add an undirected edge between both the nodes
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return null;
    }

    private boolean dfs(Set<Integer> visited, Map<Integer, Set<Integer>> map,
            int src, int target) {
        if (src == target)
            return true;
        visited.add(src);
        for (int next : map.get(src)) {
            if (!visited.contains(next)) {
                if (dfs(visited, map, next, target))
                    return true;
            }
        }
        return false;
    }
}