class Solution {
    Set<Integer> vis = new HashSet<>();
    int n;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        return dfs(rooms, 0);
    }

    public boolean dfs(List<List<Integer>> rooms, int i) {
        vis.add(i);
        if(vis.size()==n)
            return true;
        for(Integer key : rooms.get(i)) {
            if(!vis.contains(key)) {
                if(dfs(rooms, key)==true)
                return true;
            }
        }
        return false;
    }
}