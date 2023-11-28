package src.solutions.Blind75.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class threeSum{
    public static void main(String[] args){
        int[] test1 = {-1,0,1,2,-1,-4};
        int[] test2 = {};
        int[] test3 = {0};
        int[] test4 = {0,0,0};
        int[] test5 = {-2,0,0,2,2};
        // Initial Solution
        System.out.println("Brute Force Result:");
        System.out.println(twoPointerSol(test1));
        System.out.println(twoPointerSol(test2));
        System.out.println(twoPointerSol(test3));
        System.out.println(twoPointerSol(test4));
        System.out.println(twoPointerSol(test5));
    }
    // Time Complexity : O(n^3)
    // Space Complexity : O(1)
    /*
        Logic:
        1. We will iterate over the array and for each element we will check if there is a triplet that sums to 0.
        2. To check if there is a triplet that sums to 0, we will iterate over the array again and for each element we will check if there is a pair that sums to the negative of the current element.
        3. To check if there is a pair that sums to the negative of the current element, we will iterate over the array again and for each element we will check if there is an element that sums to the negative of the current element.
        4. If we find a triplet that sums to 0, we will add it to the result.
        5. We will return the result.
     */
    private static List<List<Integer>> twoPointerSol(int[] nums){
        if (nums.length < 2) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i+1;
                int high = nums.length-1;
                int currSum = -nums[i];

                while(low < high){
                    if(nums[low] + nums[high]  == currSum){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(high > low && nums[high] == nums[high-1]) high--;
                        high--;
                        low++;
                    }else if(nums[high] + nums[low] > currSum) high--;
                    else low++;
                }
            }
        }
        return res;
    }
}