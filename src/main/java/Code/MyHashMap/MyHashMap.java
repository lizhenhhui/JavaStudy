package Code.MyHashMap;




public class MyHashMap<K,V> {
     static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
        public Node(K key,V val){
            this.key=key;
            this.value=val;
        }
    }
    int currentSize;
    int capacity;
    double factor;
    Node<K,V>[] array;
    public MyHashMap(){
        currentSize=0;
        capacity=16;
        factor=0.75;
        array=new Node[capacity];
    }
    public void put(K key,V val){
        if(this.currentSize>=this.capacity*factor){
            rehash();
        }
        int hashCode=key.hashCode();
        int index=hashCode%this.capacity;
        if(array[index]==null){
            array[index]= new Node<>(key, val);
            currentSize++;
        }else{
            Node<K,V> head=array[index];
            Node<K,V> pre=null;
            while (head!=null){
                if(head.key.equals(key)){
                    head.value=val;
                    return;
                }
                pre=head;
                head=head.next;
            }
            if(pre!=null)pre.next= new Node<>(key, val);
        }
    }
    public V get(K key){
        int hashCode=key.hashCode();
        int index=hashCode%this.capacity;
        Node<K,V> head=array[index];
        while (head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }

    public  void remove(K key){
        int hashCode=key.hashCode();
        int index=hashCode%this.capacity;
        if(array[index]==null)return;

        else{
            if(array[index].key==key){
                array[index]=array[index].next;
                if(array[index]==null)currentSize--;

            }else{
                Node<K,V> head=this.array[index].next;
                Node<K,V> pre=head;
                while (head.next!=null){
                    if(head.key==key){
                        pre.next=head.next;
                        return;
                    }
                    pre=head;
                    head=head.next;
                }

            }
        }
    }
    private void rehash() {
        int newSize=this.capacity*2;
        Node<K,V> []newArray=new Node[newSize];
        for(int i=0;i<this.capacity;i++){
            if(array[i]!=null){
                int hashCode=array[i].hashCode();
                int newIndex=hashCode%newSize;
                newArray[newIndex]=array[i];
            }
        }
        array=newArray;
        this.capacity=this.capacity*2;
    }
}
