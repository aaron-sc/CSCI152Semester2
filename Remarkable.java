
/******************************************************************************
 *  Compilation:  javac Remarkable.java
 *  Execution:    java Remarkable
 * 
 *  % java Remarkable
 *  1.1726039400531787
 *  6.338253E29
 *  -0.82739605994682136814

 *
 ******************************************************************************/

import java.math.BigDecimal;

public class Remarkable {

    public static void main(String[] args) { 

        // compute using double precision
        double a = 77617.0;
        double b = 33096.0;
        double y = 333.75*b*b*b*b*b*b +
                   (a*a) * (11*a*a*b*b - b*b*b*b*b*b - 121*b*b*b*b - 2) +
                   5.5*b*b*b*b*b*b*b*b + 0.5*a/b;
        StdOut.println(y);


        // compute using single precision
        float aa = 77617.0f;
        float bb = 33096.0f;
        float yy = 333.75f*bb*bb*bb*bb*bb*bb +
                   (aa*aa) * (11*aa*aa*bb*bb - bb*bb*bb*bb*bb*bb - 121*bb*bb*bb*bb - 2) +
                   5.5f*bb*bb*bb*bb*bb*bb*bb*bb + 0.5f*aa/bb;
        StdOut.println(yy);


        // compute using high precision
        BigDecimal A = new BigDecimal(a);
        BigDecimal B = new BigDecimal(b);
        BigDecimal TWO = new BigDecimal(2.0);
        BigDecimal A2 = A.multiply(A);
        BigDecimal B2 = B.multiply(B);
        BigDecimal B4 = B2.multiply(B2);
        BigDecimal B6 = B2.multiply(B4);
        BigDecimal B8 = B4.multiply(B4);
        BigDecimal Y1 = new BigDecimal(333.75).multiply(B6);
        BigDecimal Y2 = new BigDecimal(11.0).multiply(A2).multiply(B2);
        BigDecimal Y3 = new BigDecimal(121.0).multiply(B4);
        BigDecimal Y4 = new BigDecimal(5.5).multiply(B8);
        BigDecimal Y5 = new BigDecimal(0.5).multiply(A).divide(B, 20, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal Y6 = Y2.subtract(B6).subtract(Y3).subtract(TWO);
        BigDecimal Y = Y1.add(A2.multiply(Y6)).add(Y4).add(Y5);
        StdOut.println(Y);
   }

}
