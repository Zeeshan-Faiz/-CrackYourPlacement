package Graph.MediumQuestions;

import java.util.List;

/*
Given an undirected graph and an integer M. The task is to determine if the graph can be colored 
with at most M colors such that no two adjacent vertices of the graph are colored with the same 
color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is 
possible to colour vertices and 0 otherwise.
*/

public class MColoringProblem {
    
    public static boolean graphColoring(List < Integer > [] G, int[] color, int i, int C) {

        int n = G.length;
        if (solve(i, G, color, n, C) == true) 
            return true;
        return false;
    }
}