class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        return lcs(s, rev);
    }

    public int lcs(String s, String rev){
        int i = s.length();
        int j = rev.length();

        int[][] dp = new int[i + 1][j + 1];
        for(int k = 0; k < i; k++){
            for(int l = 0; l < j; l++){
                if(k == 0 || l == 0){
                    dp[k][l] = 0;
                }
            }
        }

        for(int k = 1; k <= i; k++){
            for(int l = 1; l <= j; l++){
                if(s.charAt(k - 1) == rev.charAt(l - 1)){
                    dp[k][l] = 1 + dp[k - 1][l - 1];
                }
                else{
                    dp[k][l] = Math.max(dp[k - 1][l], dp[k][l - 1]);
                }
            }
        }
        return dp[i][j];
    }
}