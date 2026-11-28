class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int min = Integer.MAX_VALUE;

        for(int[] item : items){
            freq[item[0]]++;
            min = Math.min(min, item[1]);
        }

        int[] mul = new int[n + 1];

        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j += i){
                mul[i] += freq[j];
            }
        }

        List<int[]> deals = new ArrayList<>();

        for(int[] item : items){
            int fact = item[0];
            int pri = item[1];

            int gifts = mul[fact] - 1;

            if(gifts > 0 && pri < 2L * min){
                deals.add(new int[]{pri, gifts});
            }
        }
        deals.sort((a, b) -> Integer.compare(a[0], b[0]));
        long ans = 0;

        for(int[] deal : deals){
            int pri = deal[0];
            int gifts = deal[1];
            long buy = Math.min(gifts, budget / pri);

            ans += buy * 2;
            budget -= (int) (buy * pri);
        }
        ans += budget / min;

        return (int) ans;
    }
}