class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String result = "";

        for (int i = 0; i < n; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                seen.add(c);

                if (isNice(seen)) {
                    String curr = s.substring(i, j + 1);
                    if (curr.length() > result.length()) {
                        result = curr;
                    }
                }
            }
        }

        return result;
    }

    private boolean isNice(Set<Character> chars) {
        for (char c : chars) {
            char other = (c >= 'a') ? (char) (c - 32) : (char) (c + 32); // A↔a swap
            if (!chars.contains(other)) {
                return false;
            }
        }
        return true;
    }
}