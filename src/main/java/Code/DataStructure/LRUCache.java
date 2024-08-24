package Code.DataStructure;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    static class Node{
        Node prev;
        Node next;
        Integer key;
        Integer value;
        public Node(Integer key,Integer value){
            this.key=key;
            this.value=value;
        }
    }

    public void unlink(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void toHead(Node node){
        node.prev=this.head;
        node.next=this.head.next;
        this.head.next.prev=node;
        this.head.next=node;
    }

    int limit;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.limit=capacity;
        this.head=new Node(-1,null);
        this.tail=new Node(10001,null);
        head.next=tail;
        tail.prev=head;
        this.map=new HashMap<>();
    }

    public int get(int key) {
        Node node=this.map.get(key);
        if(node==null){
            return -1;
        }
        unlink(node);
        toHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node=this.map.get(key);
        if(node==null){
            node=new Node(key,value);
            this.map.put(key,node);
        }else {
            node.value=value;
            unlink(node);
        }
        toHead(node);
        if(map.size()>limit){
            Node last=this.tail.prev;
            this.map.remove(last.key);
            unlink(last);
        }
    }
    public void remove(Integer key) {
        Node old = this.map.remove(key);
        unlink(old);
    }
}

