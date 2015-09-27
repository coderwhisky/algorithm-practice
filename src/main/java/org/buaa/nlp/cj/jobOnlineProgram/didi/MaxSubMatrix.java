package org.buaa.nlp.cj.jobOnlineProgram.didi;

import java.util.Scanner;

/**
 * Created by whisky-yonk on 9/25/2015.
 */
public class MaxSubMatrix {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] arow = line.split("\\;");
                String[] tempStrings = arow[0].trim().split("\\s+");
                int ccount = 0;
                int rcount = arow.length;
                ccount = tempStrings.length;
                int[][] matrix = new int[rcount][ccount];
                for(int i = 0; i < rcount;i++){
                    tempStrings = arow[i].trim().split("\\s+");
                    for(int j = 0; j < ccount; j++){
                        matrix[i][j] = Integer.parseInt(tempStrings[j]);
                    }
                }

                int res = 0;
                if(ccount < 2 || rcount < 2){
                    System.out.println(0);
                }
                for(int i = 0; i < rcount - 1; i++){
                    for(int j = 0; j < ccount - 1; j++){
                        int sum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1]
                                + matrix[i + 1][j + 1];
                        res = Math.max(res, sum);
                    }
                }
                System.out.println(res);
            }
        }

}
