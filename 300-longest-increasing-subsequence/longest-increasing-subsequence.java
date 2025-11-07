class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int prev = -1;
        
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0;i <= n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }

        return solve(nums, 0, prev, n, dp);
    }

    public int solve(int[] nums, int curr, int prev, int n, int[][] dp){

        if(curr >= n) return 0;

        if(prev != - 1 && dp[curr][prev] != -1) return dp[curr][prev];
        
        int take = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + solve(nums, curr + 1, curr, n, dp);
        }
        int skip = solve(nums, curr + 1, prev, n, dp);

        if(prev != -1)
            dp[curr][prev] =  Math.max(take, skip);
            
        return  Math.max(take, skip);
    }
}