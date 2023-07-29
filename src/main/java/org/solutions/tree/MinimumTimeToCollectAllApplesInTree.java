package org.solutions.tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInTree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> tree = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            tree.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        return dfs(tree, vis, 0, hasApple);
    }

    public int dfs(List<List<Integer>> tree, boolean[] vis, int i, List<Boolean> hasApple) {
        if(vis[i])
            return 0;
        vis[i] = true;
        int length = 0;

        for(int neighbour : tree.get(i)) {
            if(!vis[neighbour]) {
                length += dfs(tree, vis, neighbour, hasApple);
            }
        }

        if(i!=0 && (length > 0 || hasApple.get(i)))
            length += 2;

        return length;
    }
}
