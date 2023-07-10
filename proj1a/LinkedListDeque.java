public class LinkedListDeque<T> {

    private class Node{
        public T item;
        public Node next;
        public Node prev;
        public Node(Node p, T i,Node n) {
            this.item = i;
            this.next = n;
            this.prev = p;
        }
    }

    private Node sentinel;
    private int size;
    private Node last;
    public LinkedListDeque(){
        this.sentinel = new Node(null,null,null);
        this.size = 0;
        this.last = sentinel;
    }


    public LinkedListDeque(T first){
        this.sentinel = new Node(null,null,null);
        this.sentinel.next = new Node(sentinel, first,null);
        this.size = 1;
        this.last = sentinel.next;
    }

    public int size(){
        return size;
    }
    public Boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public void addFirst(T item){
        Node newNode = new Node(sentinel, item,null);
        sentinel.next = newNode;
        last = newNode;
        size = size+1;
    }

    public T removeFirst(){
        T output = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return output;
    }

    public T removeLast(){
        T output = last.item;
        if (size > 0) {
            last.prev.next = last.next;
            size -= 1;
        }
        return output;
    }

    public void addLast(T item){
        Node lastNode = new Node(last, item,null);

        last.next = lastNode;
        last = lastNode;
        size += 1;
    }

    public void printDeque() {
        Node temp = sentinel.next;
        while (temp != null) {
            System.out.print(temp.item+" ");
            temp = temp.next;
        }
    }

    public T getRecursive(int index){
        if (index == 0){
            return sentinel.next.item;
        }
        return recursiveHelper(sentinel.next, index-1);
    }

    public T recursiveHelper(Node n, int index){
        if (index == 0){
            return n.item;
        }
        return recursiveHelper(n.next, index-1);

    }

    public T get(int index){
        Node output = sentinel.next;
        for(int i = 0; i < index; i++){
            output = output.next;
        }
        return output.item;
    }
}
