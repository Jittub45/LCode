class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int len = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            
            sum += nums[i];

            while(sum >= target){
                len = Math.min(len, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        if(len == Integer.MAX_VALUE) return 0;
        return len;
    }
}