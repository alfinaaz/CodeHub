https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        
         List<Integer> row = new ArrayList<Integer>();
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
      
        row.add(1);
        ans.add(row);
        for(int i=1;i<numRows;i++)
        {
            
            List<Integer> prevrow= ans.get(i-1);
            List<Integer> row1=new ArrayList<Integer>();
            row1.add(1);
            for(int j=1;j<prevrow.size();j++)
            {
                row1.add(prevrow.get(j)+prevrow.get(j-1));
            }
            row1.add(1);
            
            
            ans.add(row1);

        }
        
        return ans;
    }
}