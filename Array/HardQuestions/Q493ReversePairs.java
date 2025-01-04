package Array.HardQuestions;

/*
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

    0 <= i < j < nums.length and
    nums[i] > 2 * nums[j].

Example 1:
Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

Example 2:
Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
*/

public class Q493ReversePairs {

    int ans;

    public int reversePairs(int[] nums) {
        ans = 0;
        solve(nums, 0, nums.length - 1);
        return ans;
    }

    public int[] solve(int[] nums, int i, int j) {

        if (i == j)
            return new int[] { nums[i] };

        int mid = (i + j) / 2;
        int left[] = solve(nums, i, mid);
        int right[] = solve(nums, mid + 1, j);
        int r = 0;
        int temp = 0;

        for (int l = 0; l < left.length; l++) {
            while (r < right.length && left[l] > 2l * (long) right[r]) {
                r++;
                temp = temp + (left.length - l);
            }

        }
        ans = ans + temp;
        int arr[] = new int[left.length + right.length];

        int l = 0;
        r = 0;
        int index = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[index++] = left[l++];
            } else {
                arr[index++] = right[r++];
            }
        }
        while (l < left.length)
            arr[index++] = left[l++];
        while (r < right.length)
            arr[index++] = right[r++];
        return arr;
    }
}