public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // pick the least significant bit of n
            int bit = n & 1;
            // put it at position (31 - i) in result
            result |= bit << (31 - i);
            // shift n right by 1 to get next bit
            n >>>= 1;
        }

        return result;
    }
}