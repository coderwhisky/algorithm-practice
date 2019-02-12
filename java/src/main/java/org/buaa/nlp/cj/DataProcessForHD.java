package org.buaa.nlp.cj;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MultiHashtable;
import org.buaa.nlp.cj.Utils.FileUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/1.
 */
public class DataProcessForHD {
    public static void main(String[] args) {
        String[] fileList = {"G:\\chenjiang\\AAAAAAAA\\practice\\data\\动词频数统计\\中国物理.csv",
        "G:\\chenjiang\\AAAAAAAA\\practice\\data\\动词频数统计\\中国语言学.csv",
        "G:\\chenjiang\\AAAAAAAA\\practice\\data\\动词频数统计\\本族语 物理 动词.csv",
        "G:\\chenjiang\\AAAAAAAA\\practice\\data\\动词频数统计\\本族语 语言学 动词.csv"};
        FileUtil fileUtil = new FileUtil();
        //process files
        for (String filePath : fileList) {
            List<String> lines = fileUtil.readByLines(filePath);
            Map<String, Float> wordmap = new HashMap<String, Float>();

            String toWriteFile = "G:\\chenjiang\\AAAAAAAA\\practice\\data\\动词频数统计\\processed-" + filePath.split("\\\\")[6];

            // process a file
            for (String line : lines) {
                String[] lineSplit = line.split(",");

                //process a line
                for (int i = 0; i < 3; i += 2) {
                    if (! wordmap.containsKey(lineSplit[i+1])) {
                        wordmap.put(lineSplit[i+1], Float.valueOf(lineSplit[i]));
                    } else {
                        wordmap.put(lineSplit[i+1], wordmap.get(lineSplit[i+1]) + Float.valueOf(lineSplit[i]));
                    }
                }
            }

            //write to file
            for (Map.Entry<String, Float> entry : wordmap.entrySet()) {
                String newLine = entry.getKey() + "," + entry.getValue().toString();
                fileUtil.writeByLineWithEncode(newLine, toWriteFile, true, "utf-8");
            }
        }
    }
}
