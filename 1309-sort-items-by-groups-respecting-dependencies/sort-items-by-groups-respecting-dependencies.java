import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Assign each ungrouped item to its own group
        int nextGroupId = m;
        for (int item = 0; item < n; item++) {
            if (group[item] == -1) {
                group[item] = nextGroupId++;
            }
        }
        int totGroups = nextGroupId;

        // groupItems[groupId] = list of items in that group
        List<List<Integer>> groupItems = new ArrayList<>();
        for (int i = 0; i < totGroups; i++) {
            groupItems.add(new ArrayList<>());
        }
        for (int item = 0; item < n; item++) {
            groupItems.get(group[item]).add(item);
        }

        int[] itemInDeg = new int[n];
        int[] groupInDeg = new int[totGroups];
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) itemGraph.add(new ArrayList<>());
        for (int i = 0; i < totGroups; i++) groupGraph.add(new ArrayList<>());

        // Build item‑ and group‑graphs
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                int currGroup = group[curr];
                int prevGroup = group[prev];

                if (currGroup == prevGroup) {
                    // intra‑group dependency
                    itemGraph.get(prev).add(curr);
                    itemInDeg[curr]++;
                } else {
                    // inter‑group dependency
                    groupGraph.get(prevGroup).add(currGroup);
                    groupInDeg[currGroup]++;
                }
            }
        }

        // Topo‑sort groups
        List<Integer> groupOrder = topoSort(groupInDeg, groupGraph, totGroups);
        if (groupOrder.size() != totGroups) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        for (int groupId : groupOrder) {
            List<Integer> items = groupItems.get(groupId);
            List<Integer> itemOrder = topoSort(itemInDeg, itemGraph, items);
            if (itemOrder.size() != items.size()) {
                return new int[0];
            }
            result.addAll(itemOrder);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // Kahn’s topological sort
    private List<Integer> topoSort(int[] inDeg, List<List<Integer>> graph, int n) {
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) nodes.add(i);
        return topoSort(inDeg, graph, nodes);
    }

    private List<Integer> topoSort(int[] inDeg, List<List<Integer>> graph, List<Integer> nodes) {
        int[] deg = Arrays.copyOf(inDeg, inDeg.length);
        Queue<Integer> q = new ArrayDeque<>();
        for (int u : nodes) {
            if (deg[u] == 0) {
                q.offer(u);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : graph.get(u)) {
                if (--deg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return order.size() == nodes.size() ? order : new ArrayList<>();
    }
}