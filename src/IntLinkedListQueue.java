public class IntLinkedListQueue implements IntQueue {
    private IntLinkedList list;

    public IntLinkedListQueue() {
        list = new IntLinkedList();
    }

    @Override
    public void enqueue(int value) {
        list.addLast(value);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        // "[]" для пустой очереди
        // "[7, 8, 6]" для очереди с элементами (сначала head)
        return list.toString();
    }
}