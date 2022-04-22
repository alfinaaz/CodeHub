215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    public int findKthLargest(int[] nums, int k) {
                 
        return quickSelect(0,nums.length-1,nums,nums.length-k);       
    }   
    public int  quickSelect(int l, int r , int[] nums, int k){
        
        int piv = partition(l,r,nums); 
        if(k==piv)
            return nums[piv];
         if(k<piv)
          return  quickSelect(l,piv-1,nums,k);
       else 
           return   quickSelect(piv+1,r,nums,k);  
    }
  public static int partition(int l,int r, int[] input)
    {
        int pivele= input[l],count=0;
        for(int i=l+1;i<=r;i++)
        {
            if(input[i]<=pivele)
                count++;
        }
        int temp=input[l+count];
        input[l+count]=input[l];
        input[l]=temp;
        int i=l,j=r,piv=l+count;
        while(i<piv && j>piv)
        {
            if(input[i]<=input[piv])
                i++;
                
            else
            {
                if(input[j]>input[piv])
                    j--;
                
                else
                {
                    
                    int temp1=input[j];
                    input[j]=input[i];
                    input[i]=temp1;
                    
                    i++;
                    j--;
                }   
            }     
        }
          return piv;
    }
}
//*******************QUICK SORT TECHNIQUE************/
// The idea is to "partition" the array based on the pivot element such that all elemnts left to the pivot are lessthan/equal to pivot
// element and all elements right to it are more than the pivot element. The array is not sorted but(PIVOT ELEMENT IS AT ITS 
// CORRECT POSITION) so if (k==pivotposition) then return array[pivotposiion]. if(k<pivotposition){ we will look for the element recursively on the 
// the left side of the pivot position}



https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
//Kth smallest element


// **************This solution works only for distinct elements //////////////////
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        int ans=-1;
        int[] arr1= new int[100001];
        for(int i=0;i<arr.length;i++)
        {
            arr1[arr[i]]= 1;
        }
        for(int i=1;i<arr1.length;i++)
        {
            arr1[i]+=arr1[i-1];
        }
        int i;
        for( i=0;i<arr1.length;i++)
        {
            if(arr1[i]==k)
              {
                  ans=i;
                  break;
              }
        } 
        return ans;
    } 
    
    
}

