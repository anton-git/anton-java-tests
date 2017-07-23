package structures;

public class Queue<E> implements AntonStructure<E> {

    private final static int MAX_QUEUE_LENGTH = 7;

    Object[] collection = new Object[MAX_QUEUE_LENGTH];
    int currentIndex = 0;


    @Override
    public void put(E element) {

        if (currentIndex == MAX_QUEUE_LENGTH) {
            throw new RuntimeException("Can not add element as queue is full.");
        }

        collection[currentIndex] = element;
        currentIndex++;
    }

    @Override
    public E getFirst() {
        if (currentIndex == 0) {
            throw new RuntimeException("No elements in the queue.");
        }

        E elementToPop = (E) collection[0];

        int i = 0;
        while (i + 1 < MAX_QUEUE_LENGTH) {
            collection[i] = collection[i + 1];
            i++;
        }
        currentIndex--;

        return elementToPop;
    }

    @Override
    public int getSize() {
        return currentIndex;
    }


    private static class Element<T> {
        T data;
        Element<T> next;

        private Element(T data, Element<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Element<T> getNext() {
            return next;
        }
    }
}
