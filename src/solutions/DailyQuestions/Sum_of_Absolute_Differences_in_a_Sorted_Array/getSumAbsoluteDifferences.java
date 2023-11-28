package src.solutions.DailyQuestions.Sum_of_Absolute_Differences_in_a_Sorted_Array;// Problem Link: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

import java.util.Arrays;

public class getSumAbsoluteDifferences {
    public static void main(String[] args){
        int[] testCase1 = {2,3,5};
        int[] testCase2 = {1,4,6,8,10};

        // Two Pointer:
        int[] res1 = twoPointer(testCase1);
        System.out.println(Arrays.toString(res1));
        int[] res2 = twoPointer(testCase2);
        System.out.println(Arrays.toString(res2));


        //Brute Force
//        int[] res1 = bruteForce(testCase1);
//        System.out.println(Arrays.toString(res1));
//        int[] res2 = bruteForce(testCase2);
//        System.out.println(Arrays.toString(res2));
    }

    //Time Complexity : O(n)
    //Space Complexity : O(n)
    private static int[] twoPointer(int[] nums){
        // Store the total sum of the array
        int totalSum = 0;
        int n = nums.length;
        for(int num : nums){
            totalSum += num;
        }
        // Initialize the preSum and currentSum
        int preSum = 0;
        int suffixSum = totalSum;

        int[] res = new int[n];

        // Iterate over the array
        // Calculate the absolute difference sum by considering the preSum and suffixSum
        // Remove the current element from suffixSum and add it to preSum
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            suffixSum -= curr;

            res[i] = curr * i - preSum + suffixSum - curr * (n - i - 1);

            preSum += curr;
        }

        return res;
    }



    //Time Complexity : O(n^2)
    //Space Complexity : O(n)
    // Will work as a base solution for an interview
    private static int[] bruteForce(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            for (int num : nums) {
                res[i] += Math.abs(nums[i] - num);
            }
        }
        return res;
    }
}