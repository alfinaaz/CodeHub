class Solution {
    List<Integer> list= new ArrayList<>();
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
      for(int i=0;i<ppid.size();i++)
        {
            if(ppid.get(i)==0)
                continue;
            
           List <Integer> l = map.getOrDefault(ppid.get(i), new ArrayList <Integer> ());
            l.add(pid.get(i));
            map.put(ppid.get(i),l);
            
        }
        list.add(kill);
        return dfs(map,kill);
        
    }
    public List<Integer> dfs(HashMap<Integer,List<Integer>> map,int kill)
    {
        if(map.containsKey(kill)){
        for(int ele : map.get(kill))
        {
            list.add(ele);
            dfs(map,ele);
        }
        
        }
           
           return list;
    }
}