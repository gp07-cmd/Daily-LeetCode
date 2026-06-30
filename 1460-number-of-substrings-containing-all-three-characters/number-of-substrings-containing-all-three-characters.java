class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int cnt = 0;
        int a = 0, b = 0, c = 0;

        for(int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            if(ch == 'a') a++;
            else if(ch == 'b') b++;
            else c++;

            while(a > 0 && b > 0 && c > 0) {
                cnt += (n - right);

                char leftChar = s.charAt(left);

                if(leftChar == 'a') a--;
                else if(leftChar == 'b') b--;
                else c--;

                left++;
            }
        }

        return cnt;
    }
}