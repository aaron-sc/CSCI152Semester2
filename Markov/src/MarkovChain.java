import java.util.ArrayList;

public class MarkovChain {

    public int state;
    public int order;
    public ArrayList<String> words;
    ST<String, ArrayList<String>> st = new ST<>();


    public MarkovChain(int order, ArrayList<String> words) {
        this.order = order;
        this.words = words;
        this.state = 0;
    }

    public void generateMarkov() {
//        for (String word : words) {
//            if (!(st.contains(word))) {
//                st.put(word, new ArrayList<>());
//            }
//            String s = "";
//            for (int j = state; j < this.order; j++) {
//                s += words.get(j) + " ";
//
//            }
//            st.get(word).add(s);
//        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!(st.contains(word))) {
                st.put(word, new ArrayList<>());
            }
            String s = "";
            for (int j = i; j < this.order; j++) {
                s += words.get(j + 1) + " ";

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
        int randomNum = StdRandom.uniform(this.words.size());
        return words.get(randomNum);
    }

}
