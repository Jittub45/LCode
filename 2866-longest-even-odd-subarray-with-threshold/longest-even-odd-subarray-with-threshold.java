class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) { 
                int len = 0;
                int j = i;
                int expectedParity = 0; 
                while (j < n && nums[j] <= threshold && nums[j] % 2 == expectedParity) {
                    len++;
                    expectedParity ^= 1; 
                    j++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
