public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] birthdays = new int[n];


        for (int i = 0; i < n; i++) {
            birthdays[i] = StdRandom.uniform(1, n); // Populate birthdays randomly
        }

        for (int i = 1; i < trials; i++) {
            int[] countedBdays = new int[n];
            boolean going = true;
            int p = 0;
            double c = 0.0;

            while (going) {
                for (int j = 0; j < birthdays.length; j++) {
                    int currentBirtday = birthdays[j];
                    for (int k = 0; k < birthdays.length; k++) {
                        if (countedBdays[k] == currentBirtday) {
                            p++;
                            c += p / (double) trials;
                            going = false;
                        } else {
                            countedBdays[k] = currentBirtday;
                        }
                    }
                }
            }
            StdOut.println(i + "    " + p + "    " + c);


        }
    }


}

