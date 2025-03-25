import java.util.Arrays;

public class MySet <T extends Comparable<T>> {
    private int capacity;
    private int size;
    private Object[] data;

    static public class SetException extends Exception {
        public SetException(String msg) {
            super(msg);
        }
    }

    public MySet(int _capacity) {
        this.capacity = _capacity;
        this.size = 0;
        data = new Object[this.capacity];
    }

    public boolean isFull() {
        return (capacity == size);
    }

    public boolean isEmpty() {
        return (0 == size);
    }

    public void add(T value) throws SetException {
        if (isFull()) {
            throw new SetException("set is full!");
        }
        else {
            if (isEmpty()) {
                data[0] = value;
                size++;
            } else {
                for (int i = 0; i < size; i++) {
                    if (value.compareTo((T)data[i]) == 0) {
                        return;
                    } else if (value.compareTo((T)data[i]) == -1) {
                        // start from end and shift all values and set new one
                        for (int j = size; j > i; j--) {
                            data[j] = data[j-1];
                        }
                        data[i] = value;
                        size++;
                        return;
                    }
                }
                data[size] = value;
                size++;
            }
        }
    }

    public int find(T value) {
        if (isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                if (value.compareTo((T)data[i]) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean remove(T value) {
        int index = find(value);
        if (index == -1) {
            return false;
        } else {
            for (int i = index; i < size-1; i++) {
                data[i] = data[i+1];
            }
            data[size-1] = null;
            size--;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Capasity: " + capacity +
                "\nSize: " + size +
                "\nData: " + Arrays.toString(data);
    }

    public void add_set(MySet<T> set1) {
        int new_capacity = 0;
        if ((size + set1.size) <= capacity) {
            new_capacity = this.capacity;
        } else {
            new_capacity = this.capacity*2;
        }

        Object[] newData = new Object[new_capacity];
        int i = 0;
        int my_i = 0;
        int other_i = 0;

        while (my_i != size && other_i != set1.size) {
            int comp_val = ((T)data[my_i]).compareTo((T)set1.data[other_i]);
            if (comp_val == -1) {
                newData[i] = data[my_i];
                my_i++;
                i++;
            } else if (comp_val == 0) {
                newData[i] = data[my_i];
                my_i++;
                other_i++;
                i++;
            } else {
                newData[i] = set1.data[other_i];
                other_i++;
                i++;
            }
        }

        System.out.println(i + " " + my_i + " " + other_i);

        // add rest to new data
        if (my_i < size) {
            for (int _i = my_i; _i < size; _i++) {
                newData[i] = data[_i];
                i++;
            }
        }

        if (other_i < set1.size) {
            for (int _i = other_i; _i < set1.size; _i++) {
                newData[i] = set1.data[_i];
                i++;
            }
        }

        System.out.println(size + " " + set1.size);
        size = size + set1.size;
        data = newData; // old data will be deleted;
}

    public void subtract_set(MySet<T> set1) {

    }

    public void intersect_set(MySet<T> set1) {

    }
}
