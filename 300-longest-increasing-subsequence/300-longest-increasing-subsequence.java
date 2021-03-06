class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
           	   	if (nums == null | nums.length == 0)
		return 0;
	int  len = 0;
	int[] increasingSequence = new int[n];
	increasingSequence[len++] = nums[0];
	for (int i = 1; i < n; i++) {
		if (nums[i] > increasingSequence[len - 1])
			increasingSequence[len++] = nums[i];
		else {
			int position = findPositionToReplace(increasingSequence, 0, len-1, nums[i]);
			increasingSequence[position] = nums[i];
		}
		
	}
		return len;
    }
       public static int findPositionToReplace(int[] a, int low, int high, int x) {
	int mid;
	while (low <= high) {
		mid = (low + high ) / 2;
		if (a[mid] == x)
			return mid;
		else if (a[mid] > x)
			high = mid - 1;
		else
			low = mid + 1;
	}
	return low;
    
       }
}