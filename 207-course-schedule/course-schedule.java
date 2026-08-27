class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[]indegree=new int[numCourses];
        for(int[] prequisite:prerequisites){
            int course=prequisite[0];
            int pre=prequisite[1];
            graph.get(pre).add(course);
            indegree[course]++;


        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            count++;

            
            for (int next : graph.get(current)) {

                indegree[next]--;

                
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        
        return count == numCourses;

    }
}