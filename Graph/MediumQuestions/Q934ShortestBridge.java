package Graph.MediumQuestions;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
An island is a 4-directionally connected group of 1's not connected to any other 1's. There are 
exactly two islands in grid. You may change 0's to 1's to connect the two islands to form one island.
Return the smallest number of 0's you must flip to connect the two islands.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1

Example 2:
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
*/

public class Q934ShortestBridge {
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean flag = false;
        if (n == 0)
            return 0;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n && !flag; i++) {
            for (int j = 0; j < n && !flag; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, visited, n, q);
                    flag = true;
                }
            }
        }

        int level = 0;

        while (!q.isEmpty()) {
            int sze = q.size();
            while (sze-- > 0) {
                int[] top = q.poll();
                int i = top[0];
                int j = top[1];

                int[] dir = { 0, 1, 0, -1, 0 };
                for (int x = 0; x < 4; x++) {
                    int nrow = i + dir[x];
                    int ncol = j + dir[x + 1];

                    if (nrow < 0 || ncol < 0 || nrow >= n || ncol >= n || visited[nrow][ncol])
                        continue;
                    if (grid[nrow][ncol] == 1)
                        return level;
                    visited[nrow][ncol] = true;
                    q.offer(new int[] { nrow, ncol });
                }
            }
            level++;
        }
        return 0;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited, int n, Queue<int[]> q) {
        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;
        q.offer(new int[] { i, j });
        int[] dir = { 0, 1, 0, -1, 0 };
        for (int x = 0; x < 4; x++) {
            dfs(i + dir[x], j + dir[x + 1], grid, visited, n, q);
        }
    }
}