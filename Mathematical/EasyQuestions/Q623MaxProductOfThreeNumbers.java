package Mathematical.EasyQuestions;

/*
Given an integer array nums, find three numbers whose product is maximum and return the 
maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6

Example 2:
Input: nums = [1,2,3,4]
Output: 24

Example 3:
Input: nums = [-1,-2,-3]
Output: -6
*/

public class Q623MaxProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {

        int maxNum1 = Integer.MIN_VALUE;
        int maxNum2 = Integer.MIN_VALUE;
        int maxNum3 = Integer.MIN_VALUE; // largest value
        int minNum1 = Integer.MAX_VALUE;
        int minNum2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // Find three largest numbers.
            if (num > maxNum1) {
                if (num > maxNum3) {
                    maxNum1 = maxNum2;
                    maxNum2 = maxNum3;
                    maxNum3 = num;
                } 
                else if (num > maxNum2) {
                    maxNum1 = maxNum2;
                    maxNum2 = num;
                } 
                else {
                    maxNum1 = num;
                }

            }

            // Find two smallest numbers.
            if (num < minNum2) {
                if (num < minNum1) {
                    minNum2 = minNum1;
                    minNum1 = num;
                } 
                else {
                    minNum2 = num;
                }
            }
        }

        int maxProduct = maxNum1 * maxNum2 * maxNum3;
        int minProduct = minNum1 * minNum2 * maxNum3;
        return Math.max(minProduct, maxProduct);
    }
}