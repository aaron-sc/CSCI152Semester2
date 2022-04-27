import java.util.ArrayList;

public class MarkovChain {

    public int state;
    public int order;
    public ArrayList<String> words;
    ST<String, ArrayList<String>> st = new ST<>();


    public MarkovChain(int order, int n, ArrayList<String> words) {
        this.order = order;
        this.words = words;
        this.state = 0;
    }

    public void generateMarkov() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!(st.contains(word))) {
                st.put(word, new ArrayList<>());
            }
            String s = "";
            for (int j = 0; j < this.order; j++) {
                if (!(i + 2 > this.words.size())) s += words.get(i + 1);
                else s += words.get(Math.abs(i - words.size() - 1));
            }
            st.get(word).add(s);
        }
    }


    public int getState() {
        return this.state;
    }

    public int getOrder() {
        return this.order;
    }

    public ArrayList<String> getWords() {
        return this.words;
    }

    public String next(String word) {
        ArrayList<String> possibleWords = this.st.get(word);
        int randomNum = StdRandom.uniform(possibleWords.size());
        return possibleWords.get(randomNum);
    }

    public void transition() {
        this.state += order;
    }

    public String getStartingWord() {
        int n = StdRandom.uniform(2);
        if (n == 0) {
            int randomNum = StdRandom.uniform(this.words.size());
            return words.get(randomNum);
        } else return words.get(0);
    }

}
