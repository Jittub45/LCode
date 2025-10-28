class Solution {
    public int countValidSelections(int[] nums) {

        int n = nums.length;
        int result = 0, curr = 0, sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        
        for(int i = 0; i < n; i++){
            curr += nums[i];

            int left = curr;
            int right = sum - curr;

            if(nums[i] != 0)                       
                continue;

            if(left == right)
                result+= 2;

            if(Math.abs(left - right) == 1)
                result += 1;
        }
        return result;
    }
}