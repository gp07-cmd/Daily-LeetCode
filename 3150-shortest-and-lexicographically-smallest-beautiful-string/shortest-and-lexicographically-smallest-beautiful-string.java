class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int one = 0;
        String ans = "";

        for(int right = 0; right < n; right++) {
            if(s.charAt(right) == '1')
                one++;

            while(one > k) {
                if(s.charAt(left) == '1')
                    one--;
                left++;
            }

            while(one == k && s.charAt(left) == '0')
                left++;

            if(one == k) {
                String curr = s.substring(left, right + 1);

                if(ans.equals("") || curr.length() < ans.length() ||
                   (curr.length() == ans.length() && curr.compareTo(ans) < 0))
                    ans = curr;
            }
        }

        return ans;
    }
}