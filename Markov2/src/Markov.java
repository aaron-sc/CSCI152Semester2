import java.util.ArrayList;

public class Markov {
    private ST<String, ArrayList<String>> st = new ST<>();
    private String state = "";
    private int order;
    public ArrayList<String> words = new ArrayList<>();
    private int e;

    public Markov(String[] words, int order) {
        this.order = order;
        for (int i = 0; i < words.length; i++) {
            String sb = "";
            String w = words[i];
            for (int j = i + 1; j < order + i + 1; j++) {
                if (!(j + order > words.length)) sb += words[j] + " ";
            }
            addTransition(w, sb);
            this.words.add(w);
        }

    }

    public void addTransition(String v, String w) {
        if (!(st.contains(v))) {
            st.put(v, new ArrayList<>());
        }
        st.get(v).add(w);
        e++;
    }

    public String next() {
        int randomNum = StdRandom.uniform(this.words.size());
        String w = words.get(randomNum);
        this.state = w;
        return w;
    }

    public String next(String v) {
        if (state.equals("")) {
            int randomNum = StdRandom.uniform(this.words.size());
            String w = words.get(randomNum);
            this.state = w;
            return w;
        } else {
            ArrayList<String> possibleWords = this.st.get(v);
            int randomNum = StdRandom.uniform(possibleWords.size());
            String w = possibleWords.get(randomNum);
            this.state = w;
            return w;
        }
    }

    public ST<String, ArrayList<String>> getSt() {
        return st;
    }

    public String getState() {
        return state;
    }

    public int getOrder() {
        return order;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public int getE() {
        return e;
    }
}
