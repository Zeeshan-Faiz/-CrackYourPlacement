package StackAndQueues.MediumQuestions;

/*
A celebrity is a person who is known to all but does not know anyone at a party. A party is 
being organized by some people.  A square matrix mat is used to represent people at the party 
such that if an element of row i and column j is set to 1 it means ith person knows jth person. 
You need to return the index of the celebrity in the party, if the celebrity does not exist, 
return -1.

Example 1:
Input: mat[][] = [[0 1 0],
                [0 0 0], 
                [0 1 0]]
Output: 1
Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity. 

Example 2:
Input: mat[][] = [[0 1],
                [1 0]]
Output: -1
Explanation: The two people at the party both know each other. None of them is a celebrity.
*/

public class TheCelebrityProblem {

    public int celebrity(int mat[][]) {
        
        int n = mat.length;
        int candidate = 0;

        // Step 1: Identify a potential celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i; // candidate can't be a celebrity, i might be
            }
        }
        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // candidate should not know i, and everyone should know candidate
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0)
                    return -1;
            }
        }
        return candidate;
    }
}