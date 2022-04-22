import java.util.ArrayList;

public class TextGenerator {
    public static void main(String[] args) {
        int s = Integer.parseInt(args[0]);
        ArrayList<String> words = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            String value = StdIn.readString();
            words.add(value);
        }
        MarkovChain markovChain = new MarkovChain(s, words);
        markovChain.generateMarkov();
        StdOut.println(markovChain.toString());
    }
}
