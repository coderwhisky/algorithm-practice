package edu.buaa.nlp.xqx;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by whisky-yonk on 10/9/2015.
 */
public class Net2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int R = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int x3 = scanner.nextInt();
            int y3 = scanner.nextInt();

            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int res = 0;
            if ((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0) <= R * R) {
                res += 1;
            }

            if ((x2 - x0) * (x2 - x0) + (y2 - y0) * (y2 - y0) <= R * R) {
                res += 1;
            }

            if ((x3 - x0) * (x3 - x0) + (y3 - y0) * (y3 - y0) <= R * R) {
                res += 1;
            }
            System.out.println(res + "X");
        }
    }
}
