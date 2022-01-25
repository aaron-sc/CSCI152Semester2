public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean pos = a > 0 && b > 0 && c > 0;
        boolean t1 = (a * a + b * b == c * c);
        boolean t2 = (a * a + c * c == b * b);
        boolean t3 = (c * c + b * b == a * a);
        StdOut.println((t1 || t2 || t3) && pos);
    }
}
