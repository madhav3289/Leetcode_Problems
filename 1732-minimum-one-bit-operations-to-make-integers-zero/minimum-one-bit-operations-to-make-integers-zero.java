class Solution {
    public int minimumOneBitOperations(int n) {
        if(n == 0)
            return 0;
        
        int msb = Integer.highestOneBit(n);
        return msb * 2 - 1 - minimumOneBitOperations(msb ^ n);
    }
}