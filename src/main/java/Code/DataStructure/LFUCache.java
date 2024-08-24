package Code.DataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class LFUCache {
    private int capacity;
    private int time;
    private Map<Integer, Node> map;
    private TreeSet<Node> treeSet;

    class Node {
        int time, cnt, key, value;

        public Node(int time, int cnt, int key, int value) {
            this.time = time;
            this.cnt = cnt;
            this.key = key;
            this.value = value;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.cnt != o2.cnt) {
                return o1.cnt - o2.cnt;
            } else {
                return o1.time - o2.time;
            }
        });
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            treeSet.remove(node);
            node.time = ++time;
            node.cnt += 1;
            treeSet.add(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(capacity==0)return;
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == this.capacity) {
                Node rubbish = treeSet.first();
                treeSet.remove(rubbish);
                map.remove(rubbish.key);
            }
            node = new Node(++time, 1, key, value);
            map.put(key, node);
            treeSet.add(node);
        } else {
            treeSet.remove(node);
            node.time = ++time;
            node.cnt++;
            node.value = value;
            treeSet.add(node);
        }

    }
}
