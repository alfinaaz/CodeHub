class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        dfs(0,res,new ArrayList<String>(),s);
        return res;
        
    }
    
    void dfs(int start,List<List<String>> res, List<String> curr, String s ){
    
    
    if(start>=s.length())
    {
        res.add(new ArrayList<String>(curr));
        return ;
    }
    
    for(int i=start;i<s.length();i++)
    {
        if(isPalindrome(s,start,i))
        {
            curr.add(s.substring(start,i+1));
            dfs(i+1,res,curr,s);
            curr.remove(curr.size()-1);
        }
    }
}
     boolean isPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}