public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) { // TODO: Fix this fucker
        int max = 0;
        int total = 0;
        int count = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (i < dna.length() - 2) {
                String triple = dna.substring(i, i + 3);
                if (triple.equals("CAG")) {
                    total++;
                    count = 0;
                    if (total >= max) max = total;
                } else {
                    if (count >= 3) {
                        count = 0;
                        total = 0;
                    } else count++;
                }
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String ss = s.replace("\n", "").replace("\t", "").replace(" ", "");
        return ss;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 181) {
            return "not human";
        } else if (maxRepeats >= 40) {
            return "Huntington's";
        } else if (maxRepeats >= 36) {
            return "high risk";
        } else if (maxRepeats >= 10) {
            return "no Huntington's";
        } else if (maxRepeats >= 0) {
            return "not human";
        }
        return "not human - error";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String fname = args[0];
        In filein = new In(fname);
        String data = filein.readAll();
        int r = maxRepeats(removeWhitespace(data));
        StdOut.println("max repeats = " + r);
        StdOut.println(diagnose(r));

    }
}
