package org.buaa.nlp.cj.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by whisky on 15-5-6.
 */
public class RandomUtil {
    public List<String> randomPick(int k, int n, String srcFile) {
        List<String> result = new ArrayList<String>();
        File source = new File(srcFile);
        BufferedReader bufReader = null;

        if (k > n || !source.exists()) {
            return null;
        }
        try {
            bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(source), "utf-8"));
            for (int i = 0; i < k; i++) {
                result.add(bufReader.readLine());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = k+1; i < n; i++) {
            String line = "";
            try {
                line = bufReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int m = new Random().nextInt(i);
            if(m < k) {
                result.remove(m);
                result.add(line);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RandomUtil randomUtil = new RandomUtil();
        List<String> result = randomUtil.randomPick(5, 419, "/home/whisky/IdeaProjects/workspace/paperprogram/src/svmClassify/wdbc_traindata.txt");
    }
}
