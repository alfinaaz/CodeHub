// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int nums[])
    {
        	   	if (nums == null | nums.length == 0)
		return 0;
	int  len = 0;
	int[] increasingSequence = new int[n];
	increasingSequence[len++] = nums[0];
	for (int i = 1; i < n; i++) {
		if (nums[i] > increasingSequence[len - 1])
			increasingSequence[len++] = nums[i];
		else {
			int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
			increasingSequence[position] = nums[i];
		}
		
	}
		return len;
    }
      public static int findPositionToReplace(int[] a, int low, int high, int x) {
	int mid;
	while (low <= high) {
		mid = low + (high - low) / 2;
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