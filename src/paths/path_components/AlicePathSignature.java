package paths.path_components;

public class AlicePathSignature {
    private int size;
    private int[] content;

    public AlicePathSignature(int size) {
        this.size = size;
        content = new int[size];
    }

    public int[] getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for(int i = 0; i < size; i++) {
            builder.append(content[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(")");
        return builder.toString();
    }
}
