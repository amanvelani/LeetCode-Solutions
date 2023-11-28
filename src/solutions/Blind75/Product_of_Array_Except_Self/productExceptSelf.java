package src.solutions.Blind75.Product_of_Array_Except_Self;

import java.util.Arrays;

class productExceptSelf{
    public static void main(String[] args){
        int[] test1 = {1,2,3,4};
        int[] test2 = {-1,1,0,-3,3};
        // Initial Solution
        System.out.println("Initial Solution Result:");
        System.out.println(Arrays.toString(pExceptSelf(test1)));
        System.out.println(Arrays.toString(pExceptSelf(test2)));
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    private static int[] pExceptSelf(int[] nums){
        int preProd = 1;
        int postProd = 1;
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            // Logic : 
            // 1. We will iterate over the array and calculate the product of all the numbers before the current number.
            // 2. We will iterate over the array from the end and calculate the product of all the numbers after the current number.
            // 3. We will multiply the product of numbers before and after the current number to get the product of all the numbers except the current number.
            if(i > 0){
                preProd *= nums[i-1];
            }
            res[i] = preProd;
        }

        for(int j = n-1; j >= 0; j--){
            if(j < n-1){
                postProd *= nums[j+1];
            }
            res[j] *= postProd;
        }

        return res;

    }
}