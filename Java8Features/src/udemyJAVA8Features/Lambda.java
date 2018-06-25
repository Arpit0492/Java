package udemyJAVA8Features;

/**
 * Created by Arpit on 28-06-2017.
 *
 * Defining and Instantiating a functional Interface
 */
public class Lambda {
    public static void main(String[] args) {
//         SimpleInterface obj = () -> System.out.println("Say Something");
//        obj.calculate();
        InterfaceWithArgs obj = (v1,v2) -> {
            int result = v1 * v2;
            System.out.println("The result is " + result);
        };
        obj.calculate(2,3);
    }
}
