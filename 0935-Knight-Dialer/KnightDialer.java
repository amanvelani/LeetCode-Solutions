import java.util.HashMap;
import java.util.Map;

class KnightDialer{
    public static void main(String[] args){
        int test = 1;
        int test1 = 2;
        int test2 = 3131;
        int i = 1;
        Solution s = new Solution();
        System.out.println("Test " + i++ + ": " + (s.knightDialer(test) == 10));
        System.out.println("Test " + i++ + ": " + (s.knightDialer(test1) == 20));
        System.out.println("Test " + i++ + ": " + (s.knightDialer(test2) == 136006598));
    }
}
/*
        1   2   3
        4   5   6
        7   8   9
            0

*/
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution{
    int n;
    //int[][] dp;
    Map<String, Integer> dp;
    int MOD = (int) 1e9 + 7;
    // Possible jumps from each square 0,1,2,3,4,5,6,7,8,9
    int[][] possibleJumps = new int[][]{
            {4,6},
            {6,8},
            {7,9},
            {8,4},
            {3,9,0},
            {},
            {1,7,0},
            {6,2},
            {1,3},
            {4,2}
    };

    /*
        Iterate through each square and add the number of possible paths from each square to the result and decrease the number of remaining squares by 1.
    */
    public int knightDialer(int n){
        this.n = n;
        // dp = new int[n+1][10];
        dp = new HashMap<>();
        int result = 0;

        for(int currentSquare = 0; currentSquare < 10; currentSquare++){
            result = (result + helper(n-1, currentSquare)) % MOD;
        }

        return result;
    }

    /*
        Helper function to calculate the number of possible paths from each square.
        - If the remaining squares is 0, then we have reached the end of the path, and we return 1.
        - If the dp array already contains the number of possible paths from the current square, then we return the value.
        - Otherwise, we iterate through each possible jump from the current square and add the number of possible paths from each jump to the result.
        - We store the result in the dp array and return the result.
    */
    private int helper(int remainingSquare, int currentSquare){
        if(remainingSquare == 0) return 1;
        String key = remainingSquare + "," + currentSquare;
        /*
            if(dp[remainingSquare][currentSquare] != 0) return dp[remainingSquare][currentSquare];
        */
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int result = 0;
        for(int nextPossibleSquare : possibleJumps[currentSquare]){
            result = (result + helper(remainingSquare-1, nextPossibleSquare))% MOD;
        }
        /*
            dp[remainingSquare][currentSquare] = result;
        */
        dp.put(key, result);
        return result;
    }
}