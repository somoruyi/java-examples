package com.demo;

import java.util.*;
public class Graphs{

    // BFS
    public static List<String> findShortestPathBFS(String start, String end) {
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("LeBron James", Arrays.asList("Los Angeles Lakers", "Scoring", "Rebounding", "Playmaking", "Defense", "6"));
        graph.put("Kyrie Irving", Arrays.asList("Brooklyn Nets", "Scoring", "Playmaking", "Defense", "11"));
        graph.put("Steph Curry", Arrays.asList("Golden State Warriors", "Scoring", "Playmaking", "30"));
        graph.put("Steve Kerr", Collections.singletonList("Golden State Warriors"));
        graph.put("Los Angeles Lakers", Arrays.asList("LeBron James", "Pick and Roll", "Fast Break", "Isolation"));
        graph.put("Brooklyn Nets", Arrays.asList("Kyrie Irving", "Pick and Roll", "Isolation"));
        graph.put("Golden State Warriors", Arrays.asList("Steph Curry", "Steve Kerr", "Pick and Roll", "Fast Break"));
        graph.put("Scoring", Arrays.asList("LeBron James", "Kyrie Irving", "Steph Curry"));
        graph.put("Rebounding", Collections.singletonList("LeBron James"));
        graph.put("Playmaking", Arrays.asList("LeBron James", "Kyrie Irving", "Steph Curry"));
        graph.put("Defense", Arrays.asList("LeBron James", "Kyrie Irving"));
        graph.put("6", Collections.singletonList("LeBron James"));
        graph.put("11", Collections.singletonList("Kyrie Irving"));
        graph.put("30", Collections.singletonList("Steph Curry"));
        graph.put("Pick and Roll", Arrays.asList("Los Angeles Lakers", "Brooklyn Nets", "Golden State Warriors"));
        graph.put("Fast Break", Arrays.asList("Los Angeles Lakers", "Golden State Warriors"));
        graph.put("Isolation", Arrays.asList("Los Angeles Lakers", "Brooklyn Nets"));


        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(Arrays.asList(start));
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String lastNode = path.get(path.size() - 1);

            if (lastNode.equals(end)) {
                return path;
            }

            List<String> neighbors = graph.get(lastNode);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        queue.add(newPath);
                        visited.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    // DFS

}



