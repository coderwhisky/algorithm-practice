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
    public static void main( String[] args )
    {
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
        }
    }


}
