/**
 * Created by I320592 on 8/12/2015.
 */
public class Testggt {
    static int x = 0;
    public static int test(int x) {
        return ++x;
    }
    public static void main(String[] args) {
        int result = test(x);
        System.out.println(x);
        System.out.println(result);
    }
}
