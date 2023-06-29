package org.solutions;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {
    class Node {
        int row;
        int col;
        String key;

        Node(int row , int col , String key){
            this.row = row;
            this.col=col;
            this.key=key;
        }
        public String toString() {
            return this.row+"-"+this.col+"-"+this.key;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        Queue<Node> q = new LinkedList<>();
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length(), totalKeyCount = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i].charAt(j) == '@')
                    q.offer(new Node(i, j, ""));
                if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f')
                    totalKeyCount++;
            }
        }

        Node currNode;
        String currKey;
        Set<String> visited = new HashSet<>();
        int i, j, x, y, answer = 0;

        while(!q.isEmpty()) {
            int currSize = q.size();
            while(currSize-->0) {
                currNode = q.poll();
                x = currNode.row;
                y = currNode.col;
                currKey = currNode.key;

                if(!visited.contains(currNode.toString()))
                    visited.add(currNode.toString());
                else
                    continue;

                if(currKey.length() == totalKeyCount)
                    return answer;

                for(int[] move : moves) {
                    i = x + move[0];
                    j = y + move[1];
                    if(i<0 || j<0 || i>=m || j>=n || grid[i].charAt(j) == '#' || visited.contains(i+"-"+j+"-"+currKey))
                        continue;

                    char currentChar = grid[i].charAt(j);
                    if(currKey.indexOf(currentChar)==-1 && currentChar>='a' && currentChar<='f') {
                        q.offer(new Node(i, j, currKey+currentChar));
                    } else if(currentChar>='A' && currentChar<='F' && currKey.indexOf(Character.toLowerCase(currentChar)) == -1) {
                        continue;
                    } else {
                        q.offer(new Node(i, j, currKey));
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}
