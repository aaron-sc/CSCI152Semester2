import java.awt.*;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double filter = 0.0625;
        Picture pic = new Picture(picture.width(), picture.height());
        for (int i = 0; i < pic.height(); i++) {
            for (int j = 0; j < pic.width(); j++) {
                if ((i > 0 && j > 0) && (i < pic.height() - 1 && j < pic.width() - 1)) { // If it's a pixel NOT on the edge (j,i)
                    for (int k = i - 1; k < i + 1; k++) { // (l,K)
                        for (int l = j - 1; l < j + 1; l++) {
                            filter = filter * j;
                            Color current_color = picture.get(l, k);
                            long r = Math.round(current_color.getRed() * filter);
                            long g = Math.round(current_color.getGreen() * filter);
                            long b = Math.round(current_color.getBlue() * filter);
                            if (r <= 0) r = 0;
                            if (g <= 0) g = 0;
                            if (b <= 0) b = 0;
                            if (r >= 255) r = 255;
                            if (g >= 255) g = 255;
                            if (b >= 255) b = 255;
                            StdOut.println(r);
                            StdOut.println(g);
                            StdOut.println(b);

                            Color new_color = new Color(r, g, b);
                            pic.set(j, i, new_color);
                            StdOut.println(r);
                        }
                    }
                }
            }
        }
        return pic;
    }

//    // Returns a new picture that applies a sharpen filter to the given picture.
//    public static Picture sharpen(Picture picture) {
//
//    }
//
//    // Returns a new picture that applies an Laplacian filter to the given picture.
//    public static Picture laplacian(Picture picture) {
//
//    }
//
//    // Returns a new picture that applies an emboss filter to the given picture.
//    public static Picture emboss(Picture picture) {
//
//    }
//
//    // Returns a new picture that applies a motion blur filter to the given picture.
//    public static Picture motionBlur(Picture picture) {
//
//    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]); // Grabs the pic provided in args
        Picture n_pic = gaussian(pic);
        n_pic.show();
    }

}
