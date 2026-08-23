class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (i < n / 2 && num.charAt(i) != '?') {
                sum += num.charAt(i) - '0';
            }

            if (i >= n / 2 && num.charAt(i) != '?') {
                sum -= num.charAt(i) - '0';
            }

            if (num.charAt(i) == '?') {
                if (i < n / 2) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }

        return (sum * 2 + cnt * 9) != 0;
    }
}