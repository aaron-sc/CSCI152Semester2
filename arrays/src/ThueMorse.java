public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r[] = new int[n];

        for (int i = 0; i < n; i++) { // Using remarkable property from FAQ
            if (i == 0) {
                r[i] = 0;
            } else if (i % 2 == 0) { // is even
                r[i] = r[i / 2];
            } else { // is odd
                r[i] = 1 - r[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (r[j] == r[i]) {
                    StdOut.print("+  ");
                } else StdOut.print("-  ");

            }
            StdOut.println();
        }

    }
}
