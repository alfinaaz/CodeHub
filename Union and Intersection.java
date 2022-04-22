349. Intersection of Two Arrays-I

https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
          Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
        
        
    }
}



Intersection-II

https://leetcode.com/problems/intersection-of-two-arrays-ii/


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
          List<Integer> set = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
        
        
        
    }
}

UNION--

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        HashSet<Integer> s=new HashSet<>();
        	    
        	//we insert all the elements of first array in HashSet.
        	for(int i = 0;i<n;i++)
        	   s.add(a[i]);
        	    
        	 //we insert all the elements of second array in HashSet.
    	     //HashSet does not contain duplicates.
        	 for(int i = 0;i<m;i++)
        	    s.add(b[i]);
        	    
        	  //returning the size of HashSet which is total number
        	  //of elements in HashSet.
        	  return s.size() ;
        
        
        
    }
}