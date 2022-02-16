public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] nums = new int[args.length];
        int sumofnums = 0; // Largest Number
        int[] numbins = new int[args.length];
        int randomNum = 0;

        // Populate nums[]
        for (int i = 1; i <= args.length - 1; i++) {
            nums[Math.abs(i - args.length)] = Integer.parseInt(args[i]);
            sumofnums += Integer.parseInt(args[i]);
        }

        // Systematically Generate Bins
        numbins[0] = sumofnums;
//        System.out.println(numbins[0]);
        for (int i = 1, j = sumofnums; i < nums.length; i++) {
            numbins[i] = j - nums[i];
            j -= nums[i];
        }
        

        // For debugging purposes
//        for (int i = 0; i < numbins.length; i++) {
//            System.out.println(numbins[i]);
//        }

    }
}
