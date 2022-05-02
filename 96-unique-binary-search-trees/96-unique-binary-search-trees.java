class Solution {
    static int mod= (int)Math.pow(10,9)+7;
    public int numTrees(int n) {
        long cat = 1;
        for (int i = 1; i <= n; i++)
            cat = 2 * (2 * i - 1) * cat / (i + 1);
        return (int) cat;
    } 
}
        