public class ShannonEntropy {
    public static void main(String[] args) {
        int[] buckets = new int[Integer.parseInt(args[0]) + 1];
        double sum = 0.0;
        double shanon = 0.0;
        // Generate Buckets
        while (StdIn.hasNextLine()) { // Read next line as long as there's a next line: https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdIn.html
            String[] line = StdIn.readLine().split(" ");
            for (String s : line) {
                if (!s.isEmpty()) {
                    int n = Integer.parseInt(s);
                    buckets[n]++;
                    sum++;
                }
            }


        }
        // Calculate Entrophy
        for (int s : buckets) {
            double p = s / sum;
            if (s != 0) {
                double sh = p * (Math.log(p) / Math.log(2));
                shanon -= sh;
            }
        }

        StdOut.printf("%.4f", shanon); // https://stackoverflow.com/questions/2538787/how-to-print-a-float-with-2-decimal-places-in-java
        StdOut.println("\n");
    }
}
