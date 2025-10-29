class Solution {

    public int helper(int[] nums){
    
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i <= n; i++){
            int steal = nums[i - 1] + dp[i - 2];
            int skip = dp[i - 1];

            dp[i] = Math.max(steal, skip);
        }
        return dp[n];
    }


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        for(int i = 0; i < n; i++){
            if(i != 0){
                arr1[i - 1] = nums[i];
            }
            if(i != n - 1){
                arr2[i] = nums[i];
            }
        }
        return Math.max(helper(arr1), helper(arr2));
    }
}