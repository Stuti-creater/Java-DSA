class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int target=sum/2;
        if(sum%2!=0){
            return false;
        }
        boolean[][]dp=new boolean[n+1][target+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
               if(j>=nums[i-1]){
                dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
               }
               else{
                dp[i][j]=dp[i-1][j];
               }
            }
        }
        return dp[n][target];
        
    }
}