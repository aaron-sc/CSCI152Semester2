import java.util.ArrayList;

public class MarkovChain {
    public int state;
    public int order;
    public ArrayList<String> words;
    ST<String, ArrayList<String>> st = new ST<>();


    public MarkovChain(int order, ArrayList<String> words) {
        this.order = order;
        this.words = words;
    }

    public void generateMarkov() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!(st.contains(word))) {
                st.put(word, new ArrayList<>());
                for (int j = i; j < this.order; j++) {
                    String s = "";
                    s += words.get(j);
                    st.get(word).add(s);
                }
            } else {
                for (int j = i; j < this.order; j++) {
                    String s = "";
                    s += words.get(j);
                    st.get(word).add(s);
                }
            }
        }
    }

    public String next(String state) {
        ArrayList<String> possibleWords = st.get(state);
        int randomNum = StdRandom.uniform(possibleWords.size());
        return possibleWords.get(randomNum);
    }

}
