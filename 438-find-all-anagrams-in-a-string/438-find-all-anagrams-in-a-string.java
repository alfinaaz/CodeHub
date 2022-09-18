class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        
   
        List<Integer> ans = new ArrayList<>();
        
             if(s.length()<p.length())
            return ans;
        
        
        int[] sarr = new int[26];
        int[] parr = new int[26];
        
        int i=0;
        
        for(i=0;i<p.length();i++)
        {
           sarr[s.charAt(i)-'a']++;
           parr[p.charAt(i)-'a']++;
        }
        
        for(i=0;i<s.length()-p.length();i++)
        {
            if(isAnag(sarr,parr))
            {
                ans.add(i);
            }
            
            sarr[s.charAt(i)-'a']--;
            sarr[s.charAt(i+p.length())-'a']++;
            
        }
        
        if(isAnag(sarr,parr))
        {
            ans.add(s.length()-p.length());
        }
        
        return ans;
        
        
    }
    
    public boolean isAnag(int[] sarr, int[] parr)
    {
        for(int i=0;i<parr.length;i++)
        {
            if(parr[i]!=sarr[i])
                return false;
        }
        
        return true;
    }
}