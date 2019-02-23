package ir.acharkit.cli.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WGet {

    private static final int TIME_OUT_CONNECTION = 60 * 1000 * 2;
    private static WGet instance;

    private WGet() {

    }

    public static WGet getInstance() {
        if (instance == null) {
            instance = new WGet();
        }
        return instance;
    }

    public boolean get(String stringURL) {
        URL url = null;
        int downloadedSize = 0;
        try {
            url = new URL(stringURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(TIME_OUT_CONNECTION);
            connection.setConnectTimeout(TIME_OUT_CONNECTION);
            connection.setRequestMethod("GET");
            connection.connect();

            float totalSize = connection.getContentLength();

            File fileDownloadDir = new File(new File("").getAbsolutePath() + File.separator + "new-project" + "." + "zip");

            FileOutputStream outputStream = new FileOutputStream(fileDownloadDir);
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[32 * 1024];
            int len = 0;
            int previousPercent = -1;

            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
                downloadedSize += len;

                int percent = (int) (100.0f * (float) downloadedSize / totalSize);
                if (previousPercent != percent) {
                    previousPercent = percent;
                    String anim = "|/-\\";
                    String data = "\r" + anim.charAt(percent % anim.length()) + " " + "loading " + percent + " %";
                    System.out.write(data.getBytes());
                }
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            connection.disconnect();
            return true;
        } catch (IOException e) {
            System.out.println("Unexpected exception:" + e.getMessage());
            return false;
        }
    }


}
