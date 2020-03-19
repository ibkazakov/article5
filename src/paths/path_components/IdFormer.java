package paths.path_components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IdFormer {
    public static void formIds(List<ZVector> points) {
        Set<ZVector> uniquePointsSet = new HashSet<ZVector>();
        for(ZVector point : points) {
          uniquePointsSet.add(point);
        }
        List<ZVector> uniquePoints = new ArrayList<ZVector>(uniquePointsSet);
        for(int i = 0; i < uniquePoints.size(); i++) {
            ZVector currentUnique = uniquePoints.get(i);
            for(ZVector zVector : points) {
                if (zVector.equals(currentUnique)) {
                    zVector.setId(i + 1);
                }
            }
        }
    }

    public static void markPaths(List<AlicePath> alicePaths, int pathLength) {
        for(int i = 0; i < pathLength; i++) {
            // i-th slice
            List<ZVector> slice = new ArrayList<ZVector>();
            for(AlicePath alicePath : alicePaths) {
                slice.add(alicePath.get(i));
            }
            formIds(slice);
        }
    }


    public static AliceIdPath formIdPath(AlicePath alicePath, int pathLength) {
        AliceIdPath idPath = new AliceIdPath(pathLength);
        for(int i = 0; i < pathLength; i++) {
            idPath.set(i, alicePath.get(i).getId());
        }
        return idPath;
    }


    public static List<AliceIdPath> formIdPaths(List<AlicePath> alicePathList, int pathLength) {
        List<AliceIdPath> result = new ArrayList<AliceIdPath>();
        for(AlicePath alicePath : alicePathList) {
            result.add(formIdPath(alicePath, pathLength));
        }
        return result;
    }
}
