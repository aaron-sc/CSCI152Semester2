public class TrinomialDP {
    public static long trinomial(int n, int k) {
        int[][] v = new int[n + 1][k + 1];
        v[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                v[i][j] = v[n - 1][Math.abs(k - 1)] + v[n - 1][k] + v[n - 1][k - 1];
                StdOut.print(v[i][j]);
            }
            StdOut.println();
        }

        return 1;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        trinomial(n, k);
    }
}
