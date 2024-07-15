package Array.EasyQuestions;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order 
of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
*/

public class Q283MoveZeroes {

    public void moveZeroes(int[] nums) {
        
        int nz = 0, z = 0;
        while (nz < nums.length) {
            if (nums[nz] != 0) {
                int t = nums[nz];
                nums[nz] = nums[z];
                nums[z] = t;
                nz++;
                z++;
            } 
            else
                nz++;
        }
    }
}