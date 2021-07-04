class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.legnth;
        int m = grid[0].lenght;

        int[][] dir = { { 1, 0}, { -1, 0}, { 0, 1}, { 0, -1}};
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != '0'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
    }

    public void dfs(int[][] grid, int sr, int sc, int[][] dir){

        grid[sr][sc] = '0';
        for(int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != '0'){
                dfs(grid, x, y, dir);
            } 
        }
    }
}