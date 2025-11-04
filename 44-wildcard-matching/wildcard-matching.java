class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length() - 1;
        int n = p.length() - 1;

        Boolean[][] dp = new Boolean[m + 1][n + 1];

        return solve(s, p, m, n, dp);        
    }

    boolean solve(String s, String p, int m , int n, Boolean[][] dp){
        if(m < 0 && n < 0){
            return true;
        }

        if(m >= 0 && n < 0){
            return false;
        }

        if(m < 0 && n >= 0){
            for(int i = 0; i <= n; i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[m][n] != null){
            return dp[m][n];
        }
        
        // Matching pattern contn

        if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '?'){
            return dp[m][n] = solve(s, p, m - 1, n - 1, dp);
        }
        else if(p.charAt(n) == '*'){
            return dp[m][n] = (solve(s, p, m, n - 1, dp) || solve(s, p, m - 1, n, dp));
        }
        else{
            return false;
        }
    }
}