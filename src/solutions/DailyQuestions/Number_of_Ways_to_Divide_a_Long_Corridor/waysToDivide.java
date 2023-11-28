// Problem Link: https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
package src.solutions.DailyQuestions.Number_of_Ways_to_Divide_a_Long_Corridor;

public class waysToDivide{
    public static void main(String[] args){
        String corridor_1 = "SSPPSPS";
        String corridor_2 = "PPSPSP";
        String corridor_3 = "S";
        Solution s = new Solution();
        System.out.println("Test 1: " + (s.numberOfWays(corridor_1) == 3));
        System.out.println("Test 2: " + (s.numberOfWays(corridor_2) == 1));
        System.out.println("Test 3: " + (s.numberOfWays(corridor_3) == 0));
    }
}
// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution{
    int MOD = (int) 1e9 + 7;
    public int numberOfWays(String corridor){
        int totalChairs = 0;
        long result = 1;
        char[] corArr = corridor.toCharArray();
        int len = corArr.length;
        for(int i = 0; i < corArr.length; i++){
            if(corArr[i] == 'S'){
                totalChairs++;
                // Skip the plants
                while(++i < len && corArr[i] != 'S');
                // If encountered with an adjacent chair increase the chair count
                if(i < len && corArr[i] == 'S') totalChairs++;
                int divisions = 1;
                // Till another chair is encountered we will increase the number of divisions we can create
                /* For example:
                    SSPPPPSPS
                    SSP|PPPSPS
                    SSPP|PPSPS
                    SSPPP|PSPS
                    SSPPPP|SPS
                */
                while(++i < len && corArr[i] != 'S'){
                    divisions++;
                }

                if(divisions > 1 && i < len){
                    result = (result * divisions) % MOD;
                }
                i--;
            }
        }
        return (totalChairs!=0 && totalChairs % 2 == 0) ? (int) result : (int) 0;
    }
}