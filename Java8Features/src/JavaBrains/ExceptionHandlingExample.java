package JavaBrains;

import java.util.function.BiConsumer;

/**
 * Created by ARPIT JOHRI on 29-11-2016.
 */
public class ExceptionHandlingExample {

    public static void main(String[] args) {


        int [] someNumbers = {3,5,7,9};
        //int key = 2;
        int key = 0;
        process(someNumbers,key,wrapperLambda((a,k)->System.out.println(a/k)));

    }

    private static void process(int[]array, int key, BiConsumer<Integer,Integer> consumer){
        for (int a:array) {
            //System.out.println(a+key);
            consumer.accept(a,key);
        }
    }

    private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer){
        return (a,k)->{
            try{
                consumer.accept(a,k);
            }
            catch(ArithmeticException ae){
                System.out.println("Exception caught in wrapper lambda");
            }
        };
    }




}
