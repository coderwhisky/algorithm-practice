package org.buaa.nlp.cj.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by whisky on 15-4-15.
 */
public class FileUtil {
    /**
     * 逐行读取文件
     * @param filePath
     * @return List<String>
     */
    public List<String> readByLines(String filePath) {
        List<String> result = new ArrayList<String>();

        File file = new File(filePath);
        BufferedReader buffReader = null;
        String tmpString = null;

        try {
            buffReader = new BufferedReader(new FileReader(file));
            while ((tmpString = buffReader.readLine()) != null) {
                result.add(tmpString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     *
     * @param fileContent
     * @param filePath
     */
    public void writeByLines(List<String> fileContent, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists())
                file.createNewFile ();

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file));
            if (!fileContent.isEmpty()) {
                for (int i = 0; i < fileContent.size(); i++)
                    buffWriter.write(fileContent.get(i) + "\n");
            }
            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param filePath
     * @param encode
     * @return
     */
    public List<String> readByLinesWithEncode(String filePath, String encode)   {
        List<String> result = new ArrayList<String>();

        File file = new File(filePath);
        if (!file.exists())
            return null;
        String line = null;
        BufferedReader buffReader = null;

        try {
            buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
            while ((line = buffReader.readLine()) != null) {
                result.add(line);
            }
            buffReader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     *
     * @param fileContent
     * @param filePath
     * @param encode
     */
    public void writeBylinesWithEncode(List<String> fileContent, String filePath, String encode) {
        File file = new File(filePath);
        BufferedWriter buffWriter = null;

        try {
            if (!file.exists())
                file.createNewFile();
            buffWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encode));
            if (!fileContent.isEmpty()) {
                for (int i = 0; i < fileContent.size(); i++)
                    buffWriter.write(fileContent.get(i) + "\n");
            }
            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeByMapWithEncode(Map<String, String> map, String filePath, boolean mode, String encode) {
        File file = new File(filePath);
        BufferedWriter buffWriter = null;

        try {
            if (!file.exists())
                file.createNewFile();
            buffWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, mode), encode));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeByLineWithEncode(String line, String filePath, boolean mode, String encode) {
        File file = new File(filePath);
        BufferedWriter buffWriter = null;

        try {
            if (!file.exists())
                file.createNewFile();
            buffWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, mode), encode));
            buffWriter.write(line + "\n");
            buffWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        notifyAll();
    }

    public static void main(String[] args) {
        // test for readByLines
        FileUtil fileUtil = new FileUtil();
//        List<String> fileContent = fileUtil.readByLines("/home/whisky/IdeaProjects/workspace/paperprogram/data/wdbc.data.txt");
//        if (fileContent != null) {
//            for (int i = 0; i < fileContent.size(); i++)
//                System.out.println(fileContent.get(i));
//        }

        // test for writeByLines
//        fileUtil.writeByLines(fileContent, "/home/whisky/IdeaProjects/workspace/paperprogram/data/wdbc.data2.txt");

//        for (int i=0; i<4; i++) {
//            fileUtil.writeByLineWithEncode("dklj\n", "/home/whisky/IdeaProjects/workspace/paperprogram/data/baseline-data/preparedData.txt", true, "utf-8");
//        }
    }
}
