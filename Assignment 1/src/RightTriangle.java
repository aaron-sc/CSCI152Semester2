public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        StdOut.println(((a ^ 2) + (b ^ 2) == (c ^ 2)));
    }
}
