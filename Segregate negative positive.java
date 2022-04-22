https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/

Approach 1:
The idea is to simply apply the partition process of quicksort. 

Approach2:
 Dutch National Flag Algorithm


 public static void swap(int[] ar, int i, int j)
    {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
 
    public static void move(int[] ar)
    {
        int low = 0;
        int high = ar.length - 1;
        while (low <= high) {
            if (ar[low] <= 0)
                low++;
            else
                swap(ar, low, high--);
        }
    }


    Approach3: Two Pointer


    class GFG{
 
// Function to shift all the
// negative elements on left side
static void shiftall(int[] arr, int left,
                     int right)
{
     
    // Loop to iterate over the
    // array from left to the right
    while (left <= right)
    {
         
        // Condition to check if the left
        // and the right elements are
        // negative
        if (arr[left] < 0 && arr[right] < 0)
            left++;
 
        // Condition to check if the left
        // pointer element is positive and
        // the right pointer element is negative
        else if (arr[left] > 0 && arr[right] < 0)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
 
        // Condition to check if both the
        // elements are positive
        else if (arr[left] > 0 && arr[right] > 0)
            right--;
        else
        {
            left++;
            right--;
        }
    }
}



WITH EXTRAA SPACE----------


class Solution{
    
    void segregateElements(int arr[],int n)
    {
    	
        // Create an empty array to store result
        int temp[n];
     
        // Traversal array and store +ve element in
        // temp array
        int j = 0; // index of temp
        for (int i = 0; i < n ; i++)
            if (arr[i] >= 0 )
                temp[j++] = arr[i];
     
        // If array contains all positive or all negative.
        if (j == n || j == 0)
            return;
     
        // Store -ve element in temp array
        for (int i = 0 ; i < n ; i++)
            if (arr[i] < 0)
                temp[j++] = arr[i];
     
        // Copy contents of temp[] to arr[]
       
    }
};
