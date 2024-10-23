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
class Solution {
    List<Integer> levelSum;
    void bfs1(TreeNode root,List<Integer> levelSum){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int cS = 0;
            for(int i=0;i<size;i++){
                TreeNode cN = q.poll();
                cS += cN.val;
                if(cN.left!=null){
                    q.add(cN.left);
                }
                if(cN.right!=null){
                    q.add(cN.right);
                }
            }
            levelSum.add(cS);
        }
    }
    void bfs2(TreeNode root,List<Integer> levelSum){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode cN = q.poll();
                if(level == 0 ){
                    cN.val = 0;
                    if(cN.left!=null) cN.left.val = 0;
                    if(cN.right!=null) cN.right.val = 0;
                }

                else if(level>=1){
                    int x = 0;
                    int y = 0;
                    if(cN.left!=null) x = cN.left.val;
                    if(cN.right!=null) y = cN.right.val;
                    if(cN.left!=null && level<=levelSum.size()-2){
                        cN.left.val = levelSum.get(level+1)-x-y;
                    }
                    if(cN.right!=null && level<=levelSum.size()-2){
                        cN.right.val = levelSum.get(level+1)-x-y;
                    }
                }
                if(cN.left!=null){
                    q.add(cN.left);
                }
                if(cN.right!=null){
                    q.add(cN.right);
                }
            }
            level++;
        }
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        levelSum = new ArrayList<>();
        bfs1(root,levelSum);
        bfs2(root,levelSum);
        return root;
    }
}