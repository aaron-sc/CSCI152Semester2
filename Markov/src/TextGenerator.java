import java.util.ArrayList;

public class TextGenerator {
    public static void main(String[] args) {
        int s = Integer.parseInt(args[0]);
        ArrayList<String> words = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            String value = StdIn.readString();
            words.add(value.toLowerCase());
        }
        MarkovChain markovChain = new MarkovChain(s, words);
        markovChain.generateMarkov();
        String word = "";
        for (int i = 0; i < words.size(); i++) {

            if (markovChain.getState() == 0) {
                word = markovChain.getStartingWord();
            } else {
                String[] w = word.split(" ");
                word = w[w.length - 1];
                word = markovChain.next(word);
            }
            markovChain.transition();
            StdOut.print(word + " ");
        }
    }
}
