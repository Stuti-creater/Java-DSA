class Solution {
    public int numIslands(char[][] grid) {
        boolean[][]visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'&& !visited[i][j]){
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,char[][]grid,boolean[][]visited){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
            }
            if(grid[i][j]=='0'|| visited[i][j])
            return;
            visited[i][j]=true;
            dfs(i-1,j,grid,visited);
            dfs(i+1,j,grid,visited);
            dfs(i,j-1,grid,visited);
            dfs(i,j+1,grid,visited);
    }
}