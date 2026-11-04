import java.util.*;

class Solution {
    class MedianWindow {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();
        int lowSize, highSize;
        long lowSum, highSum;

        void addMap(TreeMap<Integer, Integer> map, int x) {
            map.merge(x, 1, Integer::sum);
        }

        void removeMap(TreeMap<Integer, Integer> map, int x) {
            int count = map.get(x);
            if (count == 1) map.remove(x);
            else map.put(x, count - 1);
        }

        void add(int x) {
            if (low.isEmpty() || x <= low.lastKey()) {
                addMap(low, x);
                lowSize++;
                lowSum += x;
            } else {
                addMap(high, x);
                highSize++;
                highSum += x;
            }
            balance();
        }

        void remove(int x) {
            if (low.containsKey(x)) {
                removeMap(low, x);
                lowSize--;
                lowSum -= x;
            } else {
                removeMap(high, x);
                highSize--;
                highSum -= x;
            }
            balance();
        }

        void balance() {
            while (lowSize > highSize + 1) {
                int x = low.lastKey();
                removeMap(low, x);
                lowSize--;
                lowSum -= x;

                addMap(high, x);
                highSize++;
                highSum += x;
            }

            while (lowSize < highSize) {
                int x = high.firstKey();
                removeMap(high, x);
                highSize--;
                highSum -= x;

                addMap(low, x);
                lowSize++;
                lowSum += x;
            }
        }

        long cost() {
            long median = low.lastKey();
            return median * lowSize - lowSum + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int[] maritovexi = nums;
        int n = maritovexi.length;

        MedianWindow window = new MedianWindow();
        long[] costs = new long[n - x + 1];

        for (int i = 0; i < n; i++) {
            window.add(maritovexi[i]);

            if (i >= x) window.remove(maritovexi[i - x]);

            if (i >= x - 1)
                costs[i - x + 1] = window.cost();
        }

        long inf = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int t = 1; t <= k; t++) {
            Arrays.fill(curr, inf);

            for (int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != inf) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + costs[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}