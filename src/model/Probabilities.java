package model;

import java.util.ArrayList;
import java.util.List;

public class Probabilities {
    public static double basic_probability = 0.9;

    public static double calculate(boolean[] active_columns) {
        int counter = 0;
        for(int i = 0; i < active_columns.length; i++) {
            if (active_columns[i]) {
                counter++;
            }
        }

        // p^c (1 - p)^(n - c)
        return Math.pow(basic_probability, counter) *
                Math.pow(1 - basic_probability, active_columns.length - counter);
    }

    private static int pow2(int columns) {
        int result = 1;
        for(int i = 0; i < columns; i++) {
            result *= 2;
        }
        return result;
    }

    public static List<ActiveColumns> allActiveColums(int columns) {
        List<ActiveColumns> all = new ArrayList<>();
        int pow2_columns = pow2(columns);
        for(int i = 0; i < pow2_columns; i++) {

            ActiveColumns activeColumns = new ActiveColumns(columns);

            int current = i;
            for(int j = 0; j < columns; j++)
            {
                int mod = current % 2;
                current = current / 2;
                if (mod == 1) {
                    activeColumns.getActiveColumns()[j] = true;
                } else {
                    activeColumns.getActiveColumns()[j] = false;
                }
            }

            all.add(activeColumns);
        }
        return all;
    }
}
