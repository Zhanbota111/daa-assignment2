public class IntArray {
    private int[] A;
    private int size;

    public IntArray() {
        size = 0;
        A = new int[4];
    }

    public IntArray(int capacity) {
        size = 0;
        A = new int[Math.max(capacity, 4)];
    }

    public void add(int value) {
        if (size == A.length) {
            int[] B = new int[A.length * 2];
            for (int i = 0; i < A.length; i++) {
                B[i] = A[i];
            }
            A = B;
        }

        A[size] = value;
        size++;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size == A.length) {
            int[] B = new int[A.length * 2];
            for (int i = 0; i < A.length; i++) {
                B[i] = A[i];
            }
            A = B;
        }

        for (int i = size; i > index; i--) {
            A[i] = A[i - 1];
        }

        A[index] = value;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return A[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        A[index] = value;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int value = A[index];

        for (int i = index; i < size - 1; i++) {
            A[i] = A[i + 1];
        }

        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int[] values) {
        for (int i = 0; i < values.length; i++) {
            add(values[i]);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size - 1; i++) {
            s.append(A[i]);
            s.append(", ");
        }
        s.append(A[size - 1]);
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        IntArray array = new IntArray();
        array.add(new int[]{4, 5, 6, 7, 8, 5, 6});
        System.out.println(array);
        array.add(3);
        array.add(4);
        array.add(7);
        System.out.println(array);
    }
}