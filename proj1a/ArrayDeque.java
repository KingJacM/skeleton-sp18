public class ArrayDeque<T> {
    private T[] array;
    int size;
    int front;
    int back;
    int capacity = 8;

    public ArrayDeque() {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.back = 1;
    }
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (T t: this.array) {
            System.out.print(t + " ");
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[index];
    }

    public void addFirst(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        size += 1;
        array[front] = item;
        front = (front - 1 + array.length) % array.length;

    }

    public void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        int frontOfList = this.front + 1;
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[frontOfList];
            frontOfList = (frontOfList + 1) % this.array.length;
        }
        this.array = newArray;
        this.front = this.array.length - 1;
        this.back = this.size;
    }


    public T removeFirst() {
        if (size == 0){
            return null;
        }

        size -= 1;
        array[front + 1] = null;
        front = (front + 1 + array.length) % array.length;
        T temp = array[front + 1];
        return temp;
    }

    public void addLast(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        size += 1;
        // yet to implement size increase
        this.array[back] = item;
        back = (back + 1) % array.length;
    }

    public T removeLast() {
        if (size == 0){
            return null;
        }
        // is this correct?

        this.array[back] = null;
        size -= 1;
        back = (back - 1) % array.length;
        T temp = this.array[back];
        return temp;
    }




}
