import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            int at = email.indexOf('@');
            String local = email.substring(0, at);
            String domain = email.substring(at);

            // Remove everything after '+' in local
            int plus = local.indexOf('+');
            if (plus != -1) {
                local = local.substring(0, plus);
            }

            // Remove all '.' in local
            local = local.replace(".", "");

            String normalized = local + domain;
            unique.add(normalized);
        }

        return unique.size();
    }
}