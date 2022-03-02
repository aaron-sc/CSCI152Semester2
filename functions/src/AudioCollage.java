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
            sound[i] = a[a.length - i - 1]; // go backwards
        }
        return sound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] sound = new double[a.length + b.length];
        for (int i = 0; i < sound.length; i++) {
            if (i < a.length) {
                sound[i] = a[i];
            } else sound[i] = b[sound.length - i - 1];
        }
        return sound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] sound;
        boolean isA = a.length > b.length;
        if (a.length > b.length) {
            sound = new double[a.length];
        } else {
            sound = new double[b.length];
        }
        for (int i = 0; i < sound.length; i++) {
            if (isA && i < b.length) sound[i] = a[i] + b[i];
            else sound[i] = a[i];
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
//        double[] sample2 = StdAudio.read("cow.wav");
        StdAudio.play(changeSpeed(reverse(amplify(sample1, 2)), 3));
    }
}
