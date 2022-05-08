class Solution {
    public int minCut(String s) {
     	return topDown(s, 0, s.length() - 1, new Integer[s.length() + 1][s.length() + 1]);
	}

	private int topDown(String s, int i, int j, Integer[][] memo) {
		if (i > j) {
			return 0;
		}
		if (memo[i][j] != null) {
			return memo[i][j];
		}
		if (isPalindrome(s, i, j)) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			if (isPalindrome(s, i, k)) {
				int ans2 = 1 + topDown(s, k + 1, j, memo);
				min = Math.min(min, ans2);
				memo[i][j] = min;
			}
		}
		return min;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}