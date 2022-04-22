https://practice.geeksforgeeks.org/problems/reverse-a-string/1#


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        
        String rev="";
        for(int i=str.length()-1;i>=0;i--)
        {
            rev+=str.charAt(i);
        }
        
        return rev;
    }
}




https://leetcode.com/problems/reverse-string/submissions/

class Solution {
    public void reverseString(char[] s) {
        
        int start=0, end=s.length-1;
        
        while(start<end)
        {
            
            char temp= s[start];
            s[start]= s[end];
            s[end]= temp;
            
            
            start++;
            end--;
            
        }
        
    }
}