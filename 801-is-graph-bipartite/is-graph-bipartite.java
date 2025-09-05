class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] color = new int[size];
        Arrays.fill(color, -1);

        for(int i = 0; i < size; i++){
            if(color[i] == -1){
                if(checkBiparBFS(graph, i, color, 1) == false){
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkBiparBFS(int[][] graph, int curr, int[] color, int currColor){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        color[curr] = currColor;

        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int neigh: graph[u]){
                if(color[neigh] == color[u]){
                    return false;
                }
                else if(color[neigh] == -1){//never colored
                    color[neigh] = 1 - color[u];
                    queue.offer(neigh);
                } 
            }
        }
        return true;
    }
}