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
            if (line.isEmpty()) {
                int v = 0; // verts
                for (int k = 0; k < 2; k++) { // read city and verts
                    String line_d = StdIn.readLine(); // read line
                    if (k == 1 && (line_d != null)) v = Integer.parseInt(line_d); // get verts
                    else StdOut.println(line_d + "  " + v);
                    if (v != 0) { // if verts != 0
                        for (int j = 0; j <= v; j++) {
                            double[] x = new double[v];
                            double[] y = new double[v];
                            String coordinate = StdIn.readLine();
                            if (!coordinate.isEmpty() && !line_d.isEmpty()) {
                                int l = 0;
                                if (coordinate.contains(" ")) {
                                    l += 1;
                                }
                                StdOut.println(coordinate);
                                x[j] = Double.parseDouble(coordinate.substring(l, coordinate.indexOf(" ")));
                                y[j] = Double.parseDouble(coordinate.substring(coordinate.indexOf(" ") + 1 + l));
//                                StdOut.println("j: " + j + ", x: " + x[j] + ", y: " + y[j]);
                            }
                        }
                    }
                }
            }
            i++;
        }

    }

}


