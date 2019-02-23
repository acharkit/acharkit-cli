package ir.acharkit.cli.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileHelper {

    public static boolean unzip() {
        String distDir = new File("").getAbsolutePath();
        File dir = new File(distDir);
        if (!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(distDir + File.separator + "new-project" + "." + "zip");
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File(distDir + File.separator + fileName);
                System.out.println("Unzipping to " + newFile.getAbsolutePath());
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zis.closeEntry();
                ze = zis.getNextEntry();
            }

            File cacheFile = new File(distDir + File.separator + "new-project" + "." + "zip");
            cacheFile.delete();

            zis.closeEntry();
            zis.close();
            fis.close();
            return true;
        } catch (IOException e) {
            System.out.println("Unexpected exception:" + e.getMessage());
            return false;
        }

    }


}
