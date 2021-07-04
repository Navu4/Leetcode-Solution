class Solution {

    public int dfs(int[][] grid, int sr, int sc, int[][] dir){
        int n = grid.length;
        int m = grid[0].length;

        int area = 0;
        grid[sr][sc] = 0;
        for(int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != 0){
                area += dfs(grid, x, y, dir);
            } 
        }

        return area + 1;
    }        
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = { { 1, 0}, { -1, 0}, { 0, 1}, { 0, -1}};
        int area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0){
                    int s = dfs(grid, i, j, dir);
                    area = Math.max(area, s);
                }
            }
        }
        return area;
    }
}