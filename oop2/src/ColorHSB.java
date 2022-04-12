public class ColorHSB {
    private int h, s, b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) throw new IllegalArgumentException();
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + this.h + ", " + this.s + ", " + this.b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (this.s == 0 || this.b == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int distance = (int) ((int) Math.min(Math.pow(this.h - that.h, 2), Math.pow(360 - Math.abs((this.h - that.h)), 2)) + Math.pow((this.s - that.s), 2) + Math.pow((this.b - that.b), 2));
        return distance;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB maincolor = new ColorHSB(h, s, b);

        int smallest = Integer.MAX_VALUE;
        String cname = "";
        ColorHSB smallestDist = null;

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            String name = line.substring(0, line.indexOf(" "));
            String niceline = line.substring(line.indexOf(" ")).trim();
            String h1 = niceline.substring(0, niceline.indexOf(" "));
            niceline = niceline.substring(niceline.indexOf(" ")).trim();
            String s1 = niceline.substring(0, niceline.indexOf(" "));
            niceline = niceline.substring(niceline.indexOf(" ") - 1).trim();
            String b1 = niceline.substring(niceline.indexOf(" ")).trim();
            int h2 = Integer.parseInt(h1);
            int s2 = Integer.parseInt(s1);
            int b2 = Integer.parseInt(b1);

            ColorHSB readcolor = new ColorHSB(h2, s2, b2);

            int distance = maincolor.distanceSquaredTo(readcolor);
            if (distance <= smallest) {
                smallestDist = readcolor;
                smallest = distance;
                cname = name;
            }


        }
        StdOut.println(cname + " " + smallestDist);

    }

}
