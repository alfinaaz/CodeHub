class Solution {
    public int numTrees(int n) {
       
        long ans=1;
         int k=n;
         n=2*n;
       
        
        for(int i=0;i<k;i++)
        {
            ans *= n-i;
            ans /= i+1;
        }
        
        
        return (int)(ans/(k+1));
    } 
}
        