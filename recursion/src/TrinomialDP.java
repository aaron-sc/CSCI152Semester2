public class TrinomialDP {
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1; // base case
        if (k < -n || k > n) return 0; // base case
        int[][] v = new int[2 * (n + 1)][2 * (n + 1)];
        v[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    v[i][j] = v[i - 1][j] + (2 * v[i - 1][j + 1]);
                } else {
                    v[i][j] = v[i - 1][j - 1] + v[i - 1][j] + v[i - 1][j + 1];
                }
            }
        }

        return v[n][k];
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
