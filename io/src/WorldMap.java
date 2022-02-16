public class WorldMap {
    public static void main(String[] args) {
        int i = 0;
        while (StdIn.hasNextLine()) { // Read next line as long as there's a next line: https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdIn.html
            String line = StdIn.readLine();
            StdOut.println(line);
            if (i == 0) StdDraw.setCanvasSize();
        }
    }
}
