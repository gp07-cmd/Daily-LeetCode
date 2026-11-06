class Solution {
    private static class Query {
        int q;
        int id;
        public Query(int q, int id) {
            this.q = q; 
            this.id = id; 
        }
    }
    public int[] countServers(int n, int[][] logs, int x, int[] ans) {

        Query[] queries = new Query[ans.length];
        for(int i = 0; i < queries.length; i++) {
            queries[i] = new Query(ans[i],i);
        }
      
        Arrays.sort(queries, (a,b) -> a.q-b.q);
        Arrays.sort(logs, (a,b) -> a[1]-b[1]);
        int left = 0; 
        int right = 0; 
        int active = 0; 
        int[] lastRequest = new int[n+1];
        Arrays.fill(lastRequest, -1); 
        for(int i = 0; i < queries.length; i++) {
            while(left < logs.length && logs[left][1] < queries[i].q-x) {
                if(lastRequest[logs[left][0]] == logs[left][1]) {
                    lastRequest[logs[left][0]] = -1;
                    active--;
                }
                left++;
            }
            if(right < left) right = left; 
            while(right < logs.length && logs[right][1] <= queries[i].q) {
                if(lastRequest[logs[right][0]] == -1) active++;
                lastRequest[logs[right][0]] = logs[right][1];
                right++;
            }
            ans[queries[i].id] = n-active;
        }
        return ans;
    }
}