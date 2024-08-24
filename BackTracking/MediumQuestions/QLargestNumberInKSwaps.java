package BackTracking.MediumQuestions;

/*
Given a number K and string str of digits denoting a positive integer, build the largest number 
possible by performing swap operations on the digits of str at most K times.

Example 1:
Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the input 1234567 to 7654321, swapping 1 with 7, 2 with 6 and finally 3 with 5

Example 2:
Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input 3435335 to 5543333, swapping 3 with 5, 4 with 5 and finally 3 with 4 
*/

public class QLargestNumberInKSwaps{
    
    public static String findMaximumNum(String str, int k){
        
        char[] chars = str.toCharArray();
        String[] result = {str}; // Use an array to hold the result since strings are immutable
        solve(chars, chars.length, k, result, 0);
        return result[0];
    }

    
}