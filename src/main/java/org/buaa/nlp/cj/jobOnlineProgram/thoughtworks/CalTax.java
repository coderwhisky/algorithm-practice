package org.buaa.nlp.cj.jobOnlineProgram.thoughtworks;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/25.
 */
public class CalTax {
    public void calTax(List<String> inputList) {
        for (String fPath : inputList) {
            double sum = 0.0;
            double sumTax =0.0;
            File input = new File(fPath);
            System.out.println(input.getName());
            if (!input.exists()) {
                System.out.println("file not find!!!");
                return;
            }
            BufferedReader buffReader = null;
            String line = null;
            try {
                buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(input),"utf-8"));
                while ((line = buffReader.readLine()) != null) {
                    String goods = extractGoods(line);
                    double price = extractPrice(line);
                    boolean isImported = isImported(line);
                    boolean isExempt = new GoodsClassify().isExempt(goods);
                    // exempt goods
                    double tax = 0.00;
                    if (isExempt) {
                        if (isImported) {
//                            tax = (price * 0.05);
                            tax = doubleRound(price * 5 / 100);
                        }
                    } else {
                        if (isImported) {
//                            tax = (price * 0.15);
                            tax = doubleRound(price * 15 / 100);
                        } else {
//                            tax = (price * 0.10);
                            tax = doubleRound(price * 10 / 100);
                        }
                    }
                    sumTax += (tax);
                    double taxedPrice = (price + tax);
                    sum += (taxedPrice);
                    System.out.println(outHead(line) + ": " + String.format("%.2f", taxedPrice));
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Sales Taxes: " + String.format("%.2f", sumTax));
            System.out.println("Total: " + String.format("%.2f", sum));
            System.out.println();
        }
    }

    public double doubleRound(double d) {
        return 0.0;
    }

    public double doubleRound4tax(double d) {
        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);
        d = bg.doubleValue();
        int g = (int) ((d*100) % 10);
        if (g < 5) {
            d = (d*100 + 5-g) / 100;
        }

        if (g == 1 || g == 2) {
            d = (d*100 - g) / 100;
        }
        if (g == 3 || g == 4) {
            d = (d*100 + 5 - g) / 100;
        }

        if (g == 6 || g == 7) {
            d = (d*100 - (g-5)) / 100;
        }
//
        if (g == 8 || g == 9) {
            d = (d*100 - g +10) /100;
        }
//        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);
//        return bg.doubleValue();
        return d;
    }


    public String extractGoods(String line) {
        String ser = "";
        int ss = 1;
        int ee = 0;
        if (line.contains("of")) {
            ss = line.lastIndexOf("of") + 2;
        }
        if (line.contains("at")) {
            ee = line.lastIndexOf("at");
        }
        ser = line.substring(ss, ee).trim();
        return ser;
    }

    public double extractPrice(String line) {
        double ser = 0.00;

        int ss = line.lastIndexOf(" ");
        String sp = line.substring(ss, line.length()).trim();

        ser = Float.parseFloat(sp);
        BigDecimal bg = new BigDecimal(ser).setScale(3, RoundingMode.UP);
        return bg.doubleValue();
    }

    public String outHead(String line) {
        int ee = line.lastIndexOf("at");
        return line.substring(0, ee).trim();
    }

    public boolean isImported(String line) {
        return line.contains("imported");
    }

    public static void main(String[] args) {
//        String line1 = "1 imported bottle of perfume at 47.50";
////        String line1 = "1 chocolate bar at 0.85";
        CalTax calTax = new CalTax();
//        System.out.println(calTax.extractGoods(line1));
//        System.out.println(calTax.isImported(line1));
//        System.out.println(calTax.outHead(line1));
//        System.out.println(calTax.extractPrice(line1));


        String baseUri = System.getProperty("user.dir");
        String input1 = baseUri + "/src/main/java/org/buaa/nlp/cj/jobOnlineProgram/thoughtworks/input1.txt";
        String input2 = baseUri + "/src/main/java/org/buaa/nlp/cj/jobOnlineProgram/thoughtworks/input2.txt";
        String input3 = baseUri + "/src/main/java/org/buaa/nlp/cj/jobOnlineProgram/thoughtworks/input3.txt";
        List<String> inputList = new ArrayList<String>();
        inputList.add(input1);
        inputList.add(input2);
        inputList.add(input3);
        calTax.calTax(inputList);

//        System.out.println(String.format("%.2f", new CalTax().doubleRound(25.0)));
    }
}
