package org.buaa.nlp.cj.jobOnlineProgram;

/**
 * Created by whisky-yonk on 10/17/2015.
 */
public class ShowMe {
    private String id;
    private static void playShow(ShowMe...showMes) {
        showMes[0] = showMes[1];
        showMes[1].id = "new name";
    }


    public static void main(String[] args) {
        ShowMe show1  = new ShowMe();
        ShowMe show2 = new ShowMe();

        show1.id = show2.id = "show1";
        playShow(show1, show2);
        System.out.println(show1.id + "&" +show2.id);

        long sum = 0;
        for (int i = 1; i <10000; i++) {
            int di = 0;
            for (int j = 1; j <=i; j++) {
                if (i % j ==0) {
                    di += j;
                }
            }
            sum  += di;
        }
        System.out.println("sum:" + sum);
    }
}
