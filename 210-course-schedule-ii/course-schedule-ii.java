class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++)        {
            adj.put(i, new ArrayList<>());
        }

        for(int[] node : prerequisites){
            int start = node[0];
            int end = node[1];

            adj.get(end).add(start);
            indegree[start]++;
        }
        return topologicalSort(adj, numCourses, indegree);
    }

    private int[] topologicalSort(HashMap<Integer, List<Integer>> adj, int n, int[] indegree){
        Queue<Integer> queue = new LinkedList<>();
        int[] order = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            order[count++] = u;

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        if(count == n){
            return order;
        }
        return new int[0];
    }
        

}