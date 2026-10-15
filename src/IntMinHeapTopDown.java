public class IntMinHeapTopDown implements IntQueue {
    private IntArray heap;

    public IntMinHeapTopDown() {
        heap = new IntArray();
    }

    public IntMinHeapTopDown(int[] values) {
        heap = new IntArray();
        for (int i = 0; i < values.length; i++) {
            enqueue(values[i]);
        }
    }

    @Override
    public void enqueue(int value) {
        heap.add(value);
        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) > heap.get(i)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, temp);
                i = parent;
            } else {
                break;
            }
        }
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    private void siftDown(int i) {
        int size = heap.size();
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                int temp = heap.get(i);
                heap.set(i, heap.get(smallest));
                heap.set(smallest, temp);
                i = smallest;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        IntMinHeapTopDown heap = new IntMinHeapTopDown();
        System.out.println(heap);
        heap.enqueue(4);
        heap.enqueue(1);
        heap.enqueue(7);
        heap.enqueue(5);
        heap.enqueue(2);
        heap.enqueue(8);
        heap.enqueue(3);
        heap.enqueue(6);
        System.out.println(heap);
    }
}
