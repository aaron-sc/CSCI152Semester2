import java.util.ArrayList;

public class MarkovChain {

    public String state;
    public int order;
    public ArrayList<String> words;
    ST<String, ArrayList<String>> st = new ST<>();


    public MarkovChain(int order, int n, ArrayList<String> words) {
        this.order = order;
        this.words = words;
        this.state = "";

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String s = "";
            for (int j = 0; j < this.order; j++) {
                if (!(i + 2 > this.words.size())) s += words.get(i + 1);
                else s += words.get(Math.abs(i - words.size() - 1));
            }
            transition(word, s);
        }
    }


    public void setState(String state) {
        this.state = state;
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

    public String next(String state) {
        ArrayList<String> possibleWords = this.st.get(state);
        int randomNum = StdRandom.uniform(possibleWords.size());
        String w = possibleWords.get(randomNum);
        this.state = w;
        return w;
    }

    public String getStartingWord() {
        int n = StdRandom.uniform(2);
        if (n == 0) {
            int randomNum = StdRandom.uniform(this.words.size());
            String w = words.get(randomNum);
            this.state = w;
            return w;
        } else {
            String w = words.get(0);
            this.state = w;
            return w;
        }
    }

    public void transition(String v, String w) {
        if (!(st.contains(v))) {
            st.put(v, new ArrayList<>());
        } else st.get(v).add(w);
    }

}
