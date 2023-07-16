package org.solutions.binarySearch;

import java.util.LinkedList;
import java.util.Queue;

public class LastDayToCross {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = row*col, mid;
        while(left<=right) {
            mid = left + (right-left)/2;
            if(canCross(row, col, cells, mid))
                left = mid+1;
            else
                right = mid-1;
        }
        return left-1;
    }

    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                grid[0][i] = -1;
            }
        }

        int[] curr;
        int r, c, i, j;
        while(!queue.isEmpty()) {
            curr = queue.poll();
            r = curr[0];
            c = curr[1];
            if(r == row-1)
                return true;
            for(int[] dir : directions) {
                i = r+dir[0];
                j = c+dir[1];
                if(i>=0 && j>=0 && i<row && j<col && grid[i][j]==0) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }

        return false;
    }
}
