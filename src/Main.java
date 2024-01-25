import java.util.ArrayList;
import java.util.List;

public class Main {
    static int a = 0;
    int b = 0;
    public static void main(String[] args) {
        Main demo = new Main();
//        final float pi = 3.14f;
        a++;
        demo.b++;
        System.out.println("a" + (demo.a + 1));
        System.out.println("b" + (demo.b + 1));
    }
}