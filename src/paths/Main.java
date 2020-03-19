package paths;

import paths.path_components.*;

import java.util.List;


public class Main {


    public static void main(String[] args) {
        int pathLength = 4;
        AlicePathProliferator proliferator = new AlicePathProliferator(BaseGenerator.getBase6());
        List<AlicePath> alicePaths = proliferator.prolifePaths(pathLength);
        IdFormer.markPaths(alicePaths, pathLength);
        List<AliceIdPath> idPaths = IdFormer.formIdPaths(alicePaths, pathLength);

        System.out.println(alicePaths);
        System.out.println(idPaths);
        System.out.println("Hello, world");
    }
}
