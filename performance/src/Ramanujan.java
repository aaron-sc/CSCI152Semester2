public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        for (long i = 0; i < Math.cbrt(n); i++) {
            double nums[] = new double[2];
            double num = Math.cbrt(n - (Math.pow(i, 3)));
            boolean numinnums = false;
            for (double item : nums) {
                if (num == item) numinnums = true;
                else break;
            }
            if (num % 1 == 0 && !numinnums) {
                nums[count] = num;
                count++;
            }
            if (count >= 2) break;
        }
        return count >= 2;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
