package src.solutions.DailyQuestions.Minimum_One_Bit_Operations_to_Make_Integers_Zero;
public class minimumOneBitOperations {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("Test 1: " + (s.minimumOneBitOperations(0) == 0));
        System.out.println("Test 2: " + (s.minimumOneBitOperations(3) == 2));
        System.out.println("Test 3: " + (s.minimumOneBitOperations(6) == 4));
        System.out.println("Test 4: " + (s.minimumOneBitOperations(9) == 14));
        System.out.println("Test 5: " + (s.minimumOneBitOperations(333) == 393));
    }
}

// Time Complexity : O(logn)
// Space Complexity : O(1)
/*
   Approach:
    1. If n is less than or equal to 1, the result is n itself because no operations are needed in this case.
    2. Initialize a variable count to 0 and iterate until (1 << count) <= n to find the position of the leftmost set bit in the binary representation of n.
    3. Calculate the result as ((1 << count) - 1) - minimumOneBitOperations(n - (1 << (count - 1))). This recursive formula considers the leftmost set bit and calculates the result for the remaining bits.
    4. The recursive approach ensures that we consider all possible combinations of operations to minimize the total number of operations.
*/

class Solution{
    public int minimumOneBitOperations(int n) {
        if (n <= 1) return n;
        int count = 0;
        while ((1<<count) <= n) count++;
        return ((1<<count)-1) - minimumOneBitOperations(n-(1<<(count-1)));
    }
}