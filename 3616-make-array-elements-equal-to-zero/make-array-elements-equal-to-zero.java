class Solution {

    boolean check(int[] nums, int count, int i, int dir){
        int[] temp = nums.clone();
        int idx = i;

        while(idx >= 0 && idx < nums.length && count > 0){
            if(temp[idx] > 0){
                temp[idx]--;

                if(temp[idx] == 0){
                    count--;
                }
                dir *= -1;
            }
            idx += dir;
        }
        return count == 0;
    }
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                count++;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                if(check(nums, count, i, -1))
                    ans++;
                if(check(nums, count, i, +1))
                    ans++;
            }
        }
        return ans;
    }
}