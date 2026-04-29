import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort by end coordinate (x_end)
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lastArrowPos = points[0][1]; // shoot first arrow at this end

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];

            // If balloon starts after last arrow, we need a new arrow
            if (start > lastArrowPos) {
                arrows++;
                lastArrowPos = end;     // shoot at current balloon's right end
            }
            // Otherwise, the current arrow already pops this balloon (overlap)
        }

        return arrows;
    }
}