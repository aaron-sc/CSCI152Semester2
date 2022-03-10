public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cellnumber = i * n + j;
                if (Integer.bitCount(cellnumber) % 2 == 0) {
                    System.out.print("+ ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
