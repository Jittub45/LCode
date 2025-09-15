class Solution {
    public int minCostConnectPoints(int[][] points) {
        int v = points.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < v; i++){
            for(int j = i + 1; j < v; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new int[]{j, d});
                adj.get(j).add(new int[]{i, d});
            }
        }

        return PrimsAlgo(adj, v);
    }

    int PrimsAlgo(ArrayList<ArrayList<int[]>> adj, int v){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, 0});
        boolean[] inMST = new boolean[v];
        int sum = 0;

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int wt = p[0];
            int node = p[1];

            if(inMST[node]){
                continue;
            }

            inMST[node] = true;
            sum += wt;

            for(int[] edge : adj.get(node)){
                int neigh = edge[0];
                int neigh_wt = edge[1];

                if(!inMST[neigh]){
                    pq.add(new int[]{neigh_wt, neigh});
                }
            }
        }
        return sum;
    }
}