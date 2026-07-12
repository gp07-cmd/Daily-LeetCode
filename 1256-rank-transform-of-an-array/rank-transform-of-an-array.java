class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return arr;

        int[] out = new int[arr.length], copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0, j = 1; i < copy.length; i++)if (!map.containsKey(copy[i])) map.put(copy[i], j++);
        for (int i = 0; i < arr.length; i++)out[i] = map.get(arr[i]);

        return out;
    }
}