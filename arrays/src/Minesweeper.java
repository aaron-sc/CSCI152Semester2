public class Minesweeper {
    public static void main(String[] args) {

        // Vars
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[] mines = new boolean[m * n];
        int[] nearbyMines = new int[m * n];

        // generate mines into mines[]
        int mineCount = 0;
        while (mineCount < k) {
            int rand = StdRandom.uniform(0, (n * m));
            if (!mines[rand]) {
                mines[rand] = true;
                mineCount++;
            }
        }

        for (int i = 0; i < mines.length; i++) {
            boolean mine = mines[i];
            if (mine) {
                if (!(i < m * 2)) {
                    for (int j = i - m - 1; j <= 4; j++) {
                        if (!mines[j]) nearbyMines[j] += 1;
                    }
                }

                for (int j = i + m; j <= 4; j++) {
                    if (!mines[j]) nearbyMines[j] += 1;
                }
                if (i + 1 != m) nearbyMines[i + 1] += 1;
                if (i != 0) nearbyMines[i - 1] += 1;
            }
        }


        for (int i = 1; i < n * m; i++) {
            if (i % n * m == 0) System.out.println();
            else {
                if (mines[i]) {
                    System.out.print("*  ");
                } else {
                    System.out.print(nearbyMines[i] + "  ");
                }
            }


        }
    }


}
