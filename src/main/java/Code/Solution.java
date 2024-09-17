package Code;

import java.util.*;

class  Solution {

    public  int numBusesToDestination(int[][] routes, int source, int target) {
        int result;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int x : routes[i]) {
                List<Integer> list = map.getOrDefault(x, new ArrayList<>());
                list.add(i);
                map.put(x, list);
            }
        }
        if (!map.containsKey(source) || !map.containsKey(target)) {
            result = source != target ? -1 : 0;
        } else {
            Map<Integer, Integer> dis = new HashMap<>();
            dis.put(source, 0);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(source);
            while (!q.isEmpty()) {
                int x = q.poll();
                int disx = dis.get(x);
                for (int i : map.get(x)) {
                    if (routes[i] != null) {
                        for (int y : routes[i]) {
                            if (!dis.containsKey(y)) {
                                dis.put(y, disx + 1);
                                q.add(y);
                            }
                        }
                        routes[i] = null;
                    }
                }
            }
            result = dis.getOrDefault(target, -1);
        }
        return result;
    }
}