public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] nums = new int[args.length];
        int sumofnums = 0;
        int[] numbins = new int[args.length];

        // Populate nums[]
        for (int i = 1; i <= args.length - 1; i++) {
            nums[i] = Integer.parseInt(args[i]);
            sumofnums++;
        }
        for (int i = 0, sum = 0; i < nums.length; i++) {
            numbins[i] = sum +
        }

    }
}
