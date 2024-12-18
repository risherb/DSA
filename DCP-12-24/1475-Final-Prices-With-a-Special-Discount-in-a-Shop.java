class Solution {
    public int[] finalPrices(int[] prices) {
        int[] newPrice = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                newPrice[index] = prices[index] - prices[i];
            }
           
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            newPrice[index] = prices[index];
        }
        
        return newPrice;
    }
}
