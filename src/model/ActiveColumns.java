package model;

public class ActiveColumns {
    private int columns;
    private boolean[] activeColumns;

    public ActiveColumns(int columns) {
        this.columns = columns;
        activeColumns = new boolean[columns];
    }

    public boolean[] getActiveColumns() {
        return activeColumns;
    }

    @Override
    public String toString() {
       StringBuffer stringBuffer = new StringBuffer();
       stringBuffer.append('<');
       for (int i = 0; i < columns; i++) {
           stringBuffer.append(Boolean.toString(activeColumns[i]));
           if (i != columns - 1) {
                stringBuffer.append(", ");
           }
       }
       stringBuffer.append('>');
       return stringBuffer.toString();
    }
}
