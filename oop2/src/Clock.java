public class Clock {
    int h = 0;
    int m = 0;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        this.h = Integer.parseInt(s.substring(0, s.indexOf(":"))); // Get the first number (h)
        this.m = Integer.parseInt(s.substring(s.indexOf(":") + 1)); // Get the second number (m)
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (this.m == 0 && this.h == 0) return (this.h + "0" + ":" + this.m + "0");
        else if (this.m == 0) return (this.h + ":" + this.m + "0");
        else if (this.h == 0) return (this.h + "0" + ":" + this.m);
        else return (this.h + ":" + this.m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        int thiscombinestime = (this.h * 60) + this.m;
        int thatcombinestime = (that.h * 60) + that.m;
        return thiscombinestime > thatcombinestime;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.m == 59) {
            if (this.h == 23) {
                this.h = 0;
                this.m = 0;
            } else {
                this.h++;
                this.m = 0;
            }
        } else this.m++;

    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        for (int i = 0; i < delta; i++) {
            tic(); // Add minutes to the clock by repeating tic
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c = new Clock("23:50");
        c.toc(10);
        StdOut.println(c.toString());
    }
}
