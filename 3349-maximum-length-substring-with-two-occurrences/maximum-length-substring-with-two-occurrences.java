class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLength = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        for (int right = 0; right < n; right++) {
            mp.put(s.charAt(right), mp.getOrDefault(s.charAt(right), 0) + 1);

            while (mp.get(s.charAt(right)) > 2) {
                char leftChar = s.charAt(left);

                mp.put(leftChar, mp.get(leftChar) - 1);

                if (mp.get(leftChar) == 0) {
                    mp.remove(leftChar);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}