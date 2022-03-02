public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int a2 = Math.abs(a);
        int b2 = Math.abs(b);
        while (b2 != 0) {
            int temp = a2;
            a2 = b2;
            b2 = temp % b2;
        }
        return a2;
    }

//    // Returns the least common multiple of a and b.
//    public static int lcm(int a, int b)
//
//    // Returns true if a and b are relatively prime; false otherwise.
//    public static boolean areRelativelyPrime(int a, int b)
//
//    // Returns the number of integers between 1 and n that are
//    // relatively prime with n.
//    public static int totient(int n)

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println(gcd(a, b));

    }
}
