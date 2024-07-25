package Array.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n]
and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]

Example 3:
Input: nums = [1]
Output: []
*/

public class Q442FindAllDuplicatesInArray {

    /*
     * We can either use Cyclic Sort or the below approach as the elements lies in [1,n] range.
    */

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> resultSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) 
        {    
            // Get the index, the element corresponds to
            int index = Math.abs(nums[i]) - 1;

            // If the number is already negative, it means we are encountering it twice
            if (nums[index] < 0)
                resultSet.add(index + 1);

            // Flip the number at the index to negative
            nums[index] = nums[index] * -1;
        }
        return resultSet;
    }
}