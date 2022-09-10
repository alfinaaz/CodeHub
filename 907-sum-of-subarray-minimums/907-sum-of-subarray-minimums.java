class Pair{
    
    int ele;
    int n;
    
    public Pair(int ele, int n)
    {
        this.ele=ele;
        this.n=n;
    }    
}
class Solution {
   // public long m= (int)Math.pow(10,9)+7;
    public int sumSubarrayMins(int[] arr) {
        
        int[] leftarr= new int[arr.length];
        int[] rightarr= new int[arr.length];
        
        ArrayDeque<Pair> left = new ArrayDeque<>();
        ArrayDeque<Pair> right= new ArrayDeque<>();
        
        for(int i=0;i<arr.length;i++)
        {
            int curr=arr[i];
            int count=1;
            while(left.size()!=0 && left.peek().ele>curr)
            {
                count+= left.peek().n;
                left.pop();
                
            }
            left.push(new Pair(curr,count));
            leftarr[i]=count;
            
            
        }
        
         for(int i=arr.length-1;i>=0;i--)
        {
            int count=1;
             int curr=arr[i];
            while(right.size()!=0 && right.peek().ele>=curr)
            {
                count+= right.peek().n;
                right.pop();
                
            }
            right.push(new Pair(curr,count));
            
            rightarr[i]=count;
            
            
        }
        
        long m = (int)Math.pow(10,9)+7,res=0;
        for(int i=0;i<arr.length;i++)
        {
            res = (res + (long)arr[i] * leftarr[i] * rightarr[i] ) % m;
        }
        
        return (int)res;
    }
}