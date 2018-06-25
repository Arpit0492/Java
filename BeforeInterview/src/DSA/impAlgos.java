package DSA;

import java.util.*;

/**
 * Created by ARPIT JOHRI on 17-01-2017.
 */
public class impAlgos {
    public static void main(String[] args) {

        for (String s: generatePermutations("abc")) {
            System.out.println(s);
        }


    }

    public static ArrayList<Integer> factorsOfNumber(int N){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <=Math.sqrt(N); i++) {
            if (N%i==0) {
                list.add(i);
                if (i!=Math.sqrt(N))
                    list.add(N/i);
            }
        }
        return list;
    }

    public static boolean checkPrime(int N){

        if (N<2)
            return false;
        for (int i = 2; i <=Math.sqrt(N) ; i++) {
            if (N%i==0)
                return false;
        }
        return true;
    }

    public static Set<String> generatePermutations (String inputString){

        // base case
        if (inputString.length()<=1){
            return new HashSet<>(Collections.singletonList(inputString));
        }

        String allCharsExceptLast = inputString.substring(0,inputString.length()-1);
        char lastChar = inputString.charAt(inputString.length()-1);

        // recursive call: get all possible permutations for all chars except last
        Set<String> permutationsOfAllCharsExceptLast = generatePermutations(allCharsExceptLast);

        // put the last char in all possible positions for each of the above permutations
        Set<String> permutations = new HashSet<String>();

        for (String permutationOfAllCharExceptLast : permutationsOfAllCharsExceptLast){

            for (int position = 0; position <=allCharsExceptLast.length(); position++) {

                String permutation = permutationOfAllCharExceptLast.substring(0,position) + lastChar + permutationOfAllCharExceptLast.substring(position);

                permutations.add(permutation);
            }
        }

        return permutations;
    }

}

