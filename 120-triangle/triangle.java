class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];
            dp[0][0]=triangle.get(0).get(0);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int top=(j>0)?dp[i-1][j-1]:Integer.MAX_VALUE;
                int sidetop=(j<i)?dp[i-1][j]:Integer.MAX_VALUE;
                dp[i][j]=triangle.get(i).get(j)+Math.min(top,sidetop);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[n-1][j]);
        }
        return ans;

    }
}