package org.buaa.nlp.cj.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by whisky on 15-5-22.
 */
public class FilterUtil {
    FileUtil fileUtil = new FileUtil();
    /**
     * 对世界杯关键词去重
     * @param input
     * @return
     */
    public List<String> deleteDuplicate(List<String> input) {
        List<String> output = new ArrayList<String>();
        String word = "";
        String newLine = "";
        double value;
        Map<String, Double> container = new HashMap<String, Double>();
        for (String line : input) {
            line = line.trim();
            word = line.split(":")[0];
            value = Double.valueOf(line.split(":")[1]);
            if (!container.containsKey(word)) {
                container.put(word, value);
                newLine = word + ":" + value;
                output.add(newLine);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        FilterUtil filterUtil = new FilterUtil();
        List<String> input = filterUtil.fileUtil.readByLinesWithEncode("/home/whisky/chenjiang/biyesheji/data/keywords_15_manual_filter.txt", "utf-8");
        List<String> output = filterUtil.deleteDuplicate(input);
        filterUtil.fileUtil.writeBylinesWithEncode(output, "/home/whisky/IdeaProjects/workspace/paperprogram/data/fifaData/filteredfifaKeywords.txt", "utf-8");
    }
}
