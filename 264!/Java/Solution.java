/*
    !!!264
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int l = 1; l < n; l++) {
            int temp = 2 * dp[i] < 3 * dp[j] ? (2 * dp[i] < 5 * dp[k] ? 2 * dp[i] : 5 * dp[k]) : (3 * dp[j] < 5 * dp[k] ? 3 * dp[j] : 5 * dp[k]);
            dp[l] = temp;

            if(2 * dp[i] == temp)   i++;
            if(3 * dp[j] == temp)   j++;
            if(5 * dp[k] == temp)   k++;
        }
        return dp[n-1];
    }
}
