import java.util.ArrayList;

public class TextGenerator {
    public static void main(String[] args) {
        int s = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        ArrayList<String> words = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            String value = StdIn.readString();
            words.add(value.toLowerCase());
        }
        MarkovChain markovChain = new MarkovChain(s, n, words);
        String word = "";
        for (int i = 0; i < n; i++) {

            if (markovChain.getState().equals("")) {
                word = markovChain.getStartingWord();
            } else {
                String[] w = word.split(" ");
                word = w[w.length - 1];
                word = markovChain.next(word);
            }
            StdOut.print(word + " ");
            if (i % 8 == 1) StdOut.println();
        }
    }
}
