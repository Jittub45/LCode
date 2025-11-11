class Solution {
    public int[][] floodFill(int[][] ans, int sr, int sc, int color) {
        int iniCol = ans[sr][sc];
        // int[][] ans = image;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        solve(sr, sc, ans, color, iniCol, delRow, delCol);
        return ans;
    }

    public void solve(int sr, int sc, int[][] ans, int newCol, int iniCol, int[] delRow, int[] delCol){
        int m = ans.length;
        int n = ans[0].length;

        ans[sr][sc] = newCol;
        for(int i = 0; i < 4; i++){
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];

            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && ans[nrow][ncol] == iniCol && ans[nrow][ncol] != newCol){
                solve(nrow, ncol, ans, newCol, iniCol, delRow, delCol);
            }
        }
    }
}