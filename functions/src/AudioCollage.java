public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] sound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            sound[i] = a[i] * alpha; // Make it LOUDER
        }
        return sound;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] sound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            sound[a.length - i - 1] = a[i]; // go backwards
        }
        return sound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] sound = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            sound[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            sound[i + a.length] = b[i];

        }
        return sound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] sound;
        boolean isA = a.length > b.length;
        if (isA) {
            sound = new double[a.length];
        } else {
            sound = new double[b.length];
        }
        for (int i = 0; i < sound.length; i++) {
            if ((isA && i < b.length) || (!isA && i < a.length)) sound[i] = a[i] + b[i];
            else if (isA) sound[i] = a[i];
            else sound[i] = b[i];
        }
        return sound;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int n = (int) (a.length / alpha); // Get the length of the sped up audio (less length bc it's faster. or longer if slower - divide by fraction)
        double[] sound = new double[n]; // hold that audio
        for (int i = 0; i < n; i++) { // for the length of our new array
            sound[i] = a[(int) (i * alpha)]; // get the (i*alpha)th value - using the alpha fr 2x, 3x etc.
        }
        return sound; // get us back te audio
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] sample1 = StdAudio.read("singer.wav");
        double[] sample2 = StdAudio.read("cow.wav");
        double[] sample3 = StdAudio.read("harp.wav");
        double[] sample4 = StdAudio.read("piano.wav");
        double[] sample5 = StdAudio.read("scratch.wav");
        StdAudio.play(merge(sample1, sample2));
        StdAudio.play(amplify(sample2, 2));
        StdAudio.play(reverse(sample3));
        StdAudio.play(mix(sample4, sample5));
        StdAudio.play(changeSpeed(sample5, 2));
    }
}
