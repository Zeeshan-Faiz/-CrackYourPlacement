package Graph.MediumQuestions;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a square chessboard, the initial position of Knight and position of a target. Find out the 
minimum steps a Knight will take to reach the target position.
Note:
The initial and the target position coordinates of Knight have been given according to 1-base 
indexing.

Example 1:
Input:
N=6
knight[ ] = {4, 5}
target[ ] = {1, 1}

Output:
3

Explanation:
Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
*/

public class QStepsByKnight {

    public int minStepToReachTarget(int knight[], int target[], int n) {
        
        boolean visited[][] = new boolean[n + 1][n + 1];
        //all 8 traversals of a knight
        int dx[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int dy[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

        Queue<Coordinates> q = new LinkedList<>();
        q.add(new Coordinates(knight[0], knight[1], 0));

        while (!q.isEmpty()) {

            Coordinates curr = q.remove();

            if (curr.x == target[0] && curr.y == target[1])
                return curr.dis;

            for (int i = 0; i < 8; i++) {

                int x = curr.x + dx[i];
                int y = curr.y + dy[i];

                if (isValid(x, y, n) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Coordinates(x, y, curr.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public boolean isValid(int x, int y, int n) {

        if (x >= 1 && x <= n && y >= 1 && y <= n)
            return true;
        return false;
    }
}