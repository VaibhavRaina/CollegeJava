import p1.*;
import p2.*;

public class pkgDemo {
    public static void main(String[] args) {
        threeDim t3 = new threeDim();
        threeDim t4 = new threeDim(1, 2, 3);
        twoDim d3 = new twoDim();
        twoDim d4 = new twoDim(1, 2);
        d3.toString();
        d4.toString();
        t3.toString();
        t4.toString();
    }
}