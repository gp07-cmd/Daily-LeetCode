class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] inv) { 
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); 
        }

        for(int i = 0; i < inv.length; i++) {
            adj.get(inv[i][0]).add(inv[i][1]); 
        }
        boolean vis[] = new boolean[n + 1]; 
        dfs(adj, k, vis); 
        boolean flag = true; 
        for(int i = 0; i < inv.length; i++) {
            int u = inv[i][0], v = inv[i][1]; 
            if(!vis[u]) { 
                if(vis[v]) {
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

        vis[k] = true; 
        for(Integer i: adj.get(k)) {
            if(!vis[i]) dfs(adj, i, vis); 
        }
    }
}