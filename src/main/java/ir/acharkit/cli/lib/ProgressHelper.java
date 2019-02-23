package ir.acharkit.cli.lib;

import java.io.IOException;

/**
 * Author:  Alireza Tizfahm Fard
 * Date:    2019-02-23
 * Email:   alirezat775@gmail.com
 */

public class ProgressHelper {

    public static void progressPercentage(int remain, int total) {
        if (remain > total) {
            throw new IllegalArgumentException("check network");
        }
        int maxBareSize = 10; // 10unit for 100%
        int remainProcent = ((100 * remain) / total) / maxBareSize;
        char defaultChar = '-';
        String icon = "*";
        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
        StringBuilder bareDone = new StringBuilder();
        bareDone.append("[");
        for (int i = 0; i < remainProcent; i++) {
            bareDone.append(icon);
        }
        String bareRemain = bare.substring(remainProcent, bare.length());
        System.out.print("\r" + bareDone + bareRemain + " " + remainProcent * 10 + "%");
        if (remain == total) {
            System.out.print("\n");
        }
    }

    public static void progressLoading(int percent) throws IOException {
        String anim = "|/-\\";
        String data = "\r" + anim.charAt(percent % anim.length()) + " " + "loading " + percent + " %";
        System.out.write(data.getBytes());
    }

    public static void progressDotAround(int percent) throws IOException {
        String anim = "⣷ ⣯ ⣟ ⡿ ⢿ ⣻ ⣽ ⣾";
        String data = "\r" + anim.charAt(percent % anim.length()) + " " + "loading " + " ===========================";
        System.out.write(data.getBytes());
    }

    public static void printProgBar(int percent) {
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < 50; i++) {
            if (i < (percent / 2)) {
                bar.append("=");
            } else if (i == (percent / 2)) {
                bar.append(">");
            } else {
                bar.append(" ");
            }
        }

        bar.append("]   " + percent + "%     ");
        System.out.print("\r" + bar.toString());

    }
}
