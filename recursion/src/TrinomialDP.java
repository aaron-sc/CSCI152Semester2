public class TrinomialDP {
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1; // base case
        if (k < -n || k > n) return 0; // base case
        int[][] v = new int[n + 1][k + 1];
        v[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                v[i][j] = v[n - 1][Math.abs(k - 1)] + v[n - 1][k] + v[n - 1][k + 1];

            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < k; j++) {
//                StdOut.println(v[i][j]);
//
//            }
//        }
        return v[n][k];
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
