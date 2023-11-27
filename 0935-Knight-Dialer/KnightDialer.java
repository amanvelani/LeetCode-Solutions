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
class Solution{
    int n;
    //int[][] dp;
    Map<String, Integer> dp;
    int MOD = (int) 1e9 + 7;
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