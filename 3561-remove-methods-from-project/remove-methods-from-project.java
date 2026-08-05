class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] inv) {
        // remove all that are only invoked by `k` 
        // and k should be 

        // step 1. find all suspecius. 
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); 
        }

        for(int i = 0; i < inv.length; i++) {
            adj.get(inv[i][0]).add(inv[i][1]); 
        }

        // Now find all elements that can be accesses from `k` 
        boolean vis[] = new boolean[n + 1]; 
        dfs(adj, k, vis); 
        boolean flag = true; 
        // Now I need to check if there is any link with some outer node. 
        for(int i = 0; i < inv.length; i++) {
            int u = inv[i][0], v = inv[i][1]; 
            if(!vis[u]) {
                // outside grp 
                if(vis[v]) {
                    // inside grp 
                    // then we don't remove anything. 
                    flag = false; 
                }
            }
        }

        List<Integer> ans = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            if(flag && vis[i]) continue; 
            ans.add(i);
        }
        return ans; 
    }

    private void dfs(List<List<Integer>> adj, int k, boolean[] vis) {
        if(vis[k]) return; 

        vis[k] = true; // mark visited 
        for(Integer i: adj.get(k)) {
            if(!vis[i]) dfs(adj, i, vis); 
        }
    }
}