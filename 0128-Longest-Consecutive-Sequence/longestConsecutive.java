import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class longestConsecutive{
    public static void main(String[] args){
        int[] test1 = {100,4,200,1,3,2};
        int[] test2 = {0,3,7,2,5,8,4,6,0,1};
        int[] test3 = {0,0};
        // Optimal Solution
        System.out.println("Optimal Solution Result:");
        System.out.println(longestConsecutiveOptimal(test1));
        System.out.println(longestConsecutiveOptimal(test2));
        System.out.println(longestConsecutiveOptimal(test3));
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    private static int longestConsecutiveOptimal(int[] nums){
        Set<Integer> set = new HashSet<>();
        int maxSeq = 0;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int num : nums){
            int currMaxSeq = 1;
            int currentNum = num;

            while(set.contains(--currentNum)){
                currMaxSeq++;
                set.remove(currentNum);
            }

            currentNum = num;

            while(set.contains(++currentNum)){
                currMaxSeq++;
                set.remove(currentNum);
            }

            maxSeq = Math.max(maxSeq, currMaxSeq);

        }

        return maxSeq;
    }

}