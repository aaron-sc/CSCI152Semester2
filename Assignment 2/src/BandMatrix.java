public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int w = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            String r = "";
            for (int i2 = 0; i2 < n; i2++) {
                if (i2 - i <= w && i - i2 <= w) r += "*  ";
                else if (i2 != n) r += "0  ";
                else r += "0";
            }
            if (i != n) System.out.println(r);
            else System.out.println(r);
        }
    }
}
