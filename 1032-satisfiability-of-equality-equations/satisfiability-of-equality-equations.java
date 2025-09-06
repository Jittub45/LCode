class Solution {

    int find(int i, int[] parent){
            if(i == parent[i]){
                return i;
            }
            return parent[i] = find(parent[i], parent);
        }

        void union(int x, int y, int[] parent, int[] rank){
            int x_parent = find(x, parent);
            int y_parent = find(y, parent);

            if(x_parent == y_parent){
                return;
            }

            if(rank[x_parent] > rank[y_parent]){
                parent[y_parent] = x_parent;
            }
            else if (rank[x_parent]  < rank[y_parent]){
                parent[x_parent] = y_parent;
            }
            else{
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
        }

    public boolean equationsPossible(String[] equations) {

        int[] parent = new int[26];
        int[] rank = new int[26];

        for(int i = 0; i < 26; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        // First union karo jo equal chars hai
        for(String str : equations){
            if(str.charAt(1) == '='){ // "a == b"
                union(str.charAt(0) - 'a', str.charAt(3)- 'a', parent, rank);
            }
        }
        //Find != wale cases and chek validity 
        for(String str : equations){
            if(str.charAt(1) == '!'){ //" a != b "
                char first = str.charAt(0);
                char last = str.charAt(3);

                int parent_fist = find(first - 'a', parent);
                int parent_last = find(last - 'a', parent);

                if(parent_fist == parent_last){
                    return false;
                }
            }
        }
        return true;
    }
}