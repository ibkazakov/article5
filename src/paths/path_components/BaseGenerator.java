package paths.path_components;

import java.util.ArrayList;
import java.util.List;

public class BaseGenerator {
    //j = 2. Ф(x) = x + 1, k = 1
    public static List<ZVector> getBase2() {
        // 1 mod (x + 1) = 1
        ZVector vector0 = new ZVector(1, new long[]{1L});
        // x mod (x + 1) = -1
        ZVector vector1 = new ZVector(1, new long[]{-1L});

        List<ZVector> result = new ArrayList<ZVector>();

        result.add(vector0);
        result.add(vector1);
        return result;
    }

    // j = 3. Ф(x) = x^2 + x + 1, k = 2
    public static List<ZVector> getBase3() {
        // 1 mod x^2 + x + 1 = 1
        ZVector vector0 = new ZVector(2, new long[]{1L, 0L});
        // x mod x^2 + x + 1 = x
        ZVector vector1 = new ZVector(2, new long[]{0L, 1L});
        // x^2 mod x^2 + x + 1 = -1 - x
        ZVector vector2 = new ZVector(2, new long[]{-1L, -1L});

        List<ZVector> result= new ArrayList<ZVector>();

        result.add(vector0);
        result.add(vector1);
        result.add(vector2);

        return result;
    }

    // j = 4. Ф(x) = x^2 + 1, k = 2
    public static List<ZVector> getBase4() {
        // 1 mod (x^2 + 1) = 1
        ZVector vector0 = new ZVector(2, new long[]{1L, 0L});
        // x mod (x^2 + 1) = x
        ZVector vector1 = new ZVector(2, new long[]{0L, 1L});
        // x^2 mod (x^2 + 1) = -1
        ZVector vector2 = new ZVector(2, new long[]{-1L, 0L});
        // x^3 mod (x^2 + 1) = -x
        ZVector vector3 = new ZVector(2, new long[]{0L, -1L});

        List<ZVector> result = new ArrayList<ZVector>();

        result.add(vector0);
        result.add(vector1);
        result.add(vector2);
        result.add(vector3);

        return result;
    }


    // j = 5. Ф(x) = x^4 + x^3 + x^2 + x + 1, k = 4
    public static List<ZVector> getBase5() {
        // 1 mod () = 1
        ZVector vector0 = new ZVector(4, new long[]{1L, 0L, 0L, 0L});
        // x mod () = x
        ZVector vector1 = new ZVector(4, new long[]{0L, 1L, 0L, 0L});
        // x^2 mod () = x^2
        ZVector vector2 = new ZVector(4, new long[]{0L, 0L, 1L, 0L});
        // x^3 mod () = x^3
        ZVector vector3 = new ZVector(4, new long[]{0L, 0L, 0L, 1L});
        // x^4 mod () = -1 - x - x^2 - x^3
        ZVector vector4 = new ZVector(4, new long[]{-1L, -1L, -1L, -1L});

        List<ZVector> result = new ArrayList<ZVector>();

        result.add(vector0);
        result.add(vector1);
        result.add(vector2);
        result.add(vector3);
        result.add(vector4);

        return result;
    }


    // j = 6. Ф(x) = x^2 - x + 1, k = 2
    public static List<ZVector> getBase6() {
        // 1 mod () = 1
        ZVector vector0 = new ZVector(2, new long[]{1L, 0L});
        // x mod () = x
        ZVector vector1 = new ZVector(2, new long[]{0L, 1L});
        // x^2 mod () = -1 + x
        ZVector vector2 = new ZVector(2, new long[]{-1L, 1L});
        // x^3 mod () = -1
        ZVector vector3 = new ZVector(2, new long[]{-1L, 0L});
        // x^4 mod () = -x
        ZVector vector4 = new ZVector(2, new long[]{0L, -1L});
        // x^5 mod () = 1 - x
        ZVector vector5 = new ZVector(2, new long[]{1L, -1L});

        List<ZVector> result = new ArrayList<ZVector>();

        result.add(vector0);
        result.add(vector1);
        result.add(vector2);
        result.add(vector3);
        result.add(vector4);
        result.add(vector5);

        return result;

    }

    // j = 10. Ф(x) = x^4 - x^3 + x^2 - x + 1, k = 4
    public static List<ZVector> getBase10() {
        // 1 mod () = 1
        ZVector vector0 = new ZVector(4, new long[]{1L, 0L, 0L, 0L});
        // x mod () = x
        ZVector vector1 = new ZVector(4, new long[]{0L, 1L, 0L, 0L});
        // x^2 mod () = x^2
        ZVector vector2 = new ZVector(4, new long[]{0L, 0L, 1L, 0L});
        // x^3 mod () = x^3
        ZVector vector3 = new ZVector(4, new long[]{0L, 0L, 0L, 1L});
        // x^4 mod () = x^3 - x^2 + x - 1
        ZVector vector4 = new ZVector(4, new long[]{-1L, 1L, -1L, 1L});
        // x^5 mod () = -1
        ZVector vector5 = new ZVector(4, new long[]{-1L, 0L, 0L, 0L});
        // x^6 mod () = -x
        ZVector vector6 = new ZVector(4, new long[]{0L, -1L, 0L, 0L});
        // x^7 mod () = -x^2
        ZVector vector7 = new ZVector(4, new long[]{0L, 0L, -1L, 0L});
        // x^8 mod () = -x^3
        ZVector vector8 = new ZVector(4, new long[]{0L, 0L, 0L, -1L});
        // x^9 mod () = -x^3 + x^2 - x + 1
        ZVector vector9 = new ZVector(4, new long[]{1L, -1L, 1L, -1L});

        List<ZVector> result = new ArrayList<ZVector>();

        result.add(vector0);
        result.add(vector1);
        result.add(vector2);
        result.add(vector3);
        result.add(vector4);
        result.add(vector5);
        result.add(vector6);
        result.add(vector7);
        result.add(vector8);
        result.add(vector9);

        return result;

    }
}
