public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int inv = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) inv++;
            }
        }
        return inv;
    }

    // Return a permutation of length n with exactly k inversions.
    public static void generate(int n, long k) {
        int invs = 0;
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            int invnum = n - i - 1;
            if (invnum + invs <= k) {
                a[i] = invnum;
                invs += invnum;
            } else {
                a[i] = i;
            }
            StdOut.print(a[i] + " ");

        }

    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 4, 3};
        generate(10, 1);
    }
}
