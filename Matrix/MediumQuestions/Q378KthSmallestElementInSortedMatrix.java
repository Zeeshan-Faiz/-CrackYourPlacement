package Matrix.MediumQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, 
return the kth smallest element in the matrix. Note that it is the kth smallest element in 
the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).

Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:
Input: matrix = [[-5]], k = 1
Output: -5
*/

public class Q378KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
            {
                if (pq.size() < k)
                    pq.add(matrix[i][j]);
                else 
                {
                    if (pq.peek() > matrix[i][j]) {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}