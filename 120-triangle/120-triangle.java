class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] mem= new int[201][201];
        
        for(int i=0;i<mem.length;i++)
        {
           Arrays.fill(mem[i],-1);
        }
        return helper(triangle,0,0,mem);
    }
    
    public int helper(List<List<Integer>> triangle,int r, int c,int[][] mem)
    {
        if(r>=triangle.size())
            return 0;
        
        if(mem[r][c]!=-1)
            return mem[r][c];
        
      return  mem[r][c]= Math.min(helper(triangle,r+1,c,mem),helper(triangle,r+1,c+1,mem))+triangle.get(r).get(c);
        //return mem[r][c];
        
        
        
    }
}