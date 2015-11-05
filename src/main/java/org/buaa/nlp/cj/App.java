package org.buaa.nlp.cj;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    private int a;
    private String s;
    public App(int a) {
        this.a = a;
    }

    public App(String ss) {
        this.s = ss;
    }

    public App(int a, String ss) {
        this(a);
    }

    public static void main( String[] args )
    {
/*
        Map<String, Integer> map = new HashMap<String, Integer>();
        File file = new File("F:\\chenjiang\\projects\\AAAAAAAA\\practice\\src\\main\\java\\org\\buaa\\nlp\\cj\\111.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (map.containsKey(line)) {
                    int old = map.get(line);
                    map.put(line, old+1);
                } else {
                    map.put(line, 1);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/


        // ++++++++++++++ test ++++++++++
//        String ss = "是的空间卡";
//        System.out.println(ss.length());
        int a = -4;
        System.out.println(a>>1);
        long b = -4;
        System.out.println(b>>1);
        // ++++++++++++++ test ++++++++++
    }


}
