public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double steps = 0.0;
        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            while ((Math.abs(x) + Math.abs(y)) != r) {
                int radnum = StdRandom.uniform(4);
                if (radnum == 0) x += 1;
                if (radnum == 1) x -= 1;
                if (radnum == 2) y += 1;
                if (radnum == 3) y -= 1;
                steps += 1;
            }

        }
        StdOut.print("average number of steps = " + (steps / trials));
    }

}
