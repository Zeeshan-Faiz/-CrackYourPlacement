package Graph.MediumQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
You are given an array of variable pairs equations and an array of real numbers values, where 
equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi 
is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you 
must find the answer for Cj / Dj = ?. Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that
there is no contradiction.
Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0

Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
*/

public class Q399EvaluateEquation {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            Set<String> visited = new HashSet<String>();
            if (query.get(0).equals(query.get(1))) {
                if (graph.containsKey(query.get(0))) {
                    ans[i] = 1.0;
                    i++;

                } else {
                    ans[i] = -1.0;
                    i++;

                }
                continue;
            }
            double res = dfs(query.get(0), query.get(1), graph, visited);
            ans[i] = res;
            i++;
        }

        return ans;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        Map<String, Double> startMap = graph.get(start);
        for (Map.Entry<String, Double> entry : startMap.entrySet()) {
            if (!visited.contains(entry.getKey())) {

                double currVal = dfs(entry.getKey(), end, graph, visited);

                if (currVal != -1) {
                    return currVal * entry.getValue();
                }
            }
        }
        return -1.0;

    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        // source, <End, Value>
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            String startEl = equation.get(0);
            String endEl = equation.get(1);
            double val = values[i];
            i++;
            graph.putIfAbsent(startEl, new HashMap<>());

            graph.get(startEl).put(endEl, val);

            graph.putIfAbsent(endEl, new HashMap<>());

            graph.get(endEl).put(startEl, 1 / val);
        }
        return graph;

    }
}