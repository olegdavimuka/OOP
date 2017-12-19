class JQueue {

    private String[] array;
    private int size;
    private int count;
    private int first;
    private int last;

    JQueue(int queueSize) {
        size = queueSize;
        array = new String[size];
        first = 0;
        last = -1;
        count = 0;
    }

    void insert(String name) {
        if(last == size - 1)
            last = -1;
        array[++last] = name;
        count++;
    }

    String pop()
    {
        String element = array[first++];
        if(first == size)
            first = 0;
        count--;
        return element;
    }

    int size() {
        return count;
    }

    boolean isEmpty() {
        return (count == 0);
    }
}