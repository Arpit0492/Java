package JavaBrains;

/**
 * Created by ARPIT JOHRI on 01-12-2016.
 */
public class MethodReferenceExample1 {

    public static void main(String[] args) {

        //Thread t = new Thread(()->printMessage());
        Thread t = new Thread(MethodReferenceExample1::printMessage);
        t.start();
    }

    public static void printMessage(){
        System.out.println("Hello");
    }
}
