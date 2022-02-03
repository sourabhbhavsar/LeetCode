class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            
            graph.putIfAbsent(x, new HashMap<>());
            graph.putIfAbsent(y, new HashMap<>());
            
            graph.get(x).put(y, values[i]);
            graph.get(y).put(x, 1 / values[i]);
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            double res = solveEquation(graph, queries.get(i).get(0), queries.get(i).get(1), visited);
            ans[i] = res;
        }
        
        return ans;
    }
    
    double solveEquation(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1;
        }
        
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        
        visited.add(start);
        for (Map.Entry<String, Double> edge : graph.get(start).entrySet()) {
            String next = edge.getKey();
            double weight = edge.getValue();
            
            if (visited.add(next)) {
                double product = solveEquation(graph, next, end, visited);
                if (product != -1.0) {
                    return product * weight;
                }
            }
        }
        
        return -1;
    }
}
