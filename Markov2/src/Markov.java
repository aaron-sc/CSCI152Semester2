import java.util.ArrayList;

public class Markov {
    private ST<String, ArrayList<String>> st = new ST<>();
    private int order;
    private int e;

    public Markov(String filename, int order) {
        In in = new In(filename);
        String file = in.readAll();
        String[] words = file.split(" ");
        file += file.substring(order);
        for (int i = 1; i < words.length - order; i++) {
            addTransition(words[i], words[i + order]);
        }

    }

    public void addTransition(String v, String w) {
        if (!(st.contains(v))) {
            st.put(v, new ArrayList<>());
        }
        st.get(v).add(w);
        e++;
    }

}
