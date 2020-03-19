public class DataSet {
    double[][] content_min;
    double[][] content_max;

    // -1 / ln(1 - p)
    double[][] coeff_min;
    double[][] coeff_max;

    double[][] speed_min;
    double[][] speed_max;

    private static double H1024 = 7.509175672278133833377072837520713172163511820752436272029;

    private static double DENSITY = Math.log(1296) / Math.log(2);

    private static double TRAC_PER_SECOND = 9.0;


    public DataSet() {
        content_min = new double[9][4];
        content_max = new double[9][4];

        coeff_min = new double[9][4];
        coeff_max = new double[9][4];

        speed_min = new double[9][4];
        speed_max = new double[9][4];

        // p = 0.1
        content_min[0][0] = 1.0000000000000002E-4;
        content_min[0][1] = 0.0013032099999999993;
        content_min[0][2] = 0.005393580481000333;
        content_min[0][3] = 0.013987132961187925;

        content_max[0][0] = 0.09999999999999999;
        content_max[0][1] = 0.18999999999999911;
        content_max[0][2] = 0.27100000000000773;
        content_max[0][3] = 0.3439000000000889;

        // p = 0.2
        content_min[1][0] = 0.0016000000000000003;
        content_min[1][1] = 0.01679616;
        content_min[1][2] = 0.05671256473599951;
        content_min[1][3] = 0.12150255072710166;

        content_max[1][0] = 0.20000000000000004;
        content_max[1][1] = 0.3599999999999998;
        content_max[1][2] = 0.4880000000000181;
        content_max[1][3] = 0.5904000000004008;


        // p = 0.3
        content_min[2][0]  = 0.0081;
        content_min[2][1]  = 0.06765200999999989;
        content_min[2][2]  = 0.18632085920100427;
        content_min[2][3]  = 0.33344620425308913;

        content_max[2][0]  = 0.2999999999999999;
        content_max[2][1]  = 0.5099999999999997;
        content_max[2][2]  = 0.6569999999999651;
        content_max[2][3]  = 0.7599000000002564;


        // p = 0.4
        content_min[3][0] = 0.025600000000000005;
        content_min[3][1] = 0.16777216000000014;
        content_min[3][2] = 0.37780199833601164;
        content_min[3][3] = 0.5739519416466792;

        content_max[3][0] = 0.4000000000000001;
        content_max[3][1] = 0.6399999999999991;
        content_max[3][2] = 0.783999999999997;
        content_max[3][3] = 0.8703999999999473;


        // p = 0.5
        content_min[4][0] = 0.0625;
        content_min[4][1] = 0.31640625;
        content_min[4][2] = 0.586181640625;
        content_min[4][3] = 0.7724761962890625;

        content_max[4][0] = 0.5;
        content_max[4][1] = 0.75;
        content_max[4][2] = 0.875;
        content_max[4][3] = 0.9375;


        // p = 0.6
        content_min[5][0] = 0.1296;
        content_min[5][1] = 0.49787136000000004;
        content_min[5][2] = 0.767544201215994;
        content_min[5][3] = 0.9014654806327885;

        content_max[5][0] = 0.6000000000000001;
        content_max[5][1] = 0.8399999999999985;
        content_max[5][2] = 0.9359999999999895;
        content_max[5][3] = 0.9744000000000734;


        // p = 0.7
        content_min[6][0] = 0.24009999999999995;
        content_min[6][1] = 0.6857496099999997;
        content_min[6][2] = 0.8962957994409971;
        content_min[6][3] = 0.9679915385408718;

        content_max[6][0] = 0.7;
        content_max[6][1] = 0.9100000000000005;
        content_max[6][2] = 0.9729999999999901;
        content_max[6][3] = 0.9919000000002406;


        // p = 0.8
        content_min[7][0] = 0.4096000000000001;
        content_min[7][1] = 0.84934656;
        content_min[7][2] = 0.9683819560960043;
        content_min[7][3] = 0.9936153436225671;

        content_max[7][0] = 0.8;
        content_max[7][1] = 0.9599999999999999;
        content_max[7][2] = 0.9920000000000053;
        content_max[7][3] = 0.9984000000000304;


        // p = 0.9
        content_min[8][0] = 0.6561;
        content_min[8][1] = 0.9605960099999997;
        content_min[8][2] = 0.9960059960009918;
        content_min[8][3] = 0.999600059996102;

        content_max[8][0] = 0.9;
        content_max[8][1] = 0.9899999999999995;
        content_max[8][2] = 0.9989999999999901;
        content_max[8][3] = 0.9999000000001059;
    }

    public void calc_coeff() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 4; j++) {
                coeff_min[i][j] = -1 / Math.log(1 - content_min[i][j]);
                coeff_max[i][j] = -1 / Math.log(1 - content_max[i][j]);
            }
        }
    }

    // bits per second
    public void calc_information() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 4; j++) {
                speed_min[i][j] = TRAC_PER_SECOND * DENSITY / ((j + 1) * H1024 * coeff_min[i][j]);

                speed_max[i][j] = TRAC_PER_SECOND * DENSITY / ((j + 1) * H1024 * coeff_max[i][j]);
            }
        }
    }

    public void print_information(int pro) {
        for(int j = 0; j < 4; j++) {
            System.out.println("inf: " + "repeat = " + (j + 1)
                    + " min = " + speed_min[pro - 1][j] +
                    " max = " + speed_max[pro - 1][j]);
        }
    }


    public void print_q(int pro) {
            for(int j = 0; j < 4; j++) {
                System.out.println("q: " + "repeat = " + (j + 1)
                        + " min = " + coeff_min[pro - 1][j] +
                        " max = " + coeff_max[pro - 1][j]);
            }
    }

}
