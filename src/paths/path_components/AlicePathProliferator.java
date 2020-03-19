package paths.path_components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlicePathProliferator {
    private List<ZVector> baseVectors;

    public AlicePathProliferator(List<ZVector> baseVectors) {
        this.baseVectors = baseVectors;
    }

    public AlicePath generatePath(AlicePathSignature signature) {
        int degree = baseVectors.get(0).getSize();
        AlicePath alicePath = new AlicePath();
        ZVector currentPoint = new ZVector(degree);
        for(int i = 0; i < signature.getSize(); i++) {
            ZVector clonePoint = currentPoint.clone();
            ZVector deltaVector = baseVectors.get(signature.getContent()[i]).clone();

            if ((baseVectors.size() % 2 == 1) && (i % 2 == 1)) {
                deltaVector.invert();
            }

            clonePoint.add(deltaVector);

            alicePath.add(clonePoint);
            currentPoint.copy(clonePoint);
        }
        return alicePath;
    }

    public List<AlicePath> toAlicePaths(List<AlicePathSignature> signatures) {
        List<AlicePath> result = new ArrayList<AlicePath>();
        for(AlicePathSignature signature : signatures) {
            result.add(generatePath(signature));
        }
        return result;
    }

    public List<AlicePath> prolifePaths(int pathLength) {
        List<AlicePathSignature> alicePathSignatures = prolifeSignatures(pathLength);
        return toAlicePaths(alicePathSignatures);
    }

    public List<AlicePathSignature> prolifeSignatures(int pathLength) {
        List<AlicePathSignature> signatures = new ArrayList<>();
        int directions = baseVectors.size();

        // from 0 to dir - 1 in sigs[i]
        // i = 0...pathleng-1
        long signsQuality = 1;
        for(int i = 0; i < pathLength; i++) {
            signsQuality *= directions;
        }

        for(long i = 0L; i < signsQuality; i++) {
            long currentValue = i;
            AlicePathSignature newSignature = new AlicePathSignature(pathLength);
            for(int j = 0; j < pathLength; j++) {
                long settingValue = currentValue % directions;
                currentValue = currentValue / directions;
                newSignature.getContent()[j] = (int)settingValue;
            }
            signatures.add(newSignature);
        }


        return signatures;
    }
}
