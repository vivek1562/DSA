class Solution {

    class Node {
        int row;
        int col;
        int key;
        Node(int row , int col , int key){
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
        int m = grid.length, n = grid[0].length(), targetKey=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i].charAt(j) == '@')
                    q.offer(new Node(i, j, 0));
                if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f')
                    targetKey |= 1<<(grid[i].charAt(j)-'a');
            }
        }

        Node currNode;
        int currKey;
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

                if(currKey == targetKey)
                    return answer;

                for(int[] move : moves) {
                    i = x + move[0];
                    j = y + move[1];
                    if(i<0 || j<0 || i>=m || j>=n || grid[i].charAt(j) == '#' || visited.contains(i+"-"+j+"-"+currKey))
                        continue;

                    char currentChar = grid[i].charAt(j);
                    if(currentChar>='a' && currentChar<='f') {
                        q.offer(new Node(i, j, currKey|(1<<(currentChar-'a'))));
                    } else if(currentChar>='A' && currentChar<='F' && (currKey>>(currentChar-'A')&1)==0) {//at a lock case check if you have the correct key. Rightshift the curr key currlock times and check if it is set or not
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