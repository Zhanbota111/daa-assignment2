public class IntMinHeapBottomUp implements IntQueue {
    private IntArray array;

    public IntMinHeapBottomUp() {
        array = new IntArray();
    }

    public IntMinHeapBottomUp(int[] values) {
        array = new IntArray();
        for (int v : values) {
            array.add(v);
        }
        for (int i = (array.size() - 2) / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public void enqueue(int value) {
        array.add(value);
        siftUp(array.size() - 1);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        int min = array.get(0);
        int last = array.remove(array.size() - 1);
        if (!array.isEmpty()) {
            array.set(0, last);
            siftDown(0);
        }
        return min;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        return array.get(0);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return array.toString();
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (array.get(i) < array.get(parent)) {
                int temp = array.get(i);
                array.set(i, array.get(parent));
                array.set(parent, temp);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int i) {
        int size = array.size();
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (array.get(left) < array.get(smallest)) {
                smallest = left;
            }
            if (right < size && array.get(right) < array.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                int temp = array.get(i);
                array.set(i, array.get(smallest));
                array.set(smallest, temp);
                i = smallest;
            } else {
                break;
            }
        }
    }
}
