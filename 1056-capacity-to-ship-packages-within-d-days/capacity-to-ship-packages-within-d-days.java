class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight:weights){
        low=Math.max(low,weight);
        high=high+weight;
        }
        int answer=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int dayused=1;
            int workload=0;
            for(int weight:weights){
                if(workload+weight<=mid){
                    workload=workload+weight;
                }else{
                    dayused++;
                    workload=weight;
                }
            }
            if(dayused<=days){
                answer=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
            return answer;
        
    }
}
