class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key: map.keySet()){
            if(map.get(key) == 2){
                result.add(key);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;       
    }
}