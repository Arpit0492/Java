package JavaBrains;

/**
 * Created by ARPIT JOHRI on 27-11-2016.
 */


/*

CLASSIC EXAMPLE OF OBJECT ORIENTED PROGRAMMING

passing the behaviour and then executing the behaviour
 */
public class Greeter implements Greeting{

    public void greet(Greeting greeter){
        greeter.Greeter();
    }


//    JavaBrains.Greeting greetingFunction = (int a)->;
    // Lambda function
    myADD addFunction = (int a, int b)-> a+b;

    public static void main(String[] args) {
        Greeter instanceOfGreeter = new Greeter();
        //instanceOfGreeter.JavaBrains.Greeter();
        HelloWorldGreeting HWD = new HelloWorldGreeting();
      //  instanceOfGreeter.greet();
//        System.out.printf(instanceOfGreeter);
        Greeting lambdaGreeting = ()-> System.out.println("hey i am lambda");
        lambdaGreeting.Greeter();

        myADD add = (int a, int b)->a+b;

        System.out.println(add.add(5,6));

    }



    @Override
    public void Greeter() {
        System.out.println("YOO");
    }
}
@FunctionalInterface
interface myADD{
    int add(int x, int y);
}

@FunctionalInterface
interface Greeting{
    public void Greeter();
}
