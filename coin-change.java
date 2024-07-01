//TC - O(m*n)
//SC - O(m*n)
//https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int dp[][] = new int[m+1][n+1];

        for(int i = 1; i <=n ; i++) {
            dp[0][i] = amount+1;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        return dp[m][n] > amount? -1: dp[m][n];
    }
}
