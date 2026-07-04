class Solution {
    public int minScore(int n, int[][] roads) {
        int[] isVisited = new int[n + 1];

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        Queue<Integer> q = new LinkedList<>();
        int minV = Integer.MAX_VALUE;

        isVisited[1] = 1;
        q.add(1);

        return bfs(graph, isVisited, q, minV);
    }

    private int bfs(List<int[]>[] graph, int[] isVisited, Queue<Integer> q, int minV) {
        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int[] road : graph[curr]) {
                minV = Math.min(minV, road[1]);

                if (isVisited[road[0]] == 0) {
                    isVisited[road[0]] = 1;
                    q.add(road[0]);
                }
            }
        }

        return minV;
    }
}