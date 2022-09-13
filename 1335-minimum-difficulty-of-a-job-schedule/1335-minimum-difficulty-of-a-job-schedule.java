class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        
        if(n<d)
            return -1;
        
        // Initialize the minDiff matrix to record the minimum difficulty
        // of the job schedule    
        int[] minDiffNextDay = new int[n + 1];
        minDiffNextDay[n-1]=jobDifficulty[n-1];
        for (int i = n-2; i>=0; i--) {
            minDiffNextDay[i] = Math.max(minDiffNextDay[i+1],jobDifficulty[i]);
        }
        for (int daysRemaining = 2; daysRemaining <= d; daysRemaining++) {
            int[] minDiffCurrDay = new int[n + 1];
           // for (int i = 0; i < n; i++) {
             //   
            //}
            for (int i = 0; i < n - daysRemaining + 1; i++) {
                int dailyMaxJobDiff = 0;
                minDiffCurrDay[i] = Integer.MAX_VALUE;
                for (int j = i + 1; j < n - daysRemaining + 2; j++) {
                    // Use dailyMaxJobDiff to record maximum job difficulty
                    dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[j - 1]);
                //    if (minDiffNextDay[j] != Integer.MAX_VALUE) {
                        minDiffCurrDay[i] = Math.min(minDiffCurrDay[i],
                                                     dailyMaxJobDiff + minDiffNextDay[j]);
                 //   }
                }
            }
            minDiffNextDay = minDiffCurrDay;
        }
        return minDiffNextDay[0] ;
    }
}