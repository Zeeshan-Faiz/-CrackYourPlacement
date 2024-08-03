package HeapPriorityQueue.MediumQuestions;

import java.util.PriorityQueue;

/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number.

Example 1:
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Example 2:
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
*/

public class Q264UglyNumberII {

    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        for (int i = 0; i < n - 1; ++i) 
        {
            long val = pq.remove();
            // remove duplicates
            while (pq.size() > 0 && pq.peek() == val)
                pq.remove();

            pq.add(val * 2);
            pq.add(val * 3);
            pq.add(val * 5);
        }
        return pq.remove().intValue();
    }
}