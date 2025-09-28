import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Step 1. Build adj list -> graph 
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Build indegree and outdegree
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for (int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1];

            // make sure u has a list before adding
            if (!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);

            // update outdegree
            if (!outdegree.containsKey(u)) {
                outdegree.put(u, 0);
            }
            outdegree.put(u, outdegree.get(u) + 1);

            // update indegree
            if (!indegree.containsKey(v)) {
                indegree.put(v, 0);
            }
            indegree.put(v, indegree.get(v) + 1);
        }

        // Find the start node
        int startNode = pairs[0][0];
        for (int node : adj.keySet()) {
            int out = outdegree.containsKey(node) ? outdegree.get(node) : 0;
            int in = indegree.containsKey(node) ? indegree.get(node) : 0;
            if (out - in == 1) {
                startNode = node;
                break;
            }
        }

        // Final DFS traversal 
        List<Integer> EulerPath = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(startNode);

        while (!st.isEmpty()) {
            int curr = st.peek();
            List<Integer> neighbors = adj.containsKey(curr) ? adj.get(curr) : new ArrayList<>();
            if (!neighbors.isEmpty()) {
                int nbr = neighbors.remove(neighbors.size() - 1);
                st.push(nbr);
            } else {
                EulerPath.add(curr);
                st.pop();
            }
        }

        // Build your result
        Collections.reverse(EulerPath);
        int[][] result = new int[EulerPath.size() - 1][2];
        for (int i = 0; i < EulerPath.size() - 1; i++) {
            result[i][0] = EulerPath.get(i);
            result[i][1] = EulerPath.get(i + 1);
        }

        return result;
    }
}
