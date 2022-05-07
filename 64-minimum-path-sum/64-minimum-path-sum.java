class Solution {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] mem= new int[n][m];
            
        return minPathSum(grid,0,0,n,m,mem);
        
    }
    public int minPathSum(int[][] grid,int i, int j,int n,int m,int[][] mem) {
        
        if(n==0)
            return 0;
        
        if(i==n-1 && j==m-1)
            return grid[i][j];
        
        if(mem[i][j]!=0)
            return mem[i][j];
        
       int sum= grid[i][j];
        if(i<n-1 && j<m-1){
            int x=minPathSum(grid,i+1,j,n,m,mem);  
            int y=minPathSum(grid,i,j+1,n,m,mem);
            
            sum+= x<=y?x:y;
        }
        
         else if(j<m-1){   
             sum+=minPathSum(grid,i,j+1,n,m,mem);  
             return mem[i][j]=sum;
             
         }
             
        
         else if(i<n-1){
             sum+=minPathSum(grid,i+1,j,n,m,mem); 
             return mem[i][j]=sum;
         }
        
     return mem[i][j]= sum;   
    }  
}