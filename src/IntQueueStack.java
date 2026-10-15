public class IntQueueStack implements IntStack {
    private IntQueue q1;
    private IntQueue q2;

    public IntQueueStack() {
        q1 = new IntLinkedListQueue();
        q2 = new IntLinkedListQueue();
    }

    @Override
    public void push(int value) {
        q2.enqueue(value);
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        IntQueue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        return q1.dequeue();
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        return q1.peek();
    }

    @Override
    public int size() {
        return q1.size();
    }

    @Override
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        IntQueue temp = new IntLinkedListQueue();
        StringBuilder sb = new StringBuilder("[");
        int size = q1.size();
        for (int i = 0; i < size; i++) {
            int val = q1.dequeue();
            temp.enqueue(val);
        }
        for (int i = 0; i < size; i++) {
            int val = temp.dequeue();
            q1.enqueue(val);
            sb.append(val);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
