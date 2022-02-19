public class ShannonEntropy {
    public static void main(String[] args) {
        int[] buckets = new int[Integer.parseInt(args[0]) + 1];
        int sum = Integer.parseInt(args[0]);
        double shanon = 0.0;
        while (StdIn.hasNextLine()) { // Read next line as long as there's a next line: https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdIn.html
            String[] line = StdIn.readLine().split(" ");
            for (String s : line) {
                int n = Integer.parseInt(s);
                buckets[n]++;
                sum += n;
            }
            for (int s : buckets) {
                double p = 1.0 * s / sum;
                if (s != 0) {
                    shanon += ((-1 * p) * Math.log(p) / Math.log(2));
                }

            }

        }
        StdOut.println(shanon);
    }
}
