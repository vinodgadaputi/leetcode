import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort by distance from origin (avoiding sqrt if you want, or use compare)
        Arrays.sort(points, (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distA, distB);
        });

        // Return first k points
        return Arrays.copyOfRange(points, 0, k);
    }
}