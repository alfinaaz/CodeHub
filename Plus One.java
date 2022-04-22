class Solution {
    public int[] plusOne(int[] digits) {
        
    int[] ans= new int[digits.length];
    int[] temp= new int[digits.length];
    int sum=0;
    int carry=1;
    for(int i=digits.length-1;i>=0;i--)
    {
        sum=digits[i]+carry;
        carry=(sum>=10)?1:0;
        ans[i]=sum%10;
    }
        
    if(carry==1)
    {
        temp=new int[digits.length+1];
        int k=1;
        for(int i=0;i<ans.length;i++)
        {
            temp[k]=ans[i];
            k++;
        }
        temp[0]=1;
        
        return temp;
    }
        
    return ans;
    }
   
}