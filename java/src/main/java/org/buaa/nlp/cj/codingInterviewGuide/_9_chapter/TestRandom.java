package org.buaa.nlp.cj.codingInterviewGuide._9_chapter;

import java.util.Random;

/**
 * Created by whisky-yonk on 10/6/2015.
 */
public class TestRandom {
    public static void main(String[] args){
        Random r1 = new Random();
        Random r2 = new Random();
        for (int i = 0; i < 10; i++)
            System.out.print(r1.nextInt(20) + " ");
        System.out.println();
        for (int i = 0; i < 10; i++)
            System.out.print(r2.nextInt(20) + " ");
    }
}
