public class KnapsackDP {

    public static int knapsack(int[] profit, int[] weight, int W) {
        int n = profit.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i-1][w],
                               profit[i-1] + dp[i-1][w - weight[i-1]]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;
        System.out.println("Maximum Profit: " + knapsack(profit, weight, W));
    }
}
