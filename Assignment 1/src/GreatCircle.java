public class GreatCircle {
    public static void main(String[] args) {
        double r = 6371.0;
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double op1 = (x2 - x1);
        double op2 = (y2 - y1);
        double internal = (Math.pow(Math.sin(op1 / 2), 2)) + (Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin(op2 / 2), 2));
        double distance = ((2 * r) * Math.asin(Math.sqrt(internal)));
        StdOut.println(distance + " kilometers");
    }
}
