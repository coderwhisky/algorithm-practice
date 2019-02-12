package org.buaa.nlp.cj;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/25.
 */
public class GoodsClassify {
    private String baseUri = System.getProperty("user.dir");
    private Map<String, String> fileMap = new HashMap<String, String>();

    public GoodsClassify() {
        fileMap.put("book", baseUri + "/src/main/java/org/buaa/nlp/cj/jobOnlineProgram/thoughtworks/dictionary-book.txt");
        fileMap.put("food", baseUri + "/src/main/java/org/buaa/nlp/cj/jobOnlineProgram/thoughtworks/dictionary-food.txt");
        fileMap.put("medical", baseUri + "/src/main/java/org/buaa/nlp/cj/jobOnlineProgram/thoughtworks/dictionary-medical.txt");
    }

    /**
     * @param fileMap {map<goodsCategory, filePath>}
     * @return {map<goods,category> }
     */
    private Map<String, String> files2Map(Map<String, String> fileMap) {
        Map<String, String> ser = new HashMap<String, String>();

        for (Map.Entry<String, String> entry : fileMap.entrySet()) {
            File file = new File(entry.getValue());
            if (!file.exists()) {
                System.out.println("file not found!!!!");
            }

            String line = null;
            BufferedReader buffreader = null;

            try {
                buffreader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                while ((line = buffreader.readLine()) != null) {
                    ser.put(line.trim(), entry.getKey());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ser;
    }

    public Map<String, String> files2Map() {
        return files2Map(this.fileMap);
    }

//    public boolean isExempt(String goods) {
//        Map<String, String> goodsMap = files2Map();
//        return goodsMap.containsKey(goods);
//    }
    public boolean isExempt(String line) {
        boolean flag = false;
        Map<String, String> goodsMap = files2Map();
        for (Map.Entry<String, String> entry : goodsMap.entrySet()) {
            if (line.contains(entry.getKey())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        GoodsClassify goods = new GoodsClassify();
//        Map<String, String> goodsMap = goods.files2Map();
//        for (Map.Entry<String, String> entry : goodsMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        System.out.println(goods.isExempt("book"));
    }
}
