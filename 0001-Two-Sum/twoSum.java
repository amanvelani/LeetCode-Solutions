import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class twoSum{
    public static void main(String[] args){
        int[] test1 = {2,7,11,15};
        int[] test2 = {3,2,4};
        int[] test3 = {3,3};
        int target1 = 9;
        int target2 = 6;
        int target3 = 6;
        // Brute Force
        System.out.println("Brute Force Result:");
        System.out.println(Arrays.toString(bruteForce(test1, target1)));
        System.out.println(Arrays.toString(bruteForce(test2, target2)));
        System.out.println(Arrays.toString(bruteForce(test3, target3)));
        //Optimal Solution
        System.out.println("Optimal Solution Result:");
        System.out.println(Arrays.toString(optimalSol(test1, target1)));
        System.out.println(Arrays.toString(optimalSol(test2, target2)));
        System.out.println(Arrays.toString(optimalSol(test3, target3)));
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // In the optimal solution we are using a hashmap to store the complement of the current number and the index of the current number. If the complement is present in the map, we return the index of the complement and the current index.
    private static int[] optimalSol(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }


    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    private static int[] bruteForce(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}