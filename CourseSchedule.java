// time complexity - O(n)
// Space complexity -O(n)
//solved on leetcode -yes
// did you face any issues - no
// Initially maintaining the indegrees in a array. and also adding all the dependencies in a list called graph. So initially adding the zero dependency node sto the queue and then adding it's dependencies.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Build adjacency list
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Build indegree array
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph[prereq].add(course);
            indegree[course]++;
        }

        // Step 3: Add nodes with indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: BFS Topological Sort
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neighbor : graph[curr]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 5: If all courses processed → return true
        return count == numCourses;
    }
}
