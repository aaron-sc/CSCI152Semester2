public class Main {
    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings(); // https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdIn.html
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] cscores = new int[26];
        int[] wscores = new int[words.length];
        int max = 0;
        boolean going = true;

        // See the most common letters within these words and create a score based on the alphabet
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char charword = word.charAt(i);
                cscores[alphabet.indexOf(charword)]++;
            }
        }

        while (going) {

            // Score the words from the .txt file based on the most common letters
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    int index = alphabet.indexOf(c);
                    wscores[index]++;
                }
            }

            // Regardless of the words used, get the best score
            for (int wscore : wscores) {
                if (wscore > max) max = wscore;
            }

            StdOut.println("Start with:");
            for (int i = 0; i < wscores.length; i++) {
                if (wscores[i] >= max - 400) { // Give a buffer for some words other than the best one
                    StdOut.println(words[i]);
                }
            }
            String input = StdIn.readString();
            StdOut.println(input);


            going = false;


//                for (int i = 0; i < alphabet.length(); i++) {
//            double freq = (cscores[i] / sum) * 100;
//            StdOut.println(alphabet.charAt(i) + ": " + cscores[i] + ": " + freq);
//        }

        }
    }
}
