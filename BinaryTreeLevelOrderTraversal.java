/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // time complexity - O(n)
// Space complexity -O(n)
//solved on leetcode -yes
// did you face any issues - no
// initially adding root to the queue and then removing each element from the queue and adding it's children to the queue. and at each level adding values to the list
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left!= null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
            }
            result.add(l);
        }
        return result;
    }
}
