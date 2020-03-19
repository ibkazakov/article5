package table;

import model.ActiveColumns;
import model.Probabilities;
import paths.path_components.AliceIdPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// table of Alice paths
public class Table {
    private int columns;


    private List<Row> rows = new ArrayList<>();

    public Table(int columns) {
        this.columns = columns;
    }

    public void addRow(Row newRow) {
       rows.add(newRow);
    }


    public void lexicPreSort(boolean[] active_columns) {
        Collections.sort(rows, new Comparator<Row>() {
            @Override
            public int compare(Row r1, Row r2) {
                // lexicographic
                long[] content1 = r1.getContent();
                long[] content2 = r2.getContent();
                for(int i = 0; i < columns; i++) {
                    if (active_columns[i]) {
                        if (content1[i] < content2[i]) {
                            return -1;
                        }
                        if (content2[i] < content1[i]) {
                            return 1;
                        }
                    }
                }
                return 0;
            }
        });
    }


    private boolean rowsEqual(Row r1, Row r2, boolean[] active_colums) {
        for(int i = 0; i < active_colums.length; i++) {
            if (active_colums[i]) {
                if (r1.getContent()[i] != r2.getContent()[i]) {
                    return false;
                }
            }
        }
        return true;
    }


    public List<Row> getUnique(boolean[] active_columns) {
        List<Row> uniques = new ArrayList<>();
        Row last_uniq = null;
        int counter = 0;
        for(int i = 0; i < rows.size(); i++) {
            Row current = rows.get(i);

            if (last_uniq == null) {
                last_uniq = current;
                counter = 1;
                continue;
            }

            if (rowsEqual(last_uniq, current, active_columns)) {
                counter++;
            } else {
                if (counter == 1) {
                    uniques.add(last_uniq);
                }

                counter = 1;
                last_uniq = current;
            }
        }

        if (counter == 1) {
            uniques.add(last_uniq);
        }

        return uniques;
    }


    public void process(ActiveColumns activeColumns) {
        boolean[] active_colums = activeColumns.getActiveColumns();
        lexicPreSort(active_colums);
        List<Row> unique_rows = getUnique(active_colums);
        double probability = Probabilities.calculate(active_colums);
        for (Row row : unique_rows) {
            row.setProbability(row.getProbability() + probability);
        }
    }

    public void totalProcessing() {
        List<ActiveColumns> activeColumns = Probabilities.allActiveColums(columns);
        for(int i = 0; i < activeColumns.size(); i++) {
            process(activeColumns.get(i));
        }
    }


    public List<Row> getRows() {
        return rows;
    }

    public void fillTable(List<AliceIdPath> aliceIdPaths, int repeat) {
        int pathSize = aliceIdPaths.get(0).getSize();
        columns = pathSize * repeat;
        for(int i = 0; i < aliceIdPaths.size(); i++) {
            AliceIdPath currentIdPath = aliceIdPaths.get(i);
            Row newRow = new Row(i, columns);
            long[] rowContent = newRow.getContent();
            for(int j = 0; j < repeat; j++) {
                for(int k = 0; k < pathSize; k++) {
                    rowContent[j * pathSize + k] = currentIdPath.get(k);
                }
            }
            rows.add(newRow);
        }
    }


}
