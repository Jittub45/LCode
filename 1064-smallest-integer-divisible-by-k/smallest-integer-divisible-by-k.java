class Solution {
    public int smallestRepunitDivByK(int k) {
        int num = 0;  
        for(int l = 1; l <= k; l++){
            num = (num * 10 + 1 ) % k;
            if(num == 0)
                return l;
        }
        return -1;
    }
}