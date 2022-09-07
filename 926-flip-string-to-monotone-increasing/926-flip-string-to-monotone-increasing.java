class Solution {
    public int minFlipsMonoIncr(String S) {
        if (S.length() <= 1) return 0;
        int dp = 0;
        int countOne = S.charAt(0) - '0';        
        int n = S.length();
        for (int i = 1; i < n; ++i) {
            if (S.charAt(i) == '0') {
                int x = dp + 1;   // flip this '0' bit to '1'
                dp = Math.min(x, countOne);  // or, maybe flip all previous ones to '0'
            } else {
                ++countOne;
            }
        }
        
        return dp;
    }
}