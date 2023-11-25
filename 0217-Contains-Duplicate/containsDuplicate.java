// Problem Link: https://leetcode.com/problems/contains-duplicate/
import java.util.*;

class containsDuplicate{
    public static void main(String[] args){
        int[] test1 = {1,2,3,1};
        int[] test2 = {1,2,3,4};
        int[] test3 = {1,1,1,3,3,4,3,2,4,2};
        //Brute Force
        System.out.println("Brute Force Result:");
        System.out.println(bruteForce(test1));
        System.out.println(bruteForce(test2));
        System.out.println(bruteForce(test3));
        //Optimal Solution
        System.out.println("Optimal Solution Result:");
        System.out.println(optimalSol(test1));
        System.out.println(optimalSol(test2));
        System.out.println(optimalSol(test3));
    }



    // Time Complexity : O(n)
    // Space Complexity : Worst case O(n)
    // The logic behind this is that we will add the number to set or map and if we find the same number again we will return true, i.e. the number is duplicate
    private static boolean optimalSol(int[] nums){
        //Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
//            if(map.containsKey(num)){
//                return true;
//            }
//            map.put(num, 1);
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    // Time Complexity : O(nlogn)
    // Space Complexity : O(1)
    private static boolean bruteForce(int[] nums){
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}