class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int n : nums) l.add(n);
        int c = 0;
        
        while (true) {
            boolean s = true;
            for (int i = 0; i < l.size() - 1; i++) {
                if (l.get(i) > l.get(i + 1)) {
                    s = false;
                    break;
                }
            }
            if (s) return c;
            
            int m = Integer.MAX_VALUE;
            int idx = -1;
            
            for (int i = 0; i < l.size() - 1; i++) {
                int sum = l.get(i) + l.get(i + 1);
                if (sum < m) {
                    m = sum;
                    idx = i;
                }
            }
            
            l.set(idx, m);
            l.remove(idx + 1);
            c++;
        }
    }
}