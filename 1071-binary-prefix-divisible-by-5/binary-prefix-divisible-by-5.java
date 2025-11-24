class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int curr = 0;
        ArrayList<Boolean> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            curr = (curr * 2 + nums[i]) % 5;
            if(curr == 0){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}