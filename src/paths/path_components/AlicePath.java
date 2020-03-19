package paths.path_components;

import java.util.ArrayList;
import java.util.List;

public class AlicePath {
    private List<ZVector> pathVectors = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("* ");
        for(int i = 0; i < pathVectors.size(); i++) {
            builder.append("-> " + pathVectors.get(i).toString() + " ");
        }
        return builder.toString();
    }

    public List<ZVector> getPathVectors() {
        return pathVectors;
    }

    public void add(ZVector newPoint) {
        pathVectors.add(newPoint);
    }

    public ZVector get(int index) {
        return pathVectors.get(index);
    }
}
