package Graph.MediumQuestions;

/*
Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all 
the vertex's from the source vertex S. If a vertices can't be reach from the S then mark the 
distance as 10^8. Note: If the Graph contains a negative cycle then return an array consisting of 
only -1.

Example 1:
Input:
E = [[0,1,9]]
S = 0

Output:
0 9

Explanation:
Shortest distance of all nodes from source is printed.

Example 2:
Input:
E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
S = 2

Output:
1 6 0

Explanation:
For nodes 2 to 0, we can follow the path- 2-0. This has a distance of 1. For nodes 2 to 1, we cam follow the path-
2-0-1, which has a distance of 1+5 = 6,
*/

public class QBellmanFordAlgorithm {
    
}