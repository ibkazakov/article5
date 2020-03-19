package exec;

import model.ActiveColumns;
import model.Probabilities;
import paths.path_components.*;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> findUniques(int[] array) {
        List<Integer> results = new ArrayList<>();
        int counter = 0;
        Integer last_unique = null;

        for(int i = 0; i < array.length; i++) {
            if (last_unique == null) {
                last_unique = array[0];
                counter = 1;
                continue;
            }
            if (array[i] == last_unique) {
                counter++;
            } else {

                if (counter == 1) {
                    results.add(last_unique);
                }

                counter = 1;
                last_unique = array[i];
            }
        }

        if (counter == 1) {
            results.add(last_unique);
        }

        return results;
    }

    private static List<ActiveColumns> testgen() {
        return Probabilities.allActiveColums(9);
    }

    private static void fillTable() {
        Table table = new Table(0);
        int pathLength = 3;
        AlicePathProliferator proliferator = new AlicePathProliferator(BaseGenerator.getBase6());
        List<AlicePath> alicePaths = proliferator.prolifePaths(pathLength);
        IdFormer.markPaths(alicePaths, pathLength);
        List<AliceIdPath> idPaths = IdFormer.formIdPaths(alicePaths, pathLength);

        table.fillTable(idPaths, 3);

        int addedRows = table.getRows().size();

        System.out.println( "rows = " + addedRows);
        System.out.println("paths = " + idPaths.size());
    }

    private static void totalProcessingTesting()  {
        Table table = new Table(0);
        int pathLength = 4;
        AlicePathProliferator proliferator = new AlicePathProliferator(BaseGenerator.getBase6());
        List<AlicePath> alicePaths = proliferator.prolifePaths(pathLength);
        IdFormer.markPaths(alicePaths, pathLength);
        List<AliceIdPath> idPaths = IdFormer.formIdPaths(alicePaths, pathLength);

        table.fillTable(idPaths, 3);

        table.totalProcessing();

        List<Row> rows = table.getRows();
        for(int i = 0; i < rows.size(); i++) {
            Row currentRow = rows.get(i);
            System.out.println( "row_num = " + currentRow.getId() +
                    " probability = " +  currentRow.getProbability()
                    + " path = " + currentRow);
        }


    }

    private static void extrProbabilies(int pathLength, int repeat) {
        Table table = new Table(0);
        AlicePathProliferator proliferator = new AlicePathProliferator(BaseGenerator.getBase6());
        List<AlicePath> alicePaths = proliferator.prolifePaths(pathLength);
        IdFormer.markPaths(alicePaths, pathLength);
        List<AliceIdPath> idPaths = IdFormer.formIdPaths(alicePaths, pathLength);

        table.fillTable(idPaths, repeat);

        table.totalProcessing();

        List<Row> rows = table.getRows();

        double min_probabitity = rows.get(0).getProbability();
        double max_probability = rows.get(0).getProbability();

        for(int i = 0; i < rows.size(); i++) {
            double current_probability = rows.get(i).getProbability();
            if (current_probability < min_probabitity) {
                min_probabitity = min_probabitity;
            }
            if (current_probability > max_probability) {
                max_probability = current_probability;
            }
        }

        System.out.println("repeat = " + repeat + " min = " + min_probabitity +
                " max = " + max_probability);
    }



    public static void main(String[] args) {
        System.out.println("Hello, world");
        int[] array = {1, 1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> uniques = findUniques(array);

        //System.out.println(testgen());

        //System.out.println(uniques);

        //fillTable();
        // totalProcessingTesting();
        for(int i = 1; i <= 4; i++) {
            extrProbabilies(4, i);
        }
    }
}
