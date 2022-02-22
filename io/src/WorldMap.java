public class WorldMap {
    public static void main(String[] args) {
        int i = 0;
        while (StdIn.hasNextLine()) { // Read next line as long as there's a next line: https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdIn.html
            String line = StdIn.readLine();
            // Set canvas
            if (i == 0) {
                int x = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                int y = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                StdDraw.setCanvasSize(x, y);
                StdDraw.setXscale(0, x);
                StdDraw.setYscale(0, y);
            }
            if (line.isEmpty()) { // if there's a newline
                int v = 0; // verts
                for (int k = 0; k < 2; k++) { // read city and verts
                    String line_d = StdIn.readLine(); // read line
                    if (k == 1 && (line_d != null)) v = Integer.parseInt(line_d); // get verts
                    if (v != 0) { // if verts != 0
                        double[] x = new double[v]; // x-cords
                        double[] y = new double[v]; // y-cords
                        for (int j = 0; j < v; j++) { // for the amount of cords
                            String[] coordinate = StdIn.readLine().split(" "); // Cleanup the line if there's excess spaces
                            for (int h = 0, p = 0; h < coordinate.length; h++) {
                                String s = coordinate[h];
                                if (!s.isEmpty()) {
                                    double cord = Double.parseDouble(s);
                                    if (p % 2 == 0) {
                                        x[j] = cord;
                                    } else {
                                        y[j] = cord;
                                    }
                                    p++;

                                }


                            }


                        }
                        // Draw
                        StdDraw.polygon(x, y);
                    }
                }


            }
            i++; // what line we're on
        }
    }


}
