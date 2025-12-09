class Solution {

    final int M = 1_000_000_007;

    public int specialTriplets(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();

        long result = 0;

        for(int num : nums){
            right.put(num, right.getOrDefault(num, 0) + 1);
        }

        for(int num: nums){
            right.put(num, right.get(num) - 1);

            int tar = num * 2;

            int l = left.getOrDefault(tar, 0);
            int r = right.getOrDefault(tar, 0);

            result = (result + (1L * l * r)) % M;

            left.put(num, left.getOrDefault(num, 0) + 1);
        }
        return (int)result;
    }
}