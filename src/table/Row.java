package table;

public class Row {
    private int id;
    private long[] content;

    private double probability = 0.0;

    public Row(int id, int size) {
       this.id = id;
       content = new long[size];
    }

    public int getId() {
        return id;
    }

    public long[] getContent() {
        return content;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append('[');
        for(int i = 0; i < content.length; i++) {
            stringBuffer.append(content[i]);
            if (i != content.length - 1) {
                stringBuffer.append(" -> ");
            }
        }
        stringBuffer.append(']');

        return stringBuffer.toString();
    }
}
