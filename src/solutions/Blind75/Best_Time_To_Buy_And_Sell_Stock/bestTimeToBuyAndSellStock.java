package src.solutions.Blind75.Best_Time_To_Buy_And_Sell_Stock;

class bestTimeToBuyAndSellStock{
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int[] prices_2 = {7,6,4,3,1};
        Solution s = new Solution();
        System.out.println("Test 1: " + (s.maxProfit(prices) == 5));
        System.out.println("Test 2: " + (s.maxProfit(prices_2) == 0));
    }
}
// Time Complexity : O(n)
// Space Complexity : O(1)
/*
    Logic:
    1. Maintain two variable for minPrice of stock on a day and a maxProfit which will store the maxProfit we can make
    2. If current Price from the prices array is less than minPrice then update the minPrice variable.
    3. Otherwise, check of current price - minPrice is greater than maxProfit if true then update the maxProfit variable.
    4. Return the maxProfit.
*/
class Solution{
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price <= minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}