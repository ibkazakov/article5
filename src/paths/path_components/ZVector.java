package paths.path_components;

import java.util.Arrays;
import java.util.Objects;

public class ZVector {
    private int size;
    private long[] content;

    private long id = 0L;

    public long getId() {
        return id;
    }

    public void setId(long id) {
       this.id = id;
    }

    public ZVector(int size) {
        this.size = size;
        content = new long[size];
        for(int i = 0; i < size; i++) {
            content[i] = 0L;
        }
    }

    public ZVector(int size, long... content) {
        this.size = size;
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public long get(int index) {
        return content[index];
    }

    public void set(int index, long value) {
        content[index] = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        for(int i = 0; i < size; i++) {
            builder.append(content[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(')');
        return builder.toString();
    }

    @Override
    public ZVector clone() {
        ZVector copy = new ZVector(size);
        for(int i = 0; i < size; i++) {
            copy.content[i] = content[i];
        }
        return copy;
    }

    public void add(ZVector other) {
        for(int i = 0; i < size; i++) {
            content[i] += other.content[i];
        }
    }

    public void invert() {
        for(int i = 0; i < size; i++) {
            content[i] *= -1;
        }
    }

    public void copy(ZVector other) {
        for(int i = 0; i < size; i++) {
            content[i] = other.content[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZVector)) return false;
        ZVector zVector = (ZVector) o;
        return size == zVector.size &&
                Arrays.equals(content, zVector.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
