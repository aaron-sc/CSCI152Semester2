public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int x = 0;
        int y = 0;
        while ((Math.abs(x) + Math.abs(y)) != r) {
            int radnum = StdRandom.uniform(4);
            StdOut.println("(" + x + ", " + y + ")");
            if (radnum == 0) x += 1;
            if (radnum == 1) x -= 1;
            if (radnum == 2) y += 1;
            if (radnum == 3) y -= 1;
            steps += 1;
        }
        if ((Math.abs(x) + Math.abs(y)) == r) StdOut.println("(" + x + ", " + y + ")");
        StdOut.print("steps = " + steps);
    }
}
