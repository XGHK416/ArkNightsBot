package com.project.xghk416.util;

import java.io.File;

public class FileUtil {
    public static boolean delFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }

        if (file.isFile()) {
            return file.delete();
        } else {
            String[] fileNames = file.list();
            for (String f : fileNames) {
                delFile(f);
            }
            return file.delete();
        }
    }
}
