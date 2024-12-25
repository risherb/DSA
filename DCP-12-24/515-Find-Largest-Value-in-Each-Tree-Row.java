class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        iterate(root, map, 0);
        return new ArrayList<>(map.values());
    }
    
    private void iterate(TreeNode node, Map<Integer, Integer> map, int row) {
        if (node == null) return;
        
        map.merge(row, node.val, Math::max);
        
        iterate(node.left, map, row + 1);
        iterate(node.right, map, row + 1);
    }
}