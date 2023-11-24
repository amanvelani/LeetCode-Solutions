// Problem Link: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/


public class maxCoinsYouCanGet {
    public static void main(String[] args){
        int[] piles = {2,4,1,2,7,8};
        int[] piles1 = {9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(piles));
        System.out.println(maxCoins(piles1));
    }
    /* 1 2 2 4 7 8
        n = 5
        i = 2
        So I can choose 2 and 7 to get the max Coins
        Alice will have 8 and 4
        Bob will have 1 and 2
    */
    // TC = O(nlogn)
    // SC = O(n)
//    private static int maxCoins(int [] piles){
//        Arrays.sort(piles);
//        int max = 0;
//        int n = piles.length;
//        for(int i = n/3; i < n; i += 2){
//            max += piles[i];
//        }
//        return max;
//    }

//    Time Complexity: O(n + max)
//    Space Complexity: O(max)
    private static int maxCoins(int[] piles){
        int max = 0;
        for(int i : piles){
            max = Math.max(max, i);
        }
        int[] numFreq = new int[max+1];
        for(int n : piles){
            numFreq[n]++;
        }
        int n = piles.length;
        int totalChance = n / 3;
        int res = 0;
        int aliceChance = 1;
        int i = max;

        while(totalChance > 0){
            if(numFreq[i] > 0){
                if(aliceChance == 1) aliceChance = 0;
                else{
                    totalChance--;
                    aliceChance = 1;
                    res += i;
                }
                numFreq[i]--;
            }else{
                i--;
            }
        }
        return res;
    }

}
