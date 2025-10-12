class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] t = new int[n + 1][amount + 1];

        for(int j = 0; j <= amount; j++){
            t[0][j] = Integer.MAX_VALUE - 1;            
        }

        for(int i = 0; i <= n; i++){
            t[i][0] = 0;
        }

        for(int j = 1; j <= amount; j++){
            if(j % coins[0] == 0){
                t[1][j] = j / coins[0];
            } else {
                t[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i - 1] <= j){
                    t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
                }
                else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        if(t[n][amount] == Integer.MAX_VALUE - 1){
            return - 1;
        }
        else {
            return t[n][amount];
        }
    }
}