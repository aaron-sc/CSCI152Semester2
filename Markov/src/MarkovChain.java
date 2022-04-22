import java.util.ArrayList;

public class MarkovChain {

    public String state;
    public int order;
    public ArrayList<String> words;
    ST<String, ArrayList<String>> st = new ST<>();


    public MarkovChain(int order, ArrayList<String> words) {
        this.order = order;
        this.words = words;
        this.state = "";
    }

    public void generateMarkov() {
        for (String word : words) {
            if (!(st.contains(word))) {
                st.put(word, new ArrayList<>());
            }
            String s = "";
            for (int j = 0; j < this.order; j++) {
                s += words.get(j) + " ";

            }
            st.get(word).add(s);
        }
    }
    

    public String getState() {
        return this.state;
    }

    public int getOrder() {
        return this.order;
    }

    public ArrayList<String> getWords() {
        return this.words;
    }

    public String next() {
        ArrayList<String> possibleWords = this.st.get(this.state);
        int randomNum = StdRandom.uniform(possibleWords.size());
        return possibleWords.get(randomNum);
    }

    public String getStartingWord() {
        int randomNum = StdRandom.uniform(this.words.size());
        return words.get(randomNum);
    }

}
