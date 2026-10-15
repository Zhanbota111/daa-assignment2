public class IntStackQueue implements IntQueue {
    private IntStack inStack;
    private IntStack outStack;

    public IntStackQueue() {
        inStack = new IntArrayStack();
        outStack = new IntArrayStack();
    }

    @Override
    public void enqueue(int value) {
        inStack.push(value);
    }

    @Override
    public int dequeue() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return outStack.pop();
    }

    @Override
    public int peek() {
        shiftStacks();
        if (outStack.isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return outStack.peek();
    }

    @Override
    public int size() {
        return inStack.size() + outStack.size();
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        IntStack temp1 = new IntArrayStack();
        IntStack temp2 = new IntArrayStack();

        while (!outStack.isEmpty()) {
            temp1.push(outStack.pop());
        }
        while (!inStack.isEmpty()) {
            temp2.push(inStack.pop());
        }

        StringBuilder sb = new StringBuilder("[");
        boolean first = true;

        while (!temp1.isEmpty()) {
            int val = temp1.pop();
            outStack.push(val);
            if (!first) {
                sb.append(", ");
            }
            sb.append(val);
            first = false;
        }

        while (!temp2.isEmpty()) {
            int val = temp2.pop();
            inStack.push(val);
            if (!first) {
                sb.append(", ");
            }
            sb.append(val);
            first = false;
        }

        sb.append("]");
        return sb.toString();
    }

    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}