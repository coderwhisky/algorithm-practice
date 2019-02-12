package org.buaa.nlp.cj;

import java.io.*;
import java.util.Scanner;

/**
 * Created by whisky-yonk on 8/16/2015.
 */
public class ProblemC {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(new File("./data/C-small-1-attempt0.in")));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("./data/C-small-1-attempt0.out")));

        int caseCount = Integer.parseInt(scanner.nextLine());
        int thisCase = 1;

        while (caseCount >0 ) {
            int cardAccount = Integer.parseInt(scanner.nextLine());
            char maxFirst = 'A'-1;
            int cost = 0;

            while (cardAccount > 0) {
                cardAccount--;
                String line = scanner.nextLine();
                char curFirst = line.charAt(0);
                if (curFirst - maxFirst < 0) {
                    cost++;
                } else {
                    maxFirst = curFirst;
                }
            }
            System.out.println("Case #" + thisCase + ": " + cost);
            out.println("Case #" + thisCase + ": " + cost);
            thisCase++;

            caseCount--;
        }

        out.flush();
        out.close();
        scanner.close();
    }
}
