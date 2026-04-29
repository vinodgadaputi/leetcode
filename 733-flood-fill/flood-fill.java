class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int original = image[sr][sc];
        if (original == color) return image;  // no change needed

        dfs(image, sr, sc, m, n, original, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int m, int n, int orig, int color) {
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != orig) {
            return;
        }

        image[i][j] = color;

        dfs(image, i - 1, j, m, n, orig, color); // up
        dfs(image, i, j + 1, m, n, orig, color); // right
        dfs(image, i + 1, j, m, n, orig, color); // down
        dfs(image, i, j - 1, m, n, orig, color); // left
    }
}