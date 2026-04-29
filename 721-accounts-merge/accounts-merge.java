import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> emailGraph = new HashMap<>();

        // Build graph of emails and map email → name
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            String firstEmail = acc.get(1);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name);
                emailGraph.computeIfAbsent(email, k -> new HashSet<>()).add(firstEmail);
                emailGraph.computeIfAbsent(firstEmail, k -> new HashSet<>()).add(email);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : emailGraph.keySet()) {
            if (!visited.contains(email)) {
                List<String> component = new ArrayList<>();
                dfs(emailGraph, visited, email, component);
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                result.add(component);
            }
        }

        return result;
    }

    private void dfs(Map<String, Set<String>> graph, Set<String> visited, String email, List<String> component) {
        visited.add(email);
        component.add(email);
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, neighbor, component);
            }
        }
    }
}