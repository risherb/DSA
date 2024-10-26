
class Solution {
    private Map<TreeNode, Integer> heights = new HashMap<>();
    private Map<Integer, TreeNode> nodeMap = new HashMap<>();
    private Map<Integer, Integer> depth = new HashMap<>();
    private Map<Integer, Integer> maxHeightAtDepth = new HashMap<>();
    private Map<Integer, Integer> secondMaxHeightAtDepth = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        calculateHeightsAndDepths(root, 0);
        computeMaxHeightsPerDepth(root, 0);
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            TreeNode nodeToRemove = nodeMap.get(queries[i]);
            int nodeDepth = depth.get(nodeToRemove.val);
            int currentHeight = heights.get(nodeToRemove);
            int maxHeightAfterRemoval;
            
            if (maxHeightAtDepth.get(nodeDepth) == currentHeight) {
                maxHeightAfterRemoval = secondMaxHeightAtDepth.getOrDefault(nodeDepth, -1) + nodeDepth;
            } else {
                maxHeightAfterRemoval = maxHeightAtDepth.get(nodeDepth) + nodeDepth;
            }
            
            result[i] = maxHeightAfterRemoval;
        }
        
        return result;
    }
    
    private int calculateHeightsAndDepths(TreeNode node, int d) {
        if (node == null) return -1;
        
        nodeMap.put(node.val, node);
        depth.put(node.val, d);
        
        int leftHeight = calculateHeightsAndDepths(node.left, d + 1);
        int rightHeight = calculateHeightsAndDepths(node.right, d + 1);
        
        int height = Math.max(leftHeight, rightHeight) + 1;
        heights.put(node, height);
        
        return height;
    }
    
    private void computeMaxHeightsPerDepth(TreeNode node, int d) {
        if (node == null) return;
        
        int nodeHeight = heights.get(node);
        
        if (!maxHeightAtDepth.containsKey(d) || nodeHeight > maxHeightAtDepth.get(d)) {
            secondMaxHeightAtDepth.put(d, maxHeightAtDepth.getOrDefault(d, -1));
            maxHeightAtDepth.put(d, nodeHeight);
        } else if (!secondMaxHeightAtDepth.containsKey(d) || nodeHeight > secondMaxHeightAtDepth.get(d)) {
            secondMaxHeightAtDepth.put(d, nodeHeight);
        }
        
        computeMaxHeightsPerDepth(node.left, d + 1);
        computeMaxHeightsPerDepth(node.right, d + 1);
    }
}
