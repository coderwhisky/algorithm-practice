package org.buaa.nlp.cj.jobOnlineProgram.qunar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/21/2015.
 */
public class StableLinuxKernel {


    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int inCount = Integer.parseInt(scanner.nextLine());
        while (inCount > 0) {
            String version = scanner.nextLine();
            sList.add(version);
            inCount--;
        }
        String vlatest = latestStable(sList);
        System.out.println(vlatest);
    }



    public static String latestStable(List<String> vList) {
        if (vList == null || vList.size() == 0)
            return "no stable available";
//        String vlatest = vList.get(0);
        int latestMajor = -1;
        int latestMinor = -1;
        String vlatest = "";

        for (int i = 0; i < vList.size(); i++) {
            String v = vList.get(i);
            String[] tmp = v.split("\\.");
            int len = tmp.length;
            int major = Integer.parseInt(tmp[0]);
            int minor = Integer.parseInt(tmp[1]);
            int patchLevel = -1;
            if (len == 3) {
                patchLevel = Integer.parseInt(tmp[2]);
            }
            if (minor%2 == 0) {
                // the latest
                if ( minor > latestMinor) {
                    latestMajor = major;
                    latestMinor = minor;
                    vlatest = v;
                } else if (minor == latestMinor){
                    if (major > latestMajor) {
                        latestMajor = major;
                        latestMinor = minor;
                        vlatest = v;
                    }
                }
            }
        }

        if (vlatest==null || vlatest.isEmpty())
            return "no stable available";
        return vlatest;
    }
}
