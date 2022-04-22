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

        for (int i = 0; i < words.size(); i++) {
            String word;
            if (markovChain.getState().isBlank()) {
                word = markovChain.getStartingWord();
            } else {
                word = markovChain.next();
            }
            StdOut.print(word + " ");
        }
    }
}
