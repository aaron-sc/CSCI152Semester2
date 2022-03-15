public class RevesPuzzle {
    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(long n, long k, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    private static void reves(long n, String from, String temp1, String temp2, String to) {
        long k = (Math.round((n + 1) - (Math.sqrt((2 * n + 1)))));
        if (n == 0) return;
        reves(k, from, temp2, to, temp1);
        hanoi(n - k, k, from, temp2, to);
        reves(k, temp1, temp2, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
