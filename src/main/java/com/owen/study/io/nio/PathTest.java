package com.owen.study.io.nio;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author Owen Xu
 * @date 2019/11/30 11:01
 */
public class PathTest {
    private static final String SYS_TEMP_DIR = System.getProperty("java.io.tmpdir");
    private static final Path APP_TEMP_PATH = Paths.get(SYS_TEMP_DIR, "exchange");

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\github\\study\\src\\main\\java\\com\\owen\\study\\io\\nio\\path-test.txt");
        System.out.printf("Path: %s", path.toString());
        System.out.println();
//        System.out.printf("Path: %s", path.toAbsolutePath().toString());
//        System.out.println();

//        Path pathCP = Paths.get("path-test-cp.txt");
//        Files.copy(path, pathCP, StandardCopyOption.REPLACE_EXISTING);

        Files.createTempFile(Paths.get("D:\\"), null, ".txt");
    }
}
