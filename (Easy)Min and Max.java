
Find minimum and maximum element in an array


class Compute 
{
    static pair getMinMax(long a[], long n)  
    {
        //Write your code here
        
       
        long min= Integer.MAX_VALUE;
        long max= Integer.MIN_VALUE;
        for(int i=0;i<(int)n;i++)
        {
            min = Math.min(min,a[i]);
            max=  Math.max(max,a[i]);
        }
         pair p = new pair(min,max);
         
         return p;
    }
}
