public class LinkedListDeque<T> {

    private class Node {
        private T item;
        private Node next;
        private Node prev;
        public Node(Node p, T i, Node n) {
            this.item = i;
            this.next = n;
            this.prev = p;
        }
    }

    private Node sentinel;
    private int size;
    private Node last;
    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
        // this.last = sentinel;
    }


    public LinkedListDeque(T first) {
        this.sentinel = new Node(null, null, null);
        Node newNode = new Node(sentinel, first, sentinel);
        this.sentinel.next = newNode;
        // new added
        this.sentinel.prev = newNode;
        this.size = 1;
        this.last = sentinel.next;
    }

    public int size() {
        return size;
    }
    public Boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        //I forgot to change the prev pointer too
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size = size + 1;
        // newly added
        if (size == 1) {
            last = newNode;
        }
    }

    public T removeFirst() {
        if (size == 0){
            return null;
        }

        // uses a temp variable to store output
        // T output = sentinel.next.item;

        // added prev change
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        if (size == 0){
            last = sentinel;
        }
        return sentinel.next.item;
    }

    public T removeLast() {
        if (size == 0){
            return null;
        }
        T output = last.item;
        last.prev = last;

        // Altering sentinel to update reference
        last.next = sentinel;
        sentinel.prev = last;

        // I guess this is wrong then
        // last.prev.next = last.next;
        size -= 1;

        return last.item;
    }

    public void addLast(T item) {
        Node lastNode = new Node(last, item, sentinel);
        last.next = lastNode;
        sentinel.prev = lastNode;
        last = lastNode;
        size += 1;
    }

    public void printDeque() {
        Node temp = sentinel.next;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return recursiveHelper(sentinel.next, index);
    }

    private T recursiveHelper(Node n, int index) {
        if (index == 0) {
            return n.item;
        }
        return recursiveHelper(n.next,  index - 1);

    }

    public T get(int index) {
        // add edge condition
        if (index >= size) {
            return null;
        }
        Node output = sentinel.next;
        for (int i = 0; i < index; i++) {
            output = output.next;
        }
        return output.item;
    }
}
