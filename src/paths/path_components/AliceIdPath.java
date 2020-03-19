package paths.path_components;

public class AliceIdPath {
    private long[] pathContent;
    private int size;

    public AliceIdPath(int size) {
        this.size = size;
        pathContent = new long[size];
    }

    public long get(int index) {
        return pathContent[index];
    }

    public int getSize() {
        return size;
    }

    public void set(int index, long value) {
        pathContent[index] = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("** -> ");
        for(int i = 0; i < size; i++) {
            builder.append(pathContent[i]);
            if (i != size - 1) {
                builder.append(" -> ");
            }
        }
        return builder.toString();
    }
}
