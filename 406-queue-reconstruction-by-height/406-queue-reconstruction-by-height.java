class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        
        List<int[]> ordered= new ArrayList<>();
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int[] ele :people)
        {
            ordered.add(ele[1],ele);
        }
        
        
        return ordered.toArray(new int[people.length][2]);
    }
}