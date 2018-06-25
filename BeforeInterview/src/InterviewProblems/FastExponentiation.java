package InterviewProblems;import java.math.BigInteger;

/**
 * Created by ARPIT JOHRI on 24-03-2017.
 */
public class FastExponentiation {
    private static BigInteger two = new BigInteger(2+"");
    public static void main(String[] args) {

        BigInteger a = new BigInteger(3125+"");
        BigInteger b = new BigInteger(5+"");
        BigInteger modd = new BigInteger(3+"");
        System.out.println(Power(b,a));

    }

    private static BigInteger Power(BigInteger a, BigInteger N){

        if(N.compareTo(BigInteger.ZERO)==0){
            return BigInteger.ONE;
        }
        else if(N.compareTo(BigInteger.ONE)==0)
        {
            return a;
        }
        else{
            BigInteger R = Power(a,N.divide(two));
            if(N.mod(two).compareTo(BigInteger.ZERO)==0){
                return R.multiply(R);
            }
            else{
                return R.multiply(R).multiply(a);
            }
        }
    }


    private static long phi(int n)
    {
        long result = n;   // Initialize result as n

        // Consider all prime factors of n and subtract their
        // multiples from result
        for (long p=2; p*p<=n; ++p)
        {
            // Check if p is a prime factor.
            if (n % p == 0)
            {
                // If yes, then update n and result
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }

        // If n has a prime factor greater than sqrt(n)
        // (There can be at-most one such prime factor)
        if (n > 1)
            result -= result / n;
        return result;
    }
}
