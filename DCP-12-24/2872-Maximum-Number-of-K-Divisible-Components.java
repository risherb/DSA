class Solution {
    private int count = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1, values, tree, k);
        return count;
    }

    private int dfs(int node, int parent, int[] values, List<List<Integer>> tree, int k){
        int subtreeSum = 0;

        for(int nbr: tree.get(node)){
            if(nbr != parent){
                subtreeSum += dfs(nbr, node, values, tree, k);
            }
        }

        subtreeSum += values[node];

        if(subtreeSum % k == 0){
            count++;
            return 0;
        }

        return (int)(subtreeSum % k);
    }
}