class Solution {
    
    public int maxValue(int[][] grid) {
        // 将grid直接dp化
        int m = grid.length, n = grid[0].length;
        // 可以将第一行、一列初始化归到下面双循环中，但每次冗余判断
        for(int j = 1; j < n; j++) 
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) 
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }
    
}