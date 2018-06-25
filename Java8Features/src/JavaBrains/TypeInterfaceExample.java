package JavaBrains;

/**
 * Created by ARPIT JOHRI on 27-11-2016.
 */
public class TypeInterfaceExample {


    public static void main(String[] args) {


        StringLength myLambda = s->s.length();

        System.out.println(myLambda.getLength("Hi I am Lambda"));


        printLambda(s->s.length());



    }


    //passing the lambda expression
    public static void printLambda(StringLength l){
        System.out.println(l.getLength("hello lambda"));
    }

    interface StringLength{
        int getLength(String s);
    }
}
