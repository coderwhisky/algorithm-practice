package edu.buaa.nlp.xqx;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by whisky-yonk on 10/9/2015.
 */
public class Net1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            String nums = scanner.next();
            char[] chars = str.toCharArray();
            char[] numchars = nums.toCharArray();
            for(int i = 0; i < chars.length; i++){
                if(Character.isLetter(chars[i]) || Character.isDigit(chars[i])){
                    chars[i] = '1';
                }else{
                    chars[i] = '0';
                }
            }
            int count = 0;
            for(int i = 0; i < chars.length; i++){
                if(chars[i] == numchars[i]){
                    count++;
                }
            }
            double res = (double) count / chars.length;
            NumberFormat nt = NumberFormat.getPercentInstance();
            //设置百分数精确度2即保留两位小数
            nt.setMinimumFractionDigits(2);
            System.out.println(nt.format(res));
        }
    }
}
