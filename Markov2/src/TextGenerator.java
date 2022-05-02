public class TextGenerator {
    public static void main(String[] args) { // parameters[fname, order, len]
        String fname = args[0];
        int order = Integer.parseInt(args[1]);
        int len = Integer.parseInt(args[2]);

        In in = new In(fname);
        String file = in.readAll().strip().toLowerCase().replace("\t", "").replace("\r", "").replace("\n", "");
        file += " " + file;
//        file += file.substring(order);
        String[] words = file.split(" ");


        Markov markovChain = new Markov(words, order);
        String s = "";
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                s = markovChain.next();
            } else {
                String s2[] = s.split(" ");
                s = s.contains(" ") ? s.split(" ")[s2.length - 1] : s;
                s = markovChain.next(s.strip());
            }
            if (!(s.contains(" ") || !(markovChain.getSt().contains(s)))) StdOut.print(s + " ");
            else StdOut.print(s);
            if (i % 8 == 0 && i != 0) StdOut.println();

        }
    }
}
