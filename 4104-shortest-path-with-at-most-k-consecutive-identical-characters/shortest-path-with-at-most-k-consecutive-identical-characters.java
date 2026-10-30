class Solution {

    class State {
        int node, count, dist;

        State(int node, int count, int dist) {
            this.node = node;
            this.count = count;
            this.dist = dist;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int[] head = new int[n];
        Arrays.fill(head, -1);

        int m = edges.length;
        int[] to = new int[m];
        int[] weight = new int[m];
        int[] next = new int[m];

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];

            to[i] = edges[i][1];
            weight[i] = edges[i][2];
            next[i] = head[u];
            head[u] = i;
        }

        int[][] dist = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int startCount = 1;
        dist[0][startCount] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.dist, b.dist));

        pq.offer(new State(0, startCount, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            int u = curr.node;
            int cnt = curr.count;
            int d = curr.dist;

            if (d != dist[u][cnt]) {
                continue;
            }

            if (u == n - 1) {
                return d;
            }

            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                int w = weight[e];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = cnt + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                int newDist = d + w;

                if (newDist < dist[v][newCount]) {
                    dist[v][newCount] = newDist;
                    pq.offer(new State(
                            v, newCount, newDist));
                }
            }
        }

        return -1;
    }
}