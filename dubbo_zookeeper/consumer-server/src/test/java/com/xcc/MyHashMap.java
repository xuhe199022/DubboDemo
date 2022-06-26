package com.xcc;

/**
 * @author xuhe
 * @PackageName:com.xcc
 * @ClassName:MyHashMap
 * @Description:
 * @data 2022/6/9 20:15
 */
public class MyHashMap{
    static class Node{
        int key,value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private final static int CAPACITY = 10000;
    Node[] nodes = new Node[CAPACITY];

    private int getIndex(int k){
        int hash = Integer.hashCode(k);
        hash ^= (hash>>16);//使用高16位与低16位进行异或，这样可以保证高位的数据也参与到与运算中来，以增大索引的散列程度，让数据分布得更为均匀
        return hash%CAPACITY;
    }

    public int get (int k){
        Node n = nodes[getIndex(k)];
        if(n != null){
            if(n.key == k){
                return n.value;
            }else{
                while(n != null){
                    if(n.key == k){
                        return n.value;
                    }
                    n=n.next;
                }
            }
        }
        return -1;
    }

    public void put(int k,int value){
        Node n = nodes[getIndex(k)];
        Node tmp = n;
        if(tmp !=null){
            Node pre = null;
            while(tmp !=null){
                if(tmp.key==k){
                    tmp.value = value;
                    return;
                }else{
                   tmp = tmp.next;
                   pre = tmp;
                }
                tmp = pre;
            }
        }
        Node node = new Node(k,value);
        if(tmp !=null){
            tmp.next = node;
        }else{
            nodes[getIndex(k)]= node;
        }

    }

    public void remove(int key){
        int idx = getIndex(key);
        Node now = nodes[idx];

        if (now != null) {
            Node prev = null;
            while (now != null) {
                if (now.key == key) {
                    if (prev != null) {
                        prev.next = now.next;
                    }else {
                        nodes[idx] = now.next;
                    }
                    now.next = null;
                    return;
                }
                prev = now;
                now = now.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        map.put(1,40);
        map.put(2,200);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }

}
