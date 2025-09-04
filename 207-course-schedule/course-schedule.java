class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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

    private boolean topologicalSort(HashMap<Integer, List<Integer>> adj, int n, int[] indegree){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                count++;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();


            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    count++;
                    queue.offer(v);
                }
            }
        }
        if(count == n){
            return true;
        }
        return false;
    }

}