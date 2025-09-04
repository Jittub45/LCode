class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int count = 0;

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < v; i++) {
            adj.put(i, new ArrayList<>());
            for (int j = 0; j < v; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                dfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i,boolean[] visited, HashMap<Integer, List<Integer>> adj){
        visited[i] = true;
        for(int neigh: adj.get(i)){
            if(!visited[neigh]){
                dfs(neigh, visited, adj);
            }
        }
    }
}