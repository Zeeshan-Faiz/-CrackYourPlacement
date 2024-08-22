package BackTracking.MediumQuestions;

/*
Suppose you have n integers labeled 1 through n. A permutation of those n integers perm 
(1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the 
following is true:
    perm[i] is divisible by i.
    i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

Example 1:
Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1

Example 2:
Input: n = 1
Output: 1
*/

public class Q526BeautifulArrangement {
    
    private int count = 0;

    public int countArrangement(int n) {
        if (n <= 0) {
            return count;
        }
        boolean[] visited = new boolean[n + 1];
        helper(visited, 1, n);
        return count;
    }

    private void helper(boolean[] visited, int valOrIndex, int n) {
        if (valOrIndex > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (valOrIndex % i == 0 || i % valOrIndex == 0)) {
                visited[i] = true;
                helper(visited, valOrIndex + 1, n);
                visited[i] = false; // backtrack
            }
        }
    }
}