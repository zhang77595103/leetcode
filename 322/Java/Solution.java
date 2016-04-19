/*
    just dp solution.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(coins.length == 0 ){
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int i = 1;

        while(i < amount + 1){
            int better = -1;
            for(int each : coins){
                if(each > i || dp[i - each] == -1){
                    continue;
                }
                if(dp[i - each] + 1 < better || better == -1){
                    better = dp[i - each] + 1;
                }
            }
            dp[i++] = better;
        }
        return dp[amount];
    }
}
