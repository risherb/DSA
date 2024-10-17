class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] last = new int[10];
        
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        return num;        
    }
}