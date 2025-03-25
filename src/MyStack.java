import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> data;

    static public class EmptyStackException extends Exception {
        public EmptyStackException(String msg) {
            super(msg);
        }
    }

    public MyStack() {
        data = new LinkedList<>();
    }

    public void add(T value) {
        data.add(value);
    }

    public T peek() throws EmptyStackException {
        if (data.isEmpty()) throw new EmptyStackException("stuck is empty");
        return data.getLast();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public T pop() throws EmptyStackException{
        if (data.isEmpty()) throw new EmptyStackException("stuck is empty");
        return data.removeLast();
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public int size() {
        return data.size();
    }
}
