public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) { // TODO: Fix this fucker
        char[] new_dna = dna.toCharArray();
        int max = 0;
        int CAGs = 0;
        StdOut.println(dna);
        for (int i = 0; i < new_dna.length; i++) {

            if (new_dna.length == 1) {
                max = 1;
                break;
            } else if (i != 0) {
                if (new_dna[i - 1] == new_dna[i]) {
                    CAGs++;
                } else {
                    CAGs = 0;
                }
                if (CAGs >= max) max = CAGs;
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
            return "normal";
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
