class Solution {
    
    // Easy But Tricky Question 
    // Calculate the formula for the Question 
    // Formula : No. of Island * 4 - no. of neighbor * 2
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int noOfIsland = 0;
        int noOfNeighbor = 0;
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(grid[i][j] == 1){
        			noOfIsland++;
        			if(i + 1 < n && grid[i + 1][j] == 1)	
        				noOfNeighbor++;
        			
        			if(j + 1 < m && grid[i][j + 1] == 1)	
        				noOfNeighbor++;
        				
        		}
        	}
        }

        return noOfIsland * 4 - noOfNeighbor * 2;
    }
}