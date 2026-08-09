class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int row=matrix.length;
       int col=matrix[0].length;
       int[][]dp=new int[row][col];
       for(int j=0;j<col;j++){
        dp[0][j]=matrix[0][j];
       } 
       for(int i=1;i<row;i++){
        for(int j=0;j<col;j++){
            int up=dp[i-1][j];
            int left=Integer.MAX_VALUE;
            if(j>0){
             left=dp[i-1][j-1];
            }
            int right=Integer.MAX_VALUE;
            if(j<col-1){
                right=dp[i-1][j+1];
            }
            dp[i][j]=matrix[i][j]+Math.min(up,Math.min(left,right)); 

        }
       }
       int ans=Integer.MAX_VALUE;
       for(int j=0;j<col;j++){
        ans=Math.min(ans,dp[row-1][j]);
       }
       return ans;
    }
}