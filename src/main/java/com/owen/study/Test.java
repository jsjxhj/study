package com.owen.study;


import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Test {
    public static void main(String[] args) throws Exception {
        String path = "D:\\测试商标的上传.zip";
//        String path = "D:\\测试中文.zip";

//        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(new BufferedInputStream(new FileInputStream(new File(path))));
//
//        ZipArchiveEntry zipArchiveEntry;
//        while ((zipArchiveEntry = zipArchiveInputStream.getNextZipEntry()) != null && !zipArchiveEntry.isDirectory()) {
//            String fileName = zipArchiveEntry.getName();
//            int zipSize = (int) zipArchiveEntry.getSize();
//            byte[] bytes = new byte[zipSize];
//            zipArchiveInputStream.read(bytes, 0, zipSize);
//
//            IOUtils.copy(ais, o);
//        }
        unzip(path, "D:\\");
    }

    public static void unzip(String zipFileName, String destDir) {
        try (InputStream fis = Files.newInputStream(Paths.get(zipFileName));
             InputStream bis = new BufferedInputStream(fis);
             ArchiveInputStream ais = new ZipArchiveInputStream(bis,"UFT-8")) {

            ArchiveEntry entry;
            while (Objects.nonNull(entry = ais.getNextEntry())) {
                if (!ais.canReadEntryData(entry)) {
                    continue;
                }

                String name = filename(destDir, entry.getName());
                File f = new File(name);
                if (entry.isDirectory()) {
                    if (!f.isDirectory() && !f.mkdirs()) {
                        f.mkdirs();
                    }
                } else {
                    File parent = f.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("failed to create directory " + parent);
                    }
                    try (OutputStream o = Files.newOutputStream(f.toPath())) {
                        IOUtils.copy(ais, o);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String filename(String destDir, String name) {
        return destDir + File.separator + name;
    }

}
