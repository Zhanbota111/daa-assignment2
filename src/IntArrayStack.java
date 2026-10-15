public class IntArrayStack implements IntStack {
    private IntArray array;

    public IntArrayStack() {
        array = new IntArray();
    }

    @Override
    public void push(int value) {
        array.add(value);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return value;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array.get(array.size() - 1);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.size() == 0;
    }

    @Override
    public String toString() {
        // "[]" для пустого стека
        // "[7, 8, 6]" для непустого (элементы от дна к вершине)
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i < array.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}